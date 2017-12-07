package ren.junsong.util;

import java.text.DecimalFormat;
import ren.junsong.view.UIFrame;
import javax.naming.spi.DirStateFactory.Result;

/**
 * 定义计算器，当点击计算的时候，生成计算器对象
 * 
 * @author famugoing
 *
 */
public class Calculator {
	private double p; // 压强
	private double T; // 温度
	int region;
	// public double w; // 音速
	// public double S; // 熵
	// public double v; // 比容
	// public double h; // 焓
	// public double u; // 内能
	// public double Cp; // 等压热熔
	// public double g; // 自由能

	public Calculator() {
		super();
	}

	public double drawRegion(int x, double p, double T) {
		double result = 0;
		int drawregion = CheckRegion.checkp_T(p, T);
		Property pro = null;
		switch (drawregion) {
		case 0:
			UIFrame.myexception(0);
			return 0;
		case 6:
			UIFrame.myexception(6);
			return 0;
		case 1:
			pro = new Region1();
			break;
		case 2:
			pro = new Region2();
			break;
		case 3:
			pro = new Region3();
			break;
		case 4:
			pro = new Region1();
			break;
		case 5:
			pro = new Region5();
			break;
		case 23:
			pro = new Region2();
			break;
		case 13:
			pro = new Region1();
			break;

		case 12:
			pro = new Region1();
			break;
		}
		switch (x) {
		case 1:
			result = pro.g_pT(p, T) * 0.01801528;// + 0.0821850173;
			break;
		case 2:
			result = pro.w_pT(p, T);
			break;
		case 3:
			result = pro.v_pT(p, T);
			break;
		case 4:
			result = pro.h_pT(p, T);
			break;
		case 5:
			result = pro.u_pT(p, T);
			break;
		case 6:
			result = pro.s_pT(p, T) * 1000 * 0.01801528 + 63.33422427;
			break;
		case 7:
			result = pro.Cp_pT(p, T);
			break;

		}
		return result;
	}

	public double drawIdealGas(int x, double p, double T) {
		double result = 0;
		switch (x) {
		case 0:// ideal gas
			IdealGas ideal = new IdealGas();
			result = ideal.Idealg_pT(p, T);
			break;
		case 1:// van der gas
			IdealGas ideal2 = new IdealGas();
			result = ideal2.VanDerg_pT(p, T);
			break;
		}
		
		return result;
	}

	private String calRegionAll(Property pro, double p, double T) {
		IdealGas ideal = new IdealGas();
		StringBuilder sbAll = new StringBuilder();
		double ht = pro.h_pT(p, T) * 0.01801528;
		double st = pro.s_pT(p, T) * 1000 * 0.01801528;

		sbAll.append("\n" + "自由能修正g=  ");
		sbAll.append(sci(pro.g_pT(p, T) * 0.01801528 + 0.0821850173)).append("   kJ/mol");
		sbAll.append("\n" + "理想气体自由能g=  ");
		sbAll.append(sci(ideal.Idealg_pT(p, T))).append("   kJ/mol");
		sbAll.append("\n" + "van der自由能g=  ");
		sbAll.append(sci(ideal.VanDerg_pT(p, T))).append("   kJ/mol");
		// sbAll.append("\n" + "自由能g= ");
		// sbAll.append(sci(pro.g_pT(p, T))).append(" kJ/kg");
		sbAll.append("\n" + "自由能未修正g=  ");
		sbAll.append(sci(pro.g_pT(p, T) * 0.01801528)).append("   kJ/mol");
		sbAll.append("\n" + "比容v=  ");
		sbAll.append(sci(pro.v_pT(p, T)* 0.01801528)).append("   m^3/kg,单位为m^3/mol");
		sbAll.append("\n" + "密度rho=  ");
		sbAll.append(sci(1 / (pro.v_pT(p, T)))).append("   kg/m^3");
		sbAll.append("\n" + "比焓h=  ");
		sbAll.append(sci(pro.h_pT(p, T) * 0.01801528)).append("   kJ/mol");
		sbAll.append("\n" + "比焓Δh=  ");

		sbAll.append(sci(pro.h_pT(p, T) * 0.01801528 - 287.720309)).append("   kJ/mol");
		sbAll.append("\n" + "内能u=  ");
		sbAll.append(sci(pro.u_pT(p, T) * 0.01801528)).append("   kJ/mol");
		sbAll.append("\n" + "音速w=  ");
		sbAll.append(sci(pro.w_pT(p, T))).append("   m/s");
		sbAll.append("\n" + "等压热熔Cp=  ");
		sbAll.append(sci(pro.Cp_pT(p, T) * 0.01801528)).append("   kJ/(mol*k)");
		sbAll.append("\n" + "熵s=  ");
		sbAll.append(sci(pro.s_pT(p, T) * 1000 * 0.01801528 + 63.33422427)).append("   J/(mol*k)");
		return sbAll.toString();

	};

	public String calRegion1(double p, double T) {
		StringBuilder sb = new StringBuilder();
		Property pro = new Region1();
		sb.append("当前区域：1区");
		sb.append(calRegionAll(pro, p, T));
		return sb.toString();
	}

	public String calRegion2(double p, double T) {
		StringBuilder sb = new StringBuilder();
		Property pro = new Region2();
		sb.append("当前区域：2区");
		sb.append(calRegionAll(pro, p, T));
		return sb.toString();
	}

	public String calRegion3(double p, double T) {
		StringBuilder sb = new StringBuilder();
		Property pro = new Region3();
		sb.append("当前区域：3区");
		sb.append(calRegionAll(pro, p, T));
		return sb.toString();
	}

	public String calRegion5(double p, double T) {
		StringBuilder sb = new StringBuilder();
		Property pro = new Region5();
		sb.append("当前区域：5区");
		sb.append(calRegionAll(pro, p, T));
		return sb.toString();
	}

	public String calRegion4_p(double p) {
		Region4 pro4 = new Region4();
		return sci(pro4.T_p(p)).toString();
	}

	public String calRegion4_T(double T) {
		Region4 pro4 = new Region4();
		return sci(pro4.p_T(T)).toString();
	}

	public String resultpT() {
		region = CheckRegion.checkp_T(p, T);
		StringBuilder sb = new StringBuilder();
		switch (region) {
		case 0:
			UIFrame.myexception(0);
			return null;
		case 1:
			sb.append(calRegion1(p, T));
			break;
		case 2:
			sb.append(calRegion2(p, T));
			break;
		case 3:
			sb.append(calRegion3(p, T));
			break;
		case 4:
			sb.append("当前区域：4区");
			Property pro = new Region1();
			sb.append("\n" + "利用一区计算结果");
			sb.append("\n" + "自由能g=  ");
			sb.append(sci(pro.g_pT(p, T))).append("   kJ/kg");
			sb.append("\n" + "比容v=  ");
			sb.append(sci(pro.v_pT(p, T))).append("   m^3/kg");
			sb.append("\n" + "密度rho=  ");
			sb.append(sci(1 / (pro.v_pT(p, T)))).append("   kg/m^3");
			pro = new Region2();
			sb.append("\n" + "利用二区计算结果");
			sb.append("\n" + "自由能g=  ");
			sb.append(sci(pro.g_pT(p, T))).append("   kJ/kg");
			sb.append("\n" + "比容v=  ");
			sb.append(sci(pro.v_pT(p, T))).append("   m^3/kg");
			sb.append("\n" + "密度rho=  ");
			sb.append(sci(1 / (pro.v_pT(p, T)))).append("   kg/m^3");
			break;
		case 5:
			sb.append(calRegion5(p, T));
			break;
		case 6:
			UIFrame.myexception(6);
			return null;
		case 13:
			sb.append("当前区域：1区和3区分界线");
			sb.append("\n" + "利用一区计算结果");
			Property pro1 = new Region1();
			sb.append(calRegionAll(pro1, p, T));
			sb.append("\n" + "利用三区计算结果");
			Property pro3 = new Region3();
			sb.append("\n" + "自由能g=  ");
			sb.append(sci(pro3.g_pT(p, T))).append("   kJ/kg");
			break;
		case 23:
			sb.append("当前区域：2区和3区分界线");
			sb.append("\n" + "利用二区计算结果");
			Property pro2 = new Region2();
			sb.append(calRegionAll(pro2, p, T));
			sb.append("\n" + "利用三区计算结果");
			Property pro3_23 = new Region3();
			sb.append("\n" + "自由能g=  ");
			sb.append(sci(pro3_23.g_pT(p, T))).append("   kJ/kg");
			break;
		case 25:
			sb.append("当前区域：2区和5区分界线");
			sb.append("\n" + "利用二区计算结果");
			Property pro2_25 = new Region2();
			sb.append(calRegionAll(pro2_25, p, T));
			sb.append("\n" + "利用五区计算结果");
			Property pro5_25 = new Region5();
			sb.append("\n" + "自由能g=  ");
			sb.append(sci(pro5_25.g_pT(p, T))).append("   kJ/kg");
			break;
		}

		return sb.toString();
	}

	private static String sci(double d) {
		if (new Double(d).isNaN() || new Double(d).isInfinite()) {
			return "(╯‵□′)╯︵[___] (NAN or infinite)";
		}
		boolean flag = false;
		if (d < 0) {
			flag = true;
			d = -d;
		}
		String value = null;
		DecimalFormat decimalFormat = new DecimalFormat();// 格式化设置
		decimalFormat.applyPattern(".000000000E0");
		if (flag) {
			value = "-0" + decimalFormat.format(d);
		} else {
			value = '0' + decimalFormat.format(d);
		}
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