////////////////////////////////////////////////////////////////////////
//                      Program for Server Side
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

class ChatServerGUI implements ActionListener, Runnable
{
    ////////////////////////////////////////////////////////////////////////
    //
    //  Description     :   This class implements the server-side GUI and
    //                      handles client connection, message sending,
    //                      and message receiving using socket programming.
    //
    ////////////////////////////////////////////////////////////////////////

    //  Characteristics of ChatServerGUI Class

    JFrame fobj;
    JTextPane ta;
    JTextField tf;
    JButton sendBtn;
    JScrollPane sp;

    StyledDocument doc;

    ServerSocket ssobj;
    Socket sobj;
    PrintStream out;
    BufferedReader in;

    Thread t;

    ////////////////////////////////////////////////////////////////////////
    //
    //  Description     :   Initializes the server GUI, waits for client
    //                      connection on a specified port, and starts
    //                      a separate thread to receive client messages.
    //
    ////////////////////////////////////////////////////////////////////////

    //  HelpDesk Class Constructor

    public ChatServerGUI()
    {
        fobj = new JFrame("Marvellous Chat Server");
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
        tf.addActionListener(this);                 // Enter key support

        fobj.setSize(400,320);
        fobj.setLayout(null);
        fobj.setVisible(true);
        fobj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try
        {
            ssobj = new ServerSocket(5100);

            sobj = ssobj.accept();

            out = new PrintStream(sobj.getOutputStream());
            in = new BufferedReader(new InputStreamReader(sobj.getInputStream()));

            t = new Thread(this);
            t.start();
        }
        catch(Exception e)
        {}
    }   //  End of Constructor

    ////////////////////////////////////////////////////////////////////////
    //
    //  Function Name   :   appendText
    //  Description     :   This function appends formatted text into the
    //                      server chat window using StyledDocument. It
    //                      displays the sender name in bold with specified
    //                      color and message text in normal white color.
    //                      It also auto-scrolls the chat window.
    //  Input           :   String sender, String msg, Color c
    //  Output          :   Displays formatted message in server chat window
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
    //                      in the server chat window, and sends it to the
    //                      connected client using socket output stream.
    //  Input           :   ActionEvent aobj
    //  Output          :   Sends message to client and displays it locally
    //  Author          :   Omkar Sachin Narlawar
    //  Date            :   13/01/2026
    //
    ////////////////////////////////////////////////////////////////////////

    public void actionPerformed(ActionEvent aobj)
    {
        String msg = tf.getText();
        if(msg.isEmpty()) return;

        appendText("Server : ", msg, Color.GREEN);
        out.println(msg);
        tf.setText("");
    }   // End of Function

    ////////////////////////////////////////////////////////////////////////
    //
    //  Function Name   :   run
    //  Description     :   This function executes in a separate thread and
    //                      continuously listens for incoming messages from
    //                      the client. Each received message is displayed
    //                      in the server chat window with proper formatting.
    //  Input           :   None
    //  Output          :   Displays client messages in server chat window
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
                appendText("Client : ", msg, Color.CYAN);
            }
        }
        catch(Exception e){}
    }   // End of Function

    ////////////////////////////////////////////////////////////////////////
    //
    //  Function Name   :   main
    //  Description     :   Entry point of the application. It creates
    //                      an object of ChatServerGUI class which
    //                      initializes the server-side GUI, starts
    //                      listening on the specified port, and waits
    //                      for client connection.
    //  Input           :   Command line arguments
    //  Output          :   Launches server chat application
    //  Author          :   Omkar Sachin Narlawar
    //  Date            :   13/01/2026
    //
    ////////////////////////////////////////////////////////////////////////
    

    public static void main(String A[])
    {
        new ChatServerGUI();
    }   // End of Main
}   // End of Class
