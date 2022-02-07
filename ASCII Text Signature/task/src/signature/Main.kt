package signature

import java.io.File

val mediumFile = File("src/medium.txt")
val romanFile = File("src/roman.txt")

//val mediumFile = File("ASCII Text Signature/task/src/medium.txt")
//val romanFile = File("ASCII Text Signature/task/src/roman.txt")

var statusList = mutableListOf<MutableList<String>>()
val nameList = mutableListOf<MutableList<String>>()

var statusSize =0
var nameSize =0

fun main() {

    statusList.add(0, mutableListOf())
    statusList.add(1, mutableListOf())
    statusList.add(2, mutableListOf())
    nameList.add(0, mutableListOf())
    nameList.add(1, mutableListOf())
    nameList.add(2, mutableListOf())
    nameList.add(3, mutableListOf())
    nameList.add(4, mutableListOf())
    nameList.add(5, mutableListOf())
    nameList.add(6, mutableListOf())
    nameList.add(7, mutableListOf())
    nameList.add(8, mutableListOf())
    nameList.add(9, mutableListOf())

    print("Enter name and surname: ")
    val name = readln()!!
    print("Enter person's status: ")
    val status = readln()!!

    WriteToList().splitString(name, romanFile)
    WriteToList().splitString(status, mediumFile)
    DrawAll().checkSize(nameSize, statusSize)
}

class WriteToList() {

    fun splitString(str: String , file: File) {

        for (i in 0 until str.length) {
            if (str[i].toString() == " ") {
                when (file) {
                    mediumFile -> statusList(0, true)
                    romanFile -> nameList(0, true)
                }
            } else {
                findString(str[i].toString(), file)
            }
        }
    }

    fun findString( liter: String, file: File) {
        var indStr = 1
        when {
            ((liter == "d") && (file == romanFile)) -> nameList(35, false)
            ((liter == "o") && (file == romanFile)) -> nameList(156, false)

            else -> {
                for (i in 0 until file.readLines().size) {
                    if (file.readLines()[i].first().toString() == liter) {
                        indStr = i + 1
                    }
                }
                when (file) {
                    mediumFile -> statusList(indStr, false)
                    romanFile -> nameList(indStr, false)
                }
            }
        }
    }

        private fun statusList(indStr: Int, spaceCheck: Boolean) {
            var size = 0
            if (spaceCheck) {
                size = 5
                for (i in 0..2) statusList[i].add("     ")
            } else {
                 size = mediumFile.readLines()[indStr - 1].substring(2).toInt()
                for (i in 0..2) statusList[i].add(mediumFile.readLines()[indStr + i])
            }
            statusSize += size
        }

        private fun nameList(indStr: Int, spaceCheck: Boolean) {
            var size = 0
            if (spaceCheck) {
               size = 10
                for (i in 0..9) nameList[i].add("          ")
            } else {
                 size = romanFile.readLines()[indStr - 1].substring(2).toInt()

                for (i in 0..9) nameList[i].add(romanFile.readLines()[indStr + i])
            }
            nameSize += size
        }
   }

class DrawAll() {

    fun checkSize(nameSize: Int, statusSize: Int) {
        if (nameSize > statusSize) printAll(nameSize, 1) else printAll(statusSize, -1)

    }

    private fun printAll(totalSize: Int, i: Int) {

        if( i > 0) {
            val rightSpace = if ((nameSize - statusSize) % 2 == 0) 0 else 1
            println("8".repeat(totalSize + 8))
            for (i in 0..9) {
                println(
                    "88  " + nameList[i].joinToString("")
                            + "  88"
                )
            }
            for (i in 0..2) {
                println(
                    "88  " + " ".repeat((nameSize - statusSize) / 2)
                            + statusList[i].joinToString("")
                            + " ".repeat((nameSize - statusSize) / 2 + rightSpace)
                            + "  88"
                )
            }
            println("8".repeat(totalSize + 8))
        }

        if( i < 0) {
            val rightSpace = if ((statusSize - nameSize)%2 == 0 ) 0 else 1
            println("8".repeat(totalSize + 8))
            for(i in 0..9) {
                println("88  " + " ".repeat((statusSize- nameSize)/2)
                    + nameList[i].joinToString("")
                        + " ".repeat((statusSize - nameSize)/2 +rightSpace)
                    + "  88")
            }
            for (i in 0..2) {
                println("88  " + statusList[i].joinToString("")
                        + "  88")
            }
            println("8".repeat(totalSize +8))
        }
    }
}














/*

               THE  OLD VERSION


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

    DrawLiteral(name.map { it.toString() } as MutableList<String>, name.size)
    DrawAll(name.map { it.toString()} as MutableList<String> , status)

}

class DrawAll(name: MutableList<String>, status: String ) {

    init {
        maxSize(name, status)
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


 */