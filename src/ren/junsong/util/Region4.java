package ren.junsong.util;

/**
 * 此为4区方程，既饱和线方程，范围为 611.213 Pa<=p<=22.064 Mpa 273.15<=T<=647.096
 * 
 * @author famugoing
 *
 */
public class Region4 {
	public double p_T(double T) {

		double teta, a, b, c;

		teta = T - 0.23855557567849 / (T - 650.17534844798);

		a = Math.pow(teta, 2) + 1167.0521452767 * teta - 724213.16703206;
		b = -17.073846940092 * Math.pow(teta, 2) + 12020.82470247 * teta - 3232555.0322333;
		c = 14.91510861353 * Math.pow(teta, 2) - 4823.2657361591 * teta + 405113.40542057;

		return (Math.pow((2 * c / (-b + Math.pow((Math.pow(b, 2) - 4 * a * c), 0.5))), 4));

	}

	public double T_p(double p) {

		double beta, e1, f, g, d;

		beta = Math.pow(p, 0.25);

		e1 = Math.pow(beta, 2) - 17.073846940092 * beta + 14.91510861353;
		f = 1167.0521452767 * Math.pow(beta, 2) + 12020.82470247 * beta - 4823.2657361591;
		g = -724213.16703206 * Math.pow(beta, 2) - 3232555.0322333 * beta + 405113.40542057;
		d = 2 * g / (-f - Math.pow((Math.pow(f, 2) - 4 * e1 * g), 0.5));

		return ((650.17534844798 + d
				- Math.pow((Math.pow((650.17534844798 + d), 2) - 4 * (-0.23855557567849 + 650.17534844798 * d)), 0.5))
				/ 2);
	}

}
