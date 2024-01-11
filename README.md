# Servlet base RESTful-API
## Background
The is a RESTful API Servlet based. It uses CRUD operations. It has four methods at basic level.
Those methods are used in ProductServlet class. Those methods are optimized in optimizeapp. The app class is to check how much energy those methods consume (wihtout any optimization) when running with a Java agent. 
Write ...
## How to build
Install maven on your machine. I use a Linux distro. Take a look at the pom file. Download and install [jRAPL](https://github.com/aservet1/jRAPL). Import and install [Java Microbench Harness](https://github.com/openjdk/jmh), JMH. It is poosible to add JMH from Plugins. If you are interested in testing Servlet to see if those methods works then download [Apache Tomacat](https://tomcat.apache.org/download-90.cgi)and configure your settings. 
IntelliJ not from the Toolbox! 


## Running -- Add screenshoot!
To run jRAPL and JMH run:
```
sudo java -cp "target/rest-api-0.0.1-SNAPSHOT/WEB-INF/classes:target/rest-api-0.0.1-SNAPSHOT/WEB-INF/lib/*:/home/superman/Skrivbord/höst2023/jRAPL-master/src/java/target/jRAPL-1.0.jar" com.demo.optimizeapp
```
To run Java agent:
```
sudo java -javaagent:/home/superman/Skrivbord/joularjx-develop/install/joularjx-2.8.1.jar -cp "/home/superman/Skrivbord/RESTful-API/target/classes" com.demo.app

```


## Code
The following shows my benchmark method designs. I have added more line of code in my project.
```
@Benchmark
public void addProduct(){
  SyncEnergyMonitor m = new SyncEnergyMonitor();
  m.activate();
  EnergyStats before = m.getSample();
  doWork(); // the code you want to benchmark
  EnergyStats after = m.getSample();
  EnergyDiff diff = EnergyDiff.between(before, after);
  m.deactivate();
}
