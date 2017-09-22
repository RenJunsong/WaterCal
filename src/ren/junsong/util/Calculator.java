package ren.junsong.util;

import java.text.DecimalFormat;
import ren.junsong.view.UIFrame;
import javax.naming.spi.DirStateFactory.Result;

/**
 * ���������������������ʱ�����ɼ���������
 * @author famugoing
 *
 */
public class Calculator{
	private double p;  //ѹǿ
	private double T;   //�¶�
	int region;
	public double w;    //����
	public double S;   //��
	public double v;   //����
	public double h;   //��
	public double u;   //����
	public double Cp;  //��ѹ����
	private StringBuilder sb;
	
	public Calculator(double p, double t) {
		super();
		this.p = p;
		T = t;
	}
	public Calculator() {
		super();
	}

	public String result(){
		region=CheckRegion.checkp_T(p,T);
		sb=new StringBuilder();
		Property pro=null;
		switch(region){
		case 0:
			System.out.println("������");
			break;
		case 1:
			pro=new Region1();
			sb.append("��ǰ����1��");
			break;
		case 2:
			pro=new Region2();
			sb.append("��ǰ����2��");
			break;
		case 3:
			pro=new Region3();
			sb.append("��ǰ����3��");
			break;
		case 4:
			System.out.println("something will happen");
		case 5:
			pro=new Region5();
			sb.append("��ǰ����5��");
			break;
		case 6:
			UIFrame.myexception(6);
			return null;	
		}
		
		sb.append("\n"+"����v=  ");
		sb.append(sci(pro.v_pT(p, T))).append("   m^3/kg");
		sb.append("\n"+"�ܶ�rho=  ");
		sb.append(sci(1/(pro.v_pT(p, T)))).append("   kg/m^3");
		sb.append("\n"+"����h=  ");
		sb.append(sci(pro.h_pT(p, T))).append("   kJ/kg");
		sb.append("\n"+"����u=  ");
		sb.append(sci(pro.u_pT(p, T))).append("   kJ/kg");
		sb.append("\n"+"����w=  ");
		sb.append(sci(pro.w_pT(p, T))).append("   m/s");
		sb.append("\n"+"��ѹ����Cp=  ");
		sb.append(sci(pro.Cp_pT(p, T))).append("   kJ/(kg*k)");
		sb.append("\n"+"��s=  ");
		sb.append(sci(pro.s_pT(p, T))).append("   kJ/(kg*k)");
		return sb.toString();
	}
	public static String sci(double d) {
		if(new Double(d).isNaN()||new Double(d).isInfinite()){
			return "(�s�F����)�s��[___] (NAN or infinite)";
		}
		boolean flag=false;
		if(d<0){
    	   flag=true;
    	   d=-d; 
		}
		String value = null;
        DecimalFormat decimalFormat = new DecimalFormat();//��ʽ������  
        decimalFormat.applyPattern(".000000000E0");
        if(flag){
        	 value ="-0"+decimalFormat.format(d);
        }else{
        value ='0'+decimalFormat.format(d);}
        return value;
	}
	public double getP() {
		return p;
	}

	public void setP(double p) {
		this.p = p;
	}

	public double getT() {
		return T;
	}

	public void setT(double t) {
		T = t;
	}

}