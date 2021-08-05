package com.hw.n2493_탑;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

//top index : 1 ~ 500,000
//top value : 1 ~ 100,000,000
public class Main2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("src\\com\\hw\\n2493_탑\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] top = new int[n]; // 탑의 높이 저장
		for (int t = 0; t < n; t++) {
			top[t] = Integer.parseInt(st.nextToken());
		}

		int[] receive = new int[n]; // 탑의 index를 배열 index에 맞춰서 수신값 저장
		receive[0] = 0;
		for (int i = n - 1; i >= 1; i--) { // i는 신호를 보내는 현재 탑위치
			for (int j = i - 1; j >= 0; j--) {	//j는 신호를 받는 탑위치
				if (top[i] < top[j]) {
					receive[i] = j + 1;
					break;
				}
			}
		}
		
		for (int i : receive) {
			bw.append(i + " ");
		}
		bw.flush();

		bw.close();
	}

}
