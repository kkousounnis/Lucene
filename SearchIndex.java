import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.custom.CustomAnalyzer;
import org.apache.lucene.analysis.standard.*;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;

import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.tartarus.snowball.ext.PorterStemmer;
import org.apache.lucene.document.*;

public class SearchIndex {

	public static void main(String[] args)throws IOException, ParseException {
		// TODO Auto-generated method stub
		String results="";
		
		
		StandardAnalyzer analyzer = new StandardAnalyzer();
		
		CharArraySet stopSet = CharArraySet.copy( StandardAnalyzer.STOP_WORDS_SET);
		FileInputStream fstream1 = new FileInputStream("cacm/common_words");
		DataInputStream in1 = new DataInputStream(fstream1);
		  BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
		  String strLineCommonWords;
		 
		  while ((strLineCommonWords = br1.readLine()) != null)   {
		   //String strLineCommonWordsStemmed= applyPorterStemmer(strLineCommonWords);

		   
			  
	       stopSet.add(applyPorterStemmer(strLineCommonWords));
	      
	        //System.out.println(strLineCommonWords);
	       // stopSet.add("across");
		  } 
		  analyzer = new StandardAnalyzer(stopSet);
		
		
		
		 
		
		
		String indexDir="/tmp/testindex";
		Directory index = FSDirectory.open(Paths.get(indexDir));
		String query="What articles exist which deal with TSS (Time Sharing System), an\n" + 
				"operating system for IBM computers?";
		
		String queryStemmed="";
		String queryInitialize="";
		String word="";
		Pattern pattern = Pattern.compile("\\w+");
		Matcher matcher = pattern.matcher(query);
		while (matcher.find()) {
			queryInitialize=matcher.group();
		    word= applyPorterStemmer(queryInitialize);

		     //System.out.println(word);
		    queryStemmed=queryStemmed+" "+word;
			 
		}		
		
		IndexWriterConfig config =new IndexWriterConfig(analyzer);
		
		String querystr=queryStemmed;
		Query q=new QueryParser("myText",analyzer).parse(querystr);
		
		int hitsPerPage=60;
		IndexReader reader=DirectoryReader.open(index);
		IndexSearcher searcher=new IndexSearcher(reader);
		TopDocs docs=searcher.search(q,hitsPerPage);
		ScoreDoc[] hits=docs.scoreDocs;
		
		
		
		//System.out.println("Found"+hits.length+"hits"+"&&&");
		String HowManyHits="Found"+hits.length+"hits"+"&&&";
		for(int i=0;i<hits.length;++i) {
			int docId=hits[i].doc;
			Document d=searcher.doc(docId);
			System.out.println((i+1)+"."+d.get("isbn")+"\t"+d.get("myText"));
			
			
			
			//results=results+d.get("isbn")+"\t"+"<br>"+d.get("title")+"&&&";
			results=results+d.get("isbn")+"&&&";
			
		} 
		 
	}
	public static  String applyPorterStemmer(String input) throws IOException {

	    PorterStemmer stemmer = new PorterStemmer();
	    stemmer.setCurrent(input);
	    stemmer.stem();
	    return stemmer.getCurrent();
	}
}
