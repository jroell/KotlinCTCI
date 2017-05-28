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

// test function
fun main(args: Array<String>) {
    var falseInput = "RaceCar"
    var trueInput = "Jason"
    println(isUnique(falseInput))
    println(isUnique(trueInput))
}