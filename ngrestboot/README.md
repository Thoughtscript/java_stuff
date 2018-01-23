# ngrestboot

[![Build Status](https://travis-ci.org/Thoughtscript/ngrestboot.svg?branch=master)](https://travis-ci.org/Thoughtscript/ngrestboot)

Java Spring RESTful Boot with Angular showcasing the @RequestBody and @ResponseBody annotations.

To simple Angular 1 controllers POST to the Java Spring MVC API backend and demonstrate how those annotations work!

# How To Use

```
(1) You need Java 8 JDK or just the JRE: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
(2) Download Apache Tomcat 8.5: https://tomcat.apache.org/download-80.cgi
(3) Drop the .war into apache-tomcat-8.5.12\webapps
(4) Navigate to apache-tomcat-8.5.12\bin to start Tomcat
```

# Gotcha's

Usually it's customary to specify 'java' in classpath:'test/java' as your test folder (in IntelliJ).

A void return Spring controller will return a 404 by default even if it's OK. You don't need to annotate with @ResponseBody (you can) since you can override the default status code with the actual appropriate result.

# Shout Out's

https://objectpartners.com/2016/07/26/junit-5-with-spring-boot-plus-kotlin/

http://mvpjava.com/spring-boot-junit5/

https://springframework.guru/unit-testing-spring-mvc-spring-boot-1-4-part-1/

# Licensing

This is MIT licensed - feel free to use!

# Status

If there's not a release/tag and a star it's not ready to be consumed! 