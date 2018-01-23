# spring-cloud-cli

**Spring Boot Cloud CLI 1.3.2** in **Groovy 2.4.12**.

## How Do I Install This?

**Spring Boot Cloud CLI 1.3.2** requires **Spring Boot CLI 1.5.2+**. The newest Spring Boot CLI can be manually installed here:

http://repo.spring.io/release/org/springframework/boot/spring-boot-cli/

I'll be using 1.5.7: 

http://repo.spring.io/release/org/springframework/boot/spring-boot-cli/1.5.7.RELEASE/spring-boot-cli-1.5.7.RELEASE-bin.zip

A simple bash script has been included with installation steps and some of the common commands for Ubuntu 14.04.

## What's Here?

Example configuration .yml files along with **Groovy 2.4.1.2** scripts for deploying simple, boilerplate, or otherwise common cloud-based services.

Clarification - I use Git on many machines and across many VM's. All accounts are just me (on different machines). 

## How Do I Use This?

In '/groovy' you'll find custom Groovy scripts that can be run using:

```bash
    spring run eureka.groovy
```
```bash
    spring run restapi.groovy
```

Running multiple configured Spring Cloud services is demonstrated in '/custom'.

Configuring core services is made possible through .yml files in '/yml' - see the supplied bash scripts for a list of commands!

**Spring Boot Cloud CLI** uses **Spring Boot Cloud Launcher** under the hood. That means that most of the commonly supported properties are available as configuration settings.

"Spring Cloud Launcher uses normal Spring Boot configuration mechanisms. The config name is cloud, so configuration can go in cloud.yml or cloud.properties."

See: https://github.com/spring-cloud/spring-cloud-cli/tree/master/spring-cloud-launcher

And: https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html

But most of all: http://cloud.spring.io/spring-cloud-static/spring-cloud-config/1.3.3.RELEASE/single/spring-cloud-config.html#_environment_repository

To use Maven, Git, or SVN resources use:

```
    spring.profiles.active= # Comma-separated list (or list if using YAML) of active profiles.
```

All Spring Cloud-specific configuration uses:

```
    spring.cloud ...
```

## Spring Cloud Configuration Security Prepping

There are some things that have to be done to get Spring Cloud Config Servers to accept *symmetric* and *asymmetric* encryption.

Both **Spring Boot Cloud CLI** as well as **Spring Cloud Config Server** use *org.springframework.security.crypto.encrypt.* to handle encrypt and decrypt commands.

As such, both require the JCE Unlimited Strength Extension available here:

http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html

# References, Resources, and Shoutouts

Inspiration and educational information obtained from the following resources:

## Spring Cloud CLI

http://cloud.spring.io/spring-cloud-static/spring-cloud-cli/1.3.2.RELEASE/

https://spring.io/blog/2016/11/02/introducing-the-spring-cloud-cli-launcher

https://cloud.spring.io/spring-cloud-cli/

## Encrypt / Decrypt 

http://www.baeldung.com/spring-cloud-configuration

http://cloud.spring.io/spring-cloud-config/single/spring-cloud-config.html#_key_management

http://cloud.spring.io/spring-cloud-static/spring-cloud-cli/1.3.2.RELEASE/#_encryption_and_decryption

https://blog.novatec-gmbh.de/encrypted-properties-spring/

https://github.com/spring-cloud/spring-cloud-cli/issues/6

## Install

https://howtoprogram.xyz/2016/08/28/install-spring-boot-command-line-interface-on-linux/

# Gotcha's

To install on Windows: just use the Command Prompt and not Cygwin.

You may run into major unsolved problems doing that.

You must install the JCE Unlimited Strength Library to use the encrypt and decrypt commands:

http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html

# Licensing and Versioning

This is MIT Licensed. My policy is that no repo is ready for consumption until there's at least one star and a tag. This is just a cluster of unpolished examples used to independently develop a solution for an article through Baeldung (a GREAT Java and Java Spring resource). The actual submitted code is available in the https://github.com/eugenp/tutorials repo where you can see all of my official commits. This repo will be taken down shortly. Thanks!

