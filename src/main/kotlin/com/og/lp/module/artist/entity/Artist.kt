package com.og.lp.module.artist.entity

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
class Artist(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
	@NotNull @Column(unique = true) val name: String,
	@NotNull val sort: String
)