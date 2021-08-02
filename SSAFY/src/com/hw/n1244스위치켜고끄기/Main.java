package com.hw.n1244스위치켜고끄기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		//스위치 개수 //100이하 양의 정수
		int swch = Integer.parseInt(br.readLine());
		
		
		//스위치 상태
		for(int i=0;i<swch;i++) {
			char [] status = st.nextToken().toCharArray();
			
		}
		
		//학생수 .. 100이하의 양의 정수
		int students = Integer.parseInt(br.readLine());
		int student [][] = new int[students][1]; //성별, 스위치 수
		// students = s1 + s2; // 학생수 = 남자수 + 여자수
		int m [] = new int[students];
		int wm [] = new int[students];
				
		//성별과 받은 수 입력받기
		//남 = 1, 여= 2,,,스위치 개수 : 1~swch
		for(int i=0;i<students;i++) {
			student[i][0] = st.nextToken().charAt(i) -'0';
			student[i][1] = st.nextToken().charAt(i) -'0';
			if(student[i][0] == 1) //남자일 때
			{
				System.out.println("남자입니다.");
			}
			else if(student[i][0] == 2) //여자일때
				System.out.println("여자입니다.");
			{
				
			}
		}
		
//		for(String i :student)
//		System.out.println(i);
	}

}
/*
8
0 1 0 1 0 0 0 1
2
1 3
2 3
 */
// 학생 몇 명을 뽑아서, 학생들에게 1 이상이고 스위치 개수 이하인 자연수를 하나씩 나누어주었다. 
//학생들은 자신의 성별과 받은 수에 따라 아래와 같은 방식으로 스위치를 조작하게 된다.
/*
 * 남학생은 스위치 번호가 자기가 받은 수의 배수이면, 그 스위치의 상태를 바꾼다. 즉, 스위치가 켜져 있으면 끄고, 꺼져 있으면 켠다.
 * 
 * <그림 1>과 같은 상태에서 남학생이 3을 받았다면, 이 학생은 <그림 2>와 같이 3번, 6번 스위치의 상태를 바꾼다.
 * 
 * 여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서, 그 구간에 속한 스위치의 상태를 모두 바꾼다. 이때 구간에 속한 스위치 개수는 항상 홀수가 된다.
 */