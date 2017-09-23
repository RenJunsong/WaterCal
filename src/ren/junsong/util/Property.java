package ren.junsong.util;

/**
 * �������з����������������ʣ��ʽ������ʳ���ӿ�
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
