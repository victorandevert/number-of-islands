
fun `number of islands`(grid: Array<CharArray>):Int {
    val visitedNodes = grid.copyOf()
        .map { CharArray(it.size){'-'} }
        .toTypedArray()
    var islands = 0
    for (row in grid.indices){
        for (column in 0 until grid[row].size) {
            if ((row == 0 || row < grid.size || column==0 || column<grid[row].size) && grid[row][column] == '1' && visitedNodes[row][column] != '1') {
                visitedNodes[row][column] = '1'
                islands = inspectNode(row, column, grid, visitedNodes, islands)
            }
        }
    }
    return islands
}

fun inspectNode(row: Int, column: Int, grid: Array<CharArray>, visitedNodes: Array<CharArray>, islands: Int): Int {
    Position.values().forEach {
        val newRow = it.row + row
        val newColumn = it.column + column
        if (isNeighbor(newRow, newColumn, grid, row, visitedNodes)) {
            visitedNodes[newRow][newColumn]='1'
            inspectNode(newRow, newColumn, grid, visitedNodes, islands)
        }
    }.also {
        return islands + 1
    }
}

private fun isNeighbor(
    newRow: Int,
    newColumn: Int,
    grid: Array<CharArray>,
    row: Int,
    visitedNodes: Array<CharArray>
) =
    newRow >= 0 && newColumn >= 0 && newRow < grid.size && newColumn < grid[row].size && grid[newRow][newColumn] == '1' && visitedNodes[newRow][newColumn] != '1'
enum class Position(val row: Int, val column: Int){
    UP(-1,0),
    DOWN(1, 0),
    RIGHT(0,1),
    LEFT(0,-1)
}