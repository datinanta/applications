# Datinanta-Sciola

This project is composed of two components:

* A backend build with Spring Boot that talks to a MongoDB store.
* A frontend build with Angular 2.

The two componends are exposed through an Nginx server.
The system runs on Docker containers.

## Build backend
This project uses Maven, so you can just run `mvn package`.

## Build frontend
You can simply use the command `ng build --prod`

## Deploy
The guide assumes you have: 

* Docker and Docker Compose installed in your system.
* the folder `/opt/server/apps/` in your server 

Steps to run the system:

1. copy the *jar* of the backned project into `/opt/server/apps/backend`
2. copy the `nginx` folder to `/opt/server/apps/`
3. copy what the folder `frontend/dist` inside `/opt/server/apps/nginx/www`
4. copy the certificates required for HTTPS into `/opt/server/apps/nginx/certs` (cert.pem and key.pem)
5. run `cd /opt/server/apps/backend`
6. run `docker-compose up`