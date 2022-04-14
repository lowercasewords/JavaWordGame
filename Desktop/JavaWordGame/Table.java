import java.util.*;
import java.util.regex.*;
import java.io.*;
public class Table 
{
    private String _guessWord;
    private FileReader fileReader;
    private File file;
    private Pattern _counter = Pattern.compile("\\w{5}");
    private Matcher _matcher;

    public String getGuessWord()
    {
        return _guessWord;
    }
    //1. reads a file from specified text
    //2. assigns the guess word
    public Table(String wordBankDirPath) throws IOException
    {
        file = new File(wordBankDirPath);
        fileReader = new FileReader(file);
        restartGuessWord();
    }
    // uses default word bank text file, NOTE: all changes should go to another constructor
    public Table() throws IOException
    {
        this("/Users/arturagalarian/Desktop/JavaWordGame/WordBank.txt");
    }

    public void restartGuessWord() throws FileNotFoundException
    {
        _guessWord = choose();
    }
    // yes, I copy-pasted this what will you do about it?
    public String choose() throws FileNotFoundException
    {
        String result = null;
        Random rand = new Random();
        int n = 0;
        for(Scanner sc = new Scanner(file); sc.hasNext(); )
        {
            ++n;
            String line = sc.nextLine();
            if(rand.nextInt(n) == 0)
            { result = line; }
        }

        return result;      
    }
}