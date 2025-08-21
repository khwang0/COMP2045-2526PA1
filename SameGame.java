import java.util.Scanner;
// Add your suitable imports here
// Remember your code should be using Java 11 features only without the use of var keyword


/**
 * @author: ______your name here (SID)_________
 *
 *          For the instruction of the assignment please refer to the assignment
 *          GitHub.
 *
 *          Plagiarism is a serious offense and can be easily detected. Please
 *          don't share your code to your classmate even if they are threatening
 *          you with your friendship. If they don't have the ability to work on
 *          something that can compile, they would not be able to change your
 *          code to a state that we can't detect the act of plagiarism. For the
 *          first commit of plagiarism, regardless you shared your code or
 *          copied code from others, you will receive 0 with an addition of 5
 *          mark penalty. If you commit plagiarism twice, your case will be
 *          presented in the exam board and you will receive a F directly.
 *
 *          Terms about generative AI:
 *          You are not allowed to use any generative AI in this assignment.
 *          The reason is straight forward. If you use generative AI, you are
 *          unable to practice your coding skills. We would like you to get
 *          familiar with the syntax and the logic of the Java programming.
 *          We will examine your code using detection software as well as
 *          inspecting your code with our eyes. Using generative AI tool
 *          may fail your assignment.
 *
 *          If you cannot work out the logic of the assignment, simply contact
 *          us on Discord. The teaching team is more the eager to provide
 *          you help. We can extend your submission due if it is really
 *          necessary. Just please, don't give up.
 */
public class SameGame {

    static final char EMPTY = ' ';
    static final char SELECTED = '*';
    static final char[] SYMBOLS = {EMPTY, '@', '=', '^', '+'};

    //for testing purpose we might change to the following, or other arrays
//    static final char[] SYMBOLS = {EMPTY, '@', '='};

    static final int MAX_ROW = 10;
    static final int MAX_COL = 26;
    // Store the top score file in this file at your current path
    // Create such file if it does not exist
    static final String TOP_SCORE_FILE = "top_scores.txt";

    public static void main(String[] args) {
        new SameGame().startGame();
    }
    void startGame() {
        char[][] gameboard = new char[MAX_ROW][MAX_COL];
        randomizeBoard(gameboard);
        printHelp();

        Scanner scanner = new Scanner(System.in);
        int score = 0;
        char[][] selectedBoard;
        while (!isGameOver(gameboard)) {
            printBoard(gameboard);
            System.out.print("Enter your move in the format column-row, e.g. A-5, or press 'h' for help, 'q' to quit: ");
            String input = scanner.nextLine().trim();
            selectedBoard = null;
            switch (input) {
                case "h":
                    printHelp();
                    break;
                case "q":
                    System.out.println("Your score is: " + score);
                    System.out.println("Thank you for playing SameGame!");
                    return;
                case "r":
                    randomizeBoard(gameboard);
                    score = 0; // Reset score on restart
                    printBoard(gameboard);
                    break;
                case "t":
                    System.out.println("Tips: selected the biggest segment of blocks for you..");
                    selectedBoard = selectBiggestSegment(gameboard);
                    //continue in default case
                default:
                    // TODO
                    // Check if the input is in the format of "A-5" or similar
                    // Then call the appropriate methods to
                    // 1. Validate the selection if it is a valid selection
                    // 2. If valid, print the number of blocks being selected and
                    //    copy the gameboard to the variable selectedBoard
                    // 3. If it is invalid, print an error message and continue to the next iteration
                    // 4. If the selectedBoard is set, either through the "t" command or a valid selection,
                    //    print the selectedBoard and ask for confirmation to remove the selected blocks
                    // 5. If confirmed, increase the score and remove the selected blocks from the gameboard
                    // 6. If not confirmed, print a message and continue to the next iteration
            }
        }
        System.out.println("\n\n");
        printBoard(gameboard); //after the game is over, print the final board again.

        System.out.println("Game over! Your final score is: " + score);
        topscorer(score); //to display the top scores and save the current score if applicable
    }
    /**
     * This method is to load the top score and update the top score to a file.
     * 
     * The method shall read from the file TOP_SCORE_FILE and load the top score
     * display the top five scores including the score from the current game on screen.
     * Then it shall save the top five scores to the file TOP_SCORE_FILE.
     * 
     * The format of the file shall be
     * KEV 1100
     * JON 900
     * SAN 884
     * JIM 700
     * CH 500
     * 
     * Each line contains an upper case name with at least 1 character and at most 3 characters,
     * followed by a space and then the score which is an integer. The file shall be sorted
     * by the score in descending order. It is possible that the file contains less than five lines.
     * 
     * When the player's score is in the top five, the player will be prompted to enter their name
     * to save the score. The name must be an upper case string with at least 1 character and 
     * at most 3 characters or it will be rejected. If the name is valid, the score will 
     * be saved to the file.
     * 
     * 
     * @param score is the score to be saved.
     */
    void topscorer(int score) {
        //TODO
    }

    /**
     * This method is to compute the score based on the number of blocks removed.
     * 
     * The score is computed based on the number of blocks removed. The score is
     * calculated as follows:
     *  Let n be the number of blocks removed. The base score is n * (n + 1). For
     * each column of blocks that is completely removed, an additional 10 points 
     * are added to the score. 
     * 
     * 
     * 
     * @param gameboard is a 2D char array that is always non-null and pointed to a
     *                   rectangular area.
     * @return the score
     */
    int computeScore(char[][] gameboard) {
        //TODO
    }
    /**
     * This method is to select the biggest segment of blocks that can be selected.
     * 
     * The method will iterate through the gameboard and find the biggest segment of 
     * blocks that can be selected. It will return a new gameboard with the selected 
     * blocks marked as SELECTED. If there are multiple segments with the same size,
     * any one of them can be returned.
     * 
     * @param gameboard is a 2D char array that is always non-null and pointed to a
     *                   rectangular area.
     * @return a new gameboard with the selected blocks marked as SELECTED.
     */
    char[][] selectBiggestSegment(char[][] gameboard) {
        //TODO
    }
    /**
     * Copy the 2D char array to a new 2D char array.
     * 
     * This method will create a new 2D char array that is the same size as the
     * parameter src. It will copy the content of the src to the new array.
     * 
     * @param src is a 2D char array that is always non-null and pointed to a
     *             rectangular area.
     * @return a new 2D char array that is a copy of the src.
     */
    char[][] copyArray(char[][] src) {
        //TODO
    }
    /**
     * This method is to print the help menu.
     * 
     * By referring to the startGame method, create a proper printHelp method
     */
    void printHelp() {
        //TODO
    }
    /**
     * This method is to print the game board with the coordinate labels.
     * 
     * The first column and the last column should be the y-coordinate labeled from "0" to "9".
     * The first row and the last row should be the x-coordinate labeled from "A" to "?" where "?"
     * is the n-th character counts from "A" and n is the total number of column of the gameboard.
     * 
     * At the beginning, the game board has MAX_COL (which is 26) columns. However, when the 
     * game keep playing, the game board may shrink horizontally. The game board will never shrink 
     * vertically, i.e., it will always display MAX_ROW (which is 10) rows of blocks even if some 
     * rows are empty.
     * 
     * The content of the game board should be printed inside the coordinate borders. The symbols of the label
     * should be referred to the constant SYMBOLS.
     * 
     * We can assume that the size of the gameboard will never be null and is always pointed 
     * to a rectangular char array.
     * 
     * If the player plays very well, the game board may be empty at the end of the game, i.e., 
     * it has no columns. In this case, the method should print a message saying "Gameboard is empty."
     */
    void printBoard(char[][] gameboard) {
        //TODO
    }
    /**
     * This method determine if the position that being selected is a valid selection
     * 
     * - If the position being selected is out of the board, it is invalid. i.e., it must be a valid 
     * coordinate with row between 0 to 9, and column between 'A' to 'Z'.
     * - If the position being selected does not contain a block, it is invalid.
     * - If the block on the selected position does not have the same type of block in its immediate 
     * up/down/left/right position, it is invalid. That means, this is an isolated block that cannot
     * be cancelled with another block.
     * - Otherwise, it is a valid selection.
     * 
     *
     * @param gameboard is a 2D char array that is always non-null and pointed to a
     *                   rectangular area.
     * @param row is the row of the selected block, which should be between 0 and 9.
     * @param column is the column of the selected block, which should be between 'A' and 'Z'.
     * @return The method should return true if it is a valid selection, false if it is not.
     *
     */
    boolean isValidSelection(char[][] gameboard, int row, char column) {
        //TODO
    }

    /**
     * This method change the gameboard by turning the selected blocks to the symbol SELECT and 
     * returns the number of blocks that are selected.
     * 
     * We assume that the selected position is valid when we call this method. (Valid, please refer to 
     * the description of is ValidSelection). This method will create a new 2D char array that is the
     * same size as the parameter gameboard. It turns the selected blocks and its adjacent blocks that 
     * share the same type to the symbol SELECT. 
     * 
     * You are expected to implement this method without using recursion.
     * 
     * 
     * @param gameboard the input gameboard
     * @param row the row of the selected block
     * @param column the column of the selected block
     * 
     * @return the number of blocks that are selected, which is the number of blocks that are turned to SELECTED.
     */
    int select(char[][] gameboard, int row, char column) {
        //TODO
    }

    /**
     * This method is to remove the selected blocks from the gameboard. Please refer to the rule
     * of the game on how blocks are removed and the subsequent shrinking of the gameboard, if any.
     * 
     * After the method, the content of the original gameboard (pointed by the parameter) is 
     * not important anymore. You are free to modify the content of the original gameboard.
     * 
     * @param gameboard
     * @return the new gameboard after removing the selected blocks.
     */
    char[][] removeSelected(char[][] gameboard) {
        //TODO
    }
    /**
     * This method is to check if the game is over.
     * 
     * The game is over when there is no valid selection left on the gameboard.
     * 
     * @param gameboard
     * @return true if the game is over, false otherwise.
     */
    boolean isGameOver(char[][] gameboard) {
        //TODO
    }

    /**
     * This method is to randomize the gameboard with the symbols defined in SYMBOLS.
     * 
     * The method will fill the gameboard with random symbols from SYMBOLS except for the EMPTY symbol.
     * @param gameboard is a 2D char array that is always non-null and pointed to a
     *                   rectangular area.
     */
    void randomizeBoard(char[][] gameboard) {
        //TODO
    }
}