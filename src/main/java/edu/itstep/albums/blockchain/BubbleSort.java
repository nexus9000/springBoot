package edu.itstep.albums.blockchain;

public class BubbleSort {
   public static int[] bubbleSort(int[] array) {
	   int temp = 0;
	   //O(n^2)
	   for(int i = 0; i < array.length; i++) {
		   boolean isSorted = true;
		   for(int j = 0; j < array.length -1; j++) {
			   if(array[j] > array[j+1]) {
				   //swap
				   temp = array[j+1];
				   array[j+1] = array[j];
				   array[j] = temp;
				   isSorted = false;
			   }
		   }
		   if(isSorted) break;
	   }
	   return array;
   }
   
   public static void main(String[]arg) {
	   int array[] = {-11, -99, 300, 13, 1, 8};
	   bubbleSort(array);//n2
	   bubbleSort(array);//n2
	   bubbleSort(array);//n2
	   //3n^2
	   
	   for(int value : array) {
		   System.out.print(" "+value);// -99 -11 1  
	   }
	   //n
	   System.out.println();//1
	   System.out.println();//1
	   //3n^2 + n + 2 => O ( n^2)
   }
}
