#ifndef E244359F_D974_4AA1_AFD5_72E4523FA8CC
#define E244359F_D974_4AA1_AFD5_72E4523FA8CC

#include "TestSuite.hpp"

class Ex_4_3_Test : public TestSuite {
 public:
  Ex_4_3_Test() : TestSuite("Ex_4_3"){};

 protected:
  virtual void registerTestCases(CU_pSuite suite);
};

#endif /* E244359F_D974_4AA1_AFD5_72E4523FA8CC */
