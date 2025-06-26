import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add User");
            System.out.println("2. Add Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show Books");
            System.out.println("6. Show Users");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter user name: ");
                    String uname = sc.nextLine();
                    library.addUser(new User(uname));
					System.out.print("Name added successfully!!! \n ");
                    break;
                case 2:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter book author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(title, author));
					System.out.print("Book added successfully!!! \n ");
                    break;
                case 3:
                    System.out.print("Enter user name: ");
                    String borrower = sc.nextLine();
                    System.out.print("Enter book title: ");
                    String btitle = sc.nextLine();
                    User u = library.findUser(borrower);
                    Book b = library.findBook(btitle);
                    if (u != null && b != null) {
                        if (u.borrowBook(b)) {
                            System.out.println("Book borrowed successfully.");
                        } else {
                            System.out.println("Failed to borrow book.");
                        }
                    } else {
                        System.out.println("User or Book not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter user name: ");
                    String returner = sc.nextLine();
                    User rUser = library.findUser(returner);
                    if (rUser != null && rUser.returnBook()) {
                        System.out.println("Book returned successfully.");
                    } else {
                        System.out.println("No book to return.");
                    }
                    break;
                case 5:
                    library.showBooks();
                    break;
                case 6:
                    library.showUsers();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
