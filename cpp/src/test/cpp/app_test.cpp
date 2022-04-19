#include <CUnit/Basic.h>
#include <CUnit/CUnit.h>

#include "Ex_4_1_Test.hpp"
#include "Ex_4_2_Test.hpp"

int main(int argc, char* argv[]) {
  CU_initialize_registry();
  Ex_4_1_Test().registerCUnit();
  Ex_4_2_Test().registerCUnit();
  CU_basic_run_tests();
  int errors = CU_get_number_of_failure_records();
  CU_cleanup_registry();
  return errors;
}