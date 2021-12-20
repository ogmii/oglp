package com.og.lp.module.record.service

import com.og.lp.module.record.entity.Record
import org.springframework.data.repository.CrudRepository

interface RecordRepository : CrudRepository<Record, Long>