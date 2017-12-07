package ren.junsong.util;

public class Constant {
	public static double p_V(double V,double T){
		double result=0;
		result=Constant.R*T/(V-b)-a/(V*V);
		return result;
	}
	public static final double R=8.314;
	public static final double a=5.51/10;
	public static final double b=0.0304/1000;
	public static void main(String[] args) {
		System.out.println(p_V(0.0414019779,500)/1000/1000);
	}
	
}
