package com.zionhuang.music.models

import androidx.paging.PagingSource
import kotlinx.coroutines.flow.Flow


data class ListWrapper<K : Any, V : Any>(
    val getList: suspend () -> List<V> = { throw UnsupportedOperationException() },
    val getPagingSource: () -> PagingSource<K, V> = { throw UnsupportedOperationException() },
    val getFlow: () -> Flow<List<V>> = { throw UnsupportedOperationException() },
) {
    val pagingSource: PagingSource<K, V> get() = getPagingSource()
    val flow: Flow<List<V>> get() = getFlow()
}