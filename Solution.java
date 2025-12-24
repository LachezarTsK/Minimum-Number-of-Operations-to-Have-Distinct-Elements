
import java.util.Arrays;

public class Solution {

    private static final int NOT_OCCURRED = -1;
    private static final int NUMBER_OF_ELEMENTS_IN_REMOVAL_GROUP = 3;

    public int minOperations(int[] input) {
        // Alternatively: int maxValue = Arrays.stream(input).max().getAsInt();
        int maxValue = 0;
        for (int value : input) {
            maxValue = Math.max(maxValue, value);
        }

        int[] mostRecentIndexOfElementOccurrence = new int[maxValue + 1];
        Arrays.fill(mostRecentIndexOfElementOccurrence, NOT_OCCURRED);
        int startIndexOfUniqueElementsTillEnd = 0;

        for (int i = 0; i < input.length; ++i) {
            if (mostRecentIndexOfElementOccurrence[input[i]] >= startIndexOfUniqueElementsTillEnd) {
                startIndexOfUniqueElementsTillEnd = 1 + mostRecentIndexOfElementOccurrence[input[i]];
            }
            mostRecentIndexOfElementOccurrence[input[i]] = i;
        }
        return (int) Math.ceil((double) startIndexOfUniqueElementsTillEnd / NUMBER_OF_ELEMENTS_IN_REMOVAL_GROUP);
    }
}
