package com.og.lp.module.statistics.entity


import org.hibernate.annotations.CreationTimestamp
import java.time.Instant
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotNull


@Entity
class CollectionValue(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,
	@NotNull val minimum: String,
	@NotNull val median: String,
	@NotNull val maximum: String,
	@CreationTimestamp val created: Instant
)