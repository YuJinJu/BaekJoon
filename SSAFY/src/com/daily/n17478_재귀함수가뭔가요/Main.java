package com.daily.n17478_재귀함수가뭔가요;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	private static String ss(int n) {
		String s = "----";
		if(n==0) return "";
		return s + ss(n-1);
	}
	
	//a,b는 반복 c는 제일 마지막에만 호출
	private static String str(int n) {
		StringBuilder sb = new StringBuilder();
		
		String s = "----";
		for(int i=0;i<n;i++) {
			
		}
		String a = "\"재귀함수가 뭔가요?\"\n";
		String b = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\r\n";
		String c = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\r\n";
		String d = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
		
		String y ="\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
		String z = "라고 답변하였지.\n";
		if (n==0) {
			sb.append(a+y+z);
		}
		//else return a+b+d;
		else {
			sb.append(a+b+c+d+str(n-1)+z);
		}
		
		return sb.toString(); 
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		int n = Integer.parseInt(br.readLine());
		bw.append(str(n));
		
		
		bw.flush();
		bw.close();
	}

}
