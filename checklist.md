Moved Customer, Rental, Movie to their own package. Created a package for main class.
Changed Enumeration raw type to Enumeration<Rental>
Changed Vector raw type to vector<Rental>
Removed object casting on line 34 of Customer.java.
Moved switch statement in Rental.java to calculateAmount method.
frequentRenterPoints becomes class variable in Customer
Changed string formating of totalAmount from String.valueOf to String.format.
Changed all class variable names to remove underscore. Use this.variableName format instead.


Moved calculateAmount to become a movie class method.

Top level: Created Movie interface with calculateAmount method.
First level: MovieChildren, MovieNew and MovieRegular implements Movie Interface. (Other classes can be added)

Modified Rental.java to accept Movie.java as an interface.

Removed Enumeration data type in Customer.java
Moved point calculation to Rental.java

Added toXML method in Customer and Rental