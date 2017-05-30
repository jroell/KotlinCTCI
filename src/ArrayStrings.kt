/**
 * Created by jr69473 on 5/29/17.
 */
/**
 * Created by jr69473 on 5/28/17.
 */

package ArraysAndStrings

// Implement an algorithm to determine if a string has all unique characters

fun isUnique(input: String): Boolean {
    // the best way would be to use a hash table or bucket sort/search to determine if we have come across this
    // character so far.

    // make boolean array so store if we've seen a value. Use the value as the index of the array
    var seenChars = arrayOfNulls<Boolean>(256)

    for (char in input){
        if (seenChars[char.toInt()] == true){
            return false
        }
        else {
            seenChars[char.toInt()] = true
        }
    }

    return true
}

fun isPermutation(input: String, input2: String): Boolean {
    if (input.length != input2.length) return false

    var map = mutableMapOf<Char, Int>()
    var map2 = mutableMapOf<Char, Int>()

    for (char in input){
        map.put(char, map.getOrDefault(char, 0) + 1)
    }
    for (char in input2){
        map2.put(char, map2.getOrDefault(char, 0) + 1)
    }

    if (map == map2){
        return true
    }

    return false
}

fun compress(input: String): String {
    // walk the string keeping track of how many of the current letter we've seen before a number
    // once we encounter a different number append the count and the letter to the string
    var count: Int = 0
    var prev: Char? = null
    var compressedString: String = ""

    for (c in input){
        if (c == prev){
            count++
        }
        else{
            when (count) {
                0 -> count += 1
                1 -> compressedString = compressedString + prev
                else -> compressedString = compressedString + count + prev
            }

            if (count != 1){
                count = 1
            }
            prev = c
        }
    }

    when (count) {
        0 -> count += 1
        1 -> compressedString += prev
        else -> compressedString = compressedString + count + prev
    }


    return compressedString
}

fun rotateMatrix(input: Array<Array<Int>>): Array<Array<Int>> {
    var matrix = input
    var length: Int = matrix.size

    for (j in 0 until length/2) {
        var last = length - 1 - j
        for (i in j until last) {
            var top = matrix[j][i]

            var left = matrix[length - i - 1][j]
            matrix[j][i] = left

            var bottom = matrix[length - 1 - j][length - 1 - i]
            matrix[length - i - 1][j] = bottom

            var right = matrix[i][length - 1-j]
            matrix[length - 1 - j][length - 1 - i] = right

            matrix[i][length - 1 - j] = top
        }
    }
    return matrix
}

fun zeroOut(matrix: Array<Array<Int>>): Array<Array<Int>> {
    var columnsWithZeros = mutableListOf<Int>()
    var rowsWithZeros = mutableListOf<Int>()
    for (row in matrix.indices){
        for (column in matrix.indices){
            if (matrix[row][column] == 0){
                columnsWithZeros.add(column)
                rowsWithZeros.add(row)
            }
        }
    }

    for (row in matrix.indices){
        for (column in matrix.indices){
            if (columnsWithZeros.contains(column) || rowsWithZeros.contains(row)){
                matrix[row][column] = 0
            }
        }
    }

    return matrix
}

fun isRotation(input: String, input2: String): Boolean {
    if (input.length != input2.length || input.isBlank()) return false

    var concat = input + input
    return concat.contains(input2)
}


fun main(args: Array<String>) {

//    var matrix = arrayOf(
//            arrayOf(0,2,3,4),
//            arrayOf(1,0,0,4),
//            arrayOf(1,0,3,4),
//            arrayOf(1,2,3,4)
//    )
//
//    var result = zeroOut(matrix)

    println(isRotation("watirbottle", "terbottlewa"))
}


