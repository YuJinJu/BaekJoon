package com.hw.n1244스위치켜고끄기;

import java.util.Scanner;

public class Main3 {

   public static int wm(int tmp) {
      if (tmp == 0)
         return 1;
      else
         return 0;
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int status[] = new int[n + 1];

      for (int i = 1; i <= n; i++) {
         status[i] = sc.nextInt();
      }
      int tmp = 0;
      tmp = sc.nextInt();
      int students = tmp;

      int mw[] = new int[students];
      int select[] = new int[students];

      for (int i = 0; i < students; i++) {

         mw[i] = sc.nextInt();
         select[i] = sc.nextInt();

         if (mw[i] == 1) // 남자일 때
         {
            int j = 1;
            while (n >= select[i] * j) {
               if (status[select[i] * j] == 1)
                  status[select[i] * j] = 0;
               else
                  status[select[i] * j] = 1;
               j++;
            }

         } else if (mw[i] == 2) // 여자일때
         {
            int w = 1;
            boolean flag = false;
            int before = 0;
            int after = 0;

            while (select[i] - w > 0 && select[i] + w <= n) {
               if (status[select[i]-w] == status[select[i]+w]) {
                  flag = true;
                  before = select[i] - w;// 2 1
                  after = select[i] + w;// 4 5
                  w++;
               }else
                  break;
            }

            if (flag == true) {
               for (int j = before; j <= after; j++)
                  status[j] = wm(status[j]);
            } else {
               status[select[i]] = wm(status[select[i]]);
            }

         }
      }
      StringBuilder sb = new StringBuilder();
      for (int b = 1; b < status.length; b++) {
         if (b % 20 == 0)
            sb.append(status[b] + "\n");
         else
            sb.append(status[b] + " ");
      }

      System.out.println(sb);
      sc.close();
   }

}