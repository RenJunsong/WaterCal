package ren.junsong.util;

public class IdealGas {
	public double Idealg_pT(double p, double T) {
		double result = 0;
		double a0=32.238,a1=1.9234e-3,a2=10.5549e-6,a3=-3.5952e-9,R=8.314,g0=0,T0=298.15,p0=0.1;
		result=(a0*T-a0*T*Math.log(T)-0.5*a1*T*T-1/6*a2*Math.pow(T, 3)-1/12*a3*Math.pow(T, 4))
				-(a0*T0-a0*T0*Math.log(T0)-0.5*a1*T0*T0-1/6*a2*Math.pow(T0, 3)-1/12*a3*Math.pow(T0, 4))
				+R*T*Math.log(p/p0);
		result=result/1000+g0;
		return result;
	}
	public double VanDerg_pT(double p, double T) {
		double result = 0;
		double a0=32.238,a1=1.9234e-3,a2=10.5549e-6,a3=-3.5952e-9,R=8.314,g0=0,T0=298.15,p0=0.1;
		result=(a0*T-a0*T*Math.log(T)-0.5*a1*T*T-1/6*a2*Math.pow(T, 3)-1/12*a3*Math.pow(T, 4))
				-(a0*T0-a0*T0*Math.log(T0)-0.5*a1*T0*T0-1/6*a2*Math.pow(T0, 3)-1/12*a3*Math.pow(T0, 4))
				+R*T*Math.log(p/p0);
		result=result/1000+g0;
		return result;
	}
}
