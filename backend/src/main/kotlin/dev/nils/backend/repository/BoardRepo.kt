package dev.nils.backend.repository

import dev.nils.backend.entity.BoardEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepo : JpaRepository<BoardEntity, Long>
