import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    public JTextArea textArea;
    public JLabel wordCountLabel;

    public Main() {
        setTitle("Word Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        initComponents();
    }

    public void initComponents() {
        textArea = new JTextArea();
        textArea.setBackground(Color.PINK);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JButton countButton = new JButton("Count Words");
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                int wordCount = countWords(text);
                wordCountLabel.setText("Word Count: " + wordCount);
            }
        });
        wordCountLabel = new JLabel("Word Count: 0");
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(countButton);
        buttonPanel.add(wordCountLabel);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        getContentPane().add(panel);
    }
    public int countWords(String text) {
        String[] words = text.split("\\s+");
        return words.length;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}
