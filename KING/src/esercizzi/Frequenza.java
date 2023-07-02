package esercizzi;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Frequenza {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] numeri = {2,4,1,5,6,3,4,2,7,4,5,4,5};
		int k = 2;
		
		System.out.println("il numero che si ripete più volte è");
		System.out.println(getFrequente(numeri));
		int[] risultato = getFrequenti(numeri,k);
		System.out.println("i primi "+k+" numeri che sono ripetuti più volte sono:");
		for(int num : risultato) {
			System.out.println(num);
		}

	}
	

	
	public static int getFrequente(Integer[] numeri) {

		int maxCount = 0, numF = 0;
		//Viene eseguito un ciclo for per iterare su tutti gli elementi dell'array numeri
		//Ogni elemento viene confrontato con tutti gli altri elementi nell'array per determinare quante volte appare.
		//se due elementi sono uguali allora il count viene incrementato
		for (int i = 0; i < numeri.length; i++) {
			int count = 0;
			for (int j = 0; j < numeri.length; j++) {
				if (numeri[i] == numeri[j]) {
					count++;
				}
			}
			//faccio in modo di salvarmi il count più alto trovato e il rispettivo numero
			if (count > maxCount) {
				maxCount = count;
				numF = numeri[i];
			}
		}
		return numF;
	}
	 
	public static int[] getFrequenti(Integer[] array, int k) {

		int c = 1,j = 0;
		int[] risultato = new int[k];

		//ordino in ordine cresente l'arrey e tolgo eventuali numeri doppi
		HashSet<Integer> set = new HashSet<>(Arrays.asList(array));
		Integer[] arraySenzaDuplicati = set.toArray(new Integer[0]);
		int[][] arrayQuadrato = new int[arraySenzaDuplicati.length][2];
		
		//conto e costruisco una matrice a n colonne e due righe 
		//dove le colonne sono identificabili con j e le righe con 0 e 1
		//la pirima righa contiene il numero la seconda riga contiene il numero di volte che il numero si ripete

		for (int num : arraySenzaDuplicati) {
			for (int i = 0; i < array.length; i++) {
				if (num == array[i]) {
					arrayQuadrato[j][0] = num;
					arrayQuadrato[j][1] = c++;
				}
			}
			j++;
			c = 1;
		}
		
		//ordino l' arrayQuadrato in base al numero di volte che un numero si ripete
		//scambiando sia numero di volte che il valore
		for (int i = 0; i < arrayQuadrato.length; i++) {
			for (int j1 = 0; j1 < arrayQuadrato.length; j1++) {
				if (arrayQuadrato[i][1] > arrayQuadrato[j1][1]) {
					int tmp = arrayQuadrato[j1][1];
					arrayQuadrato[j1][1] = arrayQuadrato[i][1];
					arrayQuadrato[i][1] = tmp;

					tmp = arrayQuadrato[j1][0];
					arrayQuadrato[j1][0] = arrayQuadrato[i][0];
					arrayQuadrato[i][0] = tmp;
				}
			}
		}
		
		//inserisco nella variabile da inviare i primi k numeri più frequenti
		for (int i = 0; i < k; i++) {
			risultato[i] = arrayQuadrato[i][0];
		}

		return risultato;
	}
}