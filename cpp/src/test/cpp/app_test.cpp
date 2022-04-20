#include <CUnit/Basic.h>
#include <CUnit/CUnit.h>

#include <memory>
#include <vector>

#include "Ex_4_1_Test.hpp"
#include "Ex_4_2_Test.hpp"
#include "Ex_4_3_Test.hpp"
#include "Ex_4_4_Test.hpp"

int main(int argc, char* argv[]) {
  CU_initialize_registry();
  std::vector<std::shared_ptr<TestSuite> > suites(
      {std::make_shared<Ex_4_1_Test>(), std::make_shared<Ex_4_2_Test>(),
       std::make_shared<Ex_4_3_Test>(), std::make_shared<Ex_4_4_Test>()});
  for (auto const& suite : suites) {
    suite->registerCUnit();
  }
  CU_basic_run_tests();
  int errors = CU_get_number_of_failure_records();
  CU_cleanup_registry();
  return errors;
}