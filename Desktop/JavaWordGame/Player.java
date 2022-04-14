import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class Player
{
    private static Scanner _scanner = new Scanner(System.in);
    private Table _playerTable;
    private int _guessCounter = 0;
    private StringBuilder _answerBuilder = new StringBuilder("-----");
    // private String _missPlaced = "";
    private String[] attepmts = new String[5];

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    public Table getTable()
    {
        return _playerTable;
    }
    public Player(Table table)
    {
        _playerTable = table;
    }
    // returns true if the move caused victory
    public boolean makeMove() throws Exception
    {
        // check if you won before the move
        if(_answerBuilder.toString().equals(_playerTable.getGuessWord()))
        {
            return true;
        }
        // declaring player's guess of 5 letters
        System.out.println("Your move: ");
        String yourGuess;
        do
        {
            System.out.print("\t Word of 5 letters: ");
            yourGuess = _scanner.nextLine().toLowerCase();
            System.out.println();
        } while(yourGuess.length() != 5);

        // getting the answer key
        var answerWord = _playerTable.getGuessWord();
        
        // checking each character
        for(int i = 0; i < yourGuess.length(); i++)
        {
            //answer and guess chars are at the same index
            if(answerWord.charAt(i) == yourGuess.charAt(i))
            {
                System.out.println("DEBUG: Char is at the same pos");
                System.out.println("DEBUG: Repeated at index " + i);
                _answerBuilder.replace(i, i+1, Character.toString(yourGuess.charAt(i)));
                System.out.println("DEBUG: String builder: " + _answerBuilder);
            }
            //if the character exists in the answer
            else if(answerWord.indexOf(yourGuess.charAt(i)) != -1)
            {
                System.out.println("DEBUG: Character '" + yourGuess.charAt(i) + "' exists in the answer");
                // // if miss placed string didn't have the character
                // if(_missPlaced.indexOf(yourGuess.charAt(i)) == -1)
                // {
                //     _missPlaced += yourGuess.charAt(i);
                // }
            }
        }
        // your guess if being recorded 
        attepmts[_guessCounter++] = yourGuess;
        // each attempt represents your guess
        for(String attempt : attepmts)
        {
            // skip an attempt if it's null
            if(attempt == null) 
            {
                System.out.println("?????"); 
                break;
            }

            // iterating through each char in the attempt
            for(int i = 0; i < attempt.length(); i++)
            {
                if (attempt.charAt(i) == _playerTable.getGuessWord().charAt(i))
                {
                    // if the character in the guess is at the same pos as the answer's char
                    System.out.print(ANSI_GREEN + attempt.charAt(i));
                }
                else if (answerWord.indexOf(attempt.charAt(i)) != -1)
                {
                    // if the character in the guess exists somewhere in the answer
                    System.out.print(ANSI_YELLOW + attempt.charAt(i));
                }
                else
                {
                    // if the character in the guess wasn't guessed at all
                    System.out.print(ANSI_RED + attempt.charAt(i));
                }
                // resets the color
                System.out.print(ANSI_RESET);
                
            }
            // go on the next line (reset color just in case)
            System.out.println(ANSI_RESET);
        }
        // player wins if the player's guess equals to answer word
        if(_answerBuilder.toString().equals(_playerTable.getGuessWord()))
        {
            return true;
        }
        // loses otherwise
        return false;
    } 

    public void printGuesses()
    {
        System.out.println();
    }
}