////////////////////////////////////////////////////////////////////////
//                      Program for Client Side
//                       (Socket Programming)
////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////
//
//  Required Import File
//
////////////////////////////////////////////////////////////////////////

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

////////////////////////////////////////////////////////////////////////
//  Help Desk Class
////////////////////////////////////////////////////////////////////////

class ChatClientGUI implements ActionListener, Runnable
{
    ////////////////////////////////////////////////////////////////////////
    //
    //  Description     :   Contains all GUI components, socket objects,
    //                      input/output streams, and thread required for
    //                      client-side chat communication.
    //
    ////////////////////////////////////////////////////////////////////////

    //  Characteristics of ChatClientGUI  Class

    JFrame fobj;
    JTextPane ta;
    JTextField tf;
    JButton sendBtn;
    JScrollPane sp;

    StyledDocument doc;

    Socket sobj;
    PrintStream out;
    BufferedReader in;

    Thread t;

    ////////////////////////////////////////////////////////////////////////
    //
    //  Description     :   Initializes the client GUI, establishes socket
    //                      connection with the server, and starts a
    //                      separate thread to receive messages.
    //
    ////////////////////////////////////////////////////////////////////////

    //  HelpDesk Class Constructor

    public ChatClientGUI()
    {
        fobj = new JFrame("Marvellous Chat Client");
        fobj.getContentPane().setBackground(new Color(43,43,43));

        ta = new JTextPane();
        ta.setEditable(false);
        ta.setBackground(new Color(30,30,30));

        doc = ta.getStyledDocument();

        sp = new JScrollPane(ta);
        sp.setBounds(20,20,350,200);

        tf = new JTextField();
        tf.setBounds(20,230,250,30);

        sendBtn = new JButton("SEND");
        sendBtn.setBounds(280,230,90,30);
        sendBtn.setBackground(new Color(76,175,80));
        sendBtn.setForeground(Color.WHITE);

        fobj.add(sp);
        fobj.add(tf);
        fobj.add(sendBtn);

        sendBtn.addActionListener(this);
        tf.addActionListener(this);

        fobj.setSize(400,320);
        fobj.setLayout(null);
        fobj.setVisible(true);
        fobj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try
        {
            sobj = new Socket("localhost",5100);

            out = new PrintStream(sobj.getOutputStream());
            in = new BufferedReader(new InputStreamReader(sobj.getInputStream()));

            t = new Thread(this);
            t.start();
        }
        catch(Exception e){}
    }   // End of Constructor

    ////////////////////////////////////////////////////////////////////////
    //
    //  Function Name   :   appendText
    //  Description     :   This function appends formatted text into the
    //                      chat window using StyledDocument. It displays
    //                      sender name in bold with specified color and
    //                      message text in normal white color. It also
    //                      auto-scrolls the chat window to the latest message.
    //  Input           :   String sender, String msg, Color c
    //  Output          :   Displays formatted message in chat window
    //  Author          :   Omkar Sachin Narlawar
    //  Date            :   13/01/2026
    //
    ////////////////////////////////////////////////////////////////////////

    void appendText(String sender, String msg, Color c)
    {
        try
        {
            SimpleAttributeSet bold = new SimpleAttributeSet();
            StyleConstants.setBold(bold, true);
            StyleConstants.setForeground(bold, c);

            SimpleAttributeSet normal = new SimpleAttributeSet();
            StyleConstants.setForeground(normal, Color.WHITE);

            doc.insertString(doc.getLength(), sender, bold);
            doc.insertString(doc.getLength(), msg + "\n", normal);

            ta.setCaretPosition(doc.getLength());
        }
        catch(Exception e){}
    }   // End of Function

    ////////////////////////////////////////////////////////////////////////
    //
    //  Function Name   :   actionPerformed
    //  Description     :   This function is invoked when the SEND button
    //                      is clicked or Enter key is pressed. It reads
    //                      the message from the text field, displays it
    //                      in the client chat window, and sends it to
    //                      the server through socket output stream.
    //  Input           :   ActionEvent aobj
    //  Output          :   Sends message to server and displays it locally
    //  Author          :   Omkar Sachin Narlawar
    //  Date            :   13/01/2026
    //
    ////////////////////////////////////////////////////////////////////////

    public void actionPerformed(ActionEvent aobj)
    {
        String msg = tf.getText();
        if(msg.isEmpty()) return;

        appendText("Client : ", msg, Color.CYAN);
        out.println(msg);
        tf.setText("");
    }   // End of Function

    ////////////////////////////////////////////////////////////////////////
    //
    //  Function Name   :   run
    //  Description     :   This function runs in a separate thread and
    //                      continuously listens for incoming messages
    //                      from the server. Each received message is
    //                      displayed in the chat window with proper
    //                      formatting.
    //  Input           :   None
    //  Output          :   Displays server messages in chat window
    //  Author          :   Omkar Sachin Narlawar
    //  Date            :   13/01/2026
    //
    ////////////////////////////////////////////////////////////////////////

    public void run()
    {
        try
        {
            String msg;
            while((msg = in.readLine()) != null)
            {
                appendText("Server : ", msg, Color.GREEN);
            }
        }
        catch(Exception e){}
    }   // End of Function

    ////////////////////////////////////////////////////////////////////////
    //
    //  Function Name   :   main
    //  Description     :   Entry point of the application. It creates
    //                      an object of ChatClientGUI class which
    //                      initializes the client-side GUI and socket
    //                      connection.
    //  Input           :   Command line arguments
    //  Output          :   Launches client chat application
    //  Author          :   Omkar Sachin Narlawar
    //  Date            :   13/01/2026
    //
    ////////////////////////////////////////////////////////////////////////

    public static void main(String A[])
    {
        new ChatClientGUI();
    }   // End of Main
}   // End of Class
