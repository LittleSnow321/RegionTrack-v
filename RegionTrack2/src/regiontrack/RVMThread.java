package regiontrack;

import java.util.ArrayList;

import regiontrack.Transaction;

public class RVMThread {
	public static int START_TRANSACTION_ID = 1;
	
	public int threadid;
	public VC currVC;
	public VC reverVC;
	public int numOfNodes;
	public boolean currentInTransaction;
	public Transaction currentTransaction;
	public ArrayList<Integer> TransactionList;
	
	
	RVMThread(int threadid)
	{
		this.threadid = threadid;
		this.currVC = new VC(threadid);
		this.currVC.incrementClock(threadid);
		this.reverVC = new VC(threadid);
		this.numOfNodes = START_TRANSACTION_ID;
		this.currentInTransaction = false;
		this.currentTransaction = new Transaction(this.numOfNodes, true, false, -1, threadid);
		this.currentTransaction.set_beginVC(this.currVC);
		this.currentTransaction.set_currVC(this.currVC);
		this.TransactionList = new ArrayList<Integer>();
	}
	


	public void set_currTransaction(Transaction currTrans)
	{
		this.currentTransaction = currTrans;
	}
	
	public Transaction get_currTransaction()
	{
		return this.currentTransaction;
	}

}
