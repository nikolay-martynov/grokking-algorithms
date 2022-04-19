#ifndef CB81544F_8035_4D15_AE61_94DC463717E9
#define CB81544F_8035_4D15_AE61_94DC463717E9

#include <list>

class Ex_4_2 {
 public:
  /**
   * @brief Calculates the number of elements in a list.
   *
   * Implementation uses recursion as required by the exercise.
   *
   * @param  {typename} Elements            : Type of elements in the list.
   * @param  {std::list<Elements>} elements : List whose elements are to be
   * counted.
   * @return {int}                          : Number of elements in the list or
   * 0 if the list is empty.
   */
  template <typename Elements>
  int count(const std::list<Elements> &elements) {
    return elements.empty()
               ? 0
               : 1 + this->count(std::list<Elements>(
                         std::next(elements.begin()), elements.end()));
  }
};

#endif /* CB81544F_8035_4D15_AE61_94DC463717E9 */
