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
}