
import kotlin.math.ceil
import kotlin.math.max

class Solution {

    private companion object {
        const val NOT_OCCURRED = -1
        const val NUMBER_OF_ELEMENTS_IN_REMOVAL_GROUP = 3
    }

    fun minOperations(input: IntArray): Int {
        // Alternatively: val maxValue = input.max()
        var maxValue = 0
        for (value in input) {
            maxValue = max(maxValue, value)
        }

        val mostRecentIndexOfElementOccurrence = IntArray(maxValue + 1) { NOT_OCCURRED }
        var startIndexOfUniqueElementsTillEnd = 0

        for (i in input.indices) {
            if (mostRecentIndexOfElementOccurrence[input[i]] >= startIndexOfUniqueElementsTillEnd) {
                startIndexOfUniqueElementsTillEnd = 1 + mostRecentIndexOfElementOccurrence[input[i]]
            }
            mostRecentIndexOfElementOccurrence[input[i]] = i
        }
        return ceil(startIndexOfUniqueElementsTillEnd.toDouble() / NUMBER_OF_ELEMENTS_IN_REMOVAL_GROUP).toInt()
    }
}
