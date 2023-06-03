package edu.itstep.albums.blockchain;

public class Permutations {
    public static <T> void permutions (int n, T[] elem) {
    	if(n == 1) printArray(elem);
    	else {
    		for(int i = 0; i < n-1;i++) {
    			permutions(n-1, elem);
    			if(n % 2 == 0)swap(elem,i , n-1);
    			else swap(elem, 0, n-1);
    		}//end for loop
    		permutions(n-1, elem);
    	}
    }
    private static <T> void swap(T[] input, int a, int b) {
    	T temp = input[a];
    	input[a] = input[b];
    	input[b] = temp;
    }
    
    private static <E> void  printArray (E[] input){
    	//Display array elements
    	for(E element : input) {
    		//System.out.printf("%s ", element);
    	}
    	//System.out.println();
    }
    
    private static int factoriel(int n) {
    	if(n == 1) return n;
    	return (n * factoriel(n-1));
    }
    
    public static void main(String...arg) {
    	long startTime = System.currentTimeMillis();
    	String array[] = {"a","b","c","d","e","f","g","h","j","k","l","m","n"};
    	System.out.println("The number of elements are: "+ array.length);
    	System.out.println("The number of permutionsa are: "+factoriel(array.length));
    	permutions(array.length, array);
    	long endTime = System.currentTimeMillis();
    	System.out.println((endTime - startTime) + " msec");
    }
}
