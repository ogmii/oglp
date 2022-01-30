package com.og.lp.module.record.entity

import com.og.lp.module.artist.entity.Artist
import com.og.lp.module.label.entity.Label
import com.og.lp.module.record.dto.RecordView
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

	fun withCovers(coverFront: String?, coverBack: String?): Record {
		this.coverFront = coverFront
		this.coverBack = coverBack

		return this
	}

	fun getWebTitle(): String {
		return "$title ($releaseYear) - ${artist.name}"
	}

	fun toRecordView() = RecordView(
		id = id,
		title = title,
		artist = artist.name,
		artistId = artist.id,
		releaseYear = releaseYear,
		format = format.format,
		coverFront = coverFront,
		coverBack = coverBack,
		label = label.name
	)
}