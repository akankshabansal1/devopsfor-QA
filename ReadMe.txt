## Getting Started
General FrameWork Info

Maven Project with dependencies added in pom.xml, found under /codeamazon folder

codeamazon/src/main/java/PageObjects(Contains page objects)
SearchPage.java
DeleteProduct.java
SigninPage.java
WishlistPage.java

codeamazon/src/main/java/TestNgPackage(Contains test methods / test script)
webConnector.java
SearchTest.java
DeleteProductTest.java
SigninTest.java
WishlistTest.java

codeamazon/src/main/resources(Contains properties files)

log4j.properties(log4jproperties file)
Configuration.properties (Contains config/properties file)

Data retrieved from TestData.xlsx found under /src/main/resources folder

testng.xml (To execute the tests) found under/codeamazon folder

Extent Report is generated inside folder /codeamazon/target/ExtentReport

Failed Screenshot are generated inside folder /codeamazon
   
## Prerequisites
* Java 8 JDK
* Apache Maven 3.x
* Chrome Driver 

## Installing
Install Apache Maven 3.x into your system.


## Running the tests

Go to the root directory and browse your testNG.xml under \codeamazon folder  right click and select Run as >>run TestNG Suite 
OR
Execute on cmd(Run as Admin) - > 
cd <Path where codeamazon folder is kept> Example : cd C:\Users\akankshabansal\eclipse-workspace\codeamazon -Press Enter
mvn clean test -Dsurefire.suiteXmlFiles=<Path where codeamazon folder is kept>/testng.xml  Example : mvn clean test -Dsurefire.suiteXmlFiles=C:\Users\akankshabansal\eclipse-workspace\codeamazon\testng.xml - Press Enter
 

Also can check emailable-report under \codeamazon\test-output folder





