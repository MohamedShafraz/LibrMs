package librms; 

class Inventory {
    private Book book;
    private int noOfCopies;

    public Inventory(Book book, int noOfCopies) {
        this.book = book;
        this.noOfCopies = noOfCopies;
    }

    public void addCopies(int count)
    {
        this.noOfCopies += count;
    }

    public void removeCopies(int count)
    {
        this.noOfCopies -= count;
    }

    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public int getNoOfCopies() {
        return noOfCopies;
    }
    public void setNoOfCopies(int noOfCopies) {
        this.noOfCopies = noOfCopies;
    }
}