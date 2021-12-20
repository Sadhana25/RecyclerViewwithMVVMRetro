package com.irayasoft.recipeapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.irayasoft.recipeapp.repository.Repository

// to access the parameterise view Model
class ActivityViewModelfactory(private val repository: Repository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ActivityViewModel(repository) as T
    }
}