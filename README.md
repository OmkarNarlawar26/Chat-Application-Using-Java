# 📄 CHAT APPLICATION USING JAVA SOCKET PROGRAMMING  
*(Client–Server GUI Based Chat System)*

This project is a Java-based Client–Server Chat Application developed using Swing for GUI and Socket Programming for communication. The server waits for client connections and enables real-time message exchange with a clean, dark-themed interface. Messages are visually distinguished using bold labels and color styling for better readability.

---

## Introduction  

In modern network-based applications, real-time communication between systems plays a crucial role. Chat applications are a classic example of such communication, where multiple users exchange messages over a network.  

This project is a **GUI-based Client–Server Chat Application** developed using **Java Socket Programming** and **Java Swing**. The application allows a client and a server to communicate with each other in real time through a reliable TCP connection. Both the client and server have interactive graphical user interfaces that display sent and received messages in a formatted manner.

---

## Project Overview (WHAT)

This project implements a **desktop chat system** where:
- A **Server application** waits for client connections.
- A **Client application** connects to the server.
- Both sides can **send and receive messages in real-time**.
- Messages are displayed using **StyledDocument** with color formatting.

It is built using **Core Java concepts**, making it ideal for learning **Networking + Multithreading + GUI**.

---

## Project Objective (WHY)

The main objectives of this project are:

- To understand the fundamentals of **TCP socket programming in Java**
- To implement **client–server communication**
- To design a **graphical user interface using Java Swing**
- To apply **multithreading** for continuous message receiving
- To use **event handling** for user interaction
- To enhance message readability using **StyledDocument formatting**

---

##  Features

-  Client–Server communication using **TCP sockets**
-  **Graphical User Interface (GUI)** using Java Swing
-  **Multithreading** for continuous message listening
-  Colored & formatted chat messages
-  Auto-scroll chat window
-  Send messages using **Button or Enter key**
-  Clean and structured code with documentation

---

## Technologies Used

| Technology | Description |
|-----------|-------------|
| Java (JDK 8+) | Core programming language used to build the application |
| Java Swing | GUI development for client and server interfaces |
| Java AWT | Event handling, layout management, and color support |
| Socket Programming (Java Sockets) | Enables network communication between client and server |
| TCP/IP | Communication protocol used for reliable data transfer |
| Multithreading | Handles concurrent client connections and message processing |
| StyledDocument | Provides formatted and styled text support in chat windows |

---

## Prerequisites

Before running this project, ensure you have:

- Java Development Kit (JDK) 8 or higher
- Basic understanding of Java Swing and Socket Programming
- Command Prompt / Terminal
- Any Java-supported OS (Windows / Linux / macOS)

---

## 📁 Project Structure

~~~text
Java-Chat-Application/
│
├── ChatServerGUI.java   # Server-side application with GUI
├── ChatClientGUI.java   # Client-side application with GUI
└── README.md            # Project documentation
~~~

---

## System Architecture  

The system follows a **Client–Server Architecture**:

- The **Server** listens on a fixed port for incoming client connections.
- The **Client** initiates a connection request to the server.
- Once connected, both sides exchange messages using input/output streams.
- Communication is **bidirectional and real-time**.

**Architecture Type:**  
- Two-tier architecture  
- Single client – single server model  

---

## Application Workflow

1. Server starts and listens on port `5100`
2. Client connects to the server using `localhost`
3. Both client and server:
   - Send messages using `PrintStream`
   - Receive messages using `BufferedReader`
4. Message receiving runs in a separate thread
5. Messages are displayed with sender-specific colors

---

## Client Side – `ChatClientGUI.java`

### Class Responsibilities
- Creates client GUI
- Connects to server socket
- Sends messages to server
- Receives messages using a background thread

### Key Methods

- **Constructor**
  - Initializes GUI
  - Creates socket connection
  - Starts message listener thread

- **`appendText(String sender, String msg, Color c)`**
  - Displays formatted messages in chat window

- **`actionPerformed()`**
  - Sends message to server when button or Enter is pressed

- **`run()`**
  - Continuously listens for server messages

---

## Server Side – `ChatServerGUI.java`

### Class Responsibilities
- Creates server GUI
- Listens for client connection
- Sends messages to client
- Receives messages using a background thread

### Key Methods

- **Constructor**
  - Starts server socket on port `5100`
  - Accepts client connection
  - Starts message listener thread

- **`appendText(String sender, String msg, Color c)`**
  - Displays formatted messages in server chat window

- **`actionPerformed()`**
  - Sends message to connected client

- **`run()`**
  - Continuously listens for client messages

---

## Client–Server Communication Flow  

1. Server starts and waits for a client connection.
2. Client connects to the server using IP address and port number.
3. Server accepts the connection.
4. Input and output streams are established on both sides.
5. Messages are sent using output streams.
6. Messages are received using input streams.
7. Separate threads continuously listen for incoming messages.

---

## GUI Design using Java Swing  

Java Swing is used to build the graphical user interface.

### GUI Components:
- **JFrame** – Main application window
- **JTextPane** – Displays chat messages
- **JTextField** – Allows message input
- **JButton** – Sends messages
- **JScrollPane** – Enables scrolling for chat history

A **dark theme UI** is used for better readability and modern appearance.

---

## Socket Programming Overview  

Socket programming enables communication between two systems over a network.

### Key Components Used:
- **ServerSocket** – Used by the server to listen for incoming connections
- **Socket** – Represents the communication endpoint
- **Port Number** – Identifies the service on the server (Port: 5100)
- **TCP Protocol** – Ensures reliable, ordered message delivery

This project uses **TCP sockets**, which guarantee message integrity and connection reliability.

---

## StyledDocument for Message Formatting  

The application uses **StyledDocument** to format messages:

- Sender names are displayed in **bold**
- Different colors are used for client and server messages
- Message content is displayed in white
- Automatic scrolling to the latest message is implemented

This improves visual clarity and user experience.

---

## Multithreading Implementation  

Multithreading is implemented using the **Runnable interface**.

### Purpose of Multithreading:
- Allows continuous listening for incoming messages
- Prevents GUI freezing
- Enables simultaneous sending and receiving of messages

Each side (client and server) runs a separate thread to handle incoming messages.

---

## Event Handling Mechanism  

The application uses **ActionListener** for event handling.

### Events Handled:
- SEND button click
- Pressing the Enter key in the text field

The same logic handles both events, making the interface intuitive and user-friendly.

---

## Message Color Scheme

| Sender | Color |
|---------|------|
| Client Name | Cyan |
| Server Name | Green |
| Message Text | White |

This color scheme improves message clarity and helps easily distinguish between client and server messages.

---

## How the Server Works  

1. Server GUI is initialized.
2. ServerSocket is created on a fixed port.
3. Server waits for a client connection.
4. Once connected, streams are established.
5. A separate thread starts listening for client messages.
6. Messages sent by the server are displayed locally and transmitted to the client.
7. Messages received from the client are displayed in the chat window.

---

## How the Client Works  

1. Client GUI is initialized.
2. Client connects to the server using IP and port.
3. Input and output streams are created.
4. A background thread listens for server messages.
5. Messages typed by the client are sent to the server.
6. Received server messages are displayed in real time.

---

## Execution Steps  

1. Compile both Java programs.
2. Run the **Server application first**.
3. Run the **Client application**.
4. Wait for successful connection.
5. Start exchanging messages.
6. Close the applications to terminate communication.

## ▶️ How to Compile the Project

### 1️⃣ Compile the Files
```bash
javac ChatServerGUI.java
```

```bash
javac ChatClientGUI.java
```

## ▶️ How to Run the Project

### 2️⃣ Run the Files
```bash
java ChatServerGUI
```

```bash
java ChatClientGUI
```

`Once both are connected, you can chat in real time.`

---

## Error Handling Strategy  

- Try–catch blocks are used to prevent application crashes.
- Network errors are safely handled.
- Input validation prevents sending empty messages.
- Thread exceptions are controlled to maintain stability.

---

## Limitations of Current System  

- Supports only **one client at a time**
- No user authentication
- No message encryption
- Chat history is not saved
- No file sharing support

---

## Future Enhancements  

- Multi-client support using thread pool
- User login and authentication
- Message timestamp feature
- Database integration for chat history
- File and image sharing
- End-to-end encryption
- Improved UI design

---

## Conclusion  

This project successfully demonstrates the implementation of a **real-time client–server chat application** using Java. It combines **socket programming, GUI development, multithreading, and event handling** into a single functional system.  

The project strengthens understanding of **network communication**, **Java Swing**, and **concurrent programming**, making it an excellent foundation for advanced distributed systems and real-world network applications.

---

##  License

This project is licensed under the **MIT License** — feel free to modify and use it for learning or development purposes.
See the [LICENSE](LICENSE) file for details.

---

## Author

**Omkar Sachin Narlawar**  

If you like this project, give it a **Star** on  
[GitHub](https://github.com/OmkarNarlawar26)!

Connect to [Linkedin](https://www.linkedin.com/in/omkar-narlawar-7504a8388/)!

---

## 🔗 Useful Links

- [Java Socket Documentation](https://docs.oracle.com/javase/8/docs/api/java/net/Socket.html)
- [Oracle Java Tutorials – Networking](https://docs.oracle.com/javase/tutorial/networking/)
- [Java ServerSocket API](https://docs.oracle.com/javase/8/docs/api/java/net/ServerSocket.html)
- [Java Swing Tutorial (GUI)](https://docs.oracle.com/javase/tutorial/uiswing/)
- [Java Multithreading (Concurrency)](https://docs.oracle.com/javase/tutorial/essential/concurrency/)
- [StyledDocument – Text Formatting](https://docs.oracle.com/javase/8/docs/api/javax/swing/text/StyledDocument.html)
- [Runnable Interface](https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html)

---
 
