package librms; 

import java.text.ParseException;
import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) throws ParseException {
        printMenu();
        System.out.println();
        Scanner sc = new Scanner(System.in);
        boolean isExit = false;
        Library library = new Library(sc);

        // isExit==false
        while (!isExit) {
            System.out.print("\nEnter the option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    library.addBook();
                    break;
                case 2:
                    library.registerMember();
                    break;
                case 3:
                    library.removeBook();
                    break;
                case 4:
                    library.removeMember();
                    break;
                case 5:
                    library.searchBookInformation();
                    break;
                case 6:
                    library.searchMemberInformation();
                    break;
                case 7:
                    library.displayBookNames();
                    break;
                case 8:
                    library.displayMemberNames();
                    break;
                case 9:
                    library.lendBook();
                    break;
                case 10:
                    library.returnBook();
                    break;
                case 11:
                    library.viewLendingInformation();
                    break;
                case 12:
                    library.displayOverdueBooks();
                    break;
                case 13:
                    System.out.println("Thank You for using our Library System");
                    isExit = true;
                    break;
                default:
                    System.out.println("Invalid Input!");
                    break;
            }
        }

        sc.close();
    }

    private static void printMenu() {
        System.out.println("1. Add Book");
        System.out.println("2. Register Member");
        System.out.println("3. Remove Book");
        System.out.println("4. Remove Member");
        System.out.println("5. Search Book Information");
        System.out.println("6. Search Member Information");
        System.out.println("7. Display Book Names");
        System.out.println("8. Display Member Names");
        System.out.println("9. Lend Book");
        System.out.println("10. Return Book");
        System.out.println("11. View Lending Information");
        System.out.println("12. Display Overdue Books");
        System.out.println("13. Exit");

    }
   
}
