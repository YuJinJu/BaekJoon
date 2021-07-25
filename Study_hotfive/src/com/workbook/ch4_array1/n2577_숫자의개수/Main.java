package com.workbook.ch4_array1.n2577_숫자의개수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		
		String result = Integer.toString(a*b*c); //17037300
		char arr[] = new char[10];
		
		for(int i=0;i<result.length();i++) {
			int index = result.charAt(i) -'0';
			arr[index]++;
		}
//		System.out.println(result.charAt(8));
//		System.out.println(result);
//		System.out.println(result.length());
		for(int i :arr) System.out.println(i);
	}

}
/*
input
150
266
427
 */
