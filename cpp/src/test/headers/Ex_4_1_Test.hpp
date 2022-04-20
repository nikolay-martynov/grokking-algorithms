#ifndef EX_4_1_TEST_HPP
#define EX_4_1_TEST_HPP

#include "TestSuite.hpp"

class Ex_4_1_Test : public TestSuite {
 public:
  Ex_4_1_Test() : TestSuite("Ex_4_1"){};

 protected:
  virtual void registerTestCases(CU_pSuite suite);
};

#endif
