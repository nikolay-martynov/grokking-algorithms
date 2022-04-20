#include "Ex_4_4.hpp"

bool Ex_4_4::contains(std::vector<int> sortedNumbers, int targetValue) {
  if (sortedNumbers.empty()) {
    return false;
  }
  int middleIndex = sortedNumbers.size() / 2;
  int middleValue = sortedNumbers.at(middleIndex);
  if (targetValue == middleValue) {
    return true;
  } else if (targetValue < middleValue) {
    return contains(
        {sortedNumbers.begin(), sortedNumbers.begin() + middleIndex},
        targetValue);
  } else {
    return contains(
        {sortedNumbers.begin() + middleIndex + 1, sortedNumbers.end()},
        targetValue);
  }
}
