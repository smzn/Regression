package regression;

import java.util.Random;

public class Regression_lib {
	
	double x[][], y[];
	double theta[];
	double eta = 0.0001;
	Random rand = new Random();

	public Regression_lib(double[][] x, double[] y) {
		this.x = x;
		this.y = y;
		theta = new double[x[0].length];
		for(int i = 0; i < theta.length; i++) {
			theta[i] = rand.nextGaussian();
		}
	}

	public double getObject() {
		// TODO Auto-generated method stub
		double object = 0;
		for(int i = 0; i < x.length; i++){
			object += Math.pow(y[i] - this.getInnerProduct(theta, x[i]), 2);
		}
		return object / 2 ;
	}

	public double[] getGradient() {
		// TODO Auto-generated method stub
		double gradient[] = new double[theta.length];
		for(int i = 0; i < theta.length; i++) {
			for(int j = 0; j < x.length; j++) {
				gradient[i] += (this.getInnerProduct(theta, x[j]) - y[j]) * x[j][i];
			}
			System.out.println("gradient["+i+"] = "+gradient[i]);
		}
		for(int i = 0; i < theta.length; i++) {
			theta[i] -= eta * gradient[i];
		}
		return theta;
	}

	public double getInnerProduct(double a[], double b[]) {
		double answer = 0;
		for(int i = 0; i < a.length; i++) {
			answer += a[i] * b[i];
		}
		return answer;
	}
}
