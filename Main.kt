package tictactoe

import kotlin.math.max
import kotlin.math.min

fun checkWinner(input: String): MutableList<String> {

    val win1 = "${input[0]}${input[1]}${input[2]}"
    val win2 = "${input[3]}${input[4]}${input[5]}"
    val win3 = "${input[6]}${input[7]}${input[8]}"
    val win4 = "${input[0]}${input[3]}${input[6]}"
    val win5 = "${input[1]}${input[4]}${input[7]}"
    val win6 = "${input[2]}${input[5]}${input[8]}"
    val win7 = "${input[0]}${input[4]}${input[8]}"
    val win8 = "${input[2]}${input[4]}${input[6]}"

    val result = mutableListOf<String>()

    if (win1 == "OOO" || win2 == "OOO" || win3 == "OOO" || win4 == "OOO" || win5 == "OOO" || win6 == "OOO" || win7 == "OOO" || win8 == "OOO")
    {
        result.add("O")
    }
    if (win1 == "XXX" || win2 == "XXX" || win3 == "XXX" || win4 == "XXX" || win5 == "XXX" || win6 == "XXX" || win7 == "XXX" || win8 == "XXX")
    {
        result.add("X")
    }
    return  result
}

fun generateMessage(input: String) {
    val results = checkWinner(input)

    if (results.size == 1) {
        if (results.contains("O")) println("O wins")
        else if(results.contains("X")) println("X wins")
        //else println("Draw")
    } else if (results.size > 1)
        println("Impossible")
    else if (results.size == 0) {
        val emptyCount = input.count({it == '_'})
        val xCount = input.count({it == 'X'})
        val oCount = input.count({it == 'O'})

        if (emptyCount == 0 && max(xCount, oCount) - min(xCount, oCount) == 1) {
            println("Draw")
        } else if (emptyCount > 0 && max(xCount, oCount) - min(xCount, oCount) == 0) {
            println("Game not finished")
        } else if ( max(xCount, oCount) - min(xCount, oCount) > 1) {
            println("Impossible")
        }
    }
}

fun main() {
    val inputStr = readln()
    println("---------")
    println("| ${inputStr[0]} ${inputStr[1]} ${inputStr[2]} |")
    println("| ${inputStr[3]} ${inputStr[4]} ${inputStr[5]} |")
    println("| ${inputStr[6]} ${inputStr[7]} ${inputStr[8]} |")
    println("---------")
    generateMessage(inputStr)
}