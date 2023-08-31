package tictactoe

fun main() {
    val inputArray = arrayOf(
        arrayOf("X", "O", "X"),
        arrayOf("O", "X", "O"),
        arrayOf("X", "X", "O")
    )

    val row = 3
    val column = 3

    for (rowIndex in 0..row - 1) {
        for (columnIndex in 0..column - 1) {
            print("${inputArray[rowIndex][columnIndex]} ")
        }
        println()
    }
}