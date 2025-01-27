package com.example.kotlinbasics.model

data class RandomUserResponse(
   val results: List<RUser>,
)

data class RUser(
   val name: Name,
   val location: Location,
   val email: String,
   val picture: Picture,
)

data class Name(
   val title: String,
   val first: String,
   val last: String
)
data class Location(
   val country: String,
)

data class Picture(
   val medium: String,
)

