fun main() {
    fun getPriority(c: Char): Int = when(c) {
        in ('a'..'z') -> c - 'a' + 1
        else -> c - 'A' + 27
    }

    fun part1(input: List<String>): Int {
        return input.sumOf { it.subSequence(0, it.length / 2).toSet().intersect(it.subSequence(it.length / 2, it.length).toSet()).map(::getPriority)[0] }
    }

    fun part2(input: List<String>): Int {
        return input.withIndex().groupBy { it.index / 3 }.map {
            val (a, b, c) = it.value.map { x -> x.value.toSet() }
            a.intersect(b.intersect(c)).map(::getPriority)[0]
        }.sum()
    }

    val input = readInputLines("3")
    println(part1(input))
    println(part2(input))
}
