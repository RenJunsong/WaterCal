package ren.junsong.util;
/**
 * Ò»Çø
 * @author Ren Junsong
 *
 */
public class Region1 implements Property{
	double ps, tau, g,gt,gp,Gtt,gpp,gpt;
    double R = 0.461526; //kJ/(kg K)
    double[] I1 = new double[] { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 8, 8, 21, 23, 29, 30, 31, 32 };
    double[] J1 = new double[] { -2, -1, 0, 1, 2, 3, 4, 5, -9, -7, -1, 0, 1, 3, -3, 0, 1, 3, 17, -4, 0, 6, -5, -2, 10, -8, -11, -6, -29, -31, -38, -39, -40, -41 };
    double[] n1 = new double[] { 0.14632971213167, -0.84548187169114, -3.756360367204, 3.3855169168385, -0.95791963387872, 0.15772038513228, -0.016616417199501, 8.1214629983568E-04, 2.8319080123804E-04, -6.0706301565874E-04, -0.018990068218419, -0.032529748770505, -0.021841717175414, -5.283835796993E-05, -4.7184321073267E-04, -3.0001780793026E-04, 4.7661393906987E-05, -4.4141845330846E-06, -7.2694996297594E-16, -3.1679644845054E-05, -2.8270797985312E-06, -8.5205128120103E-10, -2.2425281908E-06, -6.5171222895601E-07, -1.4341729937924E-13, -4.0516996860117E-07, -1.2734301741641E-09, -1.7424871230634E-10, -6.8762131295531E-19, 1.4478307828521E-20, 2.6335781662795E-23, -1.1947622640071E-23, 1.8228094581404E-24, -9.3537087292458E-26 };
	@Override
	public double v_pT(double p, double T) {
		ps = p / 16.53;
        tau = 1386 / T;
        g = 0.0;
        for (int i = 0; i <= 33; i++){
            g = g - n1[i] * I1[i] * Math.pow((7.1 - ps), (I1[i] - 1)) * Math.pow((tau - 1.222), J1[i]);
        }
        return (R * T / p * ps * g / 1000);
	}
	@Override
	public double h_pT(double p, double T) {
		 ps = p / 16.53;
         tau = 1386 / T;
         g = 0;for (int i = 0; i <= 33; i++){
             g = g + (n1[i] * Math.pow((7.1 - ps), I1[i]) * J1[i] * Math.pow((tau - 1.222), (J1[i] - 1)));
         }

         return(R * T * tau * g);
	}
	@Override
	public double w_pT(double p, double T) {
		 p = p / 16.53;
         tau = 1386 / T;

         gp = 0;
         gpp = 0;
         gpt = 0;
         Gtt = 0;

         for (int i = 0; i <= 33; i++)
         {
             gp = gp - n1[i] * I1[i] * Math.pow((7.1 - p), (I1[i] - 1)) * Math.pow((tau - 1.222), J1[i]);
             gpp = gpp + n1[i] * I1[i] * (I1[i] - 1) * Math.pow((7.1 - p), (I1[i] - 2)) * Math.pow((tau - 1.222), J1[i]);
             gpt = gpt - n1[i] * I1[i] * Math.pow((7.1 - p), (I1[i] - 1)) * J1[i] * Math.pow((tau - 1.222), (J1[i] - 1));
             Gtt = Gtt + n1[i] * Math.pow((7.1 - p), I1[i]) * J1[i] * (J1[i] - 1) * Math.pow((tau - 1.222), (J1[i] - 2));
         }

         return (Math.pow((1000 * R * T * Math.pow(gp, 2) / (Math.pow((gp - tau * gpt), 2) / (Math.pow(tau, 2) * Gtt) - gpp)), 0.5));
	}
	@Override
	public double s_pT(double p, double T) {
		p = p / 16.53;
        T = 1386 / T;
        g = 0;
        gt = 0;

        for (int i = 0; i <= 33; i++)
        {
        	gt = gt + (n1[i] * Math.pow((7.1 - p), I1[i]) * J1[i] * Math.pow((T - 1.222), (J1[i] - 1)));
            g = g + n1[i] * Math.pow((7.1 - p), I1[i]) * Math.pow((T - 1.222), J1[i]);

        }
        return (R * T * gt - R * g);
	}
	@Override
	public double u_pT(double p, double T) {
		p = p / 16.53;
        tau = 1386 / T;
        gt = 0;
        gp = 0;

        for (int i = 0; i <= 33; i++)
        {
            gp = gp - n1[i] * I1[i] * Math.pow((7.1 - p), (I1[i] - 1)) * Math.pow((tau - 1.222), J1[i]);
            gt = gt + (n1[i] * Math.pow((7.1 - p), I1[i]) * J1[i] * Math.pow((tau - 1.222), (J1[i] - 1)));
        }

       return (R * T * (tau * gt - p * gp));
	}
	@Override
	public double Cp_pT(double p, double T) {
		p = p / 16.53;
        T = 1386 / T;
        Gtt = 0;

        for (int i = 0; i <= 33; i++)
        {

            Gtt = Gtt + (n1[i] * Math.pow((7.1 - p), I1[i]) * J1[i] * (J1[i] - 1) * Math.pow((T - 1.222), (J1[i] - 2)));

        }

        return (-R * Math.pow(T, 2) * Gtt);
	}
	
	
}
