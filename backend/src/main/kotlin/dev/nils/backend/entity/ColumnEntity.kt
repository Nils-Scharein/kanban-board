package dev.nils.backend.entity

import dev.nils.backend.dto.response.ColumnDTO
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "board_column")
open class ColumnEntity(
    title: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var title: String = title

    @Column(nullable = false)
    var rank: String = ""

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    lateinit var board: BoardEntity

    @OneToMany(mappedBy = "column", cascade = [CascadeType.ALL], orphanRemoval = true)
    var cards: MutableList<CardEntity> = mutableListOf()

    fun addCard(card: CardEntity) {
        this.cards.add(card)
        card.column = this
    }

    fun removeCard(card: CardEntity) {
        this.cards.remove(card)
    }

    fun toColumnDTO() : ColumnDTO {
        return ColumnDTO(
            id = this.id!!,
            title = this.title,
            rank = this.rank,
            cards = this.cards.map { it.toCardDTO() }
        )
    }
}
