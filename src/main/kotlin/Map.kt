
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

    if (row+1<grid.size && grid[row+1][column]=='1' && visitedNodes[row+1][column] != '1') {
        visitedNodes[row+1][column]='1'
        inspectNode(row+1, column, grid, visitedNodes, islands)
    }
    if (column+1<grid[row].size && grid[row][column+1]=='1' && visitedNodes[row][column+1] != '1') {
        visitedNodes[row][column+1]='1'
        inspectNode(row, column+1, grid, visitedNodes, islands)
    }
    if (row-1>=0 && grid[row-1][column]=='1' && visitedNodes[row-1][column] != '1') {
        visitedNodes[row-1][column]='1'
        inspectNode(row-1, column, grid, visitedNodes, islands)
    }
    if (column-1>=0 && grid[row][column-1]=='1' && visitedNodes[row][column-1] != '1') {
        visitedNodes[row][column-1]='1'
        inspectNode(row, column-1, grid, visitedNodes, islands)
    }

   return islands+1

}