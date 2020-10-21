package archana.chess.board

import archana.chess.utils.Fault
import arrow.core.Either
import arrow.core.left
import arrow.core.right

class House {
    private var col: Int = -1
    private var row: Int = -1
    private constructor(col: Int, row: Int) {
        this.col = col
        this.row = row
    }
    companion object {
        fun instanceOf(col: Int, row: Int): Either<Fault, House> = if(col in 0..7 && row in 0..7)
            House(col, row).right()
        else
            Fault("err-house-params", "Invalid House").left()

        fun instanceOf(position: String): Either<Fault, House> = position.toCharArray().let { pos ->
            if(pos.size != 2)
                Fault("err-house-char-length", "Input should be of 2 length characters").left()
            else
                pos[0].toInt().let { col ->
                    if(col in 65..72) pos[1].toInt().let { row ->
                        if(row in 49..56) House(col-65, row-49).right()
                        else Fault("err-house-second-char", "row should be letter between 1 to 8").left()
                    } else
                        Fault("err-house-first-char", "Column should be letter between A to H").left()
                }
        }
    }

    override fun equals(other: Any?): Boolean {
        if(other != null) {
            if(other is House) {
                return other.getRow() == row && other.getCol() == col
            }
        }
        return false
    }

    fun getCol() = col
    fun getRow() = row

    override fun toString(): String = ((col + 65).toChar().toString() + (row + 1))
}