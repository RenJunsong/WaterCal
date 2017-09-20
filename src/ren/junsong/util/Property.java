package ren.junsong.util;
/**
 * �������з����������������ʣ��ʽ������ʳ���ӿ�
 * @author famugoing
 *
 */
public interface Property {
	/**
	public double p;  //ѹǿ
	public double T;   //�¶�
	public double w;    //����
	public double S;   //��
	public double v;   //���
	public double h;   //��
	*/
	//and then...
	double v_pT(double p, double T);
	double h_pT(double p, double T);
	double w_pT(double p, double T);
	double s_pT(double p, double T);
	double u_pT(double p, double T);
	double Cp_pT(double p, double T);
	
}
