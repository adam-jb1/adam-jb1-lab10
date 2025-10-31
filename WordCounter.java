import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.regex.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


public class WordCounter {

    public static int processText(StringBuffer input, String stopWord) throws TooSmallText, InvalidStopwordException {
        boolean found = false;
        int count = 0;
        int totalCount = 0;
        //account for total count

        Pattern regex = Pattern.compile("[a-zA-Z0-9']+");
        Matcher regexMatcher = regex.matcher(input.toString());

        while (regexMatcher.find()) {
            String word = regexMatcher.group();
            count++;

            if (word.equals(stopWord)) {
                found = true;
                break;
            }
        }   

        regexMatcher.reset();

        while (regexMatcher.find()) {
            String word = regexMatcher.group();
            totalCount++;
        } 
        //System.out.println("Count = " + count);

        if (count < 5) {
            throw new TooSmallText("Only found " + totalCount + " words.");
        } 

        if (stopWord == null) {
            return count;
        }

        if (found == false) {
            throw new InvalidStopwordException("Couldn't find stopword: " + stopWord);
        }

        return count;
    }

    public static StringBuffer processFile(String text) throws EmptyFileException {
        return null;
    }

    public static void main(String[] args) {

    }


}