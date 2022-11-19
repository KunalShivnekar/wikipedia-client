package com.kunal.wikipedia.data.pagelist.repository

import com.kunal.wikipedia.data.base.BaseRepository
import com.kunal.wikipedia.data.pagelist.model.Page

interface PageListRepository:BaseRepository<List<Page>> {
}