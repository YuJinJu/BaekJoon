package com.hw.n1244스위치켜고끄기;

import java.util.Scanner;

public class Main {

	public static int wm(int tmp) {
		if(tmp == 0) return 1;
		else return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int status [] = new int [n+1];
		
		for(int i=1;i<=n;i++) {
			status[i] = sc.nextInt();
			if(status[i] > 1 || status[i] < 0) i--; 
		}
		
		int tmp = 0;
		do{
			tmp = sc.nextInt();
		}while(tmp<1 || tmp>100);
		int students = tmp;
		
		int mw[] = new int[students];
		int select[] = new int[students];
		
		for(int i=0;i<students;i++) {
			
			mw[i] = sc.nextInt();
			select[i] =  sc.nextInt();
			
			if(mw[i] == 1) //남자일 때
			{
				int j=1;
				while(n >= select[i]*j) {
					if(status[select[i]*j]==1) status[select[i]*j]= 0;
					else status[select[i]*j]= 1;
					j++;
				}
				
			}
			else if(mw[i] == 2) //여자일때
			{
				int w = 1;
				boolean flag = false;
				int before = 0;
				int after = 0;
				
				while(select[i]-w >0 && select[i]+w <= n) {
					before = select[i]-w;//2 1
					after = select[i]+w;//4 5
///안되는 이유!!!!!!!!!!!!!!!!!!!!!!! 조건을 판단하고 맞을 때 before, after값을 할당해줘야한다.
					//정답은 Main2 
					//Main3 는 StringBuilder 도 고친것
					if(status[before] == status[after]){
						flag = true;
						w++;
					}else 
						break;
					
				}
				
				if(flag==true) {
					for(int j=before;j<=after;j++)
						status[j] = wm(status[j]);
				}else {
					status[select[i]] = wm(status[select[i]]);
				}
				
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int b=1;b<status.length;b++)
			sb.append(status[b]+" ");
		
		sb.setLength(sb.length()-1);
		
		if(sb.length()>40) {
			int l = 0;
			for(l=1;l<=sb.length()/40;l++) {
				System.out.println(sb.substring((l-1)*40, 40*l-1));
				int length = sb.length() - 40*l;
				if(length <= 40)
					System.out.println(sb.substring(40*l, sb.length()));
			}
		}else 
			System.out.println(sb);
		
		sc.close();
	}

}
