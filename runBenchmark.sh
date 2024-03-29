#!/bin/bash

JAVA_HOME="/home/superman/.jdks/openjdk-19.0.1"
IDEA_AGENT="/home/superman/.local/share/JetBrains/Toolbox/apps/IDEA-C/ch-0/233.11799.241/lib/idea_rt.jar=40779:/home/superman/.local/share/JetBrains/Toolbox/apps/IDEA-C/ch-0/233.11799.241/bin"

CLASSPATH="/home/superman/Skrivbord/restapi/target/classes:/home/superman/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.12.1/jackson-databind-2.12.1.jar:/home/superman/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.12.1/jackson-annotations-2.12.1.jar:/home/superman/.m2/repository/org/openjdk/jmh/jmh-core/1.21/jmh-core-1.21.jar:/home/superman/.m2/repository/net/sf/jopt-simple/jopt-simple/4.6/jopt-simple-4.6.jar:/home/superman/.m2/repository/org/apache/commons/commons-math3/3.2/commons-math3-3.2.jar:/home/superman/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.12.1/jackson-core-2.12.1.jar:/home/superman/.m2/repository/org/apache/tomcat/embed/tomcat-embed-core/9.0.68/tomcat-embed-core-9.0.68.jar:/home/superman/.m2/repository/org/apache/tomcat/tomcat-annotations-api/9.0.68/tomcat-annotations-api-9.0.68.jar:/home/superman/Skrivbord/höst2023/jRAPL-master/src/java/target/jRAPL-1.0.jar:/home/superman/.m2/repository/org/openjdk/jmh/jmh-generator-annprocess/1.21/jmh-generator-annprocess-1.21.jar:/home/superman/.m2/repository/org/springframework/spring-test/5.3.20/spring-test-5.3.20.jar:/home/superman/.m2/repository/org/springframework/spring-core/5.3.20/spring-core-5.3.20.jar:/home/superman/.m2/repository/org/springframework/spring-jcl/5.3.20/spring-jcl-5.3.20.jar"

MAIN_CLASS="org.openjdk.jmh.Main"
MAIN_ARGS="com.temp.ProductManagerBenchmark.*"

sudo ${JAVA_HOME}/bin/java \
  -javaagent:${IDEA_AGENT} \
  -Dfile.encoding=UTF-8 \
  -Dsun.stdout.encoding=UTF-8 \
  -Dsun.stderr.encoding=UTF-8 \
  -classpath ${CLASSPATH} \
  ${MAIN_CLASS} ${MAIN_ARGS}
