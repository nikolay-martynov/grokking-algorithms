#include "Ex_4_3_Test.hpp"

#include "Ex_4_3.hpp"

namespace {

void one_element() {
given:
  std::list<int> input = {2};
when:
  int result = Ex_4_3().max(input);
then:
  CU_ASSERT_EQUAL(result, 2);
}

void two_elements() {
given:
  std::list<int> input = {2, 3};
when:
  int result = Ex_4_3().max(input);
then:
  CU_ASSERT_EQUAL(result, 3);
}

void many_elements_random_order() {
given:
  std::list<int> input = {-1, 1, 0, -2, 2, -3};
when:
  int result = Ex_4_3().max(input);
then:
  CU_ASSERT_EQUAL(result, 2);
}

}  // namespace

void Ex_4_3_Test::registerTestCases(CU_pSuite suite) {
  CU_ADD_TEST(suite, one_element);
  CU_ADD_TEST(suite, two_elements);
  CU_ADD_TEST(suite, many_elements_random_order);
}
