package com.sdajava.countingcort;

import java.util.Random;

public class Main {

    public static void sort(int arr[])
    {
        int n = arr.length;
        int output[] = new int[n];
        int count[] = new int[n];

        //wyzerowanie tablicy count, ktora bedzie trzymała liczbe wystapien poszczegolnych liczb
        for (int i=0; i<n; ++i) {
            count[i] = 0;
        }

        //zwiekszenie wystapienia elementu w tablicy
        //np. w tablicy arr 5 jest na indeksie 3 to wartosc indeksu 5 tablicy count jest zwiekszana +1
        for (int i=0; i<n; ++i) {
            count[arr[i]] += 1 ;
        }

        //zamiana count w taki sposob, ze count zawierac bedzie aktualna pozycje liczby w tablicy
        //w razie co przedabugowac
        for (int i=1; i<=n-1; ++i) {
            count[i] += count[i - 1];
        }

        //budowanie tablicy wyjsciowej, schodzenie w dół
        for (int i = 0; i<n; ++i) {
            output[count[arr[i]]-1] = arr[i];
            count[arr[i]] -= 1;
        }

        for (int i = 0; i<n; ++i) {
            arr[i] = output[i];
            System.out.printf(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        int[] tablica = new int[20];
        Random generator = new Random();

        for(int i=0; i<tablica.length; i++){
            tablica[i] = generator.nextInt(20);
            System.out.printf(tablica[i] + " ");
        }

        System.out.println();
        sort(tablica);
    }
}
