import java.util.ArrayList;
import java.util.Arrays;

public class Boggle {
    /**
     * - Letters CAN"T be used more than once in a word.
     * - No diagonal letters, only cardinal directions can be used
     *
     * Ideas?
     * - incorporate recursion?
     * - Incorporate TST or Trie
     * -> Dictionary and "good words" TSTs
     * - use bfs?
     * -> each path would need a "travel log" keeping track of places it's been on the board
     *
     * - use dfs?
     * -> We talked about how to use this in class, incorporate using slides
     * -> parent node structure so that we can traverse in reverse using the parental nodes.
     * -> Go all the way down, and if it's a deadend, go back and check if the other available options would form a word.
     *
     * - Is it a good idea to remove a "good word" after it has been found in the board?
     *
     * I need some way to know when to stop; use a while loop?
     */
    public static String[] findWords(char[][] board, String[] dictionary) {
        // TODO: Complete the function findWords(). Add all words that are found both on the board
        //  and in the dictionary.
        //First char of the first word in the dictionary
        char currentChar = dictionary[0].charAt(0);

        //Array list of dictionary words found in board.
        ArrayList<String> goodWords = new ArrayList<String>();

        TST johnMilton = new TST();
        //Subsection: Go down through the board until we find every word.
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                dfs(board, i, j);
            }
        }



        // Convert the list into a sorted array of strings of all dictionary words found in the board, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        return sol;
    }

    // possible DFS implementation
    public static void dfs(char[][] grid, int row, int col)
    {
        //out of bounds base case, making sure we stay inside grid.
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
        {
            return;
        }
        //base case; checking if we've visited this square before
        if (grid[row][col] == '0')
        {
            return;
        }
        //base case for invalid prefix?

        /**
         * Step 1: Build words and append along the way
         * Step 2: Check if findWords is working by having it print things out
         * Step 3:
          */
        char testCaseWordThing = '';
        //If it isn't caught in the two base cases, mark square as visited.
        char placeholder = grid[row][col];
        grid[row][col] = '0';

        //recurse
        //Modify dfs so that whenever we're recursing, we're appending to the word
        // so that each successive call the word gets bigger.
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);

        // mark this square as NOT visited
        grid[row][col] = placeholder;
    }

//    public int numIslands(char[][] grid)
//    {
//        int count = 0;
//
//        for(int i = 0; i < grid.length; i++)
//        {
//            for(int j = 0; j < grid[0].length; j++)
//            {
//                if (grid[i][j] == '1')
//                {
//                    dfs(grid, i, j);
//                    count++;
//                }
//            }
//        }
//
//        return count;
//    }
}
