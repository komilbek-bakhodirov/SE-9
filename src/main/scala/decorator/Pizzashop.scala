package decorator

trait Pizza:
    def diameter: Int
    def price: BigDecimal

class Margherita extends Pizza:
    override def diameter: Int = 28
    override def price: BigDecimal = 9

class Funghi extends Margherita:
    override def price: BigDecimal = 10

class Verdura extends Margherita:
    override def price: BigDecimal = 11.5

@main def Pizzashop(): Unit =
    // pizza Verdura with extra cheese
    val p1: Pizza = new ExtraCheeseDecorator(new Verdura)
    // pizza Funghi family size with vegan cheese
    val p2: Pizza = new FamilySizeDecorator(new VeganCheeseDecorator(new Funghi))

    println(s"Price of a pizza verdura with extra cheese is ${p1.price}")

    println(s"Price of a pizza funghi family size with vegan cheese is ${p2.price}")
    

// === ADD YOUR CODE BELOW ===

// Decorator base class
abstract class PizzaDecorator(pizza: Pizza) extends Pizza{
    override def diameter: Int = pizza.diameter

    override def price: BigDecimal = pizza.price
}

// Concrete decorators
class ExtraCheeseDecorator(pizza: Pizza) extends PizzaDecorator(pizza){
    override def price: BigDecimal = pizza.price + 2
}

class VeganCheeseDecorator(pizza: Pizza) extends PizzaDecorator(pizza){
    override def price: BigDecimal = pizza.price + 1.5
}

class ExtraOnionDecorator(pizza: Pizza) extends PizzaDecorator(pizza){
    override def price: BigDecimal = pizza.price + 1
}

class FamilySizeDecorator(pizza: Pizza) extends PizzaDecorator(pizza) {
    override def diameter: Int = 42
    override def price: BigDecimal = pizza.price * 2
}



// === ADD YOUR CODE ABOVE ===
