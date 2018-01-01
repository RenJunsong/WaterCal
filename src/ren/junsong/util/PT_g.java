package ren.junsong.util;

import ren.junsong.view.UIFrame;

public class PT_g {
	public double p_gT(double g,double T){
		double p=133*Math.pow(10, -5);
		p=find(g,T);
	
		return p;
	}
	private double find(double g,double T) {
		double min=0.0000000000001,max=10,acc1=0.0001,acc2=0.001;
		double dichotomyRes;
		dichotomyRes=dichotomyCal(min,max,g,T,acc1);
		return dichotomyRes;
	}
	private double dichotomyCal(double min, double max, double g,double T, double acc1) {
		double acc;
		boolean monotonicityDe;
		
		monotonicityDe=checkAndCal(min,T)>checkAndCal(max,T);
		if((g>checkAndCal(min,T)&&g>checkAndCal(max,T))||(g<checkAndCal(min,T)&&g<checkAndCal(max,T))){
			return -1;
		}
		acc=checkAndCal((min+max)/2,T)-g;
		while(Math.abs(acc)>acc1){
			if(monotonicityDe){
				if(acc>0){
					min=(min+max)/2;
				}else{
					max=(min+max)/2;
				}
			}else{
				if(acc>0){
					max=(min+max)/2;
				}else{
					min=(min+max)/2;
				}
			}
			
			acc=checkAndCal((min+max)/2,T)-g;
		}
		
		System.out.println((min+max)/2);
		return (min+max)/2;
	}
	
	private double checkAndCal(double p,double T) {
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
		result = pro.g_pT(p, T) * 0.01801528;
		return result;
	}
}
