package brute_force.n3085_사탕게임;

import java.util.*;

//시간복잡도 O(N^3)
public class Main2 {

    //가장 긴 연속부분을 찾는 메소드 O(N)
    //연속된 부분이 나타난 행과 열만 검사
    static int check(char[][] a, int start_row, int end_row, int start_col, int end_col) {
        int n = a.length;
        int ans = 1;

        //가로줄 연속부분
        for (int i=start_row; i<=end_row; i++) {
            int cnt = 1;
            for (int j=1; j<n; j++) {
                if (a[i][j] == a[i][j-1]) {
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (ans < cnt) ans = cnt;
            }
        }
        //세로줄 연속부분
        for (int i=start_col; i<=end_col; i++) {
            int cnt = 1;
            for (int j=1; j<n; j++) {
                if (a[j][i] == a[j-1][i]) {
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (ans < cnt) ans = cnt;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] a = new char[n][n];
        for (int i=0; i<n; i++) {
            a[i] = sc.next().toCharArray();
        }
        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) { //i행을 기준으로 한열씩 이동해서 검사
                if (j+1 < n) {//오른쪽
                    char t = a[i][j]; a[i][j] = a[i][j+1]; a[i][j+1] = t; //교환
                    int temp = check(a, i, i, j, j+1);
                    if (ans < temp) ans = temp;
                    t = a[i][j]; a[i][j] = a[i][j+1]; a[i][j+1] = t;
                }
                if (i+1 < n) {//아래
                    char t = a[i][j]; a[i][j] = a[i+1][j]; a[i+1][j] = t;
                    int temp = check(a, i, i+1, j, j);
                    if (ans < temp) ans = temp;
                    t = a[i][j]; a[i][j] = a[i+1][j]; a[i+1][j] = t;
                }
            }
        }
        System.out.println(ans);
    }
}