Spring Boot Getting Started Guide
=================================

Here are my personal notes about how to develop Spring Boot web
application with Intellij IDEA + JRebel.

Learning Objectives
-------------------

1. Setup Spring Boot project in IntellijIDE
1. Building project with Gradle 
1. Use Jetty Embedded app server instead of Tomcat
1. Setup Travis CI 
1. Deploy to Heroku
1. Deploy to Vagrant development server

Requirements
------------

Configuration and tools I used to develop the demo application

* Mac OS X 10.7
* Homebrew package manager
* Java 1.7
* Grails 1.11
* Intellij 13 Ultimate
* JRebel 5.5 Personal License
* Vagrant (MySQL)

Notes on Intellij IDEA and Spring Boot
--------------------------------------

When running Spring Boot application main class inside Intellij and using JRebel You may
notice that changes to class files are not loaded correctly even when You have correctly
setup JRebel.

In this case the root cause may be that Intellij does not automatically make/rebuild the
project after saving. To fix this issue You can press __Shift+Shift__ (that's double Shift) and
type __make project__

