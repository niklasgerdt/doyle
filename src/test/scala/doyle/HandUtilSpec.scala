package doyle

import org.scalatest.WordSpec

class HandUtilSpec extends UnitSpec {

  "null string" when {
    "as hand" should {
      "return None" in {
        assertResult(Option.empty) {
          HandUtil.toHand(null)
        }
      }
    }
  }
 
   "empty string" when {
    "as hand" should {
      "return None" in {
        assertResult(Option.empty) {
          HandUtil.toHand("")
        }
      }
    }
  }
  
  "AdKd" when {
    "as hand" should {
      "have 2 cards" in {
        assertResult(2) {
          2
        }
      }

      "produce NoSuchElementException when head is invoked" in {
        intercept[NoSuchElementException] {
          Set.empty.head
        }
      }
    }
  }
}
