package ren.junsong.util;

public class ConstantForCal {
	public static final double a=5.51/10;
	public static final double b=0.0304/1000;
	public static final double R0=8.314;  //J/mol/k  
	public static final double R = 0.461526; // kJ/(kg K)
	// 一区
	public static final double[] I1 = new double[] { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3,
			4, 4, 4, 5, 8, 8, 21, 23, 29, 30, 31, 32 };
	public static final double[] J1 = new double[] { -2, -1, 0, 1, 2, 3, 4, 5, -9, -7, -1, 0, 1, 3, -3, 0, 1, 3, 17, -4,
			0, 6, -5, -2, 10, -8, -11, -6, -29, -31, -38, -39, -40, -41 };
	public static final double[] n1 = new double[] { 0.14632971213167, -0.84548187169114, -3.756360367204,
			3.3855169168385, -0.95791963387872, 0.15772038513228, -0.016616417199501, 8.1214629983568E-04,
			2.8319080123804E-04, -6.0706301565874E-04, -0.018990068218419, -0.032529748770505, -0.021841717175414,
			-5.283835796993E-05, -4.7184321073267E-04, -3.0001780793026E-04, 4.7661393906987E-05, -4.4141845330846E-06,
			-7.2694996297594E-16, -3.1679644845054E-05, -2.8270797985312E-06, -8.5205128120103E-10, -2.2425281908E-06,
			-6.5171222895601E-07, -1.4341729937924E-13, -4.0516996860117E-07, -1.2734301741641E-09,
			-1.7424871230634E-10, -6.8762131295531E-19, 1.4478307828521E-20, 2.6335781662795E-23, -1.1947622640071E-23,
			1.8228094581404E-24, -9.3537087292458E-26 };
	// 二区
	public static final double[] J20 = new double[] { 0, 1, -5, -4, -3, -2, -1, 2, 3 };
	public static final double[] n20 = new double[] { -9.6927686500217, 10.086655968018, -0.005608791128302,
			0.071452738081455, -0.40710498223928, 1.4240819171444, -4.383951131945, -0.28408632460772,
			0.021268463753307 };
	public static final double[] I2r = new double[] { 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 5, 6, 6, 6,
			7, 7, 7, 8, 8, 9, 10, 10, 10, 16, 16, 18, 20, 20, 20, 21, 22, 23, 24, 24, 24 };
	public static final double[] J2r = new double[] { 0, 1, 2, 3, 6, 1, 2, 4, 7, 36, 0, 1, 3, 6, 35, 1, 2, 3, 7, 3, 16,
			35, 0, 11, 25, 8, 36, 13, 4, 10, 14, 29, 50, 57, 20, 35, 48, 21, 53, 39, 26, 40, 58 };
	public static final double[] n2r = new double[] { -1.7731742473213E-03, -0.017834862292358, -0.045996013696365,
			-0.057581259083432, -0.05032527872793, -3.3032641670203E-05, -1.8948987516315E-04, -3.9392777243355E-03,
			-0.043797295650573, -2.6674547914087E-05, 2.0481737692309E-08, 4.3870667284435E-07, -3.227767723857E-05,
			-1.5033924542148E-03, -0.040668253562649, -7.8847309559367E-10, 1.2790717852285E-08, 4.8225372718507E-07,
			2.2922076337661E-06, -1.6714766451061E-11, -2.1171472321355E-03, -23.895741934104, -5.905956432427E-18,
			-1.2621808899101E-06, -0.038946842435739, 1.1256211360459E-11, -8.2311340897998, 1.9809712802088E-08,
			1.0406965210174E-19, -1.0234747095929E-13, -1.0018179379511E-09, -8.0882908646985E-11, 0.10693031879409,
			-0.33662250574171, 8.9185845355421E-25, 3.0629316876232E-13, -4.2002467698208E-06, -5.9056029685639E-26,
			3.7826947613457E-06, -1.2768608934681E-15, 7.3087610595061E-29, 5.5414715350778E-17, -9.436970724121E-07 };
	// 三区
	public static final double[] I3 = new double[] { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3,
			3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 8, 9, 9, 10, 10, 11 };
	public static final double[] J3 = new double[] { 0, 0, 1, 2, 7, 10, 12, 23, 2, 6, 15, 17, 0, 2, 6, 7, 22, 26, 0, 2,
			4, 16, 26, 0, 2, 4, 26, 1, 3, 26, 0, 2, 26, 2, 26, 2, 26, 0, 1, 26 };
	public static final double[] n3 = new double[] { 1.0658070028513, -15.732845290239, 20.944396974307,
			-7.6867707878716, 2.6185947787954, -2.808078114862, 1.2053369696517, -8.4566812812502E-03, -1.2654315477714,
			-1.1524407806681, 0.88521043984318, -0.64207765181607, 0.38493460186671, -0.85214708824206, 4.8972281541877,
			-3.0502617256965, 0.039420536879154, 0.12558408424308, -0.2799932969871, 1.389979956946, -2.018991502357,
			-8.2147637173963E-03, -0.47596035734923, 0.0439840744735, -0.44476435428739, 0.90572070719733,
			0.70522450087967, 0.10770512626332, -0.32913623258954, -0.50871062041158, -0.022175400873096,
			0.094260751665092, 0.16436278447961, -0.013503372241348, -0.014834345352472, 5.7922953628084E-04,
			3.2308904703711E-03, 8.0964802996215E-05, -1.6557679795037E-04, -4.4923899061815E-05 };
	// 五区
	public static final double[] J50 = new double[] { 0, 1, -3, -2, -1, 2 };
	public static final double[] n50 = new double[] { -13.179983674201, 6.8540841634434, -0.024805148933466,
			0.36901534980333, -3.1161318213925, -0.32961626538917 };
	public static final double[] I5r = new double[] { 1, 1, 1, 2, 2, 3 };
	public static final double[] J5r = new double[] { 1, 2, 3, 3, 9, 7 };
	public static final double[] n5r = new double[] { 0.15736404855259E-02, 0.90153761673944E-03, -0.50270077677648E-02,
			0.22440037409485E-05, -0.41163275453471E-05, 0.37919454822955E-07 };
}
