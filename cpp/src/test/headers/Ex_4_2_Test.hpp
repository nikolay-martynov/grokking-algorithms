#ifndef B5DF1E30_93F8_4AB9_935D_0DFB065267AA
#define B5DF1E30_93F8_4AB9_935D_0DFB065267AA

#include "TestSuite.hpp"

class Ex_4_2_Test : public TestSuite {
 public:
  Ex_4_2_Test() : TestSuite("Ex_4_2"){};

 protected:
  virtual void registerTestCases(CU_pSuite suite);
};

#endif /* B5DF1E30_93F8_4AB9_935D_0DFB065267AA */
