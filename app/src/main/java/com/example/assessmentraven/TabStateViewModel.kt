package com.example.assessmentraven

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assessmentraven.model.DummyListItem
import com.example.assessmentraven.model.DummyListedItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class TabStateViewModel : ViewModel() {
    private var _airtimeDataTabState: MutableStateFlow<Int> = MutableStateFlow(0)
    val airtimeDataTabState: StateFlow<Int> get() = _airtimeDataTabState


    var shouldNavigateRewardHistory = false
    private var _utilityElectricityTabState: MutableStateFlow<Int> = MutableStateFlow(0)
    val utilityElectricityTabState: StateFlow<Int> get() = _utilityElectricityTabState


    var shouldNavigateDealsHistory = false
    var shouldNavigateBillPayments = false

    var shouldNavigateFundTopUp = false

    private var _viewPagerTwoTabState: MutableStateFlow<Int> = MutableStateFlow(0)
    val viewPagerTwoTabState: StateFlow<Int> get() =  _viewPagerTwoTabState

    private var _wishListTabState: MutableStateFlow<Int> = MutableStateFlow(0)
    val wishListTabState : StateFlow<Int> get() = _wishListTabState


    fun setWishListTabState(state: Int){
        viewModelScope.launch(Dispatchers.IO){
            _wishListTabState.emit(state)
        }
    }

    fun setRewardsViewPager(state: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _viewPagerTwoTabState.emit(state)
        }
    }


    var dataBundle: DummyListItem? = null
    var dataBundles: DummyListedItem? = null

    fun setAirtimeProvider(state: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _airtimeDataTabState.emit(state)
        }
    }

        fun setUtilityTabState(state: Int) {
            viewModelScope.launch(Dispatchers.IO) {
                _utilityElectricityTabState.emit(state)
            }
        }
    }
