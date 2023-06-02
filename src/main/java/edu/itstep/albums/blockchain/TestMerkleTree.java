package edu.itstep.albums.blockchain;

import java.util.ArrayList;
import java.util.List;
public class TestMerkleTree {
  public static void main(String[]arg) {
	  List<String> transactions = new ArrayList<>();
	  transactions.add("11");
	  transactions.add("22");
	  transactions.add("33");
	  transactions.add("44");
	  transactions.add("55");
	  transactions.add("66");
	  transactions.add("77");
	  MerkleTree merkleTree = new MerkleTree(transactions);
	  System.out.println(merkleTree.getMerkelTree().get(0));
  }
  
  private static int fact(int number) {
	  if(number == 1) return number;
	  else {
		  return number * fact(number - 1);
	  }
  }
  public static int factIter(int number) {
	int result = number;
	  while (number != 1) {
		 result *=  (--number);//4*3, 12 * 2, 24 * 1
		 if (number == 1) break;
		
	  }
	  return result;
  }
}
