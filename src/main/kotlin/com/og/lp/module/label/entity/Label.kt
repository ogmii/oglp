package com.og.lp.module.label.entity


import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotNull


@Entity
class Label(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
	@NotNull val name: String,
	@NotNull val sort: String
)