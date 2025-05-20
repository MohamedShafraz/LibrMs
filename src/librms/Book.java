package librms; 

class Book {
    private String title;
    private String author;
    private String ISBN;
    
    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    @Override
    public String toString() {
        return "Book Title: "+title + "\n"+
        "Book Author: "+author + "\n"+
        "Book ISBN: "+ISBN;
    }
}
