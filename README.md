# SpringBoot microservices aggregator development layout.

Aggregate several SpringBoot projects in one, for convenient development and end to end testing.
___
The goal of this project is to facilitate developing microservices with SpringBoot.  
Each microservice is packaged as a regular war file, spring fat jar and as "-dev" jar used as dependency for aggregator project.
<p/>  
- **ServiceOne** - microservice one. It has a single endpoint, **serviceone** and it's connected to database **ServiceOne**.  
*Produces following artifacts:*  
	- *serviceone-0.0.1-SNAPSHOT.war* - single deployable war, that could be deployed on tomcat.    
	- *serviceone-0.0.1-SNAPSHOT-dev.jar* - jar used as dependency in aggregator project.   
	- *serviceone-0.0.1-SNAPSHOT-exec.jar* - spring boot fat jar.  
	- *serviceone-0.0.1-SNAPSHOT.source.jar* - source jar.  
<p/>
- **ServiceTwo** - microservice two. It has a single endpoint, **servicetwo** and it's connected to database **ServiceTwo**.
*Produces following artifacts:*  
	- *servicetwo-0.0.1-SNAPSHOT.war* - single deployable war, that could be deployed on tomcat.    
	- *servicetwo-0.0.1-SNAPSHOT-dev.jar* - jar used as dependency in aggregator project.   
	- *servicetwo-0.0.1-SNAPSHOT-exec.jar* - spring boot fat jar.  
	- *servicetwo-0.0.1-SNAPSHOT.source.jar* - source jar.  
<p/>
- **Common** - common dependencies, as logger for instance.  
*Produces following artifacts:*  
	- *common-0.0.1-SNAPSHOT.jar* - jar used as dependency in aggregator project.   
	- *common-0.0.1-SNAPSHOT.source.jar* - source jar.  
<p/>
- **Aggregator** - aggregator project which includes as dependencies to **ServiceOne** and **ServiceTwo** microservices.  
*Produces following artifacts:*  
	- *aggregator-0.0.1-SNAPSHOT.war* - spring boot fat war.     
	- *aggregator-0.0.1-SNAPSHOT.source.jar* - source jar.  
<p/>
Aggregator project has datasources for each microservice. After running it, all microservices endpoint will be exposed since it has dependency to "-dev" microservice artifacts. 

	