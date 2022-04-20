#include "Ex_4_1.hpp"

int Ex_4_1::sum(const std::vector<int>& numbers) {
  return numbers.empty()
             ? 0
             : numbers.at(0) + sum({std::next(numbers.begin()), numbers.end()});
}
