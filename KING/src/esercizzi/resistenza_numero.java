package esercizzi;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class resistenza_numero {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader tastiera = new BufferedReader(input);
		String numeroString = "";
		int numeroMaxResistenza = 0;
        int maxResistenza = 0;
        long i = 0; //lon massimo numero 9,223,372,036,854,775,807
        
		try {
			do {
				
				System.out.println("inserisi un mumero per calcolare la sua resistenza");
				System.out.println("esc - per usire");
				
				numeroString = tastiera.readLine();
				
				if (isConvertibleToInt(numeroString)) {
					int numero = Integer.parseInt(numeroString);
					System.out.println("resistenza numero: "+getResistenza(numero));
				}
				
				//java massimo numero di cifre intere è 2147483647
				for (int numero = 1; numero < 2147483647; numero++) {
		            int resistenza = getResistenza(numero);
		            if (resistenza > maxResistenza) {
		                maxResistenza = resistenza;
		                numeroMaxResistenza = numero;
		            }
				}
				System.out.println("massimo numero: "+numeroMaxResistenza);
				System.out.println("maxResistenza: "+maxResistenza);
				//massimo numero: 26888999
				//maxResistenza: 9
			} while (!numeroString.equals("esc"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	 public static int getResistenza(int numero) {
	        int resistenza = 0;
	        //il ciclo while controlla che il numero abbia massimo una cifra
	        //verrà ripetutto ogni volta fin quando il numero non sarà minore di 10
	        //ogni volta che il ciclo si ripete la variabile resistenza viene incrementata
	        while (numero >= 10) {
	            int prodotto = 1; // inizzializzo il prodotto a 1 perchè è il numero neutro per le operazioni di moltiplicazione
	            String numeroStringa = String.valueOf(numero);
	            //questo ciclo prennde ogni cifra del numero e la mette nella variabile cifra, il ciclo si ripeterà per il numero di cifre
	            for (char cifra : numeroStringa.toCharArray()) {
	            	//converto cifra da char a numerico e lo moltiplico per le altre cifre 
	            	//se è la prima cifra del numero per 1
	                prodotto *= Character.getNumericValue(cifra);
	            }
	            numero = prodotto;
	            resistenza++;
	        }

	        return resistenza;
	    }
		
		

	public static boolean isConvertibleToInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
	}
}