package ren.junsong.util;

/*
 * ���ڼ��������������ڷ��� ���� 0��δ֪�� 1,2,3,4(1,2),5,25,23,13
 */
public class CheckRegion {
	public static int region;

	public static int checkp_T(double p, double T) {
		Borders bor = new Borders();
		double ps;
		/*
		 * ���ڼ����� һ������Ƿ�Խ�� �����ж��Ƿ�5�� �����ж��Ƿ�2��3����2��3��ͨ��B23�����жϣ�
		 * �ģ��ж��Ƿ�1��4��2����ͨ��4�������жϣ�
		 */
		int isCrossBorder = checkCrossBorder(p, T);
		if (isCrossBorder != 0) {
			return isCrossBorder;
		} else if ((T > 1073.15) && (p <= 10)) {
			return 5;
		} else if ((T == 1073.15) && (p <= 10)) {
			return 25; // 25��ʾ2��5�߽�
		} else if (T > 623.15) {
			if (p > bor.B23p_T(T) + 0.00000000001) {
				return 3;
			} else if (Math.abs((p - bor.B23p_T(T))) < 0.0000000001) {
				return 23;
			} else {
				return 2;
			}
		} else
		// 1.4.2
		{
			ps = new Region4().p_T(T);
			if ((Math.abs(p - ps)) < 0.0000001) {
				return 4;
			} else if (p > ps) {
				if (T == 623.15) {
					return 13;
				}
				return 1;
			} else {

				return 2;
			}
		}
	}
	/*
	 * Խ�纯���ж�
	 */
	private static int checkCrossBorder(double p, double T) {
		if (T < 273.15 || T > 2273.15 || p > 100 || p < 0) {
			return 6; // ����Խ��
		} else if (T > 1073.15 && p > 10) {
			return 6;
		}
		return 0;

	}
}
