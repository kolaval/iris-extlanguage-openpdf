# iris-extlanguage-openpdf

Practical sample application showing how to generate PDF documents using IRIS and Java.

The code can easily be used to call any java application using the intersystems jdbc library.

**The java application;**

uses the [gson](https://github.com/google/gson) library to parse JSON.

uses the [OpenPDF](https://github.com/LibrePDF/OpenPDF) library to generate the PDF.

uses the intersystems jdbc library to receive and return data back to IRIS.


**The IRIS application;**

Uses a Java gateway setup in 'External Language Server' page to make a stateless connecton to the Java application.

**Setup**

Assuming IRIS is installed in C:\IRIS

Download the source code and extract.


**JAVA Setup**


**IRIS Setup**

Import the com.test/iris/classes.xml to generate the sample classes.

Import the com.test/iris/data.gof to populate the sample class data.







