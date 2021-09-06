package tech.yeswecode.coffee4codersv1.models

class Product constructor(id: Int,
                          name: String,
                          summary: String,
                          description: String,
                          price: Double,
                          currency: String,
                          countryISO: String){
    val id: Int = id
    val name: String = name
    val summary: String = summary
    val description: String = description
    val price: Double = price
    val currency: String = currency
    val countryISO: String = countryISO

    companion object {
        fun list(): List<Product> {
            return listOf(
                Product(
                    0, "Café de Colombia",
                    "Nuestro esfuerzo y trabajo conjunto representa el sueño de amor por las montañas de nuestro país.",
                    "Nuestro esfuerzo y trabajo conjunto representa el sueño de amor por las montañas de nuestro país.",
                    35.0,
                    "USD",
                    "COL"
                ),
                Product(
                    1, "Café de Costa Rica",
                    "Nuestro esfuerzo y trabajo conjunto representa el sueño de amor por las montañas de nuestro país.",
                    "Nuestro esfuerzo y trabajo conjunto representa el sueño de amor por las montañas de nuestro país.",
                    40.0,
                    "USD",
                    "CRI"
                ),
                Product(
                    2,
                    "Café de Nicaragua",
                    "Nuestro esfuerzo y trabajo conjunto representa el sueño de amor por las montañas de nuestro país.",
                    "Nuestro esfuerzo y trabajo conjunto representa el sueño de amor por las montañas de nuestro país.",
                    30.0,
                    "USD",
                    "NIC"
                ),
                Product(
                    3,
                    "Café de Brazil",
                    "Nuestro esfuerzo y trabajo conjunto representa el sueño de amor por las montañas de nuestro país.",
                    "Nuestro esfuerzo y trabajo conjunto representa el sueño de amor por las montañas de nuestro país.",
                    45.0,
                    "USD",
                    "BRA"
                )
            )
        }
    }
}