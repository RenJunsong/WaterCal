package ren.junsong.util;
/**
 * 由于所有分区都具有以下性质，故建立性质抽象接口
 * @author famugoing
 *
 */
public interface Property {
	/**
	public double p;  //压强
	public double T;   //温度
	public double w;    //音速
	public double S;   //熵
	public double v;   //体积
	public double h;   //焓
	*/
	//and then...
	double v_pT(double p, double T);
	double h_pT(double p, double T);
	double w_pT(double p, double T);
	double s_pT(double p, double T);
	double u_pT(double p, double T);
	double Cp_pT(double p, double T);
	
}
