package archana.chess.pieces

import archana.chess.board.House

class Queen: Piece(QUEEN_DISPLAY_NAME) {
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
        (0 until currentHouse.getCol()).forEach { col ->
            val diff = currentHouse.getCol() - col
            House.instanceOf(currentHouse.getCol() - diff, currentHouse.getRow() + diff).map {
                possibleMovesList.add(it)
            }
            House.instanceOf(currentHouse.getCol() - diff, currentHouse.getRow() - diff).map {
                possibleMovesList.add(it)
            }
        }
        ((currentHouse.getCol() + 1) until 8).forEach { col ->
            val diff = col - currentHouse.getCol()
            House.instanceOf(currentHouse.getCol() + diff, currentHouse.getRow() + diff).map {
                possibleMovesList.add(it)
            }
            House.instanceOf(currentHouse.getCol() + diff, currentHouse.getRow() - diff).map {
                possibleMovesList.add(it)
            }
        }
        return possibleMovesList
    }
}