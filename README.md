
## New Classes
All items now implement ItemInterface. This allows me to apply discount decorator to items. 
Movies, Books, Music and Toys have their own abstract class from ItemInterface. This reduce duplicate code in each child class.

## Strategy
Rent and Buy strategies are in "strategy" package. They change the way the price of each item is calculated.

## Decorator
The ItemDiscountDecorator class applies discount to individual items of ItemInterface. This affects the price calculation of each item.
The OrderDiscountDecorator class applies discount to the entire order after calculating. This takes effect in price calculation of the order.

## Composite
The OrderComposite class can hold multiple orders as leaves. When it prints as XML, this class will return an XML string of all orders inside and individual total.

