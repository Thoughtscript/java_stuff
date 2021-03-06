# Spring-Secured-WS

[![Build Status](https://travis-ci.org/Thoughtscript/Spring-Secured-WS.svg?branch=master)](https://travis-ci.org/Thoughtscript/Spring-Secured-WS)

Java Spring Websockets with Spring Security Coverage (No Oauth2)

Java Spring MVC 4.3.8, 4.2.3 Security, 1.13.3 Data, Hibernate 5.2.10, 1.11.3 Data-JPA, H2, REST, and Angular!

```
(1) 100% programmatic configuration  
(2) Example view controller  
(3) Conventional placement of static assets and resources  
(4) REST Controller
(5) Security configuration
(6) Embedded SQL
(7) Custom User Details and Form Login Authentication
(8) Websocket Chat through STOMP and SockJS  
```

# How To Use
```
(1) You need Java 8 JDK or just the JRE: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
(2) Download Apache Tomcat 8.5: https://tomcat.apache.org/download-80.cgi
(3) Drop the .war into apache-tomcat-8.5.12\webapps
(4) Navigate to apache-tomcat-8.5.12\bin to start Tomcat
```

# Gotcha's

If you're using Spring MVC, this must be added to your Spring Security configuration to enable H2 console viewing:
```
    http.headers().frameOptions().disable();
```

Adding security to the 'spring-websocket' library WITHOUT using the 'spring-security-messaging' library requires adding interceptors to socket handlers. Otherwise, you can use the AbstractSecurityWebSocketMessageBrokerConfigurer class to configure security and message brokers simultaneously.

To get Spring Security up and running make sure that the you extend AbstractSecurityWebApplicationInitializer.

Spring STOMP websocket chat support requires either @SendTo or the use of SimpMessagingTemplate.

Two login forms are provided: (1) A default JSP form and (2) an Angular form. Both work, but (2) will not automatically redirect per the custom access denied, login, and logout handlers.

# View Flow
```
    index.jsp -> login.jsp -> success.jsp -> socket.jsp -> index.jsp
```
Unauthenticated access attempts will perform the default Spring Security behavior: redirect to the '/login' view.

Unauthorized access attempts (an authenticated user attempting to access an endpoint beyond the granted authority of their role) will result in redirect to '/denied'.

The H2 console view is enabled and viewable at :8082 - it is not secured as it exists merely for developing and testing. The database used by the application is at: 'jdbc:h2:mem:socketDB'.

# Angular

The Angular client app is built to the desired modular, pre-component, factory-design 1.5.x spec. Normally, the different controllers would be placed in a single file for production (using webpack or some other build tool). For readability they've been separated.

# Authentication

Credentials can be viewed in the H2 or via the SQL scripts that will auto-inject data into your embedded database.

Endpoints requiring no authentication:
```
"/", "/index", "/denied", "/authenticate", "/login"
```

Endpoints requiring authentication:
```
"/secured/pet", "/secured/success", "/secured/socket", "/secured/success"
```

Authentication flow by view:
```
/ -> /login -> /authenticate -> /secured/success -> /secured/**
```

# Endpoints

### REST API Endpoints

-------------------------------------------------------------------------------------------------------------------------------------
/secured/pet/all
```
GET
```
```
0
name	"Ferdinand"
type	"BULL"
description	"PEACEFUL"

1	
name	"Jerry"
type	"JARBUL"
description	"SPACE OUTLAW"

2	
name	"Puff"
type	"DRAGON"
description	"HIGH AS A KITE"
```

-------------------------------------------------------------------------------------------------------------------------------------
/secured/pet/one

* Special note: this endpoint has been left as GET so that the normal authentication flow used above will allow to access the data.
However, in doing so, the endpoint has unconventionally been left as GET rather than some of POST or PUT or PATCH.
```
GET
?id=2
```
```
0	
name	"Jerry"
type	"JARBUL"
description	"SPACE OUTLAW"
```

-------------------------------------------------------------------------------------------------------------------------------------
/secured/pet/dragon

* Special note: this endpoint has been left as GET so that the normal authentication flow used above will allow to access the data.
However, in doing so, the endpoint has unconventionally been left as GET rather than some of POST or PUT or PATCH.
```
GET
?id=1
```
```
0	
name	"Ferdinand"
type	"DRAGON"
description	"PEACEFUL"
```

### Socket Endpoints

```
SEND
/secured/chat
```

```
SUBSCRIBE
/secured/history
```

# Shout Outs!

Stomp Socket and Subscription Servers-side walkthrough:
```
    https://github.com/bijukunjummen/spring-websocket-chat-sample
    https://www.sitepoint.com/implementing-spring-websocket-server-and-client/
    https://stackoverflow.com/questions/28250719/how-to-send-message-to-client-through-websocket-using-spring
    https://gist.github.com/theotherian/9906304
```

H2 Console:
```
    http://javasampleapproach.com/spring-framework/spring-security/configure-spring-security-access-h2-database-console-spring-boot-project
```

This was great for basic authentication:
```
    http://www.baeldung.com/spring-security-basic-authentication
```

This article was particularly helpful in clarifying a better way to implement the userDetailsService approach:
```
    http://www.ekiras.com/2016/04/authenticate-user-with-custom-user-details-service-in-spring-security.html?m=1
```

Great resource for how to combine H2 embedded database with Hibernate and JPARepositories:
```
    https://github.com/pfac/demo-spring-data-jpa-hibernate-h2
    http://blog.netgloo.com/2014/10/06/spring-boot-data-access-with-jpa-hibernate-and-mysql/
    http://docs.spring.io/spring-data/jpa/docs/1.4.2.RELEASE/reference/html/jpa.repositories.html
```

Fantastic walk-through to add websockets into your app:
```
    https://spring.io/guides/gs/messaging-stomp-websocket/
    http://www.baeldung.com/websockets-spring
```

Programmatic datasource configuration:
```
    http://www.programcreek.com/java-api-examples/index.php?api=org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
```

# Licensing

This is MIT licensed - feel free to use! This is part of a forthcoming article on Baeldung.

# Versioning

If it doesn't have a start and a tag (release) it's not ready to be consumed!