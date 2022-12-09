fun main() {

    data class Directory(val path: String, var size: Int = 0, val children: MutableList<Directory> = mutableListOf())
    class Path {
        val levels = mutableListOf<String>()
        fun toPath(): String {
            return "/" + levels.joinToString("/")
        }

        fun genSub(sub: String): String {
            levels.add(sub)
            val ans = toPath()
            levels.removeAt(levels.size - 1)
            return ans
        }

        fun cd(path: String) {
            when (path) {
                ".." -> levels.removeAt(levels.size - 1)
                "/" -> levels.clear()
                else -> levels.add(path)
            }
        }
    }

    val records = hashMapOf<String, Directory>()

    fun parse(input: String) {
        val lines = input.lines()
        var i = 0
        val curPath = Path()
        while (i < lines.size) {

            val command = lines[i].split(" ")
            i++
            if (command.size == 3) {
                val (_, _, path) = command
                curPath.cd(path)
            } else {
                val dir = Directory(curPath.toPath())
                while (i < lines.size && !lines[i].startsWith("$")) {

                    if (lines[i].startsWith("dir")) {
                        val (_, path) = lines[i].split(" ")
                        val subdir = Directory(curPath.genSub(path))
                        dir.children.add(subdir)
                    } else {
                        val (size, _) = lines[i].split(" ")
                        dir.size += size.toInt()
                    }


                    i++
                }
                records[curPath.toPath()] = dir
            }

        }
    }

    val sizes = hashMapOf<String, Int>()
    fun cntSize(path: String): Int {
        if (sizes.containsKey(path)) {
            return sizes[path]!!
        }

        val dir = records[path]!!
        var size = dir.size
        for (child in dir.children) {
            size += cntSize(child.path)
        }

        sizes[path] = size
        return size
    }

    fun part1(): Int {
        var ans = 0
        for (path in records.keys) {
            val size = cntSize(path)
            if (size <= 100000) {
                ans += size
            }
        }
        return ans
    }

    fun part2(): Int {
        val total = sizes["/"]!!
        val needReleased = 30000000 - (70000000 - total)
        val sorted = sizes.toList().sortedBy { it.second }
        var i = 0
        while (i < sorted.size && sorted[i].second < needReleased) {
            i++
        }
        return sorted[i].second
    }

    val input = readInput("7")
    parse(input)

    println(part1())
    println(part2())
}
