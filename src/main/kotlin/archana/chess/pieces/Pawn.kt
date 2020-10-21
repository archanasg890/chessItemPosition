package archana.chess.pieces

import archana.chess.board.House

class Pawn: Piece(PAWN_DISPLAY_NAME) {
    override fun possibleMoves(currentHouse: House): List<House> = mutableListOf<House>().apply {
        (currentHouse.getCol()-1 until currentHouse.getCol() + 2).forEach { col ->
            House.instanceOf(col, currentHouse.getRow()+1).map {
                add(it)
            }
        }
    }
}