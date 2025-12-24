
package main
import "math"

const NOT_OCCURRED = -1
const NUMBER_OF_ELEMENTS_IN_REMOVAL_GROUP = 3

func minOperations(input []int) int {
    // Alternatively: maxValue := slices.Max(input)
    maxValue := 0
    for _, value := range input {
        maxValue = max(maxValue, value)
    }

    mostRecentIndexOfElementOccurrence := make([]int, maxValue+1)
    for i := range mostRecentIndexOfElementOccurrence {
        mostRecentIndexOfElementOccurrence[i] = NOT_OCCURRED
    }

    startIndexOfUniqueElementsTillEnd := 0

    for i := range input {
        if mostRecentIndexOfElementOccurrence[input[i]] >= startIndexOfUniqueElementsTillEnd {
            startIndexOfUniqueElementsTillEnd = 1 + mostRecentIndexOfElementOccurrence[input[i]]
        }
        mostRecentIndexOfElementOccurrence[input[i]] = i
    }
    return int(math.Ceil(float64(startIndexOfUniqueElementsTillEnd) / NUMBER_OF_ELEMENTS_IN_REMOVAL_GROUP))
}
