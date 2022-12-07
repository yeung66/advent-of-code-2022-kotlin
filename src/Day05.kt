fun main() {
    val stacks = listOf(ArrayDeque<Char>(), ArrayDeque("DBJV".toList()), ArrayDeque("PVBWRDF".toList()), ArrayDeque("RGFLDCWQ".toList()),
        ArrayDeque("HNBPCSQ".toList()),ArrayDeque("ZBPMQFSH".toList()), ArrayDeque("SVFMR".toList()))

    fun parse(input: String): List<List<Int>> {
        return input.lines().map { line ->
            val parts = line.split(" ")
            listOf(parts[1], parts[3], parts[5]).map { it.toInt() }
        }.toList()
    }

    fun part1(input: List<List<Int>>): String {
        input.forEach {op ->
            (1..op[0]).forEach {
                stacks[op[2]].addLast(stacks[op[1]].removeLast())
            }
        }

        return stacks.filter { it.isNotEmpty() }.map { it.last() }.toString()
    }


    val input = parse(readInput("5"))
    println(part1(input))
//    println(part2(input))
}
