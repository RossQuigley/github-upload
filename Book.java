public class Book {
    private
    int isbn = 0000000000;
    String isbnString = "MISSING ISBN";
    String title = "MISSING TITLE";
    String author = "MISSING AUTHOR";

    public
    Book()
    {

    }

    Book(int i)
    {
        isbn = i;
    }

    Book(String i, String t, String a)
    {
        isbn = Integer.parseInt(i);
        isbnString = i;
        title = t;
        author = a;
    }

    int getISBN(){
        return isbn;
    }
    
    String getISBNString(){
        return isbnString;
    }

    String getTitle(){
        return title;
    }

    String getAuthor(){
        return author;
    }
    
}
