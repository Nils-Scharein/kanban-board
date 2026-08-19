package dev.nils.backend.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.OrderBy
import jakarta.persistence.Table

@Table(name = "board")
@Entity
open class BoardEntity(
    name: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    var id: Long? = null

    @Column(name = "name", nullable = false)
    var name: String = name

    @Column(name = "columns", nullable = false)
    @OneToMany(mappedBy = "board", cascade = [CascadeType.ALL], orphanRemoval = true)
    @OrderBy("rank")
    var columns: MutableList<ColumnEntity> = mutableListOf()
}
