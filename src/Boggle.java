import java.util.ArrayList;
import java.util.Arrays;

public class Boggle {
    /**
     * - Letters CAN"T be used more than once in a word.
     * - No diagonal letters, only cardinal directions can be used
     *
     * Ideas?
     * - perhaps incorporate recursion?
     * - Incorporate TST or Trie
     * -> Dictionary and "good words" TSTs
     * - use bfs?
     * -> each path would need a "travel log" keeping track of places it's been on the board
     *
     * - use dfs?
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

        //Begin to






        // Convert the list into a sorted array of strings of all dictionary words found in the board, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        return sol;
    }
}
