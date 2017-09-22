package ren.junsong.util;

import java.text.DecimalFormat;
import ren.junsong.view.UIFrame;
import javax.naming.spi.DirStateFactory.Result;

/**
 * 定义计算器，当点击计算的时候，生成计算器对象
 * @author famugoing
 *
 */
public class Calculator{
	private double p;  //压强
	private double T;   //温度
	int region;
	public double w;    //音速
	public double S;   //熵
	public double v;   //比容
	public double h;   //焓
	public double u;   //内能
	public double Cp;  //等压热熔
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
			System.out.println("打扰了");
			break;
		case 1:
			pro=new Region1();
			sb.append("当前区域：1区");
			break;
		case 2:
			pro=new Region2();
			sb.append("当前区域：2区");
			break;
		case 3:
			pro=new Region3();
			sb.append("当前区域：3区");
			break;
		case 4:
			System.out.println("something will happen");
		case 5:
			pro=new Region5();
			sb.append("当前区域：5区");
			break;
		case 6:
			UIFrame.myexception(6);
			return null;	
		}
		
		sb.append("\n"+"比容v=  ");
		sb.append(sci(pro.v_pT(p, T))).append("   m^3/kg");
		sb.append("\n"+"密度rho=  ");
		sb.append(sci(1/(pro.v_pT(p, T)))).append("   kg/m^3");
		sb.append("\n"+"比焓h=  ");
		sb.append(sci(pro.h_pT(p, T))).append("   kJ/kg");
		sb.append("\n"+"内能u=  ");
		sb.append(sci(pro.u_pT(p, T))).append("   kJ/kg");
		sb.append("\n"+"音速w=  ");
		sb.append(sci(pro.w_pT(p, T))).append("   m/s");
		sb.append("\n"+"等压热熔Cp=  ");
		sb.append(sci(pro.Cp_pT(p, T))).append("   kJ/(kg*k)");
		sb.append("\n"+"熵s=  ");
		sb.append(sci(pro.s_pT(p, T))).append("   kJ/(kg*k)");
		return sb.toString();
	}
	public static String sci(double d) {
		if(new Double(d).isNaN()||new Double(d).isInfinite()){
			return "(╯‵□′)╯︵[___] (NAN or infinite)";
		}
		boolean flag=false;
		if(d<0){
    	   flag=true;
    	   d=-d; 
		}
		String value = null;
        DecimalFormat decimalFormat = new DecimalFormat();//格式化设置  
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