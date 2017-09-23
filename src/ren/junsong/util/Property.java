package ren.junsong.util;

/**
 * 由于所有分区都具有以下性质，故建立性质抽象接口
 * 
 * @author famugoing
 *
 */
public interface Property {
	double g_pT(double p, double T);

	double v_pT(double p, double T);

	double h_pT(double p, double T);

	double w_pT(double p, double T);

	double s_pT(double p, double T);

	double u_pT(double p, double T);

	double Cp_pT(double p, double T);

}
