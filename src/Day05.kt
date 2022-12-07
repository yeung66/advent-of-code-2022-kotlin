fun main() {
    fun initStacks() = listOf(ArrayDeque(), ArrayDeque("DBJV".toList()), ArrayDeque("PVBWRDF".toList()), ArrayDeque("RGFLDCWQ".toList()), ArrayDeque("WJPMLNDB".toList()),
        ArrayDeque("HNBPCSQ".toList()), ArrayDeque("RDBSNG".toList()), ArrayDeque("ZBPMQFSH".toList()), ArrayDeque("WLF".toList()), ArrayDeque("SVFMR".toList()))

    fun parse(input: String): List<List<Int>> {
        return input.lines().map { line ->
            val parts = line.split(" ")
            listOf(parts[1], parts[3], parts[5]).map { it.toInt() }
        }.toList()
    }

    fun part1(input: List<List<Int>>): String {
        val stacks = initStacks()
        input.forEach {op ->
            (1..op[0]).forEach {
                stacks[op[2]].addLast(stacks[op[1]].removeLast())
            }
        }

        return stacks.filter { it.isNotEmpty() }.map { it.last() }.joinToString(separator = "")
    }

    fun part2(input: List<List<Int>>): String {
        val stacks = initStacks()
        input.forEach {op ->
            val temp = mutableListOf<Char>()
            (1..op[0]).forEach {
                temp.add(stacks[op[1]].removeLast())
            }
            stacks[op[2]].addAll(temp.reversed())
        }

        return stacks.filter { it.isNotEmpty() }.map { it.last() }.joinToString(separator = "")
    }


    val input = parse(readInput("5"))
    println(part1(input))
    println(part2(input))
}
