package edu.itstep.albums.blockchain;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
	//id of the transaction
   private String transactionId;
   private PublicKey  sender;
   private PublicKey receiver;
   private double amount;
   //transaction must be signed
   private byte[] signature;
   public List<TransactionInput> inputs;
   public List<TransactionOutput> outputs;
   
   public Transaction(PublicKey sender, PublicKey receiver, 
		   double amount, List<TransactionInput> inputs) {
	   this.inputs = new ArrayList<>();
	   this.outputs = 
   }
   
}
