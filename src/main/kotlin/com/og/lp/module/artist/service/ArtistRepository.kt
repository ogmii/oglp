package com.og.lp.module.artist.service

import com.og.lp.module.artist.entity.Artist
import org.springframework.data.repository.CrudRepository

interface ArtistRepository : CrudRepository<Artist, Long> {
	fun findByName(name: String): Artist?
}