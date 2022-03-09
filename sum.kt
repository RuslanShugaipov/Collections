// Return all products the given customer has ordered
fun Customer.getOrderedProducts(): List<Product> =
    orders.flatMap { it.products }
// Return the sum of prices for all the products ordered by a given customer
fun moneySpentBy(customer: Customer): Double =
        customer.getOrderedProducts().sumOf { it.price }
