package com.kunal.wikipedia.view.pagelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kunal.wikipedia.data.base.Response
import com.kunal.wikipedia.data.pagelist.model.Page
import com.kunal.wikipedia.data.pagelist.repository.PageListRepository
import com.kunal.wikipedia.view.base.BaseViewModelImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by kunal.
 */
class PageListViewModel @Inject constructor(private val pageListRepository: PageListRepository): BaseViewModelImpl(){

    private val _pageList:MutableLiveData<List<Page>> = MutableLiveData()
    val pageList: LiveData<List<Page>>
        get() = _pageList

    private var _error: MutableLiveData<Response.Error> = MutableLiveData()
    val error: LiveData<Response.Error>
        get() = _error

    fun search(text:String) {
        viewModelScope.launch {
            val response = pageListRepository.getItems(text)
            if (response is Response.Success)
                _pageList.value = response.data!!
            else if (response is Response.Error)
                _error.value = response
        }
    }
}