package librms; 

import java.util.ArrayList;
import java.util.List;

class Member {
    private int memberID;
    private String name;
    private String contactInfo;
    private List<Transaction> transactions;
    private static int lastMemberID=0; // This is not for instance

    public Member(int memberID, String name, String contactInfo) {
        this.memberID = memberID;
        this.name = name;
        this.contactInfo = contactInfo;
        this.transactions = new ArrayList<Transaction>();
    }
    
    public Member(String name, String contactInfo) {
        this.memberID = lastMemberID+1;
        lastMemberID++;
        this.name = name;
        this.contactInfo = contactInfo;
        this.transactions = new ArrayList<Transaction>();
    }

    public int getMemberID() {
        return memberID;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }


    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
    
    
    public List<Transaction> getLendingTransactions() {
        List<Transaction> list=new ArrayList<Transaction>();
        for(Transaction t:transactions)
        {
            if(!t.getIsReturn())
            {
                list.add(t);
            }
        }
        return list;
    }
  
    
    
    public Transaction getLendingTransactionByBook(Book book)
    {
        for(Transaction t:transactions)
        {
            if(t.getBook().equals(book)&&!t.getIsReturn())
            {
                return t;
            }
        }
        return null;
    }
    
    @Override
    public String toString() 
    {
        return "Member ID : " + memberID + "\n"
        + "Name : " + name + "\n"
        + "Member Contact Info: " + contactInfo;
    }
}
