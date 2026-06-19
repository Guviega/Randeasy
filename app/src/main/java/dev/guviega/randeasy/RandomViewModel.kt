package dev.guviega.randeasy

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class RandomViewModel : ViewModel() {

    var result by mutableStateOf(listOf<Int>())
        private set

    fun drawFromRange(start: Int, end: Int, quantity: Int) {

        if (start > end) {
            result = emptyList()
            return
        }

        val safeQuantity = quantity.coerceAtLeast(1)

        result = (start..end)
            .shuffled()
            .take(safeQuantity)
    }
}