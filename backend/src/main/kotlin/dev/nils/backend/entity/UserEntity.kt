package dev.nils.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "AppUser")
class UserEntity(
    email: String,
    hashedPassword: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    val id: Long? = null

    @Column(name = "email")
    val email: String = email

    @Column(name = "hashedPassword")
    val hasedPassword: String = hashedPassword
}
