# Sample App for Getting IT Tickets for A Heat Map.
This is just the skeleton of an app to get IT tickets from a service and display
them as a geographic heat map. It includes the top-level logic for a service to
get tickets for a particular geographic region. It also includes JavaScript code
to embed in a web page for requesting tickets from the service. 

This is organized into two main directories. The `ticketHeatmapServer` directory 
contains code for a service that will serve tickets. The service is not connected
to an actual data source so it will always return the same static data. This
directory is described in greater detail below under the heading 
**ticketHeatmapServer**.

The `openapi` directory contains the openapi specification that describes the 
service. The specification is in the file `swagger.yaml`. This can be used to 
generate client code.  This directory is described in greater 
detail below under the heading **openapi**. 

## ticketHeatmapServer
The main class of the service is
`com.hcl.example.ticketHeatMap.server.Swagger2SpringBoot`. The service serves 
tickest from a static data file: `src/main/resources/testDate.json`.

There is a unit test of the service at
`src/test/java/com/hcl/example/ticketHeatMap/server/api/TicketApiControllerTest.java`.

Building the service
requires that Java 8 or higher and maven are already installed. To build the 
service, issue the commands
```
cd ticketHeatmapServer
mvn clean install
```

After the service is built, you can run it locally with the command
```
java -jar target\ticket-heatmap-server-1.0.0.jar
```

Some queries that you can used to exercise the service from a browser are
```
http://127.0.0.1:8080/v1/ticket/heatmap?regions=usa&status=any
http://127.0.0.1:8080/v1/ticket/heatmap?regions=usa&status=closed
http://127.0.0.1:8080/v1/ticket/heatmap?regions=europe&status=closed
```


The service has an endpoint that can be used to get an updated openapi
specification of the `ticket/heatmap` API. The URL for this is 
```
http://127.0.0.1:8080/v1/api-docs
```

There is also interactive documentation at
```
http://127.0.0.1:8080/v1
```

## openapi
The `openapi` directory contains an ant script named `build.xml`. Running 
this script
* Starts the service.
* Get's the service's open API spec from the service's `api-docs` endpoint.
* Stores the open API spec in a file named `swagger.yaml`.
* Generates JavaScript client code from the open API spec in a directory named
`output`.
* Shuts down the service that it started.

The `swagger.yaml` file and the `output` directory are included in the source 
code repository. Because they are generated, they would not be included in a 
resository intended for production. But since this is an example, they are 
included to make easy to see everything without having to clone the repo and 
build the service.

The ant script is easily modified to generate additional types of client code.
The code generation tool that it uses supports many options including:
* Java for Android
* Objective C
* C#
* JavaScript for node.js
* JavaScript for Angular
* JMeter
