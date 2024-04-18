package br.com.cvj.discovr.ui.screen.addplace.step

import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.cvj.discovr.ui.util.components.stack.VStack
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination
fun AddPlaceStepRoute(
    viewModel: AddPlaceStepViewModel = hiltViewModel()
) {
    AddPlaceStepScreen()
}

@Composable
fun AddPlaceStepScreen(modifier: Modifier = Modifier) {
    VStack(modifier = modifier.safeContentPadding()) {
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            val pageCount = 100
//            val pagerState = rememberPagerState(
//                pageCount = { pageCount },
//            )
//            val indicatorScrollState = rememberLazyListState()
//
//            LaunchedEffect(key1 = pagerState.currentPage, block = {
//                val currentPage = pagerState.currentPage
//                val size = indicatorScrollState.layoutInfo.visibleItemsInfo.size
//                val lastVisibleIndex =
//                    indicatorScrollState.layoutInfo.visibleItemsInfo.last().index
//                val firstVisibleItemIndex = indicatorScrollState.firstVisibleItemIndex
//
//                if (currentPage > lastVisibleIndex - 1) {
//                    indicatorScrollState.animateScrollToItem(currentPage - size + 2)
//                } else if (currentPage <= firstVisibleItemIndex + 1) {
//                    indicatorScrollState.animateScrollToItem(Math.max(currentPage - 1, 0))
//                }
//            })
//            HorizontalPager(
//                state = pagerState,
//                modifier = Modifier
//                    .fillMaxSize()
//                    .weight(1f)
//            ) {
//                Box(
//                    modifier = Modifier
//                        .fillMaxSize(),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Text(text = "Page $it")
//                }
//            }
//            LazyRow(
//                state = indicatorScrollState,
//                modifier = Modifier
//                    .height(50.dp)
//                    .width(((6 + 16) * 2 + 3 * (10 + 16)).dp), // I'm hard computing it to simplify
//                horizontalArrangement = Arrangement.Center,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                repeat(pageCount) { iteration ->
//                    val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
//                    item(key = "item$iteration") {
//                        val currentPage = pagerState.currentPage
//                        val firstVisibleIndex by remember { derivedStateOf { indicatorScrollState.firstVisibleItemIndex } }
//                        val lastVisibleIndex = indicatorScrollState.layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0
//                        val size by animateDpAsState(
//                            targetValue = if (iteration == currentPage) {
//                                10.dp
//                            } else if (iteration in firstVisibleIndex + 1..lastVisibleIndex - 1) {
//                                10.dp
//                            } else {
//                                6.dp
//                            }
//                        )
//                        Box(
//                            modifier = Modifier
//                                .padding(8.dp)
//                                .background(color, CircleShape)
//                                .size(
//                                    size
//                                )
//                        )
//                    }
//                }
//            }
//        }
    }
}
