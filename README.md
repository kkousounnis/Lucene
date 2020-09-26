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


### Installation Guide - To pass All texts to Lucene
Step Before running our application.

![image](https://user-images.githubusercontent.com/39504405/94339312-c4b38a00-0001-11eb-8f89-5db064b17389.png)

We pass all text and Isbn numbers to Lucene from the given file which we already have \cacm folder\ **CACM** and ignoring all the **common words** that we don't need.

![image](https://user-images.githubusercontent.com/39504405/94339361-2673f400-0002-11eb-9c62-470c2e6de0e5.png)

Here we can see that our texts were passed successful in the last line.

**Successful indexing with avoiding common words from commowords file and using porter algorithm for stemming.**
