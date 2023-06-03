package edu.itstep.albums.blockchain;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
   public static int[] bubbleSort(int[] array) {
	   int temp = 0;
	   //O(n^2)
	   int count = 0;
	   for(int i = 0; i < array.length; i++) {
		   boolean isSorted = true;
		   for(int j = 0; j < array.length -1; j++) {
			   if(array[j] > array[j+1]) {
				   //swap
				   temp = array[j+1];
				   array[j+1] = array[j];
				   array[j] = temp;
				   isSorted = false;
				   count ++;
				   System.out.println(count);
			   }
		   }
		   if(isSorted) break;
	   }
	   return array;
   }
   
   public static void main(String[]arg) {
	   Random random = new Random();
	   System.out.println("Init array....");
	   int array[] = new int[1000];
	   for(int i = 0; i < array.length;i++) {
		   array[i] = random.nextInt();
	   }
	   System.out.println("Array was Init!");
	   long startBubble = System.currentTimeMillis();
	   System.out.println("Bubble sort was starting.....");
	  bubbleSort(array);//n2
	   long endBubble = System.currentTimeMillis();
	   System.out.println((endBubble - startBubble) + " bubble sort in msec");
	   long startQuick = System.currentTimeMillis();
	   Arrays.sort(array);//nlogn
	   long endQuick = System.currentTimeMillis();
	   System.out.println((endQuick - startQuick) + " Quick sort in msec");
	   
	   
	 
   }
}
