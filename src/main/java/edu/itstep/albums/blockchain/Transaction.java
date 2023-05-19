package edu.itstep.albums.blockchain;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public final class Transaction {
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
	   this.outputs = new ArrayList<>();
	   this.sender = sender;
	   this.receiver = receiver;
	   this.inputs = inputs;
	   calculateHash();
   }
   
   public void generateSignature(PrivateKey privateKey) {
	   String data = sender.toString() +
			   receiver.toString() + Double.toString(amount);
	   signature = CryptographyHelper.sign(privateKey, data);
   }
   public boolean verifySignature() {
	   String data = sender.toString() +
			   receiver.toString() + Double.toString(amount);
	   return CryptographyHelper.verify(sender, data, signature);
   }
   
   private final void calculateHash() {
	   String hashData = sender.toString() +
			   receiver.toString() + Double.toString(amount);
	   this.transactionId = CryptographyHelper.generateHash(hashData);
   }
   
}
