# Spring Boot Getting Started Guide

![Build Status](https://github.com/mihkels/spring-boot-getting-started/actions/workflows/gradle.yml/badge.svg)

Here are my personal notes about how-to set up local Spring Boot web
app with Astro frontend.

Learning Objectives
-------------------

1. Setup Spring Boot project in IntellijIDE
2. Building a project with Gradle 
3. Use Jetty Embedded app server instead of Tomcat
4. Set up GitHub Actions for CI 
5. Deploy to DigitalOcean App platform 
6. Build Docker images of native frontend and backend 

Requirements
------------

Configuration and tools I used to develop the demo application

* macOS 15
* Java GraalVM 21 to build native image
* Deno 2 to for frontend development 
* Homebrew package manager to install `mise`
* `mise` as my development package manager
* Gradle 8.10.2
* Intellij 2024.2 
* Docker 

## Build the project

Before installing the project, make sure you have installed the following tools:

```bash
brew install mise 
# The version of GraalVM can be different but it should be 21 or higher 
mise install java@oracle-graalvm-21.0.2 
mise install deno@latest

# make sure the version mentioned above are activated
mise use java@oracle-graalvm-21.0.2
mise use deno@latest
```

Now clone the project:

``` bash
git clone https://github.com/mihkels/spring-boot-getting-started.git \ 
cd spring-boot-getting-started
```

Now build the project:

```bash
./gradlew build && cd static && deno install 
```

Notes on Intellij IDEA and Spring Boot
--------------------------------------

When running Spring Boot application main class inside Intellij and using JRebel You may
notice that changes to class files are not loaded correctly even when You have correctly
setup JRebel.

In this case the root cause may be that Intellij does not automatically make/rebuild the
project after saving. To fix this issue You can press __Shift+Shift__ (that's double Shift) and
type __make project__

Setting up Travis CI for Java and JavaScript
--------------------------------------------

Because Travis only supports only one language per git repository then only solution is but JavaScript build and testing tasks under ```script:``` section in ```.travis.yml``` file. 

Main notes from build file:
* We need install ```bower``` and ```grunt``` before we run build
* Travis CI by default will run ```gradle assemble``` and ```gradle check``` so do need specify it
* To test JavaScript build we specify task under ```script``` section

``` yml
language: java

before_install:
  - npm install grunt-cli -g
  - npm install bower -g

jdk:
  - oraclejdk7

script:
  - cd static && npm install && grunt -verbose && cd ..
```

