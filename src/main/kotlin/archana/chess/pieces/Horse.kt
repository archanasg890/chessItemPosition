package archana.chess.pieces

import archana.chess.board.House

class Horse: Piece(HORSE_DISPLAY_NAME) {
    override fun possibleMoves(currentHouse: House): List<House> {
        val possibleMovesList = mutableListOf<House>()
        listOf(currentHouse.getCol() - 1, currentHouse.getCol() + 1).forEach { col ->
            listOf(currentHouse.getRow() - 2, currentHouse.getRow() + 2).forEach { row ->
                House.instanceOf(col, row).map {
                    possibleMovesList.add(it)
                }
            }
        }
        listOf(currentHouse.getCol() - 2, currentHouse.getCol() + 2).forEach { col ->
            listOf(currentHouse.getRow() - 1, currentHouse.getRow() + 1).forEach { row ->
                House.instanceOf(col, row).map {
                    possibleMovesList.add(it)
                }
            }
        }
        return possibleMovesList
    }
}