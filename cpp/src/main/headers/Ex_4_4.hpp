#ifndef EF799671_9C8B_4FCD_A2F4_E75D9F4899A6
#define EF799671_9C8B_4FCD_A2F4_E75D9F4899A6

#include <vector>

class Ex_4_4 {
 public:
  /**
   * Checks if a sorted vector contains a given number.
   *
   * Implementation uses recursive binary search as required by the exercise.
   *
   * @param sortedNumbers  Sorted vector where to search given value.
   * @param targetValue Value to search for.
   * @return true if sortedNumbers contains targetValue. false if sortedNumbers
   * is empty or does not contain targetValue.
   */
  bool contains(std::vector<int> sortedNumbers, int targetValue);
};

#endif /* EF799671_9C8B_4FCD_A2F4_E75D9F4899A6 */
