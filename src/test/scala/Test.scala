import org.scalatest.funsuite.AnyFunSuite

class SetSuite extends AnyFunSuite {
 
  test("An empty List should have size 0") {
    assert(List.empty.size == 0)
  }

  test("Two numbers are equals") {
    val left = 2
    val right = 2
    assert(left == right)
  }
 
}