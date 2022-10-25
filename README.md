# Spring Applications:

This repository contains few Spring application. The prominent app is "Car lease system" that uses API gateways, Eureka server, micro services with Authentication. Find the code at: https://github.com/sanjayujjainkar/SpringBootTrainingSept/tree/master/CarLeaseSystem

## Micro-services:
1. Caradmin : This app will be mainly used by Car owner / leasing company who maintains fleet of cars. APIs to manage car record. 
2. Carbroker : This app will be used by broker to maintain and manage the customer record.
3. CarleaseRate : This is to calcuate t/e lease rate based on the cost of car and usage parameters.

## Component link:
 - caradmin and carbroker:  https://github.com/sanjayujjainkar/SpringBootTrainingSept/tree/master/CarLeaseSystem

 - car lease rate : https://github.com/sanjayujjainkar/SpringBootTrainingSept/tree/master/CarLeaseRate

 - API Gateway : https://github.com/sanjayujjainkar/SpringBootTrainingSept/tree/master/Gateway-Service

 - Eureka Server : https://github.com/sanjayujjainkar/SpringBootTrainingSept/tree/master/eServer
 
 - All the code is consolidated to https://github.com/sanjayujjainkar/SpringBootTrainingSept/tree/master/CarLeaseSystem 


### Caradmin exposes following REST APIs:
> - /admin/getCars : GET - Fetch list of cars
> - /admin/addCar : POST - Add a car
> - /admin/updateCar/{id} : PUT - Update the car
> - /admin/delete/{id} : Delete - Delete the car 
> - swagger documentation : http://localhost:7081/swagger-ui.html

### Carbroker exposes following REST APIs:
> - /broker/getCustomers : GET - Fetch list of Customers
> - /broker/addCustomer : POST - Add a Customer
> - /broker/updateCustomer/{id} : PUT - Update the Customer
> - /broker/deleteCustomer/{id} : Delete - Delete the Customer
> - swagger documentation : http://localhost:7082/swagger-ui.html

### CarleaseRate: 
> - /broker/leaserate
> - Swagger documentation : http://localhost:7083/swagger-ui.html

### System architecture:
![image](https://user-images.githubusercontent.com/16114372/193628501-c3eefb25-6e28-4f0e-819d-5a1565b42cf2.png)

### Description:
Eureka server is listening on standard port: 8761. 
gateway-service:8085, caradmin-service:7081, carbroker-service:7082 and leaserate-service are the main services in this app. 
MySQL is used to store the car and customer information.

### Operating instruction:
Launch MySQL on PORT:3306
Open postman and access the following major APIs. Refer Swagger documenation for all APIs
 - caradmin service : http://localhost:8085/admin/getCars.
 - For broker service : http://localhost:8085/broker/getCustomers
 - Lease rate : http://localhost:8085/broker/leaserate

### In memory authentication
> Users for caradmin:
>> - admin123/password
>> - user123/password

> Users for carbroker:
>> - admin123/password
>> - user123/password

### Futher enhancement / fixes:
>> JWT configuration on Eureka server.


