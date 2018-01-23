# SpringDispatcher

[![Build Status](https://travis-ci.org/Thoughtscript/SpringDispatcher.svg?branch=master)](https://travis-ci.org/Thoughtscript/SpringDispatcher)

Spring 4.3.7 DispatcherServlet example featuring:

```
(1) 100% programmatic configuration  
(2) Example view controller  
(3) Conventional placement of static assets and resources  
(4) Two controllers with four endpoints - 2 REST / 2 Controller
(5) (Multipart) File uploade controller
(6) Spring theme resolver
```

# How To Use

```
(1) You need Java 8 JDK or just the JRE: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
(2) Download Apache Tomcat 8.5: https://tomcat.apache.org/download-80.cgi
(3) Drop the .war into apache-tomcat-8.5.12\webapps
(4) Navigate to apache-tomcat-8.5.12\bin to start Tomcat
```

# Endpoints

Two example endpoints:
```
http://localhost:8080/springdispatcherservlet/rest/user/example

{"id":1,"firstName":"Example","lastName":"Everyperson"}
```

```
http://localhost:8080/springdispatcherservlet/user/example

{"id":1,"firstName":"Example","lastName":"Everyperson"}
```

Also hit:
```
/?theme=example
```
or:
```
/?theme=default
```
to switch themes.

# Uploads

Uploaded files can be found in 'CATALINA_HOME/bin/uploads' 

Remember to create the 'uploads' directory otherwise it will be in '/bin'

# Licensing

This is MIT licensed - feel free to use!

A related article over at Baeldung: http://www.baeldung.com/spring-dispatcherservlet (forthcoming)
