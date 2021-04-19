// Universidad del Valle de Guatemala
// Algoritmos y Estructuras de Datos
// Diego Ruiz 18761
// Main.java

import java.util.*;
import java.io.*;
import java.lang.*;

/**
* Crea una diccionario en forma de Binary Search Tree y traduce con llave en ingles
* @author Diego Ruiz 18761
*/

public class Main {

	public static void main(String args[]) {
	
		BinaryTree diccionario = new BinaryTree();
		Association<String, String> asoc;
		int cont =0;
		
		String FILENAME = "diccionario.txt";
		
		BufferedReader br = null;
		FileReader fr = null;
		String stringOutput ="";

		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			System.out.println("Se abrio exitosamente " + FILENAME);
		
			while ((stringOutput = br.readLine()) != null) {
		
                
                int startParenIndex = 1 + stringOutput.indexOf("(");
                int endParenIndex = stringOutput.indexOf(")");
            	int commaIndex = stringOutput.indexOf(",");
            	int secondCommaIndex = stringOutput.indexOf(",", stringOutput.indexOf(",") + 1);
            	
            	String key = stringOutput.substring(startParenIndex, commaIndex);
            	String espanol = stringOutput.substring(2+commaIndex, secondCommaIndex);
            	espanol = espanol.toLowerCase();
            	String frances = stringOutput.substring(2+secondCommaIndex, endParenIndex);
            	frances = frances.toLowerCase();
            	
            	List<String> value=new ArrayList<String>();  
            	value.add(key);
            	value.add(espanol);
            	value.add(frances);
            	
            	asoc = new Association<>(key.toLowerCase(), espanol.toLowerCase());
            	if (cont == 0) { 
            		diccionario.setData(asoc);
            		cont++;
            		
            	} else {
            		diccionario.insert(asoc);
            	}
			}
		

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		} System.out.println("El diccionario se lleno correctamente");
		
		// Para interpretar el texto.txt de ingles a espanol
		FILENAME = "texto.txt";
		br = null;
		fr = null;
		stringOutput ="";
		String traduccion = "";

		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			System.out.println("El diccionario se abrio exitosamente " + FILENAME);
		
			while ((stringOutput = br.readLine()) != null) {
                
                stringOutput = stringOutput.replace(".",""); 
                
                String[] words = stringOutput.split(" ",0);
                
                for (String word : words) {
                	
                	if (diccionario.contains(word.toLowerCase())) {
                		
                		traduccion += " " + diccionario.get(word.toLowerCase());
                		
                	} else {
                		
                		traduccion += " *" + word + "*";
                	}
                }
                
                traduccion += ".\n"; // fin
				
			}
		

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
		
		// menu de opciones
		Scanner scan = new Scanner(System.in);
		
		int option = 0;
        String menu = "\n MENU: \n 1. Imprimir el diccionario en In-Order \n 2. Traducir " + FILENAME + " \n 3. Salir";
        
        while (option != 3) {
            
            System.out.println(menu);
            System.out.println("\nIngrese el numero de opcion que desea realizar: ");
            
            try {
                option = scan.nextInt();
                scan.nextLine();
                
            } catch (InputMismatchException e) {
                
                scan.nextLine();
                System.out.println("Por favor, ingrese un numero");
            }
            
            // defense for number of option
            while (option < 1 || option > 3) {
                
                System.out.println("Esa opcion no es valida");
                System.out.println("\nIngrese el numero de opcion que desea realizar: ");
                
                try {
                    option = scan.nextInt();
                    scan.nextLine();
                    
                } catch (InputMismatchException e) {
                    
                    scan.nextLine();
                    System.out.println("Por favor, ingrese un numero");
                }
            }
            
            if (option == 1) {
            	System.out.println("\nImprimiendo en forma In-Order...");
            	diccionario.printInOrder();
            } else {
            	System.out.println("\nTraduccion: ");
				System.out.println(traduccion);
            }
        }
		System.out.println("\n Gracias por usar el programa\n");
	}
}