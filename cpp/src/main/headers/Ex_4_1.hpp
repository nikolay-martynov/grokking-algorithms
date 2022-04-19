#ifndef EX_4_1_HPP
#define EX_4_1_HPP

#include <vector>

class Ex_4_1 {
 public:
  /**
   * @brief Calculates the sum of elements.
   *
   * Implementation uses recursion as required by the exercise.
   *
   * @param  {std::vector<int>} numbers : Numbers that are to be summed.
   * @return {int}                      : Sum of elements or 0 if numbers is
   * empty.
   */
  int sum(const std::vector<int>& numbers);
};

#endif