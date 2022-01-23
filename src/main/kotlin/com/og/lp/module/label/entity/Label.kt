package com.og.lp.module.label.entity


import javax.persistence.*
import javax.validation.constraints.NotNull


@Entity
class Label(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
	@NotNull @Column(unique = true) val name: String,
	@NotNull val sort: String
)