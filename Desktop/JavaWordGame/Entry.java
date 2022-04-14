import java.io.*;
import java.util.*;
public class Entry
{
    private static Scanner _scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception
    {
        do
        {
            System.out.print("\033[H\033[2J");  
            System.out.println("Tip: guesses are case insensitive");
            System.out.println("Letter colors:\n" 
                + "\t" + Player.ANSI_RED + "Red: " + Player.ANSI_RESET + "wrong letter, wrong position\n"
                + "\t" + Player.ANSI_YELLOW + "Yellow: " + Player.ANSI_RESET + "right letter, wrong position\n"
                + "\t" + Player.ANSI_GREEN + "Green: " + Player.ANSI_RESET + "right letter, right position"
                );
            Player player = new Player(new Table());
            while(!player.makeMove())
            {
                player.printGuesses();
            }
        } while(playAgain());
    }

    private static Boolean playAgain()
    {
        System.out.println("You want to play again? {y|n}");
        String decision = _scanner.nextLine();
        if(decision.toLowerCase().contains("n")) return false;
        else if(decision.toLowerCase().contains("y")) return true;
        return false;
    }
    /// copy-pasted
    ///<summary>
    /// gets a random string from textfile, each string has to start with a new line (except )
    ///<summary>
    public static String choose(File f) throws FileNotFoundException
    {
        String result = null;
        Random rand = new Random();
        int n = 0;
        for(Scanner sc = new Scanner(f); sc.hasNext(); )
        {
            ++n;
            String line = sc.nextLine();
            if(rand.nextInt(n) == 0)
            result = line;         
        }
        return result;      
    }
    ///<summary>
    /// Don't call unless the dictinary you're reading from is empty! Or if you want to read from another file
    ///</summary>
    private static void fillDictionary() throws FileNotFoundException, IOException
    {
        // change dictionary path if you want to install words from another file
        String dictionaryPath = "/usr/share/dict/words";
        String wordCheck;
        FileReader originalDictionary = new FileReader(dictionaryPath);
        BufferedReader bufferedReader = new BufferedReader(originalDictionary);
        FileWriter gameDictionary = new FileWriter("WordBank.txt");
        
        int i = 0;
        // checks each word in the file
        while((wordCheck = bufferedReader.readLine()) != null )
        {
            if(wordCheck.length() == 5)
            {
                i++;
                gameDictionary.write(wordCheck + "\n");
            }
        }
        System.out.println("That's it! " + i + " words should've been added");
        gameDictionary.close();
        bufferedReader.close();
    }
}