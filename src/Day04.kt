fun main() {
    fun parse(input: String): List<List<List<Int>>> {
        return input.lines().map { line -> line.split(",").map { range -> range.split("-").map {it.toInt()}} }.toList()
    }

    fun part1(input: List<List<List<Int>>>): Int {
        return input.map {
            val (a, b) = it
            if (a[0] >= b[0] && a[1] <= b[1] || b[0] >= a[0] && b[1] <= a[1]) 1 else 0
        }.sum()
    }

    fun part2(input: List<List<List<Int>>>): Int {
        return input.map {
            val (a, b) = it
            if (a[1] < b[0] || b[1] < a[0]) 0 else 1
        }.sum()
    }

    val input = parse(readInput("4"))
    println(part1(input))
    println(part2(input))
}
