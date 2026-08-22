package dev.nils.backend.controller

import dev.nils.backend.dto.request.CreateBoardRequest
import dev.nils.backend.dto.response.BoardDTO
import dev.nils.backend.service.BoardService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "Boards", description = "Manage Boards")
@RestController
@RequestMapping("/boards")
class BoardController (
        val boardService: BoardService
) {

    @GetMapping()
    fun getBoards(
    ): List<BoardDTO> = boardService.getBoards()

    @GetMapping("/{id}")
    fun getBoardById(@PathVariable id: Long): BoardDTO {
        return boardService.getBoardById(id)
    }

    @PostMapping()
    fun createBoard(@RequestBody createBoardRequest: CreateBoardRequest): BoardDTO {
        return boardService.createBoard(createBoardRequest)
    }

    @DeleteMapping("/{id}")
    fun deleteBoard(@PathVariable id: Long) : ResponseEntity<Void> {
        boardService.deleteBoard(id)
        return ResponseEntity.noContent().build()
    }

}
