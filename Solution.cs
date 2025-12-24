
using System;

public class Solution
{
    private static readonly int NOT_OCCURRED = -1;
    private static readonly int NUMBER_OF_ELEMENTS_IN_REMOVAL_GROUP = 3;

    public int MinOperations(int[] input)
    {
        // Alternatively: int maxValue = Arrays.stream(input).max().getAsInt();
        int maxValue = 0;
        foreach (int value in input)
        {
            maxValue = Math.Max(maxValue, value);
        }

        int[] mostRecentIndexOfElementOccurrence = new int[maxValue + 1];
        Array.Fill(mostRecentIndexOfElementOccurrence, NOT_OCCURRED);
        int startIndexOfUniqueElementsTillEnd = 0;

        for (int i = 0; i < input.Length; ++i)
        {
            if (mostRecentIndexOfElementOccurrence[input[i]] >= startIndexOfUniqueElementsTillEnd)
            {
                startIndexOfUniqueElementsTillEnd = 1 + mostRecentIndexOfElementOccurrence[input[i]];
            }
            mostRecentIndexOfElementOccurrence[input[i]] = i;
        }
        return (int)Math.Ceiling((double)startIndexOfUniqueElementsTillEnd / NUMBER_OF_ELEMENTS_IN_REMOVAL_GROUP);
    }
}
