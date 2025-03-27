// Book.java

class Book {
	//the Requirements
	//encapsulates a books properties
    private String id;
    private String title;
    private String author;
    private String genre;
    private String availability;

	//Constructor:
    public Book(String id, String title, String author, String genre, String availability) {
		//Book ID must be unique, Title and Author cannot be empty
        if (id.isEmpty() || title.isEmpty() || author.isEmpty()) {
            throw new IllegalArgumentException("Book ID, Title, and Author must be non-empty.");
        }
        if (!availability.equalsIgnoreCase("Available") && !availability.equalsIgnoreCase("Checked Out")) {
            throw new IllegalArgumentException("Availability must be either 'Available' or 'Checked Out'.");
        }
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availability = availability;
    }

	//Getters and Setters:
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public String getAvailability() { return availability; }

	//Ensures only valid availability values.
    public void setAvailability(String availability) {
        if (!availability.equalsIgnoreCase("Available") && !availability.equalsIgnoreCase("Checked Out")) {
            throw new IllegalArgumentException("Availability must be either 'Available' or 'Checked Out'.");
        }
        this.availability = availability;
    }

    public void setTitle(String title) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }
        this.title = title;
    }

    public void setAuthor(String author) {
        if (author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty.");
        }
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Availability: " + availability;
    }
}