package aps_analise_algoritmos;

import java.lang.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class SelectionSort {

	public static void main(String[] args) {

		System.out.println("Tamanho do array:");

		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		
		
		int[] melhor = new int[num];
		int[] pior = new int[num];
		int[] medio = new int[num];
		
		//Obtendo numeros com ordenação random
		List<Integer> numbers = new ArrayList<Integer>(num);
		for (int i = 0; i < num; i++)
		  numbers.add(i);
		
		Collections.shuffle(numbers);

		//Enchendo os arrays
		for(int i=0;i<num;i++) {
			melhor[i] = i+1;
			pior[i] = num-i;
			medio[i] = numbers.get(i);
		}

		long inicio;
		long fim;

		//Obtemos o tempo antes e depois da execução da função de ordenação
		inicio = System.currentTimeMillis();
		selectionSort(melhor);
		fim = System.currentTimeMillis();
		System.out.println("Array ordenado: o Selection Sort demorou " + (fim - inicio)/1000f + " segundos.");

		inicio = System.currentTimeMillis();
		selectionSort(medio);
		fim = System.currentTimeMillis();
		System.out.println("Array random: o Selection Sort demorou " + (fim - inicio)/1000f + " segundos.");
		
		inicio = System.currentTimeMillis();
		selectionSort(pior);
		fim = System.currentTimeMillis();
		System.out.println("Array oposto: o Selection Sort demorou " + (fim - inicio)/1000f + " segundos.\n\n");


		inicio = System.currentTimeMillis();
		heapSort(melhor);
		fim = System.currentTimeMillis();
		System.out.println("Array ordenado: o Heap sort demorou " + (fim - inicio)/1000f + " segundos.");

		inicio = System.currentTimeMillis();
		heapSort(medio);
		fim = System.currentTimeMillis();
		System.out.println("Array random: o Heap sort demorou " + (fim - inicio)/1000f + " segundos.");
		
		inicio = System.currentTimeMillis();
		heapSort(pior);
		fim = System.currentTimeMillis();
		System.out.println("Array oposto: o Heap Sort demorou " + (fim - inicio)/1000f + " segundos.");
		
	}
	
	public static void selectionSort(int arr[]){
		int n = arr.length; 
		  
        // Percorremos o array desordenado
        for (int i = 0; i < n-1; i++) 
        { 
            // achamos a posição do menor elemento do array 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (arr[j] < arr[min_idx]) 
                    min_idx = j; 
  
            // Trocamos o menor elemento achado com o primeiro
            int temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
            arr[i] = temp; 
        } 
	}
	
	public static void heapSort(int arr[]) 
    { 
        int n = arr.length; 
  
        // Construimos o "heap"
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
  
        // extraemos os elementos do "heap"
        for (int i=n-1; i>=0; i--) 
        { 
            // Movemos a raiz 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // criamos o "max heap"
            heapify(arr, i, 0); 
        } 
    } 
  
    // Hacemos "heapify" na sub-arvore 
    public static void heapify(int arr[], int n, int i) 
    { 
        int maior = i; 
        int esq = 2*i + 1; 
        int dir = 2*i + 2; 
  
        // Se o filho esquerdo é maior que a raiz
        if (esq < n && arr[esq] > arr[maior]) 
        	maior = esq; 
  
        // Se o filho direito e o maior
        if (dir < n && arr[dir] > arr[maior]) 
        	maior = dir; 
  
        // Se o maior nao é a raiz
        if (maior != i) 
        { 
            int troca = arr[i]; 
            arr[i] = arr[maior]; 
            arr[maior] = troca; 
  
            // chamamos recursivamente o metodo heapify para a sub-arvore
            heapify(arr, n, maior); 
        } 
    } 

	
}
