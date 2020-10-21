package archana.chess.pieces

import archana.chess.board.House
import archana.chess.utils.Fault
import arrow.core.Either
import arrow.core.left
import arrow.core.right

const val KING_DISPLAY_NAME = "King"
const val QUEEN_DISPLAY_NAME = "Queen"
const val BISHOP_DISPLAY_NAME = "Bishop"
const val HORSE_DISPLAY_NAME = "Horse"
const val ROOK_DISPLAY_NAME = "Rook"
const val PAWN_DISPLAY_NAME = "Pawn"


abstract class Piece(val displayName: String) {
    companion object {
        fun instanceOf(name: String): Either<Fault,Piece> = when(name) {
            KING_DISPLAY_NAME -> King().right()
            QUEEN_DISPLAY_NAME -> Queen().right()
            BISHOP_DISPLAY_NAME -> Bishop().right()
            HORSE_DISPLAY_NAME -> Horse().right()
            ROOK_DISPLAY_NAME -> Rook().right()
            PAWN_DISPLAY_NAME -> Pawn().right()
            else -> Fault("invalid-piece-name", "Invalid Piece Name").left()
        }
    }

    abstract fun possibleMoves(currentHouse: House): List<House>
}