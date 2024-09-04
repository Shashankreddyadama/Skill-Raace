import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatbotGUI extends JFrame {
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    public ChatbotGUI() {
        // Set up the frame
        setTitle("Chatbot");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create chat area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        // Create input field
        inputField = new JTextField();
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        // Create send button
        sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        // Add components to the frame
        add(scrollPane, BorderLayout.CENTER);
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);

        // Make the frame visible
        setVisible(true);
    }

    private void sendMessage() {
        String userInput = inputField.getText();
        if (!userInput.trim().isEmpty()) {
            chatArea.append("You: " + userInput + "\n");
            inputField.setText("");

            // Generate bot response
            String botResponse = getBotResponse(userInput);
            chatArea.append("Bot: " + botResponse + "\n");
        }
    }

    private String getBotResponse(String userInput) {
        // Simple bot logic
        if (userInput.toLowerCase().contains("hello")) {
            return "Hello! How can I help you today?";
        } else if (userInput.toLowerCase().contains("how are you")) {
            return "I'm good. How about you?";
        } else if (userInput.toLowerCase().contains("hi")) {
            return "Hello! How can I help you today?";
        } else if (userInput.toLowerCase().contains("i am fine")) {
            return "Great to hear that! How can I assist you today?";
        } else if (userInput.toLowerCase().contains("sorry")) {
            return "It's OK!";
        } else if (userInput.toLowerCase().contains("thank you")) {
            return "Your welcome :)";
        } else if (userInput.toLowerCase().contains("thanks")) {
            return "Your welcome:)";
        } else if (userInput.toLowerCase().contains("what are you doing")) {
            return "Thank you for asking. Nothing much, just assisting you for now.";
        } else if (userInput.toLowerCase().contains("bye")) {
            return "Goodbye! Have a great day!";
        } else {
            return "I'm sorry, I didn't understand that.";
        }
    }

    public static void main(String[] args) {
        // Run the chatbot GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChatbotGUI();
            }
        });
    }
}