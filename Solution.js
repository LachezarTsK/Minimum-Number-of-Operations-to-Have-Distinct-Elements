
/**
 * @param {number[]} input
 * @return {number}
 */
var minOperations = function (input) {
    const NOT_OCCURRED = -1;
    const NUMBER_OF_ELEMENTS_IN_REMOVAL_GROUP = 3;

    // Alternatively: const maxValue = Math.max(...input);
    let maxValue = 0;
    for (let value of input) {
        maxValue = Math.max(maxValue, value);
    }

    const mostRecentIndexOfElementOccurrence = new Array(maxValue + 1).fill(NOT_OCCURRED);
    let startIndexOfUniqueElementsTillEnd = 0;

    for (let i = 0; i < input.length; ++i) {
        if (mostRecentIndexOfElementOccurrence[input[i]] >= startIndexOfUniqueElementsTillEnd) {
            startIndexOfUniqueElementsTillEnd = 1 + mostRecentIndexOfElementOccurrence[input[i]];
        }
        mostRecentIndexOfElementOccurrence[input[i]] = i;
    }
    return Math.ceil(startIndexOfUniqueElementsTillEnd / NUMBER_OF_ELEMENTS_IN_REMOVAL_GROUP);
};
