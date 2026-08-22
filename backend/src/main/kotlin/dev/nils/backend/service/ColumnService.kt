package dev.nils.backend.service

import dev.nils.backend.dto.request.CreateColumnRequest
import dev.nils.backend.dto.response.ColumnDTO
import dev.nils.backend.entity.ColumnEntity
import dev.nils.backend.exceptions.BoardNotFoundException
import dev.nils.backend.exceptions.ColumnNotFoundException
import dev.nils.backend.repository.BoardRepo
import dev.nils.backend.repository.ColumnRepo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ColumnService(val columnRepo: ColumnRepo, val boardRepo: BoardRepo) {

    @Transactional(readOnly = true)
    fun findAll(): List<ColumnDTO> {
        val columns = columnRepo.findAll()
        return columns.map { it.toColumnDTO() }
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): ColumnDTO {
        val column = columnRepo.findById(id).orElseThrow { ColumnNotFoundException(id) }
        return column.toColumnDTO()
    }

    fun createColumnForBoard(boardId: Long, columnCreateRequest: CreateColumnRequest): ColumnDTO {
        val board = boardRepo.findById(boardId).orElseThrow { BoardNotFoundException(boardId) }

        val newColumn = ColumnEntity(columnCreateRequest.name)
        board.addColumn(newColumn)
        columnRepo.save(newColumn)

        return newColumn.toColumnDTO()
    }

    fun deleteColumn(id: Long) {
        val column = columnRepo.findById(id).orElseThrow { ColumnNotFoundException(id) }
        columnRepo.delete(column)
    }
}
