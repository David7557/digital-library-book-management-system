# Digital Library Book Management System

## 📌 Project Overview
The **Digital Library Book Management System** is a Java-based application that enables librarians to efficiently manage books by adding, updating, searching, and removing them while maintaining their availability status.

## 🎯 Features
- **Add a Book**: Allows adding books with a unique ID, title, author, genre, and availability status.
- **View All Books**: Displays a list of all books stored in the system.
- **Search Book by ID or Title**: Enables searching for a book using its ID or title.
- **Update Book Details**: Allows updating book information like title, author, genre, and availability status.
- **Delete a Book Record**: Provides functionality to remove a book from the catalog.

## 🛠️ Technology Stack
- **Programming Language**: Java
- **Framework**: Spring Boot
- **Collection Used**: `HashMap` for book storage
- **API Layer**: RESTful API using Spring Boot
- **Dependency Management**: Maven

## 🚀 Setup and Installation
### Prerequisites
- Java 17+
- Maven
- IDE (IntelliJ IDEA, Eclipse, or VS Code with Java support)

### Steps to Run the Project
1. Clone the repository:
   ```sh
   git clone https://github.com/David7557/digital-library-book-management.git
   ```
2. Navigate to the project directory:
   ```sh
   cd digital-library-book-management
   ```
3. Build the project using Maven:
   ```sh
   mvn clean install
   ```
4. Run the Spring Boot application:
   ```sh
   mvn spring-boot:run
   ```
5. The application will be available at: `http://localhost:8080`

## 🔥 API Endpoints
| HTTP Method | Endpoint            | Description                        |
|------------|---------------------|------------------------------------|
| `POST`     | `/books`            | Add a new book                    |
| `GET`      | `/books`            | View all books                     |
| `GET`      | `/books/{bookId}`   | Search book by ID                  |
| `GET`      | `/books/title/{title}` | Search book by Title               |
| `PUT`      | `/books/{bookId}`   | Update book details                |
| `DELETE`   | `/books/{bookId}`   | Delete a book                      |

## ✅ Constraints
- **Book ID must be unique**.
- **Title and Author must be non-empty strings**.
- **Availability Status must be either "Available" or "Checked Out"**.

## 🏆 Challenges & Improvements
### Challenges Faced
- Implementing a collection-based storage without a database.
- Ensuring uniqueness of Book IDs.
- Handling invalid input cases.

### Future Enhancements
- Implement database integration for persistence.
- Improve exception handling.
- Implement UI for user-friendly interactions.

## 📜 License
This project is open-source and available under the **MIT License**.

## 👨‍💻 Author
- **David Kumar Hansdah**  

---

Feel free to contribute or raise issues to improve the system! 🚀
