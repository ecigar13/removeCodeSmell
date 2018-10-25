## Suggested design patterns:

 - More classes: extend to get toys, movie, book, cd, dvd. Use inheritance. (possibly factory pattern to generate them)
 - Strategy: each item calculates its own price, so strategy comes inside each object instance.
	- Renamed Rental to Transaction.
	- Create inferface strategy -> create concerete classes Rent, Buy
 - Decorator: discount comes after calculation, so it belongs to rental class.
 - Composite: maybe it has sth to do with applying mass discount or mass action on multiple orders?
	- Last one to deal with. Really easy.
