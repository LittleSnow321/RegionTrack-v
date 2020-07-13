package regiontrack;

public class VC {
	public static final int SPECIAL_ELEMENTS = 1;
	public static final int MAX_THREADS = 50;
	
	public int[] clock;
	
	VC(int threadid)
	{
		this.clock = new int[MAX_THREADS + 1];
		this.clock[0] = threadid;
	}
	
	public int getTid()
	{
		return this.clock[0];
	}
	
	public void setTid(int threadid)
	{
		this.clock[0] = threadid;
	}
	
	public boolean isZero()
	{
		boolean flag = true;
		for(int i = SPECIAL_ELEMENTS; i < MAX_THREADS + 1; i ++)
		{
			if (this.clock[i] != 0)
			{
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	public void initialVC()
	{
		for(int i = SPECIAL_ELEMENTS; i < MAX_THREADS + 1; i ++)
		{
			this.clock[i] = 0;
		}
	}
	
	public void incrementClock(int threadid)
	{
		this.clock[threadid] += 1;
	}
	
	public static boolean join(VC vc1, VC vc2)
	{
		boolean updated = false;
		for(int i = SPECIAL_ELEMENTS; i < MAX_THREADS + 1; i ++)
		{
			if(vc2.clock[i] > vc1.clock[i])
			{
				vc1.clock[i] = vc2.clock[i];
				updated = true;
			}
		}
		return updated;
	}
	
	public static boolean lessThan(VC vc1, VC vc2, int tid)
	{
		return vc1.clock[tid] <= vc2.clock[tid];
	}
	
	public static boolean HappensBefore(VC vc1, VC vc2)
	{
		for(int i = SPECIAL_ELEMENTS; i < MAX_THREADS + 1; i ++)
		{
			if(vc1.clock[i] > vc2.clock[i])
			{
				return false;
			}
		}
		return true;
	}
	
	public static void copy(VC vc1, VC vc2)
	{
		for(int i = 0; i < MAX_THREADS + 1; i ++)
		{
			vc1.clock[i] = vc2.clock[i];
		}
	}
	
	public static void copyValue(VC vc1, VC vc2)
	{
		for(int i = SPECIAL_ELEMENTS; i < MAX_THREADS + 1; i ++)
		{
			vc1.clock[i] = vc2.clock[i];
		}
	}

}
