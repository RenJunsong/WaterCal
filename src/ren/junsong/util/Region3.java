package ren.junsong.util;

/**
 * 此为三区 其中，通过文档建立 f(rho,T)函数 结果计算机验证 p是关于rho的单调递增函数，故采取迭代法建立
 * rho=f(p,T)函数，然后再通过此函数计算其他值 rho关于T（p定）为单调递减函数
 * 
 * @author famugoing
 *
 */
public class Region3 implements Property {
	double delta, tau, fidelta, fitau;
	double R = ConstantForCal.R;
	double Ii[] = ConstantForCal.I3;
	double Ji[] = ConstantForCal.J3;
	double ni[] = ConstantForCal.n3;

	public double rho_pT(double p, double T) {
		double high = 770;
		double low = 0.1;
		double pT;
		double rho;
		do {
			rho = (high + low) / 2;
			pT = p_rhoT(rho, T);
			if (pT > p) {
				high = rho;
			} else {
				low = rho;
			}
		} while (Math.abs(pT - p) > 0.00000001);
		return rho;
	};

	public double v_rho(double rho) {
		return 1 / rho;
	}

	public double p_rhoT(double rho, double T) {
		double tc = 647.096;
		double rhoc = 322;
		delta = rho / rhoc;

		tau = tc / T;

		fidelta = 0;

		for (int i = 1; i <= 39; i++) {
			fidelta = fidelta + ni[i] * Ii[i] * Math.pow(delta, (Ii[i] - 1)) * Math.pow(tau, Ji[i]);
		}

		fidelta = fidelta + ni[0] / delta;

		return (rho * R * T * delta * fidelta / 1000);
	}

	public double u_rhoT(double rho, double T) {
		double tc = 647.096;
		double rhoc = 322;
		delta = rho / rhoc;

		tau = tc / T;

		fitau = 0;

		for (int i = 1; i <= 39; i++) {
			fitau = fitau + ni[i] * Math.pow(delta, Ii[i]) * Ji[i] * Math.pow(tau, (Ji[i] - 1));
		}

		return (R * T * (tau * fitau));

	}

	public double h_rhoT(double rho, double T) {
		double tc = 647.096;

		double rhoc = 322;
		delta = rho / rhoc;

		tau = tc / T;

		fidelta = 0;

		fitau = 0;

		for (int i = 1; i <= 39; i++) {
			fidelta = fidelta + ni[i] * Ii[i] * Math.pow(delta, (Ii[i] - 1)) * Math.pow(tau, Ji[i]);

			fitau = fitau + ni[i] * Math.pow(delta, Ii[i]) * Ji[i] * Math.pow(tau, (Ji[i] - 1));
		}

		fidelta = fidelta + ni[0] / delta;

		return (R * T * (tau * fitau + delta * fidelta));
	}

	public double s_rhoT(double rho, double T) {
		double tc = 647.096;

		double rhoc = 322;
		delta = rho / rhoc;
		double fi;

		tau = tc / T;

		fi = 0;

		fitau = 0;
		for (int i = 1; i <= 39; i++) {
			fi = fi + ni[i] * Math.pow(delta, Ii[i]) * Math.pow(tau, Ji[i]);
			fitau = fitau + ni[i] * Math.pow(delta, Ii[i]) * Ji[i] * Math.pow(tau, (Ji[i] - 1));
		}

		fi = fi + ni[0] * Math.log(delta);

		return (R * (tau * fitau - fi));
	}

	public double Cp_rhoT(double rho, double T) {
		double tc = 647.096;
		double rhoc = 322;
		delta = rho / rhoc;

		tau = tc / T;

		double fitautau = 0;

		fidelta = 0;

		double fideltatau = 0;

		double fideltadelta = 0;

		for (int i = 1; i <= 39; i++) {
			fitautau = fitautau + ni[i] * Math.pow(delta, Ii[i]) * Ji[i] * (Ji[i] - 1) * Math.pow(tau, (Ji[i] - 2));
			fidelta = fidelta + ni[i] * Ii[i] * Math.pow(delta, (Ii[i] - 1)) * Math.pow(tau, Ji[i]);
			fideltatau = fideltatau + ni[i] * Ii[i] * Math.pow(delta, (Ii[i] - 1)) * Ji[i] * Math.pow(tau, (Ji[i] - 1));
			fideltadelta = fideltadelta
					+ ni[i] * Ii[i] * (Ii[i] - 1) * Math.pow(delta, (Ii[i] - 2)) * Math.pow(tau, Ji[i]);

		}

		fidelta = fidelta + ni[0] / delta;

		fideltadelta = fideltadelta - ni[0] / (Math.pow(delta, 2));

		return (R * (-(Math.pow(tau, 2) * fitautau) + Math.pow((delta * fidelta - delta * tau * fideltatau), 2)
				/ (2 * delta * fidelta + Math.pow(delta, 2) * fideltadelta)));
	}

	@Override
	public double v_pT(double p, double T) {

		return v_rho(rho_pT(p, T));
	}

	@Override
	public double h_pT(double p, double T) {
		return h_rhoT(rho_pT(p, T), T);
	}

	@Override
	public double w_pT(double p, double T) {
		// return w_rhoT(rho_pT(p,T),T);
		return 0;
	}

	@Override
	public double s_pT(double p, double T) {
		return s_rhoT(rho_pT(p, T), T);
	}

	@Override
	public double u_pT(double p, double T) {
		return u_rhoT(rho_pT(p, T), T);
	}

	@Override
	public double Cp_pT(double p, double T) {
		return Cp_rhoT(rho_pT(p, T), T);
	}

}
