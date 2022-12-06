fun main() {
    val winRelations = hashMapOf(0 to 2, 1 to 0, 2 to 1)

    fun part1(input: List<Pair<Int, Int>>): Int {
        return input.sumOf {
            val (theirs, yours) = it
            val score = when (theirs) {
                yours -> 3
                winRelations[yours]!! -> 6
                else -> 0
            }
            score + yours + 1
        }
    }

    fun part2(input: List<Pair<Int, Int>>): Int {
        return input.sumOf {
            val (theirs, strategy) = it
            val yours = when (strategy) {
                0 -> winRelations[theirs]!!
                1 -> theirs
                else -> 3 - theirs - winRelations[theirs]!!
            }

            yours + 1 + strategy * 3
        }
    }

    fun parseInput(input: List<String>): List<Pair<Int, Int>> {
        return input.map {
            val chars = it.toCharArray()
            val theirs = chars[0]
            val yours = chars[2]
            Pair<Int, Int>(theirs - 'A', yours - 'X')
        }.toList();
    }

    val input = parseInput(readInputLines("2"))

    println(part1(input))
    println(part2(input))
}
