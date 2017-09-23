package ren.junsong.util;

/**
 * Ò»Çø
 * 
 * @author Ren Junsong
 *
 */
public class Region1 implements Property {
	double ps, tau, g, gt, gp, gtt, gpp, gpt;
	double R = ConstantForCal.R;
	double n1[] = ConstantForCal.n1;
	double I1[] = ConstantForCal.I1;
	double J1[] = ConstantForCal.J1;

	public double v_pT(double p, double T) {
		ps = p / 16.53;
		tau = 1386 / T;
		g = 0.0;
		for (int i = 0; i <= 33; i++) {
			g = g - n1[i] * I1[i] * Math.pow((7.1 - ps), (I1[i] - 1)) * Math.pow((tau - 1.222), J1[i]);
		}
		return (R * T / p * ps * g / 1000);
	}

	public double h_pT(double p, double T) {
		ps = p / 16.53;
		tau = 1386 / T;
		g = 0;
		for (int i = 0; i <= 33; i++) {
			g = g + (n1[i] * Math.pow((7.1 - ps), I1[i]) * J1[i] * Math.pow((tau - 1.222), (J1[i] - 1)));
		}

		return (R * T * tau * g);
	}

	public double w_pT(double p, double T) {
		p = p / 16.53;
		tau = 1386 / T;

		gp = 0;
		gpp = 0;
		gpt = 0;
		gtt = 0;

		for (int i = 0; i <= 33; i++) {
			gp = gp - n1[i] * I1[i] * Math.pow((7.1 - p), (I1[i] - 1)) * Math.pow((tau - 1.222), J1[i]);
			gpp = gpp + n1[i] * I1[i] * (I1[i] - 1) * Math.pow((7.1 - p), (I1[i] - 2)) * Math.pow((tau - 1.222), J1[i]);
			gpt = gpt - n1[i] * I1[i] * Math.pow((7.1 - p), (I1[i] - 1)) * J1[i] * Math.pow((tau - 1.222), (J1[i] - 1));
			gtt = gtt + n1[i] * Math.pow((7.1 - p), I1[i]) * J1[i] * (J1[i] - 1) * Math.pow((tau - 1.222), (J1[i] - 2));
		}

		return (Math.pow(
				(1000 * R * T * Math.pow(gp, 2) / (Math.pow((gp - tau * gpt), 2) / (Math.pow(tau, 2) * gtt) - gpp)),
				0.5));
	}

	public double s_pT(double p, double T) {
		p = p / 16.53;
		T = 1386 / T;
		g = 0;
		gt = 0;

		for (int i = 0; i <= 33; i++) {
			gt = gt + (n1[i] * Math.pow((7.1 - p), I1[i]) * J1[i] * Math.pow((T - 1.222), (J1[i] - 1)));
			g = g + n1[i] * Math.pow((7.1 - p), I1[i]) * Math.pow((T - 1.222), J1[i]);

		}
		return (R * T * gt - R * g);
	}

	public double u_pT(double p, double T) {
		p = p / 16.53;
		tau = 1386 / T;
		gt = 0;
		gp = 0;

		for (int i = 0; i <= 33; i++) {
			gp = gp - n1[i] * I1[i] * Math.pow((7.1 - p), (I1[i] - 1)) * Math.pow((tau - 1.222), J1[i]);
			gt = gt + (n1[i] * Math.pow((7.1 - p), I1[i]) * J1[i] * Math.pow((tau - 1.222), (J1[i] - 1)));
		}

		return (R * T * (tau * gt - p * gp));
	}

	public double Cp_pT(double p, double T) {
		p = p / 16.53;
		T = 1386 / T;
		gtt = 0;

		for (int i = 0; i <= 33; i++) {

			gtt = gtt + (n1[i] * Math.pow((7.1 - p), I1[i]) * J1[i] * (J1[i] - 1) * Math.pow((T - 1.222), (J1[i] - 2)));

		}

		return (-R * Math.pow(T, 2) * gtt);
	}

	public double T_ph(double p, double h) {
		double T;

		double[] I1 = new double[] { 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 3, 3, 4, 5, 6 };
		double[] J1 = new double[] { 0, 1, 2, 6, 22, 32, 0, 1, 2, 3, 4, 10, 32, 10, 32, 10, 32, 32, 32, 32 };
		double[] n1 = new double[] { -238.72489924521, 404.21188637945, 113.49746881718, -5.8457616048039,
				-1.528548241314E-04, -1.0866707695377E-06, -13.391744872602, 43.211039183559, -54.010067170506,
				30.535892203916, -6.5964749423638, 9.3965400878363E-03, 1.157364750534E-07, -2.5858641282073E-05,
				-4.0644363084799E-09, 6.6456186191635E-08, 8.0670734103027E-11, -9.3477771213947E-13,
				5.8265442020601E-15, -1.5020185953503E-17 };

		h = h / 2500;
		T = 0;

		for (int i = 0; i <= 19; i++) {
			T = T + n1[i] * Math.pow(p, I1[i]) * Math.pow((h + 1), J1[i]);
		}

		return T;
	}

	public double T_ps(double p, double s) {
		double T1ps;

		double[] I1 = new double[] { 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 4 };
		double[] J1 = new double[] { 0, 1, 2, 3, 11, 31, 0, 1, 2, 3, 12, 31, 0, 1, 2, 9, 31, 10, 32, 32 };
		double[] n1 = new double[] { 174.78268058307, 34.806930892873, 6.5292584978455, 0.33039981775489,
				-1.9281382923196E-07, -2.4909197244573E-23, -0.26107636489332, 0.22592965981586, -0.064256463395226,
				7.8876289270526E-03, 3.5672110607366E-10, 1.7332496994895E-24, 5.6608900654837E-04,
				-3.2635483139717E-04, 4.4778286690632E-05, -5.1322156908507E-10, -4.2522657042207E-26,
				2.6400441360689E-13, 7.8124600459723E-29, -3.0732199903668E-31 };

		T1ps = 0;

		for (int i = 0; i <= 19; i++) {
			T1ps = T1ps + n1[i] * Math.pow(p, I1[i]) * Math.pow((s + 2), J1[i]);
		}

		return (T1ps);
	}

	public double p_hs(double h, double s) {
		double p;

		double[] I1 = new double[] { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 4, 4, 5 };
		double[] J1 = new double[] { 0, 1, 2, 4, 5, 6, 8, 14, 0, 1, 4, 6, 0, 1, 10, 4, 1, 4, 0 };
		double[] n1 = new double[] { -0.691997014660582, -18.361254878756, -9.28332409297335, 65.9639569909906,
				-16.2060388912024, 450.620017338667, 854.68067822417, 6075.23214001162, 32.6487682621856,
				-26.9408844582931, -319.9478483343, -928.35430704332, 30.3634537455249, -65.0540422444146,
				-4309.9131651613, -747.512324096068, 730.000345529245, 1142.84032569021, -436.407041874559 };

		h = h / 3400;
		s = s / 7.6;
		p = 0;

		for (int i = 0; i <= 18; i++) {
			p = p + n1[i] * Math.pow((h + 0.05), I1[i]) * Math.pow((s + 0.05), J1[i]);
		}

		return (p * 100);
	}

}
