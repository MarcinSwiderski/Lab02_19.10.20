package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

    List<List<Utwor>> permutation = new ArrayList<>();

    public void recursive(int n, List<Utwor> elements) {

    int x = n;
    int [][]twoDimensoionalElementsTab = new int[factorial(n)][n];


        if(n == 1) {
            for (int i = 0; i < factorial(elements.size()); i++) {
                for (int j = 0; j < elements.size() ; j++) {
                    twoDimensoionalElementsTab[i][j] = elements.get(j).getId();
                    System.out.printf(" ");
                }
            }
            System.out.println();

        } else {
            for(int i = 0; i < n-1; i++) {
                recursive(n - 1, elements);
                if(n % 2 == 0) {
                    swap(elements, i, n-1);
                } else {
                    swap(elements, 0, n-1);
                }
            }
            recursive(n - 1, elements);
        }
    }

    private void swap(List<Utwor> list, int a, int b) {
        Utwor buffer = list.get(a);
        list.set(a, list.get(b));
        list.set(b, buffer);
    }
    public static int factorial(int n)
    {
        int res = 1, i;
        for (i=2; i<=n; i++)
            res *= i;
        return res;
    }

    public void writeToConsole() {
        for (int i = 0; i < permutation.size(); i++) {
            for (int j = 0; j < permutation.get(0).size(); j++) {
                System.out.print(permutation.get(i).get(j).getId() + " ");
            }
            System.out.println(permutation.get(i).hashCode());
        }
    }
}
