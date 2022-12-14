// Find the most expensive product among all the delivered products
// ordered by the customer. Use `Order.isDelivered` flag.
fun findMostExpensiveProductBy(customer: Customer): Product? = customer.orders.filter(Order::isDelivered).flatMap(Order::products).maxByOrNull(Product::price)

// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int = customers.flatMap(Customer::orders).flatMap(Order::products).count{it == product}

fun Customer.getOrderedProducts(): List<Product> =
        orders.flatMap { it.products }
