package com.paawk4.hammertestapp.presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.paawk4.hammertestapp.domain.utils.Status
import com.paawk4.hammertestapp.presentation.ui_items.FilterRow
import com.paawk4.hammertestapp.presentation.ui_items.MealListItem
import com.paawk4.hammertestapp.presentation.ui_items.SalesRow
import com.paawk4.hammertestapp.presentation.viewmodels.MenuViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun MenuScreen(
    viewModel: MenuViewModel = koinViewModel()
) {
    val lazyListState = rememberLazyListState()
    val mealsList = viewModel.mealsList.collectAsState().value

    val pullRefreshState = rememberPullRefreshState(
        mealsList.responseType == Status.LOADING,
        { viewModel.requestMeals() }
    )

    Box(Modifier.pullRefresh(pullRefreshState)) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp),
            state = lazyListState,
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item { SalesRow() }
            stickyHeader { FilterRow() }
            if (mealsList.responseType == Status.SUCCESSFUL) {
                items(mealsList.data!!) {
                    Box(Modifier.padding(end = 16.dp)) {
                        MealListItem(it)
                    }

                }
            } else if (mealsList.responseType == Status.ERROR) {
                item { Text(text = "Нет доступа к интернету") }
            }
        }

        PullRefreshIndicator(
            mealsList.responseType == Status.LOADING,
            pullRefreshState,
            Modifier.align(Alignment.TopCenter)
        )
    }
}