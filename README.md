# Sample App for Aetting IT Tickets for A Heat Map.
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
service. The specification is in the file `swagger.yaml`. The service was 
originally generated from `swagger.yaml`.  This directory is described in greater 
detail below under the heading **openapi**. 

## ticketHeatmapServer
The service was originally generated from the `swagger.yaml` in the `openapi`
directory. 


## openapi
