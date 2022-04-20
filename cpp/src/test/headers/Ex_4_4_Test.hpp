#ifndef BA927C60_978A_449D_B26D_54427923DD22
#define BA927C60_978A_449D_B26D_54427923DD22

#include "TestSuite.hpp"

class Ex_4_4_Test : public TestSuite {
 public:
  Ex_4_4_Test() : TestSuite("Ex_4_4"){};

 protected:
  virtual void registerTestCases(CU_pSuite suite);
};

#endif /* BA927C60_978A_449D_B26D_54427923DD22 */
