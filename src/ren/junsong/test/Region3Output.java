package ren.junsong.test;
/**
 * 用于验证
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import ren.junsong.util.Region3;
/**
public class Region3Output {
	public static void main(String[] args) throws IOException{ //
		Region3 region3=new Region3();
		//double T=700;
		double p=100;
		File file=new File("d:/Region3.txt");
		OutputStream os=new FileOutputStream(file,true);
		for(double T=623;T<870;T+=0.05){
			Double re=region3.rho_pT(p,T);
			String st="\t";
			try {
				os.write(re.toString().getBytes());
				os.write(st.getBytes());
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			os.flush();
		}
		os.close();
		
	}
	
}
*/