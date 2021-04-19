// Universidad del Valle de Guatemala
// Algoritmos y Estructuras de Datos
// Diego Ruiz 18761
// Association.java

import java.util.*;

/**
 * Clase con las asociaciones de key y value
 * @author Diego Ruiz 18761
 */

public class Association<K,V> implements Map.Entry<K,V> {

    protected K key; 
    protected V value;
    private HashMap<K,V> association;

    /**
     * Constructor
     * @param key
     * @param value
     */
    public Association(K k, V v) {
        this.key = k;
        this.value = v;
    }

    /**
     * Constructor cuando no tiene nada asociado
     * @param key with a null value
     */
    public Association(K key) {
        this(key,null);
    }
	
	/**
     * Constructor cuando no se especifica key y value
     */
    public Association() {
		association = new HashMap<K,V>();
    }
    
    /**
     * Comparar keys
     * @param other una association
     * @return true if the keys ==, else false
     */
    public boolean equals(Object other) {
        Association otherAssoc = (Association)other;
        return getKey().equals(otherAssoc.getKey());
    }
    
    /**
     * @return A hash code for association.
     */
    public int hashCode() {
        return getKey().hashCode();
    }
    
    /**
     * Getter del value
     * @return the value
     */
    public V getValue(){
        return value;
    }

    /**
     * Getter del key
     * @return the key
     */
    public K getKey() {
        return key;
    }

    /**
     * Setter del value
     * @param value the new value.
     * @return the old value
     */
    public V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }
    
    /**
     * Poner key y value en la association
     * @param key the new key
     * @param value the new value.
     */
    public void put(K key, V value){
            association.put(key, value);
	}
	
	/**
	 * @param key
	 * @return value for the key
	 */
	public V get(Object key){
		return association.get(key);
	}

    /**
     * @return string representacion de asociacion
     */
    public String toString() {
    
        StringBuffer str = new StringBuffer();
        
        str.append("(" + getKey() + ", " + getValue() + ")");
        return str.toString();
    }
}