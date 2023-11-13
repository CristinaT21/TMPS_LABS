# Topic: *Behavioural Design Patterns*

Author: *Țărnă Cristina*
------
## Theoretical background:
&ensp; &ensp; Behavioral design patterns are a category of design patterns that focus on the interaction and communication between objects and classes. They provide a way to organize the behavior of objects in a way that is both flexible and reusable, while separating the responsibilities of objects from the specific implementation details. Behavioral design patterns address common problems encountered in object behavior, such as how to define interactions between objects, how to control the flow of messages between objects, or how to define algorithms and policies that can be reused across different objects and classes.
## Objectives:
&ensp; &ensp; __1. Study and understand the Behavioural Design Patterns.__

&ensp; &ensp; __2. As a continuation of the previous laboratory work, think about the functionalities that your system will need to provide to the user.__

&ensp; &ensp; __3. Implement 3 behavioural design patterns.__


&ensp; &ensp; Some examples of from this category of design patterns are:

* Chain of Responsibility
* Iterator
* Strategy


## Chain of Responsibility
I created a class CreditCardHandler and PayPalHandler that implement the IPaymentHandler interface.
[CreditCardHandler.kt](https://github.com/CristinaT21/TMPS_LABS/blob/314bb5accfa2d3c139181969db81a02b497d33e0/src/main/kotlin/chainOfResponsibility/CreditCardHandler.kt)
```python
 class CreditCardHandler: IPaymentHandler() {
    override fun handleRequest(amount: Double): Boolean {
        if (amount <= 20) {
            println("Credit Card processed the payment.")
            return true
        }
        return false
    }
}
```
[PayPalHandler.kt](src/main/kotlin/chainOfResponsibility/PayPalHandler.kt) is similar to the CreditCardHandler class.

[HandlerChain.kt](src/main/kotlin/chainOfResponsibility/HandlerChain.kt) is the class that creates the chain of handlers and calls the handleRequest method.

Code snippet from the HandlerChain.kt class:
```python
for (handler in paymentHandlers){
    if (handler.handleRequest(amount)){
        return true
    }
```



## Iterator
I created a class [CollectionIterator](src/main/kotlin/iterator/CollectionIterator.kt) that implements the ProductIterator interface.
It has the following methods:
- hasNext() - returns true if the collection has more elements
- next() - returns the next element in the collection

I created a new method in the [Collection](src/main/kotlin/composite/Collection.kt) class that returns a CollectionIterator object.
```python3
// Create an iterator for the collection
fun createIterator(): ProductIterator {
    return CollectionIterator(products)
}
```

## Strategy
I created an interface [DiscountStrategy](src/main/kotlin/interfaces/DiscountStrategy.kt) that has a method that returns the price for a product.
Two concrete classes implement this interface: [NoDiscountStrategy](src/main/kotlin/strategy/NoDiscountStrategy.kt) and [PercentageDiscountStrategy](src/main/kotlin/strategy/PercentageDiscountStrategy.kt).

```python
class NoDiscountStrategy: DiscountStrategy {
    override fun applyDiscount(price: Double): Double {
        return price
    }
}
```
## Conclusions:
In this laboratory work I studied and implemented 3 behavioural design patterns. I learned how to use them and when to use them. I also learned how to create a chain of handlers, how to create an iterator and how to use the strategy pattern. 