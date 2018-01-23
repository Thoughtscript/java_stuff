# SpringBootDispatcher

[![Build Status](https://travis-ci.org/Thoughtscript/SpringBootDispatcher.svg?branch=master)](https://travis-ci.org/Thoughtscript/SpringBootDispatcher)

Spring Boot 1.5.2 DispatcherServlet example: 

```
(1) 100% programmatic configuration  
(2) Example view controller  
(3) Conventional placement of static assets and resources  
(4) One controllers with four endpoints demonstrating various important concepts
```

# How To Use

```
(1) You need Java 8 JDK or just the JRE: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
(2) Download Apache Tomcat 8.5: https://tomcat.apache.org/download-80.cgi
(3) Drop the .war into apache-tomcat-8.5.12\webapps
(4) Navigate to apache-tomcat-8.5.12\bin to start Tomcat
```

# Endpoints

Four example endpoints:

(use Postman: https://www.getpostman.com/)

-------------------------------------------------------------

JSP view served via Model:

```
http://localhost:8080/springbootdispatcherservlet/controller/exampleone?text=adam


<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <h1>Example One</h1>
        <span>Your Text: adam</span>
    </body>
</html>

```
-------------------------------------------------------------

JSP view served via HTTP Servlet forwarding:

```
http://localhost:8080/springbootdispatcherservlet/controller/exampletwo?text=adam


<html>
<head>
    <title></title>
</head>
<body>
    <h1>Example Two - JSTL + RequestDispatcher</h1>
    <span>adam says, "Et tu, Brutus?"</span>
</body>
</html>

```

-------------------------------------------------------------

JSP view served via ModelMap:

```
http://localhost:8080/springbootdispatcherservlet/controller/examplethree?text=adam


<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Example Three</h1>
<span>I say: adam</span>
</body>
</html>
```

-------------------------------------------------------------

JSON response via @ResponseBody:

```
http://localhost:8080/springbootdispatcherservlet/controller/examplefour

{"name":"EXAMPLE_NAME"}
```

-------------------------------------------------------------

This is MIT licensed - feel free to use!

A related article over at Baeldung: http://www.baeldung.com/an-intro-to-the-Spring-DispatcherServlet (forthcoming)
