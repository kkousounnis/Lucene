# Web Site Search Engine - Lucene Libraries
### J2EE-Eclipse-Tomcat Apache Server- Lucene - JSP
#### Quick Application Presentation
![p1](https://user-images.githubusercontent.com/39504405/94338861-486b7780-fffe-11ea-85e7-0f071ae4ab3f.png)

Here we can see our first page similar to a search bar.
We can find a question to ask from the Ergasia_p14086_Lucene2018_2019\cacm folder\ **query.txt**.

We Press Search and After we hava passed into Lucene all the test cases from \cacm folder\ **CACM** file we can get our respond to query.

![p2](https://user-images.githubusercontent.com/39504405/94339137-4b676780-0000-11eb-8c0c-2b7cfee14eb5.png)

It responds like a search engine. 
It shows us first all the common texts and numeric order to how similar are with our query. 
Afterwards we can read the whole text by pressing **ViewFullText**.

![image](https://user-images.githubusercontent.com/39504405/94339244-0db70e80-0001-11eb-9554-f5bdf45e381a.png)

Here is the full text.
At the bottom of the page we can return to first page.


## Installation Guide - To pass All texts to Lucene
Step Before running our application.

![image](https://user-images.githubusercontent.com/39504405/94339643-10ffc980-0004-11eb-912f-f233b59f24ef.png)

Here we take the file \cacm folder\ **CACM** and pass all the texts it to Lucene.

![image](https://user-images.githubusercontent.com/39504405/94339312-c4b38a00-0001-11eb-8f89-5db064b17389.png)

We pass all text and Isbn numbers to Lucene from the given file which we already have \cacm folder\ **CACM** and ignoring all the **common words** that we don't need.

![image](https://user-images.githubusercontent.com/39504405/94339361-2673f400-0002-11eb-9c62-470c2e6de0e5.png)

Here we can see that our texts were passed successful in the last line.

**Successful indexing with avoiding common words from commowords file and using porter algorithm for stemming.**

## Analysis - Precision Recall - Query 
Step 1 We make a query in the example we use 7th query at the web search engine we created.
Step 2 we take all the results and print to an excel file as we see at the Bottom.

![image](https://user-images.githubusercontent.com/39504405/94364495-5db1d600-00d2-11eb-933a-1fc284832fdb.png)

**First column**: We construct the first column from the qrel.text file that we already have been given from CACM folder. This txt file was created by people who have already read the texts and declared if the query is relevant or not, in other words it habe been made with human judgment. We assign R (Relevant) if the text  exists in qrel.txt and N (NonRelevant) if it doesn't.

![image](https://user-images.githubusercontent.com/39504405/94364736-39ef8f80-00d4-11eb-9dec-08c734feeb36.png)

![image](https://user-images.githubusercontent.com/39504405/94364869-28f34e00-00d5-11eb-8de4-eb31eb96d8fc.png)

**Second column**: The Isbn number of the text that has been returned.
**Third column**: Recall List, fraction with numerator all relevant texts until this point and denominator all texts that were returned.
**Fourth column**: Precision List, fraction all the relevant texts until this point and denominator all the text until this point.
**Graphical Presentation**: As an analysis must be maid we create a precision - recall Diagram.






