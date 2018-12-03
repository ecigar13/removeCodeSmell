
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

## Frequen renter point strategy

Double regular point to any customer renting more than 2 types of category.
Double regular point to customer 18-22 renting new release movies. 

If a customer has more than 10 frequent renter points, give them a free movie rental of any type.
