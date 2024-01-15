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
    val p1: Pizza = ???
    // pizza Funghi family size with vegan cheese
    val p2: Pizza = ???

    println(s"Price of a pizza verdura with extra cheese is ${p1.price}")

    println(s"Price of a pizza funghi family size with vegan cheese is ${p2.price}")
    

// === ADD YOUR CODE BELOW ===




// === ADD YOUR CODE ABOVE ===
