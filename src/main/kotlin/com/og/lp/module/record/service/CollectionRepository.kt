package com.og.lp.module.record.service

import com.og.lp.module.statistics.entity.CollectionValue
import org.springframework.data.repository.CrudRepository

interface CollectionRepository : CrudRepository<CollectionValue, Long> {

	fun findTop12OrderByCreated(): List<CollectionValue>

}
