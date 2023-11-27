# iris-extlanguage-openpdf

### Introduction
Practical sample application showing how to generate PDF documents using IRIS and Java.
OpenPDF allows you to handcraft PDFs instead of relying on HTML to PDF printing.
This gives you complete control over the structure of the PDF.

The code can easily be used to call any java application using the intersystems jdbc library.    
The code works on windows and linux.    

The IRIS and java source (eclipse project) is included.    
This sample uses the USER namespace and assumes you are familiar with IRIS.

### Prerequisites
IRIS.    
IRIS supported Java version.

### 1. JAVA TEST
Let's make sure your Java is working:    
1. Extract the javatest folder.
2. In command line, navigate to the javatest parent folder, and run the testpackage.Text.class, e.g.
```code
  C:\>java -classpath "C:\javatest;C:\javatest\lib\*" testpackage.Test
  Call result: %PDF-1.5
```
You should not get any errors and the output should contain the text '%PDF'.    
*Do not execute the command from inside the javatest folder itself (the classpath has to contain the root directory, not the package subdirectories).

### 2. External Language Server setup
![image](https://github.com/kolaval/iris-extlanguage-openpdf/assets/4124487/6406a5f4-94ea-4966-bbe2-d6e5c84acbcf)

1. In IRIS SMP navigate to System > Configuration > External Language Servers.    
2. Click Add External Language Server, give it a name, port (that is not blocked by your firewall)    
   Set the Java home directory if not part of your PATH.    
   Click Save.    
3. Click Start and make sure your gateway is running by checking the activity log.
4. You can also do a check from terminal:
```code
USER>w ##class(%Net.Remote.Java.JavaGateway).%Ping("127.0.0.1",12345)
1
```

### 3. IRIS code setup
Now let's setup IRIS    
1. Extract the iris folder.    
2. Import the classes and globals to your USER namespace.    
  ```code
    USER>Do $system.OBJ.Load("c:\iris\classes.xml","ck")
    USER>Do $system.OBJ.Load("c:\iris\data.gof")
  ```
   You should have some classes and data (taken from the Intersystems samples):    
   ![image](https://github.com/kolaval/iris-extlanguage-openpdf/assets/4124487/9f469d46-5153-41c8-abb7-ac31c816062a)
3. Edit the Sample.Report class to set your classpath (to the folder you used in 1.1)
   We do this because we have multiple external language servers running:
  ```code
  Set ClassPath=##class(%ListOfDataTypes).%New()
  Do ClassPath.Insert("C:\javatest\lib\gson-2.8.2.jar")
  Do ClassPath.Insert("C:\javatest\lib\openpdf-1.3.32.jar")
  Do ClassPath.Insert("C:\javatest\")
  Set File=##class(%Stream.FileBinary).%New()
  Set sc=File.LinkToFile("C:\javatest\sample.pdf")
  ```
4. Make sure the port number matches your external gateway port:
  ```code
  Set host="127.0.0.1"
  Set port=12345
  Set serviceName="testpackage.ExampleOpenPdf"
  ```
5. Compile your class.


### 3. Generate a PDF
1. In terminal run
  ```code
  d ##class(Sample.Report).GenerateReport()
  ```
You should get a "PDF generated" message and a PDF file in your folder.


### 4. More details: Java application
1. Uses the [gson](https://github.com/google/gson) library to parse JSON.    
2. Uses the [OpenPDF](https://github.com/LibrePDF/OpenPDF) library to generate the PDF.    
3. Uses the intersystems jdbc library to receive and return data back to IRIS.    
4. The class you're calling should implement com.intersystems.gateway.Service
