package ren.junsong.util;

/**
 * 此为5区方程，文档推荐温度范围为 0<p<=10Mpa
 * 
 * @author famugoing
 *
 */
public class Region5 implements Property {
	double tau, gamma0_tau, gammar_tau, h5_pT, gamma0_pi, gammar_pi, gamma0_tautau, gammar_tautau, gamma0, gammar,
			gammar_pitau, gammar_pipi;
	double R = ConstantForCal.R;
	double Ji0[] = ConstantForCal.J50;
	double ni0[] = ConstantForCal.n50;
	double Jir[] = ConstantForCal.J5r;
	double nir[] = ConstantForCal.n5r;
	double Iir[] = ConstantForCal.I5r;

	@Override
	public double v_pT(double p, double T) {
		tau = 1000 / T;
		gamma0_pi = 1 / p;
		gammar_pi = 0;
		for (int i = 0; i <= 5; i++) {
			gammar_pi = gammar_pi + nir[i] * Iir[i] * Math.pow(p, (Iir[i] - 1)) * Math.pow(tau, Jir[i]);
		}
		return (R * T / p * p * (gamma0_pi + gammar_pi) / 1000);
	}

	@Override
	public double h_pT(double p, double T) {
		tau = 1000 / T;
		gamma0_tau = 0;
		for (int i = 0; i <= 5; i++) {
			gamma0_tau = gamma0_tau + ni0[i] * Ji0[i] * Math.pow(tau, (Ji0[i] - 1));
		}
		gammar_tau = 0;
		for (int i = 0; i <= 5; i++) {
			gammar_tau = gammar_tau + nir[i] * Math.pow(p, Iir[i]) * Jir[i] * Math.pow(tau, (Jir[i] - 1));
		}
		return (R * T * tau * (gamma0_tau + gammar_tau));
	}

	@Override
	public double w_pT(double p, double T) {
		tau = 1000 / T;
		gamma0_tautau = 0;

		for (int i = 0; i <= 5; i++) {
			gamma0_tautau = gamma0_tautau + ni0[i] * (Ji0[i] - 1) * Ji0[i] * Math.pow(tau, (Ji0[i] - 2));
		}

		gammar_pi = 0;
		gammar_pitau = 0;
		gammar_pipi = 0;
		gammar_tautau = 0;

		for (int i = 0; i <= 5; i++) {
			gammar_pi = gammar_pi + nir[i] * Iir[i] * Math.pow(p, (Iir[i] - 1)) * Math.pow(tau, Jir[i]);
			gammar_pitau = gammar_pitau
					+ nir[i] * Iir[i] * Math.pow(p, (Iir[i] - 1)) * Jir[i] * Math.pow(tau, (Jir[i] - 1));
			gammar_pipi = gammar_pipi
					+ nir[i] * Iir[i] * (Iir[i] - 1) * Math.pow(p, (Iir[i] - 2)) * Math.pow(tau, Jir[i]);
			gammar_tautau = gammar_tautau
					+ nir[i] * Math.pow(p, Iir[i]) * Jir[i] * (Jir[i] - 1) * Math.pow(tau, (Jir[i] - 2));
		}

		return (Math
				.pow((1000 * R * T * (1 + 2 * p * gammar_pi + Math.pow(p, 2) * Math.pow(gammar_pi, 2))
						/ ((1 - Math.pow(p, 2) * gammar_pipi)
								+ Math.pow((1 + p * gammar_pi - tau * p * gammar_pitau), 2)
										/ (Math.pow(tau, 2) * (gamma0_tautau + gammar_tautau)))),
						0.5));
	}

	@Override
	public double s_pT(double p, double T) {
		tau = 1000 / T;
		gamma0 = Math.log(p);
		gamma0_tau = 0;

		for (int i = 0; i <= 5; i++) {
			gamma0_tau = gamma0_tau + ni0[i] * Ji0[i] * Math.pow(tau, (Ji0[i] - 1));
			gamma0 = gamma0 + ni0[i] * Math.pow(tau, Ji0[i]);
		}

		gammar = 0;
		gammar_tau = 0;

		for (int i = 0; i <= 5; i++) {
			gammar = gammar + nir[i] * Math.pow(p, Iir[i]) * Math.pow(tau, Jir[i]);
			gammar_tau = gammar_tau + nir[i] * Math.pow(p, Iir[i]) * Jir[i] * Math.pow(tau, (Jir[i] - 1));
		}

		return (R * (tau * (gamma0_tau + gammar_tau) - (gamma0 + gammar)));
	}

	@Override
	public double u_pT(double p, double T) {
		tau = 1000 / T;
		gamma0_pi = 1 / p;
		gamma0_tau = 0;

		for (int i = 0; i <= 5; i++) {
			gamma0_tau = gamma0_tau + ni0[i] * Ji0[i] * Math.pow(tau, (Ji0[i] - 1));
		}
		gammar_pi = 0;
		gammar_tau = 0;
		for (int i = 0; i <= 5; i++) {
			gammar_pi = gammar_pi + nir[i] * Iir[i] * Math.pow(p, (Iir[i] - 1)) * Math.pow(tau, Jir[i]);
			gammar_tau = gammar_tau + nir[i] * Math.pow(p, Iir[i]) * Jir[i] * Math.pow(tau, (Jir[i] - 1));

		}
		return (R * T * (tau * (gamma0_tau + gammar_tau) - p * (gamma0_pi + gammar_pi)));
	}

	@Override
	public double Cp_pT(double p, double T) {
		tau = 1000 / T;
		gamma0_tautau = 0;

		for (int i = 0; i <= 5; i++) {
			gamma0_tautau = gamma0_tautau + ni0[i] * Ji0[i] * (Ji0[i] - 1) * Math.pow(tau, (Ji0[i] - 2));
		}

		gammar_tautau = 0;

		for (int i = 0; i <= 5; i++) {
			gammar_tautau = gammar_tautau
					+ nir[i] * Math.pow(p, Iir[i]) * Jir[i] * (Jir[i] - 1) * Math.pow(tau, (Jir[i] - 2));
		}

		return (-R * Math.pow(tau, 2) * (gamma0_tautau + gammar_tautau));
	}

	@Override
	public double g_pT(double p, double T) {
		return h_pT(p,T)-T*s_pT(p,T);
	}

}
