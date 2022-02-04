package signature

val topLiteral= mapOf<String, String>("A" to "____","B" to "___ ","C" to "____","D" to "___ ",
  "E" to "____","F" to "____","G" to "____","H" to "_  _","I" to "_","J" to " _",
  "K" to "_  _","L" to "_   ","M" to "_  _","N" to "_  _","O" to "____","P" to "___ ",
  "Q" to "____","R" to "____","S" to "____","T" to "___","U" to "____","V" to "_  _",
  "W" to "_ _ _","X" to "_  _","Y" to "_   _","Z" to "___ ")

val midLiteral= mapOf<String, String>("A" to "|__|","B" to "|__]","C" to "|   ","D" to "|  \\",
  "E" to "|___","F" to "|___","G" to "| __","H" to "|__|","I" to "|","J" to " |",
  "K" to "|_/ ","L" to "|   ","M" to "|\\/|","N" to "|\\ |","O" to "|  |","P" to "|__]",
  "Q" to "|  |","R" to "|__/","S" to "[__ ","T" to " | ","U" to "|  |","V" to "|  |",
  "W" to "| | |","X" to " \\/ ","Y" to " \\_/ ","Z" to "  /")

val botLiteral= mapOf<String, String>("A" to "|  |","B" to "|__]","C" to "|___","D" to "|__/",
  "E" to "|___","F" to "|   ","G" to "|__]","H" to "|  |","I" to "|","J" to "_|",
  "K" to "| \\_","L" to "|___","M" to "|  |","N" to "| \\|","O" to "|__|","P" to "|   ",
  "Q" to "|_\\|","R" to "|  \\","S" to "___]","T" to " | ","U" to "|__|","V" to " \\/ ",
  "W" to "|_|_|","X" to "_/\\_","Y" to "  |  ","Z" to " /__")

var word = mutableListOf<MutableList<String>>()

fun main() {
//  val firstName = readln()
    //val status = readln()
    // val long = if (firstName.length > status.length) firstName.length else status.length
    //  var topBotton = "*".

    val name = readln().uppercase().toMutableList()

    DrawLiteral(name.map { it.toString() } as MutableList<String>, name.size)

    for (i in 0..2) {
        println(word[i].joinToString(" "))

    }
}



class DrawLiteral(string: MutableList<String>, size: Int) {
var subListTop = mutableListOf<String>()
var subListMid = mutableListOf<String>()
var subListBot = mutableListOf<String>()
    init {
        drawTop(string, size)
        drawMid(string, size)
        drawBot(string, size)
    }


   fun buildString(string: MutableList<String>) {

       word.add(0, subListTop)
       word.add(1, subListMid)
       word.add(2, subListBot)


   }


    fun drawTop(string: MutableList<String>, size: Int) {
       for(i in 0 until size) {
          subListTop.add(i, topLiteral.getValue(string[i]))
       }
        buildString(subListTop)
    }

    fun drawMid(string: MutableList<String>, size: Int) {
        for(i in 0 until size) {
            subListMid.add(i, midLiteral.getValue(string[i]))
        }
        buildString(subListMid)
    }

    fun drawBot(string: MutableList<String>, size: Int) {
        for(i in 0 until size) {
            subListBot.add(i, botLiteral.getValue(string[i]))
        }
        buildString(subListBot)
    }




}




////

/*

word.add(0, mutableListOf(drawTop("X"), drawTop("u"), drawTop("y")))
    word.add(1, mutableListOf(drawMid("X"), drawMid("u"), drawMid("y")))
    word.add(2, mutableListOf(drawBot("X"), drawBot("u"), drawBot("y")))

 */