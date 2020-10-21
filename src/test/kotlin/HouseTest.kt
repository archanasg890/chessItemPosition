import archana.chess.board.House
import org.junit.Assert
import org.junit.Test

class HouseTest {
    @Test
    fun `display house name`() {
        House.instanceOf(1, 1).fold({
            Assert.assertFalse("Valid House", true)
        }, {
            Assert.assertEquals(it.toString(), "B2")
        })
        House.instanceOf(-1, 1).fold({ fault ->
            Assert.assertEquals("err-house-params", fault.errorCode)
        }, {
            Assert.assertFalse("Invalid House", true)
        })
        House.instanceOf(4, 8).fold({ fault ->
            Assert.assertEquals("err-house-params", fault.errorCode)
        }, {
            Assert.assertFalse("Invalid House", true)
        })
    }

    @Test
    fun `get house`() {
        House.instanceOf("H8").fold({
            Assert.assertFalse("Valid House", true)
        }, {
            Assert.assertEquals(7, it.getCol())
            Assert.assertEquals(7, it.getRow())
        })
        House.instanceOf("A1").fold({
            Assert.assertFalse("Valid House", true)
        }, {
            Assert.assertEquals(0, it.getCol())
            Assert.assertEquals(0, it.getRow())
        })
        House.instanceOf("I1").fold({ fault ->
            Assert.assertEquals("err-house-first-char", fault.errorCode)
        }, {
            Assert.assertFalse("Invalid House", true)
        })
        House.instanceOf("AI").fold({ fault ->
            Assert.assertEquals("err-house-second-char", fault.errorCode)
        }, {
            Assert.assertFalse("Invalid House", true)
        })
        House.instanceOf("A0").fold({ fault ->
            Assert.assertEquals("err-house-second-char", fault.errorCode)
        }, {
            Assert.assertFalse("Invalid House", true)
        })
        House.instanceOf("A9").fold({ fault ->
            Assert.assertEquals("err-house-second-char", fault.errorCode)
        }, {
            Assert.assertFalse("Invalid House", true)
        })
        House.instanceOf("A").fold({ fault ->
            Assert.assertEquals("err-house-char-length", fault.errorCode)
        }, {
            Assert.assertFalse("Invalid House", true)
        })
        House.instanceOf("A99").fold({ fault ->
            Assert.assertEquals("err-house-char-length", fault.errorCode)
        }, {
            Assert.assertFalse("Invalid House", true)
        })
    }
}