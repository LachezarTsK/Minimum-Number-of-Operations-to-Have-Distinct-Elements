
#include <cmath>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {

    inline static const int NOT_OCCURRED = -1;
    inline static const int NUMBER_OF_ELEMENTS_IN_REMOVAL_GROUP = 3;

public:
    int minOperations(const vector<int>& input) const {
        // Alternatively: int maxValue = *ranges::max_element(input);
        int maxValue = 0;
        for (const auto& value : input) {
            maxValue = max(maxValue, value);
        }

        vector<int> mostRecentIndexOfElementOccurrence(maxValue + 1, NOT_OCCURRED);
        int startIndexOfUniqueElementsTillEnd = 0;

        for (int i = 0; i < input.size(); ++i) {
            if (mostRecentIndexOfElementOccurrence[input[i]] >= startIndexOfUniqueElementsTillEnd) {
                startIndexOfUniqueElementsTillEnd = 1 + mostRecentIndexOfElementOccurrence[input[i]];
            }
            mostRecentIndexOfElementOccurrence[input[i]] = i;
        }
        return ceil(static_cast<double>(startIndexOfUniqueElementsTillEnd) / NUMBER_OF_ELEMENTS_IN_REMOVAL_GROUP);
    }
};
