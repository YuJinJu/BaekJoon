package com.basic_level1.ch3.brute_force.n3085_사탕게임;

import java.util.Scanner;

public class Prac2 {
    public static int max_2column(char[][] candy,int row,int column){
        int ans = 0;

            //가로줄 1개 검사
        int cnt = 1;
        for (int i=1;i<candy.length;i++) {
            if (candy[row][i - 1] == candy[row][i]) cnt++;
            else cnt = 1;
            if (ans < cnt) ans = cnt;
        }
            //세로줄 2개 검사
        cnt = 1;
        for (int i=1;i<candy.length;i++) {
            if (candy[i - 1][column - 1] == candy[i][column - 1]) cnt++;
            else cnt = 1;
            if (ans < cnt) ans = cnt;
        }
        cnt=1;
        for (int i=1;i<candy.length;i++){
            if(candy[i-1][column]==candy[i][column]) cnt++;
            else cnt = 1;
            if(ans < cnt) ans = cnt;
        }

        return ans;
    }

    public static int max_2row(char[][] candy,int row,int column){
        int ans = 0;
            //세로줄 1개 검사
        int cnt = 1;
        for (int i=1;i<candy.length;i++) {
            if (candy[i - 1][column] == candy[i][column]) cnt++;
            else cnt = 1;
            if (ans < cnt) ans = cnt;
        }
            //가로줄 2개 검사
        cnt = 1;
        for (int i=1;i<candy.length;i++) {
            if (candy[row - 1][i - 1] == candy[row - 1][i]) cnt++;
            else cnt = 1;
            if (ans < cnt) ans = cnt;
        }
        cnt=1;
        for (int i=1;i<candy.length;i++){
            if(candy[row][i-1]==candy[row][i]) cnt++;
            else cnt = 1;
            if(ans < cnt) ans = cnt;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char [][] candy = new char[n][n];
        for (int i=0;i<n;i++){
            candy[i] =  sc.next().toCharArray();
        }

        int m = 1;
        for(int i=0;i<n;i++){
            for (int j=1;j<n;j++){ //오른쪽
                char t = candy[i][j-1];
                candy[i][j-1] = candy[i][j];
                candy[i][j] = t;
                int tmp = max_2column(candy,i,j);
                if(m<tmp) m = tmp;

                t = candy[i][j-1];
                candy[i][j-1] = candy[i][j];
                candy[i][j] = t;

            }
            for (int j=1;j<n;j++){ //아래
                char t = candy[j-1][i];
                candy[j-1][i] = candy[j][i];
                candy[j][i] = t;
                int tmp = max_2row(candy,j,i);
                if(m<tmp) m = tmp;

                t = candy[j-1][i];
                candy[j-1][i] = candy[j][i];
                candy[j][i] = t;
            }
        }

        System.out.println(m);

    }
}
