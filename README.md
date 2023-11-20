# iris-extlanguage-openpdf

Practical sample application showing how to generate PDF documents using IRIS and Java.

The code can easily be used to call any java application using the intersystems jdbc library.
The IRIS and java source is included.

### Prerequisites    
Assuming IRIS is installed in C:\IRIS    
Assuming Java is installed and using C:\IRIS\CSP\user as the folder.    

### To run the sample code
1. Download and extract the source.    
2. Put the pdf folder in C:\IRIS\CSP\user    
3. Create a new 'Extrenal Language Server' configuration and make sure it starts.    
![image](https://github.com/kolaval/iris-extlanguage-openpdf/assets/4124487/90d260db-2f4a-4fe9-93e2-6f2b8595f6fe)
4. Import and compile the com.test/iris/classes.xml to generate the sample classes.    
5. Import the com.test/iris/data.gof to populate the sample class data.    
6. Run USER>d ##class(Sample.Report).GenerateReport()    
7. View PDF generated in C:\IRIS\CSP\user\sample.pdf    



### More details: Java application
1. Uses the [gson](https://github.com/google/gson) library to parse JSON.    
2. Uses the [OpenPDF](https://github.com/LibrePDF/OpenPDF) library to generate the PDF.    
3. Uses the intersystems jdbc library to receive and return data back to IRIS.    
4. The class you're calling should implement com.intersystems.gateway.Service    

### More details: IRIS application

1. See Sample.Report:GenerateReport    
2. Add your java libraries and teh classes to the the classpath e.g. d ClassPath.Insert("C:\IRIS\CSP\user\pdf\lib\gson-2.8.2.jar")    
3. Generate your JSON object and convert it to string    
4. Call the %Net.Remote.Java.JavaGateway:%RemoteService method    
5. Note: the port number should match your Extrenal Language Server port and the java classes should follow your class path.
