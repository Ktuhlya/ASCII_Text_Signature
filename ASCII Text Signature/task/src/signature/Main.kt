package signature

val topLiteral= mapOf<String, String>("A" to "____","B" to "___ ","C" to "____","D" to "___ ",
  "E" to "____","F" to "____","G" to "____","H" to "_  _","I" to "_","J" to " _",
  "K" to "_  _","L" to "_   ","M" to "_  _","N" to "_  _","O" to "____","P" to "___ ",
  "Q" to "____","R" to "____","S" to "____","T" to "___","U" to "_  _","V" to "_  _",
  "W" to "_ _ _","X" to "_  _","Y" to "_   _","Z" to "___ "," " to "    ")

val midLiteral= mapOf<String, String>("A" to "|__|","B" to "|__]","C" to "|   ","D" to "|  \\",
  "E" to "|___","F" to "|___","G" to "| __","H" to "|__|","I" to "|","J" to " |",
  "K" to "|_/ ","L" to "|   ","M" to "|\\/|","N" to "|\\ |","O" to "|  |","P" to "|__]",
  "Q" to "|  |","R" to "|__/","S" to "[__ ","T" to " | ","U" to "|  |","V" to "|  |",
  "W" to "| | |","X" to " \\/ ","Y" to " \\_/ ","Z" to "  / "," " to "    ")

val botLiteral= mapOf<String, String>("A" to "|  |","B" to "|__]","C" to "|___","D" to "|__/",
  "E" to "|___","F" to "|   ","G" to "|__]","H" to "|  |","I" to "|","J" to "_|",
  "K" to "| \\_","L" to "|___","M" to "|  |","N" to "| \\|","O" to "|__|","P" to "|   ",
  "Q" to "|_\\|","R" to "|  \\","S" to "___]","T" to " | ","U" to "|__|","V" to " \\/ ",
  "W" to "|_|_|","X" to "_/\\_","Y" to "  |  ","Z" to " /__"," " to "    ")

var word = mutableListOf<MutableList<String>>()

fun main() {

    val name = readln().uppercase().toMutableList()
    val status = readln()
    val maxLenght= if (name.size > status.length) name.size else status.length
   // println()


    DrawLiteral(name.map { it.toString() } as MutableList<String>, name.size)
    DrawAll(name.map { it.toString()} as MutableList<String> , status)




}

class DrawAll(name: MutableList<String>, status: String ) {

//var layoutSize = maxSize(name, status)
//var state = 1

    init {
        maxSize(name, status)
       // printAll(status)
    }
    fun maxSize(name: MutableList<String>, status: String  ) {
        var nameSize = 0
        for (i in name.indices){
            if ((name[i].toString() != "I") && (name[i].toString() != "J") &&
                (name[i].toString() != "T") && (name[i].toString() != "Y") &&
                (name[i].toString() != "W") && (name[i].toString() != " ")) {
                nameSize += 5
            }else{
                if (name[i].toString() == " ") nameSize += 5
                if (name[i].toString() == "I") nameSize += 2
                if (name[i].toString() == "J") nameSize += 3
                if (name[i].toString() == "W") nameSize += 6
                if (name[i].toString() == "T") nameSize += 4
                if (name[i].toString() == "Y") nameSize += 6

            }
        }

      if (nameSize > status.length) printAll(status, nameSize, nameSize, 1)
      else printAll(status, status.length, nameSize, -1 )


      //  return max
    }

    fun printAll(status: String, layoutSize: Int, nameSize : Int, state : Int) {
          var leftSpace = 0
        var rightSpace = 0



        if (state ==1) {
            if ((layoutSize - status.length) % 2 == 0){
                leftSpace = (layoutSize+4 -status.length)/2 -1
                rightSpace =  (layoutSize+4 -status.length)/2
            }else {
                leftSpace = (layoutSize+4 - status.length) / 2
                rightSpace = (layoutSize+4 - status.length) / 2
            }


            println("*".repeat(layoutSize + 5))
            for (i in 0..2) {
                println("*  " +word[i].joinToString(" ") + "  *")
            }
            println("*" + " ".repeat(leftSpace)  +status + " ".repeat(rightSpace)+ "*")
            println("*".repeat(layoutSize + 5))
           //  println(layoutSize + 5)
        }else{
            if ((layoutSize -nameSize ) % 2 == 0){
                leftSpace = (layoutSize+6 - nameSize)/2 -1
                rightSpace =  (layoutSize+6 - nameSize)/2
            }else {
                leftSpace = (layoutSize+6 - nameSize) / 2
                rightSpace = (layoutSize+6 - nameSize) / 2
            }


            println("*".repeat(layoutSize + 6))
            for (i in 0..2) {
                println("*" + " ".repeat(leftSpace)+
                        word[i].joinToString(" ") + " ".repeat(rightSpace) + "*")
            }
            println("*  " +status + "  *")
            println("*".repeat(layoutSize + 6))
            // println(layoutSize + 5)
        }


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
     //   subListTop.add(0, "* ")
     //   subListTop.add(subListTop.size, " *")
        buildString(subListTop)
    }

    fun drawMid(string: MutableList<String>, size: Int) {
        for(i in 0 until size) {
            subListMid.add(i, midLiteral.getValue(string[i]))
        }
     //   subListMid.add(0, "* ")
     //   subListMid.add(subListMid.size, " *")
        buildString(subListMid)
    }

    fun drawBot(string: MutableList<String>, size: Int) {
        for(i in 0 until size) {
            subListBot.add(i, botLiteral.getValue(string[i]))
        }
     //   subListBot.add(0, "* ")
     //   subListBot.add(subListBot.size, " *")
        buildString(subListBot)
    }




}




////

/*

word.add(0, mutableListOf(drawTop("X"), drawTop("u"), drawTop("y")))
    word.add(1, mutableListOf(drawMid("X"), drawMid("u"), drawMid("y")))
    word.add(2, mutableListOf(drawBot("X"), drawBot("u"), drawBot("y")))

 */