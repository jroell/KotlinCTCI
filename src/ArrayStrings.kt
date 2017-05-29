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

// test isUnique function
fun main(args: Array<String>) {
//    var falseInput = "RaceCar"
//    var trueInput = "Jason"
//    println(isUnique(falseInput))
//    println(isUnique(trueInput))
//
    var input = "Jason"
    var input2 = "nosaJ"

    println(isPermutation(input, input2))

}

fun isPermutation(input: String, input2: String): Boolean {
    // we know something is a permutation if it contains all of the same chars with the same frequency
    // the easiest way to determine this is to first check if inputs are same length
    // if they are then use a hash map to store the fequency of all the characters
    // check hashmaps for equality

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

