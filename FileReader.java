import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class FileReader {
  
    public static String readFile(String f){
        String text = "";
        int lc = 0;

        try{
        File bookList = new File(f);
        Scanner scan = new Scanner(bookList);
            while (scan.hasNextLine()){
                lc++;
                text = text + scan.nextLine() + "\n";
             }
        scan.close();
        }
        catch(FileNotFoundException e){
            System.out.println("FILE NOT FOUND");
        }
        text = text + String.valueOf(lc);
        return text;

    } 

    public static int fileSize(String f){
        int lc = 0;
        try{
        File bookList = new File(f);
        Scanner scan = new Scanner(bookList);
            while (scan.hasNextLine()){
                lc++;
                scan.nextLine();
             }
        scan.close();
        }
        catch(FileNotFoundException e){
            System.out.println("FILE NOT FOUND");
        }
        return lc;

    } 

    public static Book[] library(String f){
        String text = "";
        int lc = 0;

        try{
        File bookList = new File(f);
        Scanner scan = new Scanner(bookList);
            while (scan.hasNextLine()){
                lc++;
                text = text + scan.nextLine() + "\n";
             }
        scan.close();
        }
        catch(FileNotFoundException e){
            System.out.println("FILE NOT FOUND");
        }
        Book library[] = new Book[lc];
        String lines[] = text.split("\n");
        
        for(int i = 0; i < lc; i++)
        {
            String division[] = lines[i].split("_");
            //System.out.println(String.valueOf(i+1) + ". " + division[0] + " '" + division [1] + "' by " + division[2]);
            Book b = new Book(division[0], division[1], division[2]);
            library[i] = b;
        }

        return library;
    }
}
