package com.basic_level1.ch3.brute_force.n2309_일곱난쟁이;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int sum =0;
        int n = 9;

        for (int i=0;i<n;i++){
            list.add(sc.nextInt());
            sum += list.get(i);
        }


        for (int i=0;i<n-1;i++){
            for (int j=i+1;j<n;j++){
                if(sum-100 == list.get(i)+list.get(j)){
                    list.remove(j);
                    list.remove(i);

                    Collections.sort(list);
                    for (int k : list) System.out.println(k);

                    System.exit(0);
                }
            }
        }



    }
}
