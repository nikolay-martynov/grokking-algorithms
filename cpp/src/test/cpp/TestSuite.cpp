#include "TestSuite.hpp"

#include <cassert>

TestSuite::TestSuite(const std::string& aSuiteName) : suiteName{aSuiteName} {}

void TestSuite::registerCUnit() {
  assert(CU_registry_initialized());
  if (CU_pSuite suite = CU_add_suite(suiteName.c_str(), nullptr, nullptr);
      suite != NULL) {
    registerTestCases(suite);
  }
}

TestSuite::~TestSuite() {}
