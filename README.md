# Servlet base RESTful-API
## Background
Write ...
## Prerequeisites
## How to build
IntelliJ not from the Toolbox! ...
Download and install [jRAPL] (https://github.com/aservet1/jRAPL)

## Running
To run jRAPL and JMH run:
```
sudo java -cp "target/rest-api-0.0.1-SNAPSHOT/WEB-INF/classes:target/rest-api-0.0.1-SNAPSHOT/WEB-INF/lib/*:/home/superman/Skrivbord/höst2023/jRAPL-master/src/java/target/jRAPL-1.0.jar" com.demo.optimizeapp
```
To run Java agent:
```
sudo java -javaagent:/home/superman/Skrivbord/joularjx-develop/install/joularjx-2.8.1.jar -cp "/home/superman/Skrivbord/exam/RESTful-API-main/target/rest-api-0.0.1-SNAPSHOT/WEB-INF/classes" com.demo.app
```


## Code
The following shows how my benchmark method designs. I have added more line of code. More jRAPL is used
```
  @Benchmark
    public void addProduct(){
SyncEnergyMonitor m = new SyncEnergyMonitor();
m.activate();
EnergyStats before = m.getSample();
doWork();
EnergyStats after = m.getSample();
EnergyDiff diff = EnergyDiff.between(before, after);
m.deactivate();
}
