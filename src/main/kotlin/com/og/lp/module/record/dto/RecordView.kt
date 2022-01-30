package com.og.lp.module.record.dto

class RecordView(
	private val id: Long,
	private val title: String,
	private val artist: String,
	private val artistId: Long,
	private val releaseYear: Long?,
	private val format: String,
	private val coverFront: String?,
	private val coverBack: String?,
	private val label: String
)