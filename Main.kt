package tictactoe

fun formatStrings(input: String): String = input.replace('_', ' ')

fun printScreen(inputArray: Array<Array<String>>){
    println("---------")
    println("| ${inputArray[0][0]} ${inputArray[0][1]} ${inputArray[0][2]} |")
    println("| ${inputArray[1][0]} ${inputArray[1][1]} ${inputArray[1][2]} |")
    println("| ${inputArray[2][0]} ${inputArray[2][1]} ${inputArray[2][2]} |")
    println("---------")
}

fun playUser(x: Int, y: Int, inputArray: Array<Array<String>>): Boolean {

    if(inputArray[x][y] == " ") {
        inputArray[x][y] = "X"
        return true
    }
    else return false
}

fun main() {
    val inputArray = arrayOf(
        arrayOf(" ", " ", " "),
        arrayOf(" ", " ", " "),
        arrayOf(" ", " ", " "),
    )

    var inputString = readln()
    inputString = formatStrings(inputString)

    inputArray[0][0] = inputString[0].toString()
    inputArray[0][1] = inputString[1].toString()
    inputArray[0][2] = inputString[2].toString()
    inputArray[1][0] = inputString[3].toString()
    inputArray[1][1] = inputString[4].toString()
    inputArray[1][2] = inputString[5].toString()
    inputArray[2][0] = inputString[6].toString()
    inputArray[2][1] = inputString[7].toString()
    inputArray[2][2] = inputString[8].toString()

    printScreen(inputArray)
    var inputStr = readln()

    while (true)
    {
        if (inputStr[0].isDigit() && inputStr[2].isDigit())
            break
        println("You should enter numbers!")
        inputStr = readln()
    }

    var xCord: Int
    var yCord: Int

    while (true)
    {
        var (x,y) = inputStr.split(" ")
        if (x.toInt() in 1..3 && y.toInt() in 1..3)
        {
            xCord = x.toInt()
            yCord = y.toInt()
            --xCord
            --yCord
            if (playUser(xCord, yCord, inputArray))
                break
            else {
                println("This cell is occupied! Choose another one!")
            }

        } else {
            println("Coordinates should be from 1 to 3!")
        }
        inputStr = readln()
    }

    printScreen(inputArray)
}