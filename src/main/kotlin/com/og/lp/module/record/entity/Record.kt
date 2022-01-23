package com.og.lp.module.record.entity

import com.og.lp.integration.discogs.dto.DiscogsRecordResponse
import com.og.lp.integration.discogs.dto.DiscogsResponse
import com.og.lp.module.artist.entity.Artist
import com.og.lp.module.label.entity.Label
import org.hibernate.annotations.CreationTimestamp
import java.time.Instant
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
class Record(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
	@NotNull val title: String,
	@NotNull @ManyToOne val artist: Artist,
	val releaseYear: Long?,
	val catalogNumber: String?,
	@NotNull @OneToOne val format: Format,
	val variant: String?,
	val comment: String?,
	var coverFront: String?,
	var coverBack: String?,
	val discogsId: String?,
	@NotNull val sort: String,
	val owned: Boolean = true,
	@ManyToOne val label: Label,
	@CreationTimestamp val created: Instant
) {
	fun hasCover(): Boolean {
		return coverFront != null && coverBack != null
	}

	fun withCovers(record: DiscogsRecordResponse) : Record {
		coverFront = record.frontCover
		coverBack = record.backCover

		return this
	}
}