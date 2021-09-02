
fun numberOfIslands(grid: Array<CharArray>):Int {
    val visitedNodes = grid.copyOf()
        .map { CharArray(it.size){'-'} }
        .toTypedArray()
    var islands = 0

    grid.indices.forEach { row ->
       grid[row].indices.forEach { column ->
           when {
               isBorderNode(row, column, grid) && isValidNode(row, column, grid) && isUnvisitedNode(row, column, visitedNodes) ->
                   islands = inspectNode(row, column, grid, visitedNodes, islands)
           }
        }
    }
    return islands
}

private fun inspectNode(row: Int, column: Int, grid: Array<CharArray>, visitedNodes: Array<CharArray>, islands: Int): Int {
    Position.values().forEach {
        val newRow = it.row + row
        val newColumn = it.column + column
        when {
            isNeighbor(newRow, newColumn, grid, visitedNodes) -> {
                addVisitedNode(newRow, newColumn, visitedNodes)
                inspectNode(newRow, newColumn, grid, visitedNodes, islands)
            }
        }
    }.also { return islands + 1 }
}

private fun addVisitedNode(newRow: Int, newColumn: Int, visitedNodes: Array<CharArray>) {
    visitedNodes[newRow][newColumn] = '1'
}

private fun isBorderNode(row: Int, column: Int, grid: Array<CharArray>) =
    row >= 0 && column >= 0 && row < grid.size && column < grid[row].size

private fun isValidNode(row: Int, column: Int, grid: Array<CharArray>) = grid[row][column] == '1'

private fun isUnvisitedNode(row: Int, column: Int, grid: Array<CharArray>) = !isValidNode(row, column, grid)

private fun isNeighbor(newRow: Int, newColumn: Int, grid: Array<CharArray>, visitedNodes: Array<CharArray>) =
    isBorderNode(newRow, newColumn, grid) &&
    isValidNode(newRow, newColumn, grid) &&
    isUnvisitedNode(newRow, newColumn, visitedNodes)

enum class Position(val row: Int, val column: Int){
    UP(-1,0),
    DOWN(1, 0),
    RIGHT(0,1),
    LEFT(0,-1)
}