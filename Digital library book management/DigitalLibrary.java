// DigitalLibrary.java

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class DigitalLibrary {
	//Use HashMap to store book efficiently
    private static Map<String, Book> bookCatalog = new HashMap<>();
	//A Scanner for user input.
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nDigital Library Book Management System");
            System.out.println("1. Add a Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID or Title");
            System.out.println("4. Update Book Details");
            System.out.println("5. Delete a Book Record");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addBook(); break;
                case 2: viewAllBooks(); break;
                case 3: searchBook(); break;
                case 4: updateBook(); break;
                case 5: deleteBook(); break;
                case 6: System.out.println("Exiting system..."); System.exit(0);
                default: System.out.println("Invalid choice! Please try again.");
            }
        }
    }

	// addBook() Method, take user input for book details.
    private static void addBook() {
        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine();
		//Checks if ID is unique before adding.
        if (bookCatalog.containsKey(id)) {
            System.out.println("Book ID must be unique!");
            return;
        }

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter Availability (Available/Checked Out): ");
        String availability = scanner.nextLine();
        
        try {
            bookCatalog.put(id, new Book(id, title, author, genre, availability));
            System.out.println("Book added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

	//viewAllBooks() Method
    private static void viewAllBooks() {
        if (bookCatalog.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
		//Loops through HashMap to display all books.
        for (Book book : bookCatalog.values()) {
            System.out.println(book);
        }
    }

	// searchBook() Method
    private static void searchBook() {
        System.out.print("Enter Book ID or Title: ");
        String search = scanner.nextLine();
        boolean found = false;
        for (Book book : bookCatalog.values()) {
			//Finds book by ID or Title.
            if (book.getId().equalsIgnoreCase(search) || book.getTitle().equalsIgnoreCase(search)) {
                System.out.println(book);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }

	//updateBook() Method
    private static void updateBook() {
        System.out.print("Enter Book ID to update: ");
        String id = scanner.nextLine();
		//Allows updating Title, Author, or Availability.
        if (!bookCatalog.containsKey(id)) {
            System.out.println("Book not found!");
            return;
        }
        Book book = bookCatalog.get(id);
        
        System.out.print("Enter new Title (Leave empty to keep unchanged): ");
        String newTitle = scanner.nextLine();
        if (!newTitle.isEmpty()) book.setTitle(newTitle);

        System.out.print("Enter new Author (Leave empty to keep unchanged): ");
        String newAuthor = scanner.nextLine();
        if (!newAuthor.isEmpty()) book.setAuthor(newAuthor);

        System.out.print("Enter new Availability (Available/Checked Out): ");
        String newAvailability = scanner.nextLine();
        if (!newAvailability.isEmpty()) book.setAvailability(newAvailability);

        System.out.println("Book updated successfully!");
    }

	//deleteBook() Method
    private static void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        String id = scanner.nextLine();
		// Removes book from HashMap using ID.
        if (bookCatalog.remove(id) != null) {
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }
}
