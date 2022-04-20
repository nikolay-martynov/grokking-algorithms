#include "Ex_4_4_Test.hpp"

#include "Ex_4_4.hpp"

namespace {

void empty() {
given:
  std::vector<int> input = {};
  int target = 6;
when:
  bool result = Ex_4_4().contains(input, target);
then:
  CU_ASSERT_FALSE(result);
}

void one_other_element() {
given:
  std::vector<int> input = {5};
  int target = 6;
when:
  bool result = Ex_4_4().contains(input, target);
then:
  CU_ASSERT_FALSE(result);
}

void one_target_element() {
given:
  std::vector<int> input = {6};
  int target = 6;
when:
  bool result = Ex_4_4().contains(input, target);
then:
  CU_ASSERT_TRUE(result);
}

void two_elements_missing_left() {
given:
  std::vector<int> input = {1, 2};
  int target = 0;
when:
  bool result = Ex_4_4().contains(input, target);
then:
  CU_ASSERT_FALSE(result);
}

void two_elements_contains_left() {
given:
  std::vector<int> input = {1, 2};
  int target = 1;
when:
  bool result = Ex_4_4().contains(input, target);
then:
  CU_ASSERT_TRUE(result);
}

void two_elements_contains_right() {
given:
  std::vector<int> input = {1, 2};
  int target = 2;
when:
  bool result = Ex_4_4().contains(input, target);
then:
  CU_ASSERT_TRUE(result);
}

void two_elements_missing_right() {
given:
  std::vector<int> input = {1, 2};
  int target = 3;
when:
  bool result = Ex_4_4().contains(input, target);
then:
  CU_ASSERT_FALSE(result);
}

void two_elements_missing_middle() {
given:
  std::vector<int> input = {1, 3};
  int target = 2;
when:
  bool result = Ex_4_4().contains(input, target);
then:
  CU_ASSERT_FALSE(result);
}

void odd_elements_contains_middle() {
given:
  std::vector<int> input = {1, 2, 3, 4, 5};
  int target = 3;
when:
  bool result = Ex_4_4().contains(input, target);
then:
  CU_ASSERT_TRUE(result);
}

void odd_elements_contains_left() {
given:
  std::vector<int> input = {1, 2, 3, 4, 5};
  int target = 1;
when:
  bool result = Ex_4_4().contains(input, target);
then:
  CU_ASSERT_TRUE(result);
}

void odd_elements_contains_right() {
given:
  std::vector<int> input = {1, 2, 3, 4, 5};
  int target = 5;
when:
  bool result = Ex_4_4().contains(input, target);
then:
  CU_ASSERT_TRUE(result);
}

void odd_elements_missing_left() {
given:
  std::vector<int> input = {1, 2, 3, 4, 5};
  int target = 0;
when:
  bool result = Ex_4_4().contains(input, target);
then:
  CU_ASSERT_FALSE(result);
}

void odd_elements_missing_right() {
given:
  std::vector<int> input = {1, 2, 3, 4, 5};
  int target = 6;
when:
  bool result = Ex_4_4().contains(input, target);
then:
  CU_ASSERT_FALSE(result);
}

void odd_elements_missing_middle() {
given:
  std::vector<int> input = {1, 2, 3, 5, 6};
  int target = 4;
when:
  bool result = Ex_4_4().contains(input, target);
then:
  CU_ASSERT_FALSE(result);
}

void even_elements_contain() {
given:
  std::vector<int> input = {1, 2, 3, 4, 5, 6};
  int target = 4;
when:
  bool result = Ex_4_4().contains(input, target);
then:
  CU_ASSERT_TRUE(result);
}

void even_elements_missing() {
given:
  std::vector<int> input = {1, 2, 4, 5, 6, 7};
  int target = 3;
when:
  bool result = Ex_4_4().contains(input, target);
then:
  CU_ASSERT_FALSE(result);
}

}  // namespace

void Ex_4_4_Test::registerTestCases(CU_pSuite suite) {
  CU_ADD_TEST(suite, empty);
  CU_ADD_TEST(suite, one_other_element);
  CU_ADD_TEST(suite, one_target_element);
  CU_ADD_TEST(suite, two_elements_missing_left);
  CU_ADD_TEST(suite, two_elements_contains_left);
  CU_ADD_TEST(suite, two_elements_contains_right);
  CU_ADD_TEST(suite, two_elements_missing_right);
  CU_ADD_TEST(suite, two_elements_missing_middle);
  CU_ADD_TEST(suite, odd_elements_contains_middle);
  CU_ADD_TEST(suite, odd_elements_contains_left);
  CU_ADD_TEST(suite, odd_elements_contains_right);
  CU_ADD_TEST(suite, odd_elements_missing_left);
  CU_ADD_TEST(suite, odd_elements_missing_right);
  CU_ADD_TEST(suite, odd_elements_missing_middle);
  CU_ADD_TEST(suite, even_elements_contain);
  CU_ADD_TEST(suite, even_elements_missing);
}