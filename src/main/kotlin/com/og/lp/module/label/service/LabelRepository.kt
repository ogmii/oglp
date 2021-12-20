package com.og.lp.module.label.service

import com.og.lp.module.label.entity.Label
import org.springframework.data.repository.CrudRepository

interface LabelRepository : CrudRepository<Label, Long>