package dev.nils.backend.entity

import dev.nils.backend.dto.response.CardDTO
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import kotlin.time.Clock
import kotlin.time.Instant

@Entity
class CardEntity(
    title: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null

    @Column(name = "title", nullable = false)
    var title: String = title

    @Column(name = "description")
    var description: String? = null

    @Column(name = "createdAt", nullable = false)
    val createdAt: Instant = Clock.System.now()

    @Column(name = "completedAt", nullable = true)
    var completedAt: Instant? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "column_id", nullable = false)
    lateinit var column: ColumnEntity

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "assignee_id")
    var assignee: UserEntity? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    var priority: Priority = Priority.MEDIUM

    fun toCardDTO(): CardDTO = CardDTO(this.id!!, this.title)
}
