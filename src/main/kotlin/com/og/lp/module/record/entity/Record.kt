package com.og.lp.module.record.entity

import com.og.lp.module.artist.entity.Artist
import com.og.lp.module.label.entity.Label
import org.hibernate.annotations.CreationTimestamp
import java.time.Instant
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
class Record(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
	@NotNull val title: String,
	@NotNull @ManyToOne val artist: Artist,
	val releaseYear: Long?,
	val catalogNumber: String?,
	@NotNull @OneToOne val format: Format,
	val variant: String?,
	val comment: String?,
	val coverFront: String?,
	val coverBack: String?,
	val discogsId: String?,
	@NotNull val sort: String,
	val owned: Boolean = true,
	@ManyToOne val label: Label,
	@CreationTimestamp val created: Instant
) {

}