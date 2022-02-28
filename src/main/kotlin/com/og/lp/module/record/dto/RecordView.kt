package com.og.lp.module.record.dto

class RecordView(
	private val id: Long,
	private val artist: String,
	private val heading: String,
	private val artistId: Long,
	private val releaseYear: Long?,
	private val format: String,
	private val coverFront: String?,
	private val coverBack: String?,
	private val hasCover: Boolean = false,
	private val label: String,
	private val comment: String?,
	private val variant: String?,
	private val catalogueNumber: String?
)