package archana.chess.pieces

import archana.chess.board.House

class Bishop: Piece(BISHOP_DISPLAY_NAME) {
    override fun possibleMoves(currentHouse: House): List<House> {
        val possibleMovesList = mutableListOf<House>()
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