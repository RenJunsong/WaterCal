package ren.junsong.util;
/**
 * ���������������������ʱ�����ɼ���������
 * @author famugoing
 *
 */
public class Calculator{
	public double p;
	public double T;
	
	public Calculator(double p, double t) {
		super();
		this.p = p;
		T = t;
	}

	public double result(){
	Region1 r1=new Region1();
	return r1.v_pT(p, T);
	}
}