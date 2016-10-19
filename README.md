# LearnJDBC
Learn and use JDBC APIs with simple but the best examples. The step by step learning with coolest examples and proper supporting documentation.

## Getting started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
1. Java, we are using Java 1.8 (download and install [Java](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html))
2. Any **IDE** of you choice like Eclipse (download and install/unzip [Eclipse](http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/neon1a))
3. Any relational database, here for simplicity we are using H2 (download and install/unzip [H2](http://www.h2database.com/html/download.html))
4. JDBC Driver, in our case we are using H2 and H2 JDBC driver can be found in h2\bin as Executable Jar File

### Good to have
If you wanna speed up all the process and want up-to-date with all changes. Follow the below steps

* Join [GitHub](https://github.com/join), watch and star the [LearnJDBC](https://github.com/AtulDwivedi/LearnJDBC) project  
* Download and install [Git](https://git-scm.com/downloads)
* Download and install [TortoiseGit](https://tortoisegit.org/download/)

### How to run Hello world JDBC program?
After installing all mentioned softwares, you can follow the below steps to get [HelloWorldJDBC.java](https://github.com/AtulDwivedi/LearnJDBC/blob/master/src/com/atuldwivedi/learnjdbc/basic/HelloWorldJDBC.java) program run.

1. Copy https://github.com/AtulDwivedi/LearnJDBC.git URL
2. Launch the eclipse
3. Go to eclipss workspace folder, right click and click Git Clone, paste the copied URL in URL field, click Ok
4. Copy project name i.e. LearnJDBC
5. Create new **LearnJDBC** project in Eclipse
  * Open Eclipse click File -> New -> Others
  * Type Java Project in Wizards text box
  * Select Java Project, click Next
  * Paste copied project name in Project Name text box
  * Select Use default JRE radio button
  * Click Next, Click Finish
6. Click on newly created project, right click, click Refresh
7. Click on LearnJDBC project, right click, click Build Path -> Configure Build Path...
8. Click Libraries, click Add External JARs..
9. Navigate to H2 installation directory and go inside h2\bin
10. Select Executable Jar File, click Open
11. Click Ok
12. Open HelloWorldJDBC.java file in eclipse
13. Right click in file, Run As -> Java Application


