package dev.nils.backend.repository

import dev.nils.backend.entity.CardEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CardRepo : JpaRepository<CardEntity, Long>
