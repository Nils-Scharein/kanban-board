package dev.nils.backend.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class CardEntity (

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    val id: Long? = null


)





