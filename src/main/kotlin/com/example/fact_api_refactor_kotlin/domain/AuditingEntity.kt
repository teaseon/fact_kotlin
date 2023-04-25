package com.example.fact_api_refactor_kotlin.domain

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.time.LocalDateTime

@EntityListeners(value = [AuditingEntityListener::class])
@MappedSuperclass
abstract class AuditingEntity(): AuditingEntityId() {
    @CreatedDate
    @Column(name = "create_dt", nullable = false, updatable = false)
    lateinit var createDT : LocalDateTime
        protected set

    @LastModifiedDate
    @Column(name = "update_dt")
    lateinit var updateDT : LocalDateTime
        protected set
}

@EntityListeners(value = [AuditingEntityListener::class])
@MappedSuperclass
abstract class AuditingEntityId : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long? = null
        protected set
}