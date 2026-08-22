package dev.nils.backend.service

import dev.nils.backend.dto.request.CreateBoardRequest
import dev.nils.backend.dto.response.BoardDTO
import dev.nils.backend.dto.response.CardDTO
import dev.nils.backend.entity.BoardEntity
import dev.nils.backend.entity.CardEntity
import dev.nils.backend.exceptions.BoardNotFoundException
import dev.nils.backend.repository.BoardRepo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class BoardService(val boardRepo: BoardRepo) {

    @Transactional(readOnly = true)
    fun getBoards() : List<BoardDTO> {
        val boards : MutableList<BoardEntity> =  boardRepo.findAll();
        return boards.map { it -> it.toBoardDTO()}
    }

    @Transactional(readOnly = true)
    fun getBoardById(id : Long) : BoardDTO {
        val board = boardRepo.findById(id).orElseThrow { BoardNotFoundException(id) }
        return board.toBoardDTO()
    }

    fun createBoard(createBoardRequest: CreateBoardRequest): BoardDTO {
        val newBoard = BoardEntity(createBoardRequest.name)
        val savedBoard = boardRepo.save(newBoard)
        return savedBoard.toBoardDTO()
    }

    fun deleteBoard(id: Long) {
        boardRepo.deleteById(id)
    }
}
