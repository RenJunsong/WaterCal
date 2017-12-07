package ren.junsong.util;

import java.util.Arrays;

public class VanDerWaalsEq {
	public double calc(double p, double T) {
		double result =0;
		p=p*1000*1000;
		result=run(info(p, T),p,T);
		System.out.println("通过反代v求p="+(ConstantForCal.R0*T/(info(p, T)[1]-ConstantForCal.b)-ConstantForCal.a/(info(p, T)[1]*info(p, T)[1])));
		System.out.println("info="+Arrays.toString(info(p,T)));
		return result;
	}

	private double run(double[] info,double p,double T) {
		double g=0;
		double a0=32.238,a1=1.9234e-3,a2=10.5549e-6,a3=-3.5952e-9,g0,T0=372.755919,p0=0.1;
		Property pro=new Region1();
		g0=pro.g_pT(p0, T0)* 0.01801528;
		g=(a0*T-a0*T*Math.log(T)-0.5*a1*T*T-1/6*a2*Math.pow(T, 3)-1/12*a3*Math.pow(T, 4))
		-(a0*T0-a0*T0*Math.log(T0)-0.5*a1*T0*T0-1/6*a2*Math.pow(T0, 3)-1/12*a3*Math.pow(T0, 4));
		double[] temp=info(p0*1000*1000,T);
		System.out.println("前两项="+g);
		g=g+(-2*ConstantForCal.a/info[1]-ConstantForCal.R0*T*Math.log(info[1]-ConstantForCal.b)+ConstantForCal.b*ConstantForCal.R*T/(info[1]-ConstantForCal.b));
		g=g-(-2*ConstantForCal.a/temp[1]-ConstantForCal.R0*T*Math.log(temp[1]-ConstantForCal.b)+ConstantForCal.b*ConstantForCal.R*T/(temp[1]-ConstantForCal.b));
		System.out.println("Tc="+8*ConstantForCal.a/(27*ConstantForCal.R0*ConstantForCal.b));
		System.out.println("所有项"+g);
		return g/1000+g0;
	}

	private double[] info(double p, double T) {
		double[] info =new double[2];
		double a = p, b = -(p * ConstantForCal.b + ConstantForCal.R0 * T), c = ConstantForCal.a,
				d = -ConstantForCal.a * ConstantForCal.b;
		double A = b * b - 3 * a * c, B = b * c - 9 * a * d, C = c * c - 3 * b * d;
		double det = B * B - 4 * A * C;
		if (A == B && A == 0) {
			info[0] = 1;
			info[1] = -c / b;
			return info;
		}
		if (det > 0) {
			info[0] = 1;
			double Y1 = A * b + (3 * a * (-B + Math.sqrt(det))) / 2;
			double Y2 = A * b + (3 * a * (-B - Math.sqrt(det))) / 2;
			double GS1, GS2;
			if (Y1 > 0) {
				GS1 = Math.pow(Y1, 1.0 / 3);
			} else {
				GS1 = -Math.pow(Math.abs(Y1), 1.0 / 3);
			}
			if (Y2 > 0) {
				GS2 = Math.pow(Y2, 1.0 / 3);
			} else {
				GS2 = -Math.pow(Math.abs(Y2), 1.0 / 3);
			}
			info[1] = (-b - GS1 - GS2) / (3 * a);
			return info;
		}
		if (det == 0) {
			double K = B / A;
			double x1 = -b / a + K;
			double x2 = -0.5 * K;
			if (check2_3(p - 0.00001, T) == 2) {
				info[0] = 2;
				if (x1 < x2) {
					info[1] = x1;
				} else {
					info[1] = x2;
				}

			} else {
				info[0] = 3;
				if (x1 < x2) {
					info[1] = x2;
				} else {
					info[1] = x1;
				}

			}
			return info;
		}
		if (det < 0) {
			double x1 = 0,x2 = 0,x3 = 0,temp1=0,temp2=0;
			temp1=(2*A*b-3*a*B)/(2*Math.pow(A,1.5));
			temp2=Math.acos(temp1);
			 x1=(-b-2*Math.sqrt(A)*Math.cos(temp2/3))/(3*a);       
			 x2=(-b+Math.sqrt(A)*(Math.cos(temp2/3)+Math.sqrt(3)*Math.sin(temp2/3)))/(3*a);      
			 x3=(-b+Math.sqrt(A)*(Math.cos(temp2/3)-Math.sqrt(3)*Math.sin(temp2/3)))/(3*a); 
			 double rank;
			 if(x2<x1)
				 {rank=x1;x1=x2;x2=rank;}
			 if(x3<x2)
			 {rank=x2;x2=x3;x3=rank;}
			 if(x3<x1)
			 {rank=x1;x1=x3;x3=rank;}
			 if(x3<x2)
			 {rank=x2;x2=x3;x3=rank;}
			info=check4_5(p, T,x1,x2,x3);
			return info;
		}
		return info;
	}

	private int check2_3(double p, double T) {
		double a = p, b = -(p * ConstantForCal.b + ConstantForCal.R0 * T), c = ConstantForCal.a,
				d = -ConstantForCal.a * ConstantForCal.b;
		double A = b * b - 3 * a * c, B = b * c - 9 * a * d, C = c * c - 3 * b * d;
		double det = B * B - 4 * A * C;
		if (det > 0) {
			return 2;
		} else {
			return 3;
		}
	}

	private double[] check4_5(double p, double T,double x1,double x2,double x3) {
		double[] result=new double[2];
		double integral=0,area=0;
		integral=ConstantForCal.R0*T*Math.log((x3-ConstantForCal.b)/(x1-ConstantForCal.b))+ConstantForCal.a/x3-ConstantForCal.a/x1;
		area=p*(x3-x1);
		if(area>integral){
			result[0]=4;
			result[1]=x1;
		}else{
			result[0]=5;
			result[1]=x3;
		}
		return result;
	}
}
