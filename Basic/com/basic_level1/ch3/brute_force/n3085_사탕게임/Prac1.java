package com.basic_level1.ch3.brute_force.n3085_사탕게임;

import java.util.Scanner;

public class Prac1 {
    //연결된 사탕갯수 검사
    public static int max (char [][] arr){
        int cnt = 0;
        int ans = 1;
        for (int i =0;i<arr.length;i++){
            //가로 줄 검사
            cnt = 1;
            for (int j=1;j<arr.length;j++){
                if(arr[i][j-1] == arr[i][j]) cnt++;
                else cnt =1;

                if(ans<cnt) ans = cnt;
            }

            //세로 줄 검사
            cnt = 1;
            for (int j=1;j<arr.length;j++){
                if(arr[j-1][i]==arr[j][i]) cnt++;
                else cnt = 1;

                if(ans<cnt) ans = cnt;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char [][] candy = new char[n][n];

        for (int i =0; i<n; i++){
            candy[i] = sc.next().toCharArray(); //입력 받은 문자열을 char배열형태로 바꿈
        }

        int m = 1;
        for(int i=0;i<n;i++){

            for (int j=1;j<n;j++){
                //오른쪽에 있는 사탕이랑 교환
                char t = candy[i][j-1];
                candy[i][j-1] = candy[i][j];
                candy[i][j] = t;

                //가장 긴지 검사..
                if(m<max(candy)) {
                    m = max(candy);
//                       for (char [] k: candy){
//                           for (char l :k) System.out.print(l);
//                           System.out.println();
//                       }
//                       System.out.println("right : "+m);
                }

                t = candy[i][j-1];
                candy[i][j-1] = candy[i][j];
                candy[i][j] = t;

            }

            for (int j=1;j<n;j++){
                //아래에 있는 사탕이랑 교환
                char t = candy[j-1][i];
                candy[j-1][i] = candy[j][i];
                candy[j][i] = t;

                if(m<max(candy)) {
                    m = max(candy);
//                    for (char [] k: candy){
//                        for (char l :k) System.out.print(l);
//                        System.out.println();
//                    }
//                    System.out.println("down: "+m);
                }

                t = candy[j-1][i];
                candy[j-1][i] = candy[j][i];
                candy[j][i] = t;
            }
        }
        System.out.println(m);


    }
}
