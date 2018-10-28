## Suggested design patterns:

 - More classes: extend to get toys, movie, book, cd, dvd. Use inheritance. (possibly factory pattern to generate them)
 - Strategy: each item calculates its own price, so strategy comes inside each object instance.
	- Renamed Rental to Transaction.
	- Create inferface strategy -> create concerete classes Rent, Buy
	- Each item has a strategy -> use setStrategy. This can be set at run time but in the current situation, I opt for setting it in Main.
 - Decorator: discount comes after calculation, so I use decorator to decorate the rentals and buy.
	- Each rental/buy has its discount. 
	- Each transaction also has its discount.
 - Composite: maybe it has sth to do with applying mass discount or mass action on multiple orders?
	- Last one to deal with. Really easy.
