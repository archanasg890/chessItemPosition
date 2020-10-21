package archana.chess.pieces

import archana.chess.board.House

class King: Piece(KING_DISPLAY_NAME) {
    override fun possibleMoves(currentHouse: House): List<House> {
        val possibleMovesList = mutableListOf<House>()
        (0..7).filter { (it >= currentHouse.getCol()-1 && it <= currentHouse.getCol()+1) }.let { cols ->
            (0..7).filter { (it >= currentHouse.getRow()-1 && it <= currentHouse.getRow()+1) }.let { rows ->
                cols.forEach { col ->
                    rows.forEach { row ->
                        if(col == currentHouse.getCol() && row == currentHouse.getRow()) {
                            //Already piece is at this position
                        } else {
                            House.instanceOf(col, row).map {
                                possibleMovesList.add(it)
                            }
                        }
                    }
                }
            }
        }
        return possibleMovesList
    }
}