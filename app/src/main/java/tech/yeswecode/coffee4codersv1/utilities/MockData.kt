package tech.yeswecode.coffee4codersv1.utilities

import tech.yeswecode.coffee4codersv1.models.Product

class MockData {
    companion object {
        fun listOfProducts(): List<Product> {
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

        fun listOfCities(): List<String> {
            return listOf(
                "Ciudad de México, México",
                "La Habana, Cuba",
                "Cancún, México",
                "Medellín, Colombia",
                "Buenos Aires, Argentina",
                "Sao Paulo, Brasil",
                "Lima, Perú",
                "Montevideo, Uruguay",
                "Ciudad de Panamá, Panamá"
            )
        }
    }
}