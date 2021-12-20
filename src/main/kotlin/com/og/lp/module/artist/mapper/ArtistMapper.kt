package com.og.lp.module.artist.mapper

import com.og.lp.module.artist.dto.csv.ArtistCsvDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(componentModel = "spring")
abstract class ArtistMapper {

	@Mappings(
		Mapping(target = "name", expression = "java(line.get(0))"),
		Mapping(target = "alphabetSort", expression = "java(line.get(1))")
	)
	abstract fun toArtistCsvDto(line: List<String>): ArtistCsvDto
}


