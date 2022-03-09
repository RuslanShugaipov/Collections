// Return the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> {
    val products = customers.fold(setOf<Product>()){sum, i -> sum.plus(i.getOrderedProducts())}
    return customers.fold(products) { result, customer ->
        result.intersect(customer.getOrderedProducts())
    }
}

fun Customer.getOrderedProducts(): List<Product> =
         orders.flatMap { it.products }
