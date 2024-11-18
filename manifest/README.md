******* Complete deployment of 3 tier web application in kubernetes ********
--------------------------------------------------------
Stage 1: Creating database deployment (e.g. Mysql)

	- Create config map
	- Create secret
	- Create Persistent volume claim
	- Create deployment
	- Create database service with default type (i.e. type: ClusterIP, name: mysql-service)

Stage 2: Create backend deployment 

	- Update the backend code and change the db connection ulr with db-servie service name or ip address-
	e.g. spring.datasource.url=jdbc:mysql://mysql-service:3306/spring-db?allowPublicKeyRetrieval=true
	- Now, build backend docker image
	- Push docker image to docker repo
	- Create backend deployment and use the image create in about step
	- Create backend service.
		* in case of Docker Desktop - Service type should be LoadBalancer. So that it can be accesible using localhost from the host machine.
		
Stage 3: Create fronend application deployment

	- Build the fronend docker image
	- Push the image to docker repo
	- Create Frontend deployment using the image in above step
	- Create service for fronend deployment
		* in case of Docker Desktop - Service type should be LoadBalancer. So that it can be accesible using localhost from the host machine.
	
Stage 4: Configure ingress controller
	- Install NGINX. Reference link - https://kubernetes.github.io/ingress-nginx/deploy/#docker-desktop
	- Change the domain name into host files
	- on windows C:\Windows\System32\drivers\etc\hosts
	- on linux/mac /etc/hosts