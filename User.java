public class User {
    private String name;
    private Book borrowedBook;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean borrowBook(Book book) {
        if (borrowedBook == null && !book.isBorrowed()) {
            borrowedBook = book;
            book.borrow();
            return true;
        }
        return false;
    }

    public boolean returnBook() {
        if (borrowedBook != null) {
            borrowedBook.returnBook();
            borrowedBook = null;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return name + (borrowedBook != null ? " (Borrowed: " + borrowedBook.getTitle() + ")" : " (No books borrowed)");
    }
}
