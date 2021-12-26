package com.og.lp.module.record.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotNull

@Entity
class Format(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
	@NotNull val format: String
)