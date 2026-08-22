package dev.nils.backend.dto.response

data class ColumnDTO(
    val id: Long,
    val title: String,
    val rank: String,
    val cards: List<CardDTO>
)
