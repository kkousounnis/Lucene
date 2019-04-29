
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

import org.apache.lucene.analysis.CharArraySet;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.tartarus.snowball.ext.PorterStemmer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class IndexErgasiaFIles {
	 
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		try{
		StandardAnalyzer analyzer = new StandardAnalyzer();
		
		 CharArraySet stopSet = CharArraySet.copy( StandardAnalyzer.STOP_WORDS_SET);
		 
		 FileInputStream fstream1 = new FileInputStream("cacm/common_words");
		 
		  DataInputStream in1 = new DataInputStream(fstream1);
		  BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
		  String strLineCommonWords;
		 
		  while ((strLineCommonWords = br1.readLine()) != null)   {
		   //String strLineCommonWordsStemmed= applyPorterStemmer(strLineCommonWords);

		   //System.out.println(word); 
			  
	       stopSet.add(applyPorterStemmer(strLineCommonWords));
	      
	       // System.out.println(strLineCommonWords);
	       // stopSet.add("across");
		  } 
	     analyzer = new StandardAnalyzer(stopSet);
		
		 
	     
	     //String word= applyPorterStemmer("accordingly");

	     //System.out.println(word);
	          
		
		
		String indexDir="/tmp/testindex";
		Directory index = FSDirectory.open(Paths.get(indexDir));
		
		IndexWriterConfig config=new IndexWriterConfig(analyzer);
		
		IndexWriter w=new IndexWriter(index,config);
		
		
		FileInputStream fstream = new FileInputStream("cacm/cacm.all");
		 
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  String strLine;
		 
		  
		  int x=0;
		  
		  String s1="";
		  String s2="";
		  
		  while ((strLine = br.readLine()) != null)   {
			  
			  if(strLine.contains(".I")) {
					//System.out.println(strLine);
				  	
					s1=strLine;
					
				}
			  if(strLine.contains(".T")||x==1) {
					x=1;
					if(strLine.contains(".B")) {
					
					}else {
						//System.out.println(strLine);
						
						
						s2=s2+strLine;
						
						
					}
				}
				if(strLine.contains(".B")) {
					x=0;
					
					 				
				}	
				if(strLine.contains(".A")) {
					x=2;
					 
					
				}
				
				if(x==2) {
					if(strLine.contains(".N")==false || strLine.contains(".K") || strLine.contains(".C")) {
						s2=s2+strLine; 
						//System.out.println(strLine);
					}
				}
				if(strLine.contains(".N")|| strLine.contains(".K") || strLine.contains(".C")) {
					x=0;
					addDoc(w,s2,s1);
					s1="";
					s2="";
				}
				
		   
			  //addDoc(w,"This is my first Doc Kwstas","1");
		
			  
		
		  }
		   
		  w.close();
		  System.out.println("Successful indexing with avoiding common words from commowords file and using Porter algorithm for stemming!!!");
		
		}catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
	}
	private static void addDoc(IndexWriter w, String myText, String isbn)throws IOException {
		// TODO Auto-generated method stub
		Document doc = new Document();
		String myTextStemmed="";
		String myTextInitialize="";
		String word="";
		Pattern pattern = Pattern.compile("\\w+");
		Matcher matcher = pattern.matcher(myText);
		while (matcher.find()) {
			myTextInitialize=matcher.group();
		    word= applyPorterStemmer(myTextInitialize);

		     //System.out.println(word);
		    myTextStemmed=myTextStemmed+" "+word;
			 
		}
		
		//System.out.println(tittleStemmed); 
		doc.add(new TextField("myText",myTextStemmed,Field.Store.YES));
		
		doc.add(new StringField("isbn",isbn,Field.Store.YES));
		w.addDocument(doc);
		
		System.out.println(doc); 
		 
		 
	}
	public static  String applyPorterStemmer(String input) throws IOException {

	    PorterStemmer stemmer = new PorterStemmer();
	    stemmer.setCurrent(input);
	    stemmer.stem();
	    return stemmer.getCurrent();
	}
}



