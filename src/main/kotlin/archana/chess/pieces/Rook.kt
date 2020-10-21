package archana.chess.pieces

import archana.chess.board.House

class Rook: Piece(ROOK_DISPLAY_NAME) {
    override fun possibleMoves(currentHouse: House): List<House> {
        val possibleMovesList = mutableListOf<House>()
        (0..7).forEach { col ->
            (0..7).forEach { row ->
                if(col == currentHouse.getCol() && row == currentHouse.getRow()) {
                    //Piece is at this position
                } else if(col == currentHouse.getCol() || row == currentHouse.getRow()) {
                    House.instanceOf(col, row).map {
                        possibleMovesList.add(it)
                    }
                }
            }
        }
        return possibleMovesList
    }
}