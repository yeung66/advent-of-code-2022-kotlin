fun main() {
    fun part1(input: List<Int>): Int {
        return input.max()
    }

    fun part2(input: List<Int>): Int {
        return input.sortedDescending().take(3).sum()
    }

    fun parseInput(input: String): List<Int> {
        return input.split("\r\n\r\n").map { part -> part.lines().filter { it.isNotEmpty() }.sumOf { it.toInt() } }
    }

    val input = parseInput(readInput("1"))
    println(part1(input))
    println(part2(input))
}
