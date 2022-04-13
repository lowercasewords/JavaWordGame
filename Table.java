import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;
public class Table {
    
    private String _guessWord;
    private FileReader fileReader;
    private Pattern counter = Pattern.compile("\\w{5}");

    // reads from specified text file
    public Table(String wordBankDirPath) throws IOException{
        fileReader = new FileReader(wordBankDirPath);

    }
    // uses default word bank text file 
    public Table() throws IOException{
        this("/Users/arturagalarian/Desktop/JavaWordGame/WordBank.txt");
    }

    public String RestartGuessWord() throws Exception
    {
        throw new Exception();
        // counter.int
        // return "";
    }
}