package com.hw.n2493_탑;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src\\com\\hw\\n2493_탑\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int top = -1; 
		int [] stack = new int [n];
		int [] tower = new int [n];
		int val;
		
		for (int t = 0; t < n; t++) {
			val = Integer.parseInt(st.nextToken());
			
			while(top>=0) {
				if(tower[top] > val) {
					bw.append((stack[top]+1)+" ");
					break;
				}
				else top --;
			}
			
			if(top<0) bw.append(0 +" ");
			
			stack[++top] = t;
			tower[top] = val;
		}
		bw.flush();

		bw.close();
	}

}
