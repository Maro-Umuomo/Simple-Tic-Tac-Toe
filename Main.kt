fun checkWinner(input: Array<Array<String>>): MutableList<String> {

    val win1 = "${input[0][0]}${input[0][1]}${input[0][2]}"
    val win2 = "${input[1][0]}${input[1][1]}${input[1][2]}"
    val win3 = "${input[2][0]}${input[2][1]}${input[2][2]}"
    val win4 = "${input[0][0]}${input[1][0]}${input[2][0]}"
    val win5 = "${input[0][1]}${input[1][1]}${input[2][1]}"
    val win6 = "${input[0][2]}${input[1][2]}${input[2][2]}"
    val win7 = "${input[0][0]}${input[1][1]}${input[2][2]}"
    val win8 = "${input[0][2]}${input[1][1]}${input[2][0]}"

    val result = mutableListOf<String>()

    if (win1 == "OOO" || win2 == "OOO" || win3 == "OOO" || win4 == "OOO" || win5 == "OOO" || win6 == "OOO" || win7 == "OOO" || win8 == "OOO")
    {
        result.add("O")
    }
    else if (win1 == "XXX" || win2 == "XXX" || win3 == "XXX" || win4 == "XXX" || win5 == "XXX" || win6 == "XXX" || win7 == "XXX" || win8 == "XXX")
    {
        result.add("X")
    }
    return  result
}

fun printScreen(inputArray: Array<Array<String>>){
    println("---------")
    println("| ${inputArray[0][0]} ${inputArray[0][1]} ${inputArray[0][2]} |")
    println("| ${inputArray[1][0]} ${inputArray[1][1]} ${inputArray[1][2]} |")
    println("| ${inputArray[2][0]} ${inputArray[2][1]} ${inputArray[2][2]} |")
    println("---------")
}

fun playUser(x: Int, y: Int, player: Int, inputArray: Array<Array<String>>): Boolean {

    return if(inputArray[x][y] == " ") {
        when (player) {
            1 -> inputArray[x][y] = "X"
            2 -> inputArray[x][y] = "O"
        }
        true
    }
    else false
}

fun notFull(inputArray: Array<Array<String>>): Boolean {
    var counts = 0

    for (array in inputArray) {
        counts += array.count{it == " "}
    }
    return counts > 0
}

fun getValidUserInput(player: Int, inputArray: Array<Array<String>>, play: (Int, Int, Int, Array<Array<String>>) -> Boolean): Boolean{
    var inputStr: String
    var xCord: Int
    var yCord: Int

    while (true)
    {
        inputStr = readln()
        if (inputStr.length < 3) {
            println("Invalid Entry! Enter another coordinate")
            continue
        }
        else if ( !inputStr[0].isDigit()  || !inputStr[2].isDigit() ) {
            println("You should enter numbers!")
            continue
        }

        val (x,y) = inputStr.split(" ")

        if (x.toInt() in 1..3 && y.toInt() in 1..3)
        {
            xCord = x.toInt()
            yCord = y.toInt()
            --xCord
            --yCord
            if (play(xCord, yCord, player, inputArray))
                break
            else {
                println("This cell is occupied! Choose another one!")
                continue
            }
        }
        else {
            println("Coordinates should be from 1 to 3!")
            continue
        }
    }
    return true
}

fun generateMessage(input: Array<Array<String>>) {
    val results = checkWinner(input)

    if (results.size == 1) {
        if (results.contains("O")) println("O wins")
        else if(results.contains("X")) println("X wins")
    } else if (results.size > 1)
        println("Impossible")
    else if (results.size == 0) {
        println("Draw")
    }
}

fun getPlayer(count: Int): Int = (count % 2) + 1

fun main() {

    var count = 0   //Add 1 to determine if it's player 1 or 2.
    var player: Int

    val inputArray = arrayOf(
        arrayOf(" ", " ", " "),
        arrayOf(" ", " ", " "),
        arrayOf(" ", " ", " "),
    )
    printScreen(inputArray)

    while (checkWinner(inputArray).size == 0 && notFull(inputArray))
    {
        player = getPlayer(count)
        if (getValidUserInput(player, inputArray, ::playUser)) {
            ++count
        }
        printScreen(inputArray)
    }
    generateMessage(inputArray)
}