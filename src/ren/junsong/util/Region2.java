package ren.junsong.util;

public class Region2 implements Property {
	double tau, g0pi, grpi, g0tau, grtau, g0, gr, g0tautau, grtautau, grpitau, grpipi;
	double R = ConstantForCal.R;
	double J0[] = ConstantForCal.J20;
	double n0[] = ConstantForCal.n20;
	double Ir[] = ConstantForCal.I2r;
	double Jr[] = ConstantForCal.J2r;
	double nr[] = ConstantForCal.n2r;

	@Override
	public double v_pT(double p, double T) {
		tau = 540 / T;
		g0pi = 1 / p;
		grpi = 0;
		for (int i = 0; i <= 42; i++) {
			grpi = grpi + nr[i] * Ir[i] * Math.pow(p, (Ir[i] - 1)) * Math.pow((tau - 0.5), Jr[i]);
		}
		return (R * T / p * p * (g0pi + grpi) / 1000);
	}

	@Override
	public double h_pT(double p, double T) {
		tau = 540 / T;

		g0tau = 0;

		for (int i = 0; i <= 8; i++) {

			g0tau = g0tau + n0[i] * J0[i] * Math.pow(tau, (J0[i] - 1));

		}

		grtau = 0;

		for (int i = 0; i <= 42; i++) {

			grtau = grtau + nr[i] * Math.pow(p, Ir[i]) * Jr[i] * Math.pow((tau - 0.5), (Jr[i] - 1));

		}

		return (R * T * tau * (g0tau + grtau));
	}

	@Override
	public double w_pT(double p, double T) {
		tau = 540 / T;
		g0tautau = 0;

		for (int i = 0; i <= 8; i++) {
			g0tautau = g0tautau + n0[i] * J0[i] * (J0[i] - 1) * Math.pow(tau, (J0[i] - 2));
		}

		grpi = 0;
		grpitau = 0;
		grpipi = 0;
		grtautau = 0;

		for (int i = 0; i <= 42; i++) {
			grpi = grpi + nr[i] * Ir[i] * Math.pow(p, (Ir[i] - 1)) * Math.pow((tau - 0.5), Jr[i]);
			grpipi = grpipi + nr[i] * Ir[i] * (Ir[i] - 1) * Math.pow(p, (Ir[i] - 2)) * Math.pow((tau - 0.5), Jr[i]);
			grpitau = grpitau + nr[i] * Ir[i] * Math.pow(p, (Ir[i] - 1)) * Jr[i] * Math.pow((tau - 0.5), (Jr[i] - 1));
			grtautau = grtautau + nr[i] * Math.pow(p, Ir[i]) * Jr[i] * (Jr[i] - 1) * Math.pow((tau - 0.5), (Jr[i] - 2));

		}

		return (Math.pow((1000 * R * T * (1 + 2 * p * grpi + Math.pow(p, 2) * Math.pow(grpi, 2))
				/ ((1 - Math.pow(p, 2) * grpipi) + Math.pow((1 + p * grpi - tau * p * grpitau), 2)
						/ (Math.pow(tau, 2) * (g0tautau + grtautau)))),
				0.5));
	}

	@Override
	public double s_pT(double p, double T) {
		tau = 540 / T;
		g0 = Math.log(p);
		g0tau = 0;

		for (int i = 0; i <= 8; i++) {
			g0 = g0 + n0[i] * Math.pow(tau, J0[i]);
			g0tau = g0tau + n0[i] * J0[i] * Math.pow(tau, (J0[i] - 1));
		}

		gr = 0;
		grtau = 0;

		for (int i = 0; i <= 42; i++) {
			gr = gr + nr[i] * Math.pow(p, Ir[i]) * Math.pow((tau - 0.5), Jr[i]);
			grtau = grtau + nr[i] * Math.pow(p, Ir[i]) * Jr[i] * Math.pow((tau - 0.5), (Jr[i] - 1));
		}

		return (R * (tau * (g0tau + grtau) - (g0 + gr)));
	}

	@Override
	public double u_pT(double p, double T) {
		tau = 540 / T;
		g0pi = 1 / p;
		g0tau = 0;

		for (int i = 0; i <= 8; i++) {
			g0tau = g0tau + n0[i] * J0[i] * Math.pow(tau, (J0[i] - 1));

		}

		grpi = 0;
		grtau = 0;

		for (int i = 0; i <= 42; i++) {

			grpi = grpi + nr[i] * Ir[i] * Math.pow(p, (Ir[i] - 1)) * Math.pow((tau - 0.5), Jr[i]);
			grtau = grtau + nr[i] * Math.pow(p, Ir[i]) * Jr[i] * Math.pow((tau - 0.5), (Jr[i] - 1));

		}

		return (R * T * (tau * (g0tau + grtau) - p * (g0pi + grpi)));
	}

	@Override
	public double Cp_pT(double p, double T) {
		tau = 540 / T;
		g0tautau = 0;

		for (int i = 0; i <= 8; i++) {
			g0tautau = g0tautau + n0[i] * J0[i] * (J0[i] - 1) * Math.pow(tau, (J0[i] - 2));
		}

		grtautau = 0;

		for (int i = 0; i <= 42; i++) {
			grtautau = grtautau + nr[i] * Math.pow(p, Ir[i]) * Jr[i] * (Jr[i] - 1) * Math.pow((tau - 0.5), (Jr[i] - 2));
		}

		return (-R * Math.pow(tau, 2) * (g0tautau + grtautau));
	}

}
