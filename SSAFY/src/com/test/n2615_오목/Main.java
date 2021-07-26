package com.test.n2615_오목;



import java.util.Scanner;

/*
가로줄과 세로줄에 1~19까지 번호가 붙어있는 오목판에 흰 바둑알과 검정
바둑알을 교대로 놓아서 먼저 정확히 5개의 같은 색 알이 연속적으로 일직선(직선, 대각선
포함)을 이루면 이기는 게임이다.
하지만 여섯 알 이상이 연속적으로 놓인 경우에는 이긴 것이 아니다.
검은색과 흰색이 동시에 이기거나 검은색 또는 흰색이 두 군데 이상에서 동시에
이기는 경우는 없다

input
검은 바둑알은 1, 흰 바둑알은 2, 알이 놓이지 않는 자리는 0
한칸씩 띄어서

pr
첫 줄에 승부가 결정되지 않았다면 0, 
검은 색이 이기면 1, 흰 색이 이기면 2를 출력

이긴 바둑알 중 가장 왼쪽,위쪽에 있는거의 가로줄 번호와, 세로줄 번호를
순서대로 출력한다
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr [][] = new int[19][19];
		//int xy [][] = new xy[][];
			
//			{
//			{-1,0},{1,0},{0,-1},{0,1}//,{-1,-1},{1,-1},{1,1},{-1,1}
//		};	
		// 상 하 좌 우 좌상 좌하 우하 상우
		
		for(int i =0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int count1 = 0;
		int count2 = 0;
		int startX = 0;
		int startY = 0;
		
		int tmpX = 0;
		int tmpY = 0;
		
		
		for(int i =0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				i = tmpX--;
				j = tmpY--;
				
				boolean yes1 = false;
				boolean yes2 = false;
				
				//검은알 일 때
				if(arr[i][j] == 1) {
					//if(arr[i-1][j]==1 && i-1>=0) xy[i][j] += xy[i-1][j];	//상
					//else if(arr[i][j-1]==1 && j-1>=0) xy[i][j] += xy[i][j-1]; //좌
					startX = j;
					startY = i;
					
					if(arr[i][j+1]==1 && j+1<19) yes1 = true; //우
					else if(arr[i+1][j]==1 && i+1<19) yes1 = true; //하

					//else if(arr[i-1][j-1]==1 && i-1>0 && j-1>=0) xy[i][j] += xy[i-1][j-1]; //좌상
					else if(arr[i+1][j-1]==1 && i+1<19 && j-1>=0) yes1 = true; //좌하
					else if(arr[i+1][j+1]==1 && i+1<19 && j+1<19) yes1 = true; //우하
					else if(arr[i-1][j+1]==1 && i-1>0 && j+1<19) yes1 = true; //상우
					else {
						yes1= false;
						count1=0;
					}
					
					if(yes1==true) {
						count1++;
						tmpX = j;
						tmpY = i;
					}
					
				//흰알일 때	
				}else if(arr[i][j] == 2) {
					if(arr[i-1][j]==2 && i-1>0) yes2 = true;	//상
					else if(arr[i+1][j]==2 && i+1<19) yes2 = true; //하
					else if(arr[i][j-1]==2 && j-1>0) yes2 = true; //좌
					else if(arr[i][j-1]==2 && j+1<19) yes2 = true; //우

					else if(arr[i-1][j-1]==2 && i-1>0 && j-1>0) yes2 = true; //좌상
					else if(arr[i+1][j-1]==2 && i+1<19 && j-1>0) yes2 = true; //좌하
					else if(arr[i+1][j+1]==2 && i+1<19 && j+1<19) yes2 = true; //우하
					else if(arr[i-1][j+1]==2 && i-1>0 && j+1<19) yes2 = true; //상우
					else {
						yes2= false;
						count2=0;
					}
					
					if(yes1) count2++;
					
				}
				
				if(count1 == 5 || count2 == 5) break;
				
			}
			if(count1 == 5 || count2 == 5) break;
			
		}
		if(count1 == 5) System.out.println("1");
		else if(count2 == 5) System.out.println("2");
		
		System.out.println(startX);
		System.out.println(startY);
		
		
//		for(int i []: arr) {
//			for(int j : i)	System.out.print(j);
//			System.out.println();
//		}
		
		
		sc.close();
	}

}
