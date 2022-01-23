package com.og.lp.module.statistics.entity


import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotNull


@Entity
class CollectionValue(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,
	@NotNull val minimum: Double,
	@NotNull val median: Double
)