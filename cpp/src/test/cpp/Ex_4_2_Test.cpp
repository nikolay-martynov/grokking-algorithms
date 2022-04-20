#include "Ex_4_2_Test.hpp"

#include "Ex_4_2.hpp"

namespace {

void when_empty_then_zero() {
given:
  std::list<int> input = {};
when:
  int result = Ex_4_2().count(input);
then:
  CU_ASSERT_EQUAL(result, 0);
}

void one() {
given:
  std::list<int> input = {6};
when:
  int result = Ex_4_2().count(input);
then:
  CU_ASSERT_EQUAL(result, 1);
}

void many() {
given:
  std::list<int> input = {0, 2, 4};
when:
  int result = Ex_4_2().count(input);
then:
  CU_ASSERT_EQUAL(result, 3);
}

}  // namespace

void Ex_4_2_Test::registerTestCases(CU_pSuite suite) {
  CU_ADD_TEST(suite, when_empty_then_zero);
  CU_ADD_TEST(suite, one);
  CU_ADD_TEST(suite, many);
}
