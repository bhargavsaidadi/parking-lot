

### Problem Statement
We own a parking lot that can hold up to ‘n’ cars at any given point in time. Each slot is given a number starting at one increasing with increasing distance from the entry point in steps of one. We want to create an automated ticketing system that allows our customers to use our parking lot without human intervention.
When a car enters the parking lot, we want to have a ticket issued to the driver. The ticket issuing process includes:- 
1.	We are taking note of the number written on the vehicle registration plate and the age of the driver of the car.
2.	And we are allocating an available parking slot to the car before actually handing over a ticket to the driver (we assume that our customers are kind enough to always park in the slots allocated to them).
The customer should be allocated a parking slot that is nearest to the entry. At the exit, the customer returns the ticket, marking the slot they were using as being available.
Due to government regulation, the system should provide us with the ability to find out:-
●	Vehicle Registration numbers for all cars which are parked by the driver of a certain age,
●	Slot number in which a car with a given vehicle registration plate is parked. 
●	Slot numbers of all slots where cars of drivers of a particular age are parked.
We interact with the system via a file-based input system, i.e. it should accept a filename as an input. The file referenced by filename will contain a set of commands separated by a newline, we need to execute the commands in order and produce output.

### Project Requirements

* JDK 1.8
* Maven

### Runing the project

The file will be running by the file based input

git clone "https://github.com/bhargavsaidadi/parking-lot.git" 

---> after cloning the project make sure run the below command on the the terminal.

to run the project on terminal: java -jar <parkinglot.jar file path> <input.txt file path>

you can find the parkinlot.jar in the out\artifacts\parking_lot_jar\parkinglot.jar <-------------*** copy the full path and  do same for the file_input.txt

eg: C:\activity\latest\squadstackassignment>java -jar C:\activity\latest\squadstackassignment\out\artifacts\parking_lot_jar\parkinglot.jar C:\activity\latest\squadstackassignment\file_input.txt



### Output

>Created a parking lot with 6 slots
>Car with vehicle registration number "KA-01-HH-1234" has been parked at slot number 1


>Car with vehicle registration number "PB-01-HH-1234" has been parked at slot number 2


>1, 2


>Car with vehicle registration number "PB-01-TG-2341" has been parked at slot number 3


>2


>Slot number 2 is vacated.vehicle with registration number "PB-01-HH-1234" left the space, the driver of the car was of age 21


>Car with vehicle registration number "HR-29-TG-3098" has been parked at slot number 2


>null




### Further Enhancements:

We can add the different modes according to our requirement so with the commands and services
