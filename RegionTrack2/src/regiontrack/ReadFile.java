package regiontrack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadFile {
	
	public static String trace_path = "/home/xiaoxue/velodrome-output/";
	public static String loc = "/home/xiaoxue/Documents/";
	public static ArrayList<String> bench1 = new ArrayList<String>(Arrays.asList( "eclipse6", "sunflow9")); //"eclipse6",
	//public static ArrayList<String> bench1 = new ArrayList<String>(Arrays.asList( "eclipse6"));
	//public static ArrayList<String> bench2 = new ArrayList<String>(Arrays.asList("lusearch6"));
	//public static ArrayList<String> bench2 = new ArrayList<String>(Arrays.asList("micro-nest", "micro2", "micro4", "micro5"));
	public static ArrayList<String> bench2 = new ArrayList<String>(Arrays.asList("hsqldb6", "lusearch6", "xalan6", "jython9", "luindex9", "lusearch9-fixed", "pmd9", "xalan9"));
	//public static ArrayList<String> bench2 = new ArrayList<String>(Arrays.asList("sor","crypt", "lufact", "series"));
	//public static ArrayList<String> bench2 = new ArrayList<String>(Arrays.asList("xalan9"));
	//public static ArrayList<String> bench3 = new ArrayList<String>(Arrays.asList("avrora9")); 
	//public static ArrayList<String> bench3 = new ArrayList<String>(Arrays.asList("sparsematmult")); 
	public static ArrayList<String> bench3 = new ArrayList<String>(Arrays.asList("montecarlo")); 
	public static final int BUFFER_SIZE = 19999992; 
	public static boolean flag = false;
	
	public static void main(String[] args) throws IOException
	{

		String trace = args[0];
		System.out.println("detection started");
//		for(int i = 0; i < bench3.size(); i++) {
//			String bench_trace1 = "avrora_"+ trace + "/" + trace_path + bench3.get(i) + "1.log"; //loc + "trace_" + trace + trace_path +
//			String bench_trace2 = "avrora_"+ trace + "/" + trace_path + bench3.get(i) + "2.log"; //loc + "trace_" + trace + trace_path + 
//			String bench_trace3 = "avrora_"+ trace + "/" + trace_path + bench3.get(i) + "3.log";
//			String bench_trace4 = "avrora_"+ trace + "/" + trace_path + bench3.get(i) + "4.log";
//			File f1 = new File(bench_trace1);
//			FileInputStream fileInput1 = new FileInputStream(f1);
//			File f2 = new File(bench_trace2);
//			FileInputStream fileInput2 = new FileInputStream(f2);
//			File f3 = new File(bench_trace3);
//			FileInputStream fileInput3 = new FileInputStream(f3);
//			File f4 = new File(bench_trace4);
//			FileInputStream fileInput4 = new FileInputStream(f4);
//			String atomic_out = "atomic_specification/RT_iteration/" + bench3.get(i) + "_" + trace;
//			FileWriter f5 = new FileWriter(atomic_out, true);
//			BufferedWriter fileOutput5 = new BufferedWriter(f5);
//			TransactionalHBGraph transGraph = new TransactionalHBGraph();
//			PrintStream ps = new PrintStream(new FileOutputStream("RT_iteration_"+bench3.get(i)+trace));
//			System.setOut(ps);
//			byte[] readBytes1 = new byte[BUFFER_SIZE];
//			byte[] readBytes2 = new byte[BUFFER_SIZE];
//			byte[] readBytes3 = new byte[BUFFER_SIZE];
//			byte[] readBytes4 = new byte[BUFFER_SIZE];
//			int offset = 0;
//			int[] test = new int[3];
//			int lastLen = 0;
//			int newLen = 0;
//			int round = 0;
//			while(true)
//			{
//				round++;
//				System.out.println("round "+round);
//				transGraph.initData();
//				if(round != 1)
//				{
//					fileInput1 = new FileInputStream(f1);
//					fileInput2 = new FileInputStream(f2);
//					fileInput3 = new FileInputStream(f3);
//					fileInput4 = new FileInputStream(f4);
//				}
//				while((offset = fileInput1.read(readBytes1)) != -1)
//				{
//					int index = 0;
//					for(int read = 0; read < offset; read += 4)
//					{
//						test[index] = ((readBytes1[read] & 0xff) << 24) |
//									((readBytes1[read+1] & 0xff) << 16) |
//									((readBytes1[read+2] & 0xff) << 8) |
//									(readBytes1[read +3] & 0xff);
//						index++;
//						
//						if (index == 3)
//						{
//							if (test[1] == 20)
//							{
//								transGraph.startTransaction(test[0], test[2]);
//							}
//							else if(test[1] == 21)
//							{
//								transGraph.endTransaction(test[0], test[2]);
//							}
//							else if(test[1] == 22)
//							{
//								transGraph.processRead(test[0], test[2]);
//							}
//							else if(test[1] == 23)
//							{
//								transGraph.processWrite(test[0], test[2]);
//							}
//							else if(test[1] == 24)
//							{
//								transGraph.processAcquire(test[0], test[2]);
//							}
//							else if(test[1] == 25)
//							{
//								transGraph.processRelease(test[0], test[2]);
//							}
//							
//							index = 0;
//						}
//					}
//				}
//				while((offset = fileInput2.read(readBytes2)) != -1)
//				{
//					int index = 0;
//					for(int read = 0; read < offset; read += 4)
//					{
//						test[index] = ((readBytes2[read] & 0xff) << 24) |
//									((readBytes2[read+1] & 0xff) << 16) |
//									((readBytes2[read+2] & 0xff) << 8) |
//									(readBytes2[read +3] & 0xff);
//						index++;
//						
//						if (index == 3)
//						{
//							if (test[1] == 20)
//							{
//								transGraph.startTransaction(test[0], test[2]);
//							}
//							else if(test[1] == 21)
//							{
//								transGraph.endTransaction(test[0], test[2]);
//							}
//							else if(test[1] == 22)
//							{
//								transGraph.processRead(test[0], test[2]);
//							}
//							else if(test[1] == 23)
//							{
//								transGraph.processWrite(test[0], test[2]);
//							}
//							else if(test[1] == 24)
//							{
//								transGraph.processAcquire(test[0], test[2]);
//							}
//							else if(test[1] == 25)
//							{
//								transGraph.processRelease(test[0], test[2]);
//							}
//							
//							index = 0;
//						}
//					}
//				}
//				while((offset = fileInput3.read(readBytes3)) != -1)
//				{
//					int index = 0;
//					for(int read = 0; read < offset; read += 4)
//					{
//						test[index] = ((readBytes3[read] & 0xff) << 24) |
//									((readBytes3[read+1] & 0xff) << 16) |
//									((readBytes3[read+2] & 0xff) << 8) |
//									(readBytes3[read +3] & 0xff);
//						index++;
//						
//						if (index == 3)
//						{
//							if (test[1] == 20)
//							{
//								transGraph.startTransaction(test[0], test[2]);
//							}
//							else if(test[1] == 21)
//							{
//								transGraph.endTransaction(test[0], test[2]);
//							}
//							else if(test[1] == 22)
//							{
//								transGraph.processRead(test[0], test[2]);
//							}
//							else if(test[1] == 23)
//							{
//								transGraph.processWrite(test[0], test[2]);
//							}
//							else if(test[1] == 24)
//							{
//								transGraph.processAcquire(test[0], test[2]);
//							}
//							else if(test[1] == 25)
//							{
//								transGraph.processRelease(test[0], test[2]);
//							}
//							
//							index = 0;
//						}
//					}
//				}
//				while((offset = fileInput4.read(readBytes4)) != -1)
//				{
//					int index = 0;
//					for(int read = 0; read < offset; read += 4)
//					{
//						test[index] = ((readBytes4[read] & 0xff) << 24) |
//									((readBytes4[read+1] & 0xff) << 16) |
//									((readBytes4[read+2] & 0xff) << 8) |
//									(readBytes4[read +3] & 0xff);
//						index++;
//						
//						if (index == 3)
//						{
//							if (test[1] == 20)
//							{
//								transGraph.startTransaction(test[0], test[2]);
//							}
//							else if(test[1] == 21)
//							{
//								transGraph.endTransaction(test[0], test[2]);
//							}
//							else if(test[1] == 22)
//							{
//								transGraph.processRead(test[0], test[2]);
//							}
//							else if(test[1] == 23)
//							{
//								transGraph.processWrite(test[0], test[2]);
//							}
//							else if(test[1] == 24)
//							{
//								transGraph.processAcquire(test[0], test[2]);
//							}
//							else if(test[1] == 25)
//							{
//								transGraph.processRelease(test[0], test[2]);
//							}
//							
//							index = 0;
//						}
//					}
//				}
//				transGraph.update_AtomicList();
//				newLen = transGraph.get_atomic();
//				if(lastLen == newLen)
//				{
//					ArrayList<Integer> atomicList = transGraph.get_atomicList();
//					for(int s = 0; s < atomicList.size(); s++)
//					{
//						fileOutput5.write(atomicList.get(s).toString());
//						fileOutput5.write("\n");
//					}
//					fileOutput5.flush();
//					System.out.println(round);
//					//print atomic
//					break;
//				}
//				lastLen = newLen;
//			}
//			fileInput1.close();
//			fileInput2.close();
//			fileInput3.close();
//			fileInput4.close();
//			fileOutput5.close();
//			
//		}

		
//		for(int i = 0; i < bench3.size(); i++) {
//		String bench_trace1 = loc + "JGF_section3_"+ trace + "/" + trace_path + bench3.get(i) + "1.log"; //loc + "trace_" + trace + trace_path +
//		String bench_trace2 = loc + "JGF_section3_"+ trace + "/" + trace_path + bench3.get(i) + "2.log"; //loc + "trace_" + trace + trace_path + 
//		String bench_trace3 = loc + "JGF_section3_"+ trace + "/" + trace_path + bench3.get(i) + "3.log";
//		String bench_trace4 = loc + "JGF_section3_"+ trace + "/" + trace_path + bench3.get(i) + "4.log";
//		File f1 = new File(bench_trace1);
//		FileInputStream fileInput1 = new FileInputStream(f1);
//		File f2 = new File(bench_trace2);
//		FileInputStream fileInput2 = new FileInputStream(f2);
//		File f3 = new File(bench_trace3);
//		FileInputStream fileInput3 = new FileInputStream(f3);
//		File f4 = new File(bench_trace4);
//		FileInputStream fileInput4 = new FileInputStream(f4);
//		String atomic_out = "atomic_specification/RT_iteration/" + bench3.get(i) + "_" + trace;
//		FileWriter f5 = new FileWriter(atomic_out, true);
//		BufferedWriter fileOutput5 = new BufferedWriter(f5);
//		TransactionalHBGraph transGraph = new TransactionalHBGraph();
//		PrintStream ps = new PrintStream(new FileOutputStream("RT_iteration_"+bench3.get(i)+trace));
//		System.setOut(ps);
//		byte[] readBytes1 = new byte[BUFFER_SIZE];
//		byte[] readBytes2 = new byte[BUFFER_SIZE];
//		byte[] readBytes3 = new byte[BUFFER_SIZE];
//		byte[] readBytes4 = new byte[BUFFER_SIZE];
//		int offset = 0;
//		int[] test = new int[3];
//		int lastLen = 0;
//		int newLen = 0;
//		int round = 0;
//		while(true)
//		{
//			round++;
//			System.out.println("round "+round);
//			transGraph.initData();
//			if(round != 1)
//			{
//				fileInput1 = new FileInputStream(f1);
//				fileInput2 = new FileInputStream(f2);
//				fileInput3 = new FileInputStream(f3);
//				fileInput4 = new FileInputStream(f4);
//			}
//			while((offset = fileInput1.read(readBytes1)) != -1)
//			{
//				int index = 0;
//				for(int read = 0; read < offset; read += 4)
//				{
//					test[index] = ((readBytes1[read] & 0xff) << 24) |
//								((readBytes1[read+1] & 0xff) << 16) |
//								((readBytes1[read+2] & 0xff) << 8) |
//								(readBytes1[read +3] & 0xff);
//					index++;
//					
//					if (index == 3)
//					{
//						if (test[1] == 20)
//						{
//							transGraph.startTransaction(test[0], test[2]);
//						}
//						else if(test[1] == 21)
//						{
//							transGraph.endTransaction(test[0], test[2]);
//						}
//						else if(test[1] == 22)
//						{
//							transGraph.processRead(test[0], test[2]);
//						}
//						else if(test[1] == 23)
//						{
//							transGraph.processWrite(test[0], test[2]);
//						}
//						else if(test[1] == 24)
//						{
//							transGraph.processAcquire(test[0], test[2]);
//						}
//						else if(test[1] == 25)
//						{
//							transGraph.processRelease(test[0], test[2]);
//						}
//						
//						index = 0;
//					}
//				}
//			}
//			while((offset = fileInput2.read(readBytes2)) != -1)
//			{
//				int index = 0;
//				for(int read = 0; read < offset; read += 4)
//				{
//					test[index] = ((readBytes2[read] & 0xff) << 24) |
//								((readBytes2[read+1] & 0xff) << 16) |
//								((readBytes2[read+2] & 0xff) << 8) |
//								(readBytes2[read +3] & 0xff);
//					index++;
//					
//					if (index == 3)
//					{
//						if (test[1] == 20)
//						{
//							transGraph.startTransaction(test[0], test[2]);
//						}
//						else if(test[1] == 21)
//						{
//							transGraph.endTransaction(test[0], test[2]);
//						}
//						else if(test[1] == 22)
//						{
//							transGraph.processRead(test[0], test[2]);
//						}
//						else if(test[1] == 23)
//						{
//							transGraph.processWrite(test[0], test[2]);
//						}
//						else if(test[1] == 24)
//						{
//							transGraph.processAcquire(test[0], test[2]);
//						}
//						else if(test[1] == 25)
//						{
//							transGraph.processRelease(test[0], test[2]);
//						}
//						
//						index = 0;
//					}
//				}
//			}
//			while((offset = fileInput3.read(readBytes3)) != -1)
//			{
//				int index = 0;
//				for(int read = 0; read < offset; read += 4)
//				{
//					test[index] = ((readBytes3[read] & 0xff) << 24) |
//								((readBytes3[read+1] & 0xff) << 16) |
//								((readBytes3[read+2] & 0xff) << 8) |
//								(readBytes3[read +3] & 0xff);
//					index++;
//					
//					if (index == 3)
//					{
//						if (test[1] == 20)
//						{
//							transGraph.startTransaction(test[0], test[2]);
//						}
//						else if(test[1] == 21)
//						{
//							transGraph.endTransaction(test[0], test[2]);
//						}
//						else if(test[1] == 22)
//						{
//							transGraph.processRead(test[0], test[2]);
//						}
//						else if(test[1] == 23)
//						{
//							transGraph.processWrite(test[0], test[2]);
//						}
//						else if(test[1] == 24)
//						{
//							transGraph.processAcquire(test[0], test[2]);
//						}
//						else if(test[1] == 25)
//						{
//							transGraph.processRelease(test[0], test[2]);
//						}
//						
//						index = 0;
//					}
//				}
//			}
//			while((offset = fileInput4.read(readBytes4)) != -1)
//			{
//				int index = 0;
//				for(int read = 0; read < offset; read += 4)
//				{
//					test[index] = ((readBytes4[read] & 0xff) << 24) |
//								((readBytes4[read+1] & 0xff) << 16) |
//								((readBytes4[read+2] & 0xff) << 8) |
//								(readBytes4[read +3] & 0xff);
//					index++;
//					
//					if (index == 3)
//					{
//						if (test[1] == 20)
//						{
//							transGraph.startTransaction(test[0], test[2]);
//						}
//						else if(test[1] == 21)
//						{
//							transGraph.endTransaction(test[0], test[2]);
//						}
//						else if(test[1] == 22)
//						{
//							transGraph.processRead(test[0], test[2]);
//						}
//						else if(test[1] == 23)
//						{
//							transGraph.processWrite(test[0], test[2]);
//						}
//						else if(test[1] == 24)
//						{
//							transGraph.processAcquire(test[0], test[2]);
//						}
//						else if(test[1] == 25)
//						{
//							transGraph.processRelease(test[0], test[2]);
//						}
//						
//						index = 0;
//					}
//				}
//			}
//			transGraph.update_AtomicList();
//			newLen = transGraph.get_atomic();
//			if(lastLen == newLen)
//			{
//				ArrayList<Integer> atomicList = transGraph.get_atomicList();
//				for(int s = 0; s < atomicList.size(); s++)
//				{
//					fileOutput5.write(atomicList.get(s).toString());
//					fileOutput5.write("\n");
//				}
//				fileOutput5.flush();
//				System.out.println(round);
//				//print atomic
//				break;
//			}
//			lastLen = newLen;
//		}
//		fileInput1.close();
//		fileInput2.close();
//		fileInput3.close();
//		fileInput4.close();
//		fileOutput5.close();
//		
//	}
		
		
		
		
		
		for(int i = 0; i < bench2.size(); i++) {
			String bench_trace = loc + "trace_" + trace + trace_path + bench2.get(i) + "1.log";
			//String bench_trace = loc + "JGF_section2_" + trace + trace_path + bench2.get(i) + "1.log";
			//String bench_trace = bench2.get(i) + "1.log";
			File f1 = new File(bench_trace);
			FileInputStream fileInput1 = new FileInputStream(f1);
			String atomic_out = "atomic_specification/RT_iteration/" + bench2.get(i) + "_" + trace;
			FileWriter f3 = new FileWriter(atomic_out, true);
			BufferedWriter fileOutput3 = new BufferedWriter(f3);
			TransactionalHBGraph transGraph = new TransactionalHBGraph();
			PrintStream ps = new PrintStream(new FileOutputStream("RT_iteration_"+bench2.get(i)+trace));
			System.setOut(ps);
			byte[] readBytes1 = new byte[BUFFER_SIZE];
			int offset = 0;
			int[] test = new int[3];
			int lastLen = 0;
			int newLen = 0;
			int round = 0;
			while(true)
			{
				round++;
				System.out.println("round "+round);
				transGraph.initData();
				if(round != 1)
				{
					fileInput1 = new FileInputStream(f1);
				}
				
				while((offset = fileInput1.read(readBytes1)) != -1)
				{
					int index = 0;
					for(int read = 0; read < offset; read += 4)
					{
						test[index] = ((readBytes1[read] & 0xff) << 24) |
									((readBytes1[read+1] & 0xff) << 16) |
									((readBytes1[read+2] & 0xff) << 8) |
									(readBytes1[read +3] & 0xff);
						index++;
						
						if (index == 3)
						{
//							if(test[0] != 2)
//							{
//								System.out.print(test[0]);
//								System.out.print(" ");
//								System.out.print(test[1]);
//								System.out.print(" ");
//								System.out.print(test[2]);
//								System.out.println(" ");
//							}
							
							if (test[1] == 20)
							{
								transGraph.startTransaction(test[0], test[2]);
							}
							else if(test[1] == 21)
							{
								transGraph.endTransaction(test[0], test[2]);
							}
							else if(test[1] == 22)
							{
								transGraph.processRead(test[0], test[2]);
							}
							else if(test[1] == 23)
							{
								transGraph.processWrite(test[0], test[2]);
							}
							else if(test[1] == 24)
							{
								transGraph.processAcquire(test[0], test[2]);
							}
							else if(test[1] == 25)
							{
								transGraph.processRelease(test[0], test[2]);
							}
							
							index = 0;
						}
					}
				}
				transGraph.update_AtomicList();
				newLen = transGraph.get_atomic();
				if(lastLen == newLen)
				{
					ArrayList<Integer> atomicList = transGraph.get_atomicList();
					for(int s = 0; s < atomicList.size(); s++)
					{
						fileOutput3.write(atomicList.get(s).toString());
						fileOutput3.write("\n");
					}
					fileOutput3.flush();
					System.out.println(round);
					//print atomic
					break;
				}
				lastLen = newLen;
			}
			fileInput1.close();
			fileOutput3.close();
			
		}
		
		
		
		for(int i = 0; i < bench1.size(); i++) {
			String bench_trace1 =  loc + "trace_" + trace + trace_path + bench1.get(i) + "1.log"; //
			String bench_trace2 = loc + "trace_" + trace + trace_path + bench1.get(i) + "2.log"; //
//			String bench_trace3 = loc + "trace_" + trace + trace_path + bench1.get(i) + "3.log";
			File f1 = new File(bench_trace1);
			FileInputStream fileInput1 = new FileInputStream(f1);
			File f2 = new File(bench_trace2);
			FileInputStream fileInput2 = new FileInputStream(f2);
//			File f3 = new File(bench_trace3);
//			FileInputStream fileInput3 = new FileInputStream(f3);
			String atomic_out = "atomic_specification/RT_iteration/" + bench1.get(i) + "_" + trace;
			FileWriter f4 = new FileWriter(atomic_out, true);
			BufferedWriter fileOutput4 = new BufferedWriter(f4);
			TransactionalHBGraph transGraph = new TransactionalHBGraph();
			PrintStream ps = new PrintStream(new FileOutputStream("RT_iteration_"+bench1.get(i)+trace));
			System.setOut(ps);
			byte[] readBytes1 = new byte[BUFFER_SIZE];
			byte[] readBytes2 = new byte[BUFFER_SIZE];
//			byte[] readBytes3 = new byte[BUFFER_SIZE];
			int offset = 0;
			int[] test = new int[3];
			int lastLen = 0;
			int newLen = 0;
			int round = 0;
			while(true)
			{
				round++;
				System.out.println("round "+round);
				transGraph.initData();
				if(round != 1)
				{
					fileInput1 = new FileInputStream(f1);
					fileInput2 = new FileInputStream(f2);
//					fileInput3 = new FileInputStream(f3);
				}
				while((offset = fileInput1.read(readBytes1)) != -1)
				{
					int index = 0;
					for(int read = 0; read < offset; read += 4)
					{
						test[index] = ((readBytes1[read] & 0xff) << 24) |
									((readBytes1[read+1] & 0xff) << 16) |
									((readBytes1[read+2] & 0xff) << 8) |
									(readBytes1[read +3] & 0xff);
						index++;
						
						if (index == 3)
						{
//							if(flag == true)
//							{
//								System.out.println(test[0]+" "+test[1]+" "+test[2]);
//							}
							if (test[1] == 20)
							{
								transGraph.startTransaction(test[0], test[2]);
							}
							else if(test[1] == 21)
							{
								transGraph.endTransaction(test[0], test[2]);
							}
							else if(test[1] == 22)
							{
								transGraph.processRead(test[0], test[2]);
							}
							else if(test[1] == 23)
							{
								transGraph.processWrite(test[0], test[2]);
							}
							else if(test[1] == 24)
							{
								transGraph.processAcquire(test[0], test[2]);
							}
							else if(test[1] == 25)
							{
								transGraph.processRelease(test[0], test[2]);
							}
							
							index = 0;
						}
					}
				}
				while((offset = fileInput2.read(readBytes2)) != -1)
				{
					int index = 0;
					for(int read = 0; read < offset; read += 4)
					{
						test[index] = ((readBytes2[read] & 0xff) << 24) |
									((readBytes2[read+1] & 0xff) << 16) |
									((readBytes2[read+2] & 0xff) << 8) |
									(readBytes2[read +3] & 0xff);
						index++;
						
						if (index == 3)
						{
//							if(flag == true)
//							{
//								System.out.println(test[0]+" "+test[1]+" "+test[2]);
//							}
							if (test[1] == 20)
							{
								transGraph.startTransaction(test[0], test[2]);
							}
							else if(test[1] == 21)
							{
								transGraph.endTransaction(test[0], test[2]);
							}
							else if(test[1] == 22)
							{
								transGraph.processRead(test[0], test[2]);
							}
							else if(test[1] == 23)
							{
								transGraph.processWrite(test[0], test[2]);
							}
							else if(test[1] == 24)
							{
								transGraph.processAcquire(test[0], test[2]);
							}
							else if(test[1] == 25)
							{
								transGraph.processRelease(test[0], test[2]);
							}
							
							index = 0;
						}
					}
				}
//				while((offset = fileInput3.read(readBytes3)) != -1)
//				{
//					int index = 0;
//					for(int read = 0; read < offset; read += 4)
//					{
//						test[index] = ((readBytes3[read] & 0xff) << 24) |
//									((readBytes3[read+1] & 0xff) << 16) |
//									((readBytes3[read+2] & 0xff) << 8) |
//									(readBytes3[read +3] & 0xff);
//						index++;
//						
//						if (index == 3)
//						{
//							if (test[1] == 20)
//							{
//								transGraph.startTransaction(test[0], test[2]);
//							}
//							else if(test[1] == 21)
//							{
//								transGraph.endTransaction(test[0], test[2]);
//							}
//							else if(test[1] == 22)
//							{
//								transGraph.processRead(test[0], test[2]);
//							}
//							else if(test[1] == 23)
//							{
//								transGraph.processWrite(test[0], test[2]);
//							}
//							else if(test[1] == 24)
//							{
//								transGraph.processAcquire(test[0], test[2]);
//							}
//							else if(test[1] == 25)
//							{
//								transGraph.processRelease(test[0], test[2]);
//							}
//							
//							index = 0;
//						}
//					}
//				}
				transGraph.update_AtomicList();
				newLen = transGraph.get_atomic();
				if(lastLen == newLen)
				{
					ArrayList<Integer> atomicList = transGraph.get_atomicList();
					for(int s = 0; s < atomicList.size(); s++)
					{
						fileOutput4.write(atomicList.get(s).toString());
						fileOutput4.write("\n");
					}
					fileOutput4.flush();
					System.out.println(round);
					//print atomic
					break;
				}
				lastLen = newLen;
			}
			fileInput1.close();
			fileInput2.close();
//			fileInput3.close();
			fileOutput4.close();
			
		}


		
	}
	
	
	

}
