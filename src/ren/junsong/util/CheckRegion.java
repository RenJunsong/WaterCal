package ren.junsong.util;
/*
 * 用于检验输入内容所在分区
 */
public class CheckRegion {
	public static int region;
	public static int checkp_T(double p,double T){
		Borders bor=new Borders();
		double ps;
		int all=checkAll(p,T);
		if(all!=0){
			return all;
		}else if ((T > 1073.15) && (p < 50)){
			return 5;	
		}else if (T <= 1073.15){
			if (T > 623.15){
        	  if (p > bor.B23p_T(T)){
                    return 3;
                 }else{
                        //REGION 2
                        return 2;
                 	}
			}else   //1,4,2
                {
				ps = new Region4().p4_T(T);

                    if ((Math.abs(p - ps)) < 0.001)
                    {
                        //REGION 4
                      return 4;
                    }
                    else if (p > ps)
                    {
                        //REGION 1
                        return 1;
                    }
                    else
                    {
                        //REGION 2
                        return 2;
                    }
                }
        }else{
			return 0;
		}
	}		 
	private static int checkAll(double p, double T) {
		if(T<273.15||T>2273.15||p>100||p<0.000611){
			return 6; //输入越界
		}else if(T>1073.5&&p>10){
			return 6;
		}
		return 0;
		
	}
}
