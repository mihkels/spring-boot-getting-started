Spring Boot Getting Started Guide
=================================

Here are my personal notes about how to develop Spring Boot web
application with Intellij IDEA + JRebel.

Learning Objectives
-------------------

* Setup Spring Boot project in IntellijIDE
* Building project with Gradle 
* Use Jetty Embedded app server instead of Tomcat
* Setup Travis CI 
* Deploy to Heroku
* Deploy to Vagrant development server

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

