package regiontrack;

import regiontrack.VC;

public class Transaction {
	
	public int transactionID;
	public boolean isUnary;
	public boolean isSync;
	public int siteID;
	public int threadid;
	public VC beginVC;
	public VC currVC;
	
	Transaction(int transactionID, boolean isUnary, boolean isSync, int siteID, int threadid) {
		this.transactionID = transactionID;
		this.isUnary = isUnary;
		this.isSync = isSync;
		this.siteID = siteID;
		this.threadid = threadid;
		this.beginVC = new VC(threadid);
		this.currVC = new VC(threadid);
	}

	public void set_beginVC(VC currVC2) {
		// TODO Auto-generated method stub
		VC.copyValue(this.beginVC, currVC2);
		
	}

	public void set_currVC(VC currVC2) {
		// TODO Auto-generated method stub
		VC.copyValue(this.currVC, currVC2);
		
	}
	
	

}
