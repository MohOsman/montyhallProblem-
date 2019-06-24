# Monty Hall Problem Simulation 

## Problem description 
Assume that you are attending a TV show where you can win money by picking the right box. The
game show host shows you three boxes explaining that the money is in one of the boxes. He
asks you to pick one of them without opening it. After you have picked one of the boxes he opens
one of the other two boxes which is empty. Now he turns to you and asks, do you want to change
your mind, picking the remaining box?



#### Simulation  of Game
This is a Spring Boot application with a REST Interface. To start the simulation of the game:

* Run the application using the local development environment  for example Intellij or eclipse .
* When the application is up and running start your API tool for example Postman and provide the URL below.  

* **URL**

  <http://localhost:8080/api/v1/simulation/start/{programIterations}>

* **Method:**
  
  <_The request type_>

  `GET` 
  
*  **URL Params**

   gameIterations=[Integer]
   
 
**When the request is sent the simulation will start and when it is over 
a JSON body of each game played and overall information will be returned as a response.**
