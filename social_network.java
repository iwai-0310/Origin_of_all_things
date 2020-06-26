package UF;
import java.io.*;
import java.util.*;

public class social_network{
	private FileInputStream ins;
	public weightedQuickUnionUF uf;
	public social_network(int num,FileInputStream ins){
		this.ins=ins;
		uf = new WeightedQuickUnionUF(num);
	}
	public String getEarliestConTime(){
		Scanner scanner=new Scanner(ins,"utf-8");
		String earliestConTime=null;
		while(scanner.hasNextLine()){
			String line=scanner.nextLine();
			if(line !=null && !line.trim().equals("")){
				String[] lineArray=line.split("");
				if(lineArray.length==3){
					String timestamp=lineArray[0];
					int p=Integer.parseInt(lineArray[1]);
					int q=Integer.parseInt(lineArray[2]);
					if(uf.connected(p,q))continue;
					uf.union(p,q);
					if(uf.count()==1){
						earliestConTime=timestamp;
						break;
					}
				}
			}
		}
	}
	 public static void main(String[] args) {
		FileInputStream ins;
		try{
			ins=new FileInputStream("Socialnetworking.txt");
			social_network socialnet=new social_network(10,ins);
			String earliestConTime=socialnet.getEarliestConTime();
			StdOut.println("the earliest connected time is :"+earliestConTime);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
}