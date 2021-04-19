// Universidad del Valle de Guatemala
// Algoritmos y Estructuras de Datos
// Diego Ruiz 18761
// BinaryTree.java

public class BinaryTree {
    
	Association<String,String> data; // info
	BinaryTree left;
	BinaryTree right;
	
	/*
     * Constructor de un nodo
     */
	public BinaryTree() {
		data = null;
		left = null;
		right = null;
	}
	
	/*
     * Constructor de un nodo
     * @param data la data del nodo
     */
	public BinaryTree(Association<String,String> data) {
		this.data = data;
		left = null;
		right = null;
	}
	
	/*
     * Setter del root
     * @param data the data of the node
     */
	public void setData(Association<String,String> data) {
		this.data = data;
	}
    
    /*
     * Getter de la data
     * @return data of the Node
     */
    public Association<String,String> getValue() {
		return data;
	}
	
	/*
     * Inserta un valor
     * @param value el valor a insertar
     */
	public void insert(Association<String,String> value) {
		
		int res = stringCompare(value.getKey(), data.getKey());
		
		if (res <= 0) {
		
			if (left == null) {
				left = new BinaryTree(value);
			} else {
				left.insert(value);
			}
			
		} else {
			
			if (right == null) {
				right = new BinaryTree(value);
			} else {
				right.insert(value);
			}
		}
		
	}
	
	/*
     * Verifica si ya existe un valor
     * @param value valor a insertar
     * @return True if contained, false if not
     */
	public boolean contains(String value) {
		
		int res = stringCompare(value, data.getKey());
		
		if (res == 0) {
			return true;
			
		} else if (res < 0) {
		
			if (left == null) {
				return false;	
			} else {
				return left.contains(value);
			}
		} else {
		
			if (right == null) {
				return false;
			} else {
				return right.contains(value);
			}
		}
	}
	
	/*
     * Regresa el valor para una key
     * @param key string
     * @return key value
     */
	public String get(String key) {
	
		int res = stringCompare(key, data.getKey());
		
		if (res == 0) {
			return data.getValue();
			
		} else {
			
			if (res < 0) {
				return left.get(key);
			
			} else {
				return right.get(key);
			}
		}

	}
	
	/*
     * Imprime todos los nodos del arbol
     */
	public void printInOrder() {
		
		if (left != null) {
			left.printInOrder();
		}
		
		System.out.println(this.data.toString());
		
		if (right != null) {
			right.printInOrder();
		}
	}
	
	
	/*
     * Compara strings lexicograficamente
     * Fuente: https://www.geeksforgeeks.org/compare-two-strings-in-java/
     * @param str1 string 1
     * @param str2 string 2
     * @return int con el valor de comparacion, negativo si str1 es menor, positivo si es mayor o 0 si son iguales
     */
	public static int stringCompare(String str1, String str2) { 
  
        int l1 = str1.length(); 
        int l2 = str2.length(); 
        int lmin = Math.min(l1, l2); 
  
        for (int i = 0; i < lmin; i++) { 
            int str1_ch = (int)str1.charAt(i); 
            int str2_ch = (int)str2.charAt(i); 
  
            if (str1_ch != str2_ch) { 
                return str1_ch - str2_ch; 
            } 
        } 
        if (l1 != l2) { 
            return l1 - l2; 
        } else { 
            return 0; 
        } 
    }

}