package librms;

import java.util.Date;

class Transaction{
    private Member member;
    private Book book;
    private Date borrowDate;
    private Date dueDate;
    private boolean isReturn;
    private int noOfCopies;

    public Transaction(Member member, Book book,int noOfCopies, Date borrowDate, Date dueDate) {
        this.member = member;
        this.book = book;
        this.noOfCopies = noOfCopies;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.isReturn = false;
    }

    public Transaction(Member member, Book book, Date borrowDate, Date dueDate) {
        this.member = member;
        this.book = book;
        this.noOfCopies = 1;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.isReturn = false;
    }


    public int getNoOfCopies(){
        return noOfCopies;
    }

    public Member getMember() {
        return member;
    }

    public Book getBook() {
        return book;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getDueDate() {
        return dueDate;
    }
    
    public boolean getIsReturn(){
        return isReturn;
    }
    
    public void setIsReturn(boolean isReturn){
        this.isReturn = isReturn;
    }
    public double getFineAmount() {
        if(isReturn) return 0;
        Date currentDate = new Date();
       
        int fineStart = ((int) ((dueDate.getTime() - currentDate.getTime()) / (24 * 60 * 60 * 1000)));
        if (fineStart <= 7 && fineStart > 0) {
            return (double) (50.0 * fineStart);
        } else if (fineStart > 7) {
            return  (100.0 * (fineStart - 7)+50*7);
        } else {
            return 0.0;
        }
    }
    
    public String toString()
    {
        return member.toString() + "\n" + book.toString() +"\nBorrowed Date: " + borrowDate.toString()+ "\n" + "Due Date: " + dueDate.toString()+ "\nNo.of.Copies: "+noOfCopies+"\nReturn Status: "+isReturn;
    }
}