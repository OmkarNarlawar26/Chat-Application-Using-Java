# Chat-Application-Using-Java
This project is a Java-based Client–Server Chat Application developed using Swing for GUI and Socket Programming for communication. The server waits for client connections and enables real-time message exchange with a clean, dark-themed interface. Messages are visually distinguished using bold labels and color styling for better readability.

# 🗨️ Java Socket Programming – GUI Based Chat Application

A **Java Swing based Client–Server Chat Application** developed using **Socket Programming**.  
This project demonstrates **real-time two-way communication** between a server and a client with a modern GUI interface.

---

## Project Overview

This project implements a **desktop chat system** where:
- A **Server application** waits for client connections.
- A **Client application** connects to the server.
- Both sides can **send and receive messages in real-time**.
- Messages are displayed using **StyledDocument** with color formatting.

It is built using **Core Java concepts**, making it ideal for learning **Networking + Multithreading + GUI**.

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

| Technology | Purpose |
|----------|--------|
| Java (JDK 8+) | Core programming |
| Swing | GUI design |
| Socket Programming | Network communication |
| Multithreading | Concurrent message handling |
| StyledDocument | Text formatting |

---

## 📁 Project Structure

~~~text
Java-Chat-Application/
│
├── ChatServerGUI.java   # Server-side application with GUI
├── ChatClientGUI.java   # Client-side application with GUI
└── README.md            # Project documentation
~~~


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

## Multithreading

- Both client and server implement `Runnable`
- Message receiving runs on a separate thread
- Prevents GUI freezing
- Enables real-time communication

---

## Message Color Scheme

| Component | Color |
|---------|------|
| Client Messages | Cyan |
| Server Messages | Green |
| Message Text | White |

This color scheme improves message clarity and helps easily distinguish between client and server messages.

---

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

##  License

This project is licensed under the **MIT License** — feel free to modify and use it for learning or development purposes.
See the [LICENSE](LICENSE) file for details.

---

## Author

**Omkar Sachin Narlawar**  
*Java | Swing | Socket Programming*

If you like this project, give it a **Star** on  
[GitHub](https://github.com/OmkarNarlawar26)!

Connect to [Linkedin](https://www.linkedin.com/in/omkar-narlawar-7504a8388/)!

---

## 🔗 Useful Links

* [Java Socket Documentation](https://docs.oracle.com/javase/8/docs/api/java/net/Socket.html)
* [Oracle Java Tutorials - Networking](https://docs.oracle.com/javase/tutorial/networking/)

---
 
