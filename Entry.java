import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Entry
{
    public static void main(String[] args) throws Exception
    {
        
    }
    
    ///<summary>
    /// Don't call unless the dictinary you're reading from is empty! Or if you want to read from another file
    ///</summary>
    private static void fillDictionary() throws FileNotFoundException, IOException
    {
        //test
        String dictionaryPath = "/usr/share/dict/words";
        String wordCheck;
        FileReader originalDictionary = new FileReader(dictionaryPath);
        BufferedReader bufferedReader = new BufferedReader(originalDictionary);
        FileWriter gameDictionary = new FileWriter("/Users/arturagalarian/Desktop/JavaWordGame/WordBank.txt");
        
        int i = 0;
        // checks each word in the file
        while((wordCheck = bufferedReader.readLine()) != null )
        {
            if(wordCheck.length() == 5)
            {
                i++;
                gameDictionary.write(wordCheck + " ");
            }
        }
        System.out.println("That's it! " + i + " words should've been added");
        gameDictionary.close();
        bufferedReader.close();
    }
}