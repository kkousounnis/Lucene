package Main;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadTitleTwoLinesText {
	public String TitleTwoLinesText(String TextResult) throws FileNotFoundException{
		String TitleTwoLinesText="";
		
		FileInputStream fstream = new FileInputStream("../../cacm/cacm.all");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String strLine;
		int x=0;
		int takefirsttwolines=5;
		try {
			while ((strLine = br.readLine()) != null)   {
				  if(x==1) {
					  if(strLine.contains(".T")==false ) {
						  if(strLine.contains(".W")==false ) {
							  TitleTwoLinesText= TitleTwoLinesText+strLine;
						  }
						  
							 
						  
					  //Text.setTitle(strLine);
						  if(takefirsttwolines<2 ) {
							   
							  takefirsttwolines++;						  
							   
							  x=0;
						  }
						  if(strLine.contains(".W")==true ) {
							  TitleTwoLinesText=TitleTwoLinesText+"              )TextStart:";
							  takefirsttwolines=1;
							   
						  }
						  
						  
					  }
					  
				  }
				  if(strLine.contains(TextResult)) { 
						x=1;
					}						
				  
				  if(strLine.contains(".B")) {
					  	 
						x=0;
					}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return TitleTwoLinesText;
	}
}
