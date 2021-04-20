package brute_force.n2309_일곱난쟁이;

import java.util.*;
public class Main2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = 9;
        int[] a = new int[n];
        int sum = 0;
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }

        Arrays.sort(a);
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {

                if (sum - a[i] - a[j] == 100) {

                    for (int k=0; k<n; k++) { // 7명의 진짜 난쟁이 출력
                        if (i == k || j == k) continue; //가짜이면 넘어감
                        System.out.println(a[k]);
                    }
                    System.exit(0);  // main 메소드 종료 (main 내부 함수에서도 실제호출)

                }
            }
        }
    }
}