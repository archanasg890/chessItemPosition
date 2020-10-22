package archana.chess

import archana.chess.board.House
import archana.chess.pieces.Piece
import archana.chess.utils.Fault
import arrow.core.Either
import arrow.core.flatMap
import arrow.core.right

object PredictPossibleMoves {
    private const val ANSI_YELLOW = "\u001B[33m"
    private const val ANSI_RESET = "\u001B[0m"
    @JvmStatic
    fun main(args: Array<String>): Unit {
        if(args.size == 2) {
            val possibleMoves: Either<Fault, List<House>> = Piece.instanceOf(args[0]).flatMap { piece ->
                House.instanceOf(args[1]).flatMap { house ->
                    piece.possibleMoves(house).right()
                }
            }
            possibleMoves.fold({ fault ->
                println(fault.message)
            }, { moves ->
                (7 downTo 0).forEach { row->
                    println()
                    (0..7).forEach{ col ->
                        House.instanceOf(col, row).map {
                            if (moves.contains(it)) {
                                print("$ANSI_YELLOW  $it")
                            }
                            else {
                                print("$ANSI_RESET  $it")
                            }
                        }
                    }
                }
            })
        } else {
            println("Please Enter two args, Example King A1")
        }
        println("")
    }
}