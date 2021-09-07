package tech.yeswecode.coffee4codersv1.models

class Purchase(product: Product, name: String, email: String, phone: String, address: String, city: String) {
    val product = product
    val name = name
    val email = email
    val phone = phone
    val address = address
    val city = city

    companion object {
        fun cities(): List<String> {
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