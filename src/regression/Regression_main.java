package regression;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Regression_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//double x[][] = { {1,0.0,2.0}, {1,0.2,3.0}, {1,0.4,2.2}, {1,0.6,1.2}, {1,0.8,4.2}, {1,1.0,3.2}, {1,1.2,1.0} };
		//double y[] = { 1.0, 1.9, 3.2, 4.3, 4.8, 6.1, 7.2 };

		//この例はOK
		//double x[][] = {{1,5,6},{1,5,8},{1,7,10},{1,4,13},{1,8,11},{1,12,13}};
		//double y[] = {8,9,13,11,14,17};
		/*
		double x[][] = {
				{1,6.0,2.8,2.0},{1,8.4,2.2,2.4},{1,20.0,1.4,1.0},{1,11.0,1.0,0.9},{1,8.0,0.8,1.1},{1,28.0,0.7,0.8},{1,24.0,1.5,1.0},{1,10.0,3.5,1.4},{1,11.0,2.7,2.1},{1,30.0,1.2,1.1},
				{1,26.0,1.0,1.8},{1,16.0,0.7,1.4},{1,21.0,2.8,0.8},{1,8.0,3.8,1.9},{1,9.0,1.9,3.2},{1,20.0,1.2,1.0},{1,9.0,2.9,2.4},{1,15.0,3.1,1.4},{1,21.0,1.8,1.4},{1,12.0,1.9,1.1}
		};*/
		Regression_main rmain = new Regression_main();
		double[][] x = rmain.getCSV2("csv/x.csv", 20, 4);
		//double y[] = {1.0,1.8,2.7,3.6,2.2,7.3,4.8,2.6,2.1,5.6,4.2,5.5,3.2,1.4,1.2,2.8,2.0,1.4,3.3,2.9};
		double y[] = rmain.getCSV1("csv/y.csv", 20);
		
		Regression_lib slib = new Regression_lib(x, y);
		
		int iteration = 300000;
		double value[] = new double[iteration];
		for(int i = 0; i < iteration; i++){
			System.out.println(i+" : Theta"+ Arrays.toString(slib.getGradient()));
			System.out.println(i+" : Objective function = "+slib.getObject());
			value[i] = slib.getObject();
		}
		Graph graph = new Graph(value);
		graph.setBounds(5,5,755,455);
		graph.setVisible(true);
	}

	public double[][] getCSV2(String path, int row, int column) { //CSVから2次元データ取り込み
		//CSVから取り込み
		double csvdata[][] = new double[row][column];
		try {
			File f = new File(path);
			BufferedReader br = new BufferedReader(new FileReader(f));
				 
			String[][] data = new String[row][column];
			String line = br.readLine();
			for (int i = 0; line != null; i++) {
				data[i] = line.split(",", 0);
				line = br.readLine();
			}
			br.close();
			
			// CSVから読み込んだ配列の中身を取り込み
			for(int i = 0; i < data.length; i++) {
				for(int j = 0; j < data[0].length; j++) {
					csvdata[i][j] = Double.parseDouble(data[i][j]);
				}
			}

		} catch (IOException e) {
			System.out.println(e);
		}
		//System.out.println("CSV取り込み = "+Arrays.deepToString(csvdata));
		return csvdata;
		//CSVから取り込みここまで
	}

	public double[] getCSV1(String path, int n) { //CSVから1次元データ取り込み(n:データ数)
		//CSVから取り込み
		double csvdata[] = new double[n];
		try {
			File f = new File(path);
			BufferedReader br = new BufferedReader(new FileReader(f));
				 
			String[] data = new String[n];
			String line = br.readLine();
			data = line.split(",", 0);
			line = br.readLine();
			
			br.close();
			
			// CSVから読み込んだ配列の中身を取り込み
			for(int i = 0; i < data.length; i++) {
				csvdata[i] = Double.parseDouble(data[i]);
			}

		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("CSV取り込み = "+Arrays.toString(csvdata));
		return csvdata;
		//CSVから取り込みここまで
	}

}
