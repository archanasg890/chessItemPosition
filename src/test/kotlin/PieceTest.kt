import archana.chess.board.House
import archana.chess.pieces.*
import org.junit.Assert
import org.junit.Test

class PieceTest {
    @Test
    fun `get piece from name`() {
        Piece.instanceOf("King").fold({
            Assert.assertFalse("Valid Piece", true)
        }, {
            Assert.assertEquals(KING_DISPLAY_NAME, it.displayName)
        })
        Piece.instanceOf("Queen").fold({
            Assert.assertFalse("Valid Piece", true)
        }, {
            Assert.assertEquals(QUEEN_DISPLAY_NAME, it.displayName)
        })
        Piece.instanceOf("Bishop").fold({
            Assert.assertFalse("Valid Piece", true)
        }, {
            Assert.assertEquals(BISHOP_DISPLAY_NAME, it.displayName)
        })
        Piece.instanceOf("Horse").fold({
            Assert.assertFalse("Valid Piece", true)
        }, {
            Assert.assertEquals(HORSE_DISPLAY_NAME, it.displayName)
        })
        Piece.instanceOf("Rook").fold({
            Assert.assertFalse("Valid Piece", true)
        }, {
            Assert.assertEquals(ROOK_DISPLAY_NAME, it.displayName)
        })
        Piece.instanceOf("Pawn").fold({
            Assert.assertFalse("Valid Piece", true)
        }, {
            Assert.assertEquals(PAWN_DISPLAY_NAME, it.displayName)
        })
        Piece.instanceOf("xyz").fold({
            Assert.assertEquals("invalid-piece-name", it.errorCode)
        }, {
            Assert.assertFalse("Invalid Piece", true)
        })
    }

    @Test
    fun `king moves`() {
        Piece.instanceOf("King").map{ king ->
            House.Companion.instanceOf("E5").map { house ->
                king.possibleMoves(house).let { moves ->
                    Assert.assertEquals(8, moves.size)
                    House.instanceOf("F4").map {
                        Assert.assertTrue(moves.contains(it))
                    }
                    House.instanceOf("D5").map {
                        Assert.assertTrue(moves.contains(it))
                    }
                }
            }
        }
    }

    @Test
    fun `queen moves`() {
        Piece.instanceOf("Queen").map{ queen ->
            House.Companion.instanceOf("E5").map { house ->
                queen.possibleMoves(house).let { moves ->
                    Assert.assertEquals(27, moves.size)
                    House.instanceOf("F5").map {
                        Assert.assertTrue(moves.contains(it))
                    }
                    House.instanceOf("D4").map {
                        Assert.assertTrue(moves.contains(it))
                    }
                }
            }
        }
    }

    @Test
    fun `bishop moves`() {
        Piece.instanceOf("Bishop").map{ bishop ->
            House.Companion.instanceOf("E5").map { house ->
                bishop.possibleMoves(house).let { moves ->
                    Assert.assertEquals(13, moves.size)
                    House.instanceOf("D4").map {
                        Assert.assertTrue(moves.contains(it))
                    }
                    House.instanceOf("G3").map {
                        Assert.assertTrue(moves.contains(it))
                    }
                }
            }
        }
    }

    @Test
    fun `horse moves`() {
        Piece.instanceOf("Horse").map{ horse ->
            House.Companion.instanceOf("E5").map { house ->
                horse.possibleMoves(house).let { moves ->
                    Assert.assertEquals(8, moves.size)
                    House.instanceOf("C4").map {
                        Assert.assertTrue(moves.contains(it))
                    }
                    House.instanceOf("F7").map {
                        Assert.assertTrue(moves.contains(it))
                    }
                }
            }
        }
    }

    @Test
    fun `rook moves`() {
        Piece.instanceOf("Rook").map{ rook ->
            House.Companion.instanceOf("E5").map { house ->
                rook.possibleMoves(house).let { moves ->
                    Assert.assertEquals(14, moves.size)
                    House.instanceOf("E4").map {
                        Assert.assertTrue(moves.contains(it))
                    }
                    House.instanceOf("A5").map {
                        Assert.assertTrue(moves.contains(it))
                    }
                }
            }
        }
    }

    @Test
    fun `pawn moves`() {
        Piece.instanceOf("Pawn").map{ pawn ->
            House.Companion.instanceOf("E5").map { house ->
                pawn.possibleMoves(house).let { moves ->
                    Assert.assertEquals(3, moves.size)
                    House.instanceOf("E6").map {
                        Assert.assertTrue(moves.contains(it))
                    }
                    House.instanceOf("F6").map {
                        Assert.assertTrue(moves.contains(it))
                    }
                }
            }
        }
    }
}