import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src/input", "$name.txt").readText()

fun readInputLines(name: String) = File("src/input", "$name.txt")
    .readLines()