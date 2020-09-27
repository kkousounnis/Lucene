package Main;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.lucene.queryparser.classic.ParseException;

import Model.Text;



/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private static String SearchResult="/SearchResult.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action=request.getParameter("action");
    	if(action.equalsIgnoreCase("ViewFullText")) {
    		response.setContentType("text/html;charset=UTF-8");
    		PrintWriter out = response.getWriter();    		
    		out.print("<head><title>FullText</title></head>");
			String isbn=request.getParameter("isbn");
			System.out.println(isbn);
			FileInputStream fstream = new FileInputStream("../../cacm/cacm.all");
			 
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int x=0;
			out.print("<b> Text "+isbn+"</b>");
			
				
			//Text.setIsbn(TextResults[i]);
			out.print( "<br>");
			while ((strLine = br.readLine()) != null)   {
				  if(x==1) {
					  if(strLine.contains(".T")==false) {
						  if(strLine.contains(".B")==false) {
							  if(strLine.contains(".W")==false) {
								  out.print(strLine);
								 
							  }
						  }
					  }
					  if(strLine.contains(".W")) {
						  out.print(".</b><br></br>Text:");
					  }
						  
				  }
				  if(strLine.contains(isbn)) {							  	
						x=1;
						out.print( "<b>Title:");
					}						
					  
				  if(strLine.contains(".B")) {
						  	 
						x=0;
					}
			}
				
				out.print( "<br>");
				out.print( "<br><br><br><br><a href=\"Index.jsp\">StartPage</a> ");
				
		}
    }
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String action=request.getParameter("action");
		String query=request.getParameter("Query");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<head><title>SearchResult</title></head>");
		
		SearchIndex s=new SearchIndex();
		
		ArrayList<Text> Texts=new ArrayList<Text>();
	
		File file=new File("../../../query65.txt");
		file.createNewFile();
		FileWriter writer=new FileWriter(file);
		
	
		if(action.equalsIgnoreCase("Search")) {
			 
			 	
			//out.print(result);
			 
			
			 
			try {
				//System.out.println(s.Search(query));
				String 	Result = s.Search(query);
				
				//Text.setIsbn("I123");
				//Text.setTitle("Hello this is my title");
				ReadTitleTwoLinesText RT=new ReadTitleTwoLinesText();
				//Texts.add(Text);
				//System.out.println(Texts);
				String[] TextResults=Result.split("&&&");
				for(int i=0;i<TextResults.length;i++) {
					Text Text=new Text();
					String title="";
					 title=RT.TitleTwoLinesText(TextResults[i]);
					 //System.out.println(TextResults[i]+title);
					 Text.setIsbn(TextResults[i]);
					 Text.setTitle(title);
					 Text.setCounter(i);
					 Texts.add(Text);
					 
					// System.out.println(Texts);
					 
					 writer.write(TextResults[i]);
					 
					}
				
				writer.close();
				//out.print(Result);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(Texts);
			request.setAttribute("Texts", Texts);
			
			request.getRequestDispatcher("SearchResult.jsp").forward(request, response);
			 
		}
		
	}
	
}
