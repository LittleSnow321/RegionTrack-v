package regiontrack;
import regiontrack.VC;
public class LockData {
	public int address;
	public VC clock;
	
	LockData(int address)
	{
		this.address = address;
		//this.clock = new VC(0);
		this.clock = null;
	}
	
	public void updateClock(VC vc)
	{
		VC.copy(this.clock, vc);
	}
}
