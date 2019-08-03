Description
===========

This repository hosts a project which demonstrates an error found in Mojarra implementation running in a clustered environment.

![error-screenshot](https://github.com/rvieira5/mojarra-ajax-error-clustered-environment/raw/master/error-screenshot.gif)

Requirements
============

- Docker
- Docker Compose

Instructions
============

To run the application using Tomcat, use the following command:

```bash
$ docker-compose -f docker-compose-tomcat.yml up -d --build
```

To run the application using Payara Micro, use the following command:

```bash
$ docker-compose -f docker-compose-payara-micro.yml up -d --build
```

Then, after the application finishes the startup, access the following URL:

http://localhost/mojarra-ajax-error-clustered-environment/
