package dev.nils.backend.dto.response

data class BoardDTO(
    val id: Long,
    val name: String,
    val columns : List<ColumnDTO>
)
