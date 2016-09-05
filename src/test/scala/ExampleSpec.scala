import org.scalatest.{FunSuite, Matchers}

class ExampleSpec extends FunSuite with Matchers {
  test("An empty Set should have size 0") {
    assert(Set.empty.isEmpty)
  }

  test("Invoking head on an empty Set should produce NoSuchElementException") {
    assertThrows[NoSuchElementException] {
      Set.empty.head
    }
  }

  /**
   * You can find more documentation about scalatest matchers on
   * [[http://www.scalatest.org/user_guide/using_matchers]]
   *
   * Go try your tests!
   */
  test("Let's try some matchers") {
    1 + 2 should be (3)
    Set("Tom", "Rodrigo", "Juanchi") should contain allOf("Rodrigo", "Tom")
    List(1,2,3) should contain atLeastOneOf(2,3,6)
  }
}
