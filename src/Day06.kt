fun main() {
    fun part1(input: String): Int {
        for (i in 0..input.length) {
            if (input.subSequence(i, i + 4).toSet().size == 4) {
                return i + 4
            }
        }

        return 0
    }

    fun part2(input: String): Int {
        for (i in 0..input.length) {
            if (input.subSequence(i, i + 14).toSet().size == 14) {
                return i + 14
            }
        }

        return 0
    }

    val input = readInput("6")
    println(part1(input))
    println(part2(input))
}
