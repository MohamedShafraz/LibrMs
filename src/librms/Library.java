package librms; 

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Library{
  
    private Scanner scanner;
    private List<Book> books;
    private List<Member> members;
    private List<Transaction> transactions;
    private List<Inventory> inventories;

    public Library(Scanner scanner) {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.inventories=new ArrayList<>();
        this.scanner=scanner;
    }

    
    public void addBook() {

        System.out.print("Enter the book Title: ");
        String Title = scanner.nextLine();
        System.out.print("Enter the book author: ");
        String Author = scanner.nextLine();
        System.out.print("Enter the book ISBN: ");
        String ISBN = scanner.nextLine();

        Book book = new Book(Title, Author, ISBN);
        System.out.print("Number of copies: ");
        int count=scanner.nextInt();
        scanner.nextLine();
        Inventory inventory=new Inventory(book,count);
        books.add(book);
        inventories.add(inventory);
    }

    public void registerMember() {
   
        System.out.print("Enter the Name ");
        String MemberName = scanner.nextLine();
        System.out.print("Enter the Contact Information ");
        String MemberContact = scanner.nextLine();
      
        Member member = new Member(MemberName, MemberContact);
        members.add(member);
    }

    public void removeBook() {
        if(books.isEmpty())
        {
            System.out.println("No books available");
            return;
        }
        System.out.println("Available Books are");
        for(int i=0;i<books.size();i++)
        {
            System.out.println((i+1)+". "+books.get(i).getTitle());
        }
        System.out.print("Enter the book index: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        if(index < 1 || index > books.size())
        {
            System.out.println("Invalid Input!");
            return;
        }
        Book removedBook=books.remove(index-1);
        Inventory inventory=findInventoryByBook(removedBook);
        inventories.remove(inventory);
        System.out.println("Successfully Removed!");
    }
    

    public void removeMember() {
        if(members.isEmpty())
        {
            System.out.println("No members available");
            return;
        }
        System.out.println("Registered Members are");
        for(int i=0;i<members.size();i++)
        {
            System.out.println((i+1) + ". " + members.get(i).getName());
        }
        System.out.print("Enter the member index: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        if(index <1 || index > members.size())
        {
            System.out.println("Invalid Input!");
            return;
        }
        members.remove(index-1);
        System.out.println("Successfully Removed the member!");
        
    }

    public void searchBookInformation() {
        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();
        for (Book b : books) {
            if (b.getTitle().equals(title)) {
                System.out.println(b);
                return;
            }
        }
        System.out.println("No books found for your query");
    }

    public void searchMemberInformation() {
        System.out.print("Enter the member name: ");
        String name = scanner.nextLine();
        for (Member m : members) {
            if (m.getName().equals(name)) {
                System.out.println(m);
                return;
            }
        }
        System.out.println("No members found for your query");
    }

    public void displayBookNames() {
        if(books.isEmpty())
        {
            System.out.println("No books found");
            return;
                    
        }
        for (Book a : books) {
            System.out.println(a.getTitle());
            
        }
        
    }

    public void displayMemberNames() {
        if(members.isEmpty())
        {
            System.out.println("No members found");
            return;
        }

        for (Member a : members) {
            System.out.println(a.getName());
        }
        
    }

    public void lendBook() throws ParseException {
        System.out.println("Available Books are");
        for(int i=0;i<books.size();i++)
        {
            System.out.println((i+1)+". "+books.get(i).getTitle());
        }
        System.out.print("Enter the book index: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        if(index < 1 || index > books.size())
        {
            System.out.println("Invalid Input!");
            return;
        }
        Book book=books.get(index-1);
        Inventory inventory=findInventoryByBook(book);
        if(inventory.getNoOfCopies()<=0)
        {
            System.out.println(book.getTitle()+" is not available at the moment Please check Later.");
            return;
        }
        System.out.print("Please enter your Member ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Member member = findMemberById(id);
        if(member == null)
        {
            System.out.println("Invalid MemberID "+ id);
            return;
        }
        Transaction existTransaction=member.getLendingTransactionByBook(book);
        if(existTransaction!=null)
        {
            System.out.println("You already lent this book. you can't lend book again until you return the old books");
            return;
        }
        
        System.out.print("No of due days: ");
        int days = scanner.nextInt();
        scanner.nextLine();
        Date currDate=new Date();
        long time=currDate.getTime()+days*24*60*60*1000;
        Date dueDate=new Date(time);
        Transaction transaction = new Transaction(member,book,currDate,dueDate);
        transactions.add(transaction);
        inventory.removeCopies(1);
        member.addTransaction(transaction);
    }

    public void returnBook() {
        System.out.print("Enter the member ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Member member = findMemberById(id);
        if(member == null)
        {
            System.out.println("Invalid MemberID "+ id);
            return;
        }
        if(member.getLendingTransactions().isEmpty())
        {
            System.out.println("No Transactions available!");
            return;
        }
        for(int i=0;i<member.getLendingTransactions().size();i++)
        {
            System.out.println((i+1)+". "+member.getLendingTransactions().get(i));
        }
        System.out.print("Enter the transaction id: ");
        int index=scanner.nextInt();
        scanner.nextLine();
        if(index < 1 || index > member.getLendingTransactions().size())
        {
            System.out.println("Invalid Index!");
            return;
        }
        
        Transaction transaction = member.getLendingTransactions().get(index-1);
        double fine=transaction.getFineAmount();
        if(fine>0)
        {
            System.out.println("You need to pay "+fine);
        }
        transaction.setIsReturn(true);
        Inventory inventory=findInventoryByBook(transaction.getBook());
        inventory.addCopies(transaction.getNoOfCopies());
        System.out.println("Sucessfully Returned the book!");
        
    }

    public void viewLendingInformation() {
        for(Transaction t : transactions)
        {
            if(!t.getIsReturn()){
                System.out.println(t + "\n");
            }
            
        }
        
    }

    public void displayOverdueBooks() {
        Date currDate = new Date();
        boolean isOverdueAvailalbe=false;
        for(Transaction t: transactions)
        {
            if(!t.getIsReturn() && currDate.after(t.getDueDate()))
            {
                System.out.println(t);
                isOverdueAvailalbe=true;
            }
        }
        if(!isOverdueAvailalbe)
        {
            System.out.println("No overdue books avaialble");
        }   
    }
    
    private Inventory findInventoryByBook(Book book)
    {
        for(Inventory inventory:inventories)
        {
            if(inventory.getBook().equals(book))
                return inventory;
                  
        }
        return null;
    }
    
    
    private Member findMemberById(int memberID)
    {
        for(Member member: members)
        {
            if(member.getMemberID()== memberID)
            {
                return member;
            }
        }
        return null;
    }
}
