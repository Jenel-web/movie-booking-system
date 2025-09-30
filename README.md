# 🎬 Movie Ticket Booking System

A simple **Java console-based project** for booking and managing movie tickets.  
This project demonstrates **Object-Oriented Programming (OOP)** concepts such as classes, objects, encapsulation, and ArrayLists.

---

## ✨ Features
- 👥 **User Management**: Register multiple users with names and usernames.
- 🎥 **Movie Management**: Add movies with a title and theater location.
- 🎟️ **Ticket Booking**:
  - Book **VIP** or **Regular** seats.
  - Generates a **unique Ticket ID** using UUID.
- ✅ **Seat Availability**:
  - Prevents overbooking.
  - Updates remaining VIP/Regular seats after each booking.
- 📜 **Validation**:
  - Handles invalid inputs (e.g., wrong movie index, non-integer values).
  - Ensures only registered users can book tickets.

---

## 🛠️ Tech Stack
- **Language**: Java (JDK 8+)
- **Concepts Used**:  
  - Object-Oriented Programming (OOP)  
  - ArrayLists for data management  
  - Exception handling for input validation  

---

## 📂 Project Structure
LearningOOP.MovieTickets/

│
├── Cinema.java # Manages users, movies, and tickets

├── Movie.java # Represents a movie with seat availability

├── Ticket.java # Represents a ticket with unique ID

├── User.java # Represents a user with name and username

└── Main.java # Entry point with menu-driven booking system


## Future Improvements 
 - Make it menu-based for better UX
 - Add Database (Will learn SQL in the Future)
 - Add UI (Might be JAVA GUI or using frontend languages like HTML, CSS, and JS)
