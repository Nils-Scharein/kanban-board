package dev.nils.backend.entity

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
    title: String = "",
    rank: String = "",
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var title: String = title

    @Column(nullable = false)
    var rank: String = rank

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    lateinit var board: BoardEntity

    @OneToMany(mappedBy = "column", cascade = [CascadeType.ALL], orphanRemoval = true)
    var cards: MutableList<CardEntity> = mutableListOf()
}
