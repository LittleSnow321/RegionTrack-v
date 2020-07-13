package regiontrack;
import java.util.ArrayList;

import regiontrack.VC;

public class MemoryData {
	
	public int address;
	public VC writeVC;
	public boolean setRead;
	public ArrayList<VC> readVCMap;
	
	MemoryData(int address)
	{
		this.address = address;
		//this.writeVC = new VC(0);
		this.writeVC = null;
		this.setRead = false;
		this.readVCMap = new ArrayList<VC>();
		for(int id = VC.SPECIAL_ELEMENTS; id < VC.MAX_THREADS + 1; id ++)
		{
			//readVCMap.add(new VC(id));
			readVCMap.add(null);
		}
	}

}
