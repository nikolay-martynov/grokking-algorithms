#ifndef A41E3840_55B9_4436_80FE_0F70F5B0A1BC
#define A41E3840_55B9_4436_80FE_0F70F5B0A1BC

#include <list>

class Ex_4_3 {
 public:
  /**
   * @brief Calculates a maximum element in a list.
   *
   * Implementation uses recursion as required by the exercise.
   *
   * @param  {std::list<int>} elements : List where to find a maximum element.
   * @return {int}                     : Value of the maximum element in the
   * list. As with std::valarray, the behaviour is undefined if the list is
   * empty.
   */
  int max(const std::list<int>& elements);
};

#endif /* A41E3840_55B9_4436_80FE_0F70F5B0A1BC */
