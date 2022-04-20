#ifndef EE78EA4F_7510_493C_9242_391E178AC15C
#define EE78EA4F_7510_493C_9242_391E178AC15C

#include <CUnit/CUnit.h>

#include <string>

/**
 * Base class for test suites.
 */
class TestSuite {
 public:
  /**
   * @brief Registers test suite with CUnit.
   */
  void registerCUnit();
  /**
   * @brief Descrtucts the object.
   */
  virtual ~TestSuite();

 protected:
  /**
   * @brief Constructs an object.
   *
   * @param  {aSuiteName} : Name of the test suite.
   */
  TestSuite(const std::string &aSuiteName);

  /**
   * @brief Registers test cases in the test suite.
   *
   * Use CU_ADD_TEST to register individual test cases.
   *
   * @param  {CU_Suite} suite : CUnit test suite to register test cases with.
   */
  virtual void registerTestCases(CU_pSuite suite) = 0;

 private:
  std::string suiteName;
};

#endif /* EE78EA4F_7510_493C_9242_391E178AC15C */
