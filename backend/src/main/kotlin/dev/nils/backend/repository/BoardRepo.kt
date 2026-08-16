package dev.nils.backend.repository

import dev.nils.backend.entity.Board
import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepo : JpaRepository<Board, Long>  {
}
