package ren.junsong.util;

/*
 * 用于检验输入内容所在分区 返回 0（未知） 1,2,3,4(1,2),5,25,23,13
 */
public class CheckRegion {
	public static int region;

	public static int checkp_T(double p, double T) {
		Borders bor = new Borders();
		double ps;
		/*
		 * 用于检测分区 一，检测是否越界 二，判断是否5区 三，判断是否2，3区（2，3区通过B23方程判断）
		 * 四，判断是否1，4，2区（通过4区条件判断）
		 */
		int isCrossBorder = checkCrossBorder(p, T);
		if (isCrossBorder != 0) {
			return isCrossBorder;
		} else if ((T > 1073.15) && (p <= 10)) {
			return 5;
		} else if ((T == 1073.15) && (p <= 10)) {
			return 25; // 25表示2，5边界
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
	 * 越界函数判断
	 */
	private static int checkCrossBorder(double p, double T) {
		if (T < 273.15 || T > 2273.15 || p > 100 || p < 0) {
			return 6; // 输入越界
		} else if (T > 1073.15 && p > 10) {
			return 6;
		}
		return 0;

	}
}
