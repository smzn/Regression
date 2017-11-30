package regression;

import java.util.Arrays;

public class Regression_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//double x[][] = { {1,0.0,2.0}, {1,0.2,3.0}, {1,0.4,2.2}, {1,0.6,1.2}, {1,0.8,4.2}, {1,1.0,3.2}, {1,1.2,1.0} };
		//double y[] = { 1.0, 1.9, 3.2, 4.3, 4.8, 6.1, 7.2 };

		//この例はOK
		//double x[][] = {{1,5,6},{1,5,8},{1,7,10},{1,4,13},{1,8,11},{1,12,13}};
		//double y[] = {8,9,13,11,14,17};
		
		double x[][] = {
				{1,6.0,2.8,2.0},{1,8.4,2.2,2.4},{1,20.0,1.4,1.0},{1,11.0,1.0,0.9},{1,8.0,0.8,1.1},{1,28.0,0.7,0.8},{1,24.0,1.5,1.0},{1,10.0,3.5,1.4},{1,11.0,2.7,2.1},{1,30.0,1.2,1.1},
				{1,26.0,1.0,1.8},{1,16.0,0.7,1.4},{1,21.0,2.8,0.8},{1,8.0,3.8,1.9},{1,9.0,1.9,3.2},{1,20.0,1.2,1.0},{1,9.0,2.9,2.4},{1,15.0,3.1,1.4},{1,21.0,1.8,1.4},{1,12.0,1.9,1.1}
		};
		double y[] = {1.0,1.8,2.7,3.6,2.2,7.3,4.8,2.6,2.1,5.6,4.2,5.5,3.2,1.4,1.2,2.8,2.0,1.4,3.3,2.9};
		
		Regression_lib slib = new Regression_lib(x, y);
		
		for(int i = 0; i < 300000; i++){
			System.out.println(i+" : Theta"+ Arrays.toString(slib.getGradient()));
			System.out.println(i+" : Objective function = "+slib.getObject());
		}
	}

}
