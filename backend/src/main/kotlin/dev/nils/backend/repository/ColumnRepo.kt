package dev.nils.backend.repository

import dev.nils.backend.entity.ColumnEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ColumnRepo : JpaRepository<ColumnEntity, Long>
