#include "Ex_4_1_Test.hpp"

#include "Ex_4_1.hpp"

namespace {

void when_empty_then_zero() {
given:
  std::vector<int> input = {};
when:
  int result = Ex_4_1().sum(input);
then:
  CU_ASSERT_EQUAL(result, 0);
}

void one_element_is_self() {
given:
  std::vector<int> input = {9};
when:
  int result = Ex_4_1().sum(input);
then:
  CU_ASSERT_EQUAL(result, 9);
}

void two_elements() {
given:
  std::vector<int> input = {2, 1};
when:
  int result = Ex_4_1().sum(input);
then:
  CU_ASSERT_EQUAL(result, 3);
}

void many_elements() {
given:
  std::vector<int> input = {3, 2, 1};
when:
  int result = Ex_4_1().sum(input);
then:
  CU_ASSERT_EQUAL(result, 6);
}

}  // namespace

void Ex_4_1_Test::registerTestCases(CU_pSuite suite) {
  CU_ADD_TEST(suite, when_empty_then_zero);
  CU_ADD_TEST(suite, one_element_is_self);
  CU_ADD_TEST(suite, two_elements);
  CU_ADD_TEST(suite, many_elements);
}
