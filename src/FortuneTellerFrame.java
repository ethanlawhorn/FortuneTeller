import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JLabel titleLabel;
    private JTextArea fortuneArea;
    private JButton readButton;
    private JButton quitButton;
    private ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;

    public FortuneTellerFrame() {
        super("Honest Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setResizable(false);
        setLocationRelativeTo(null);


        fortunes = new ArrayList<>();
        fortunes.add("You will have to be peanut butter for Halloween for the 7th time in a row because your girlfriend thinks she looks so cute as jelly.");
        fortunes.add("You will go to jail for kicking your prostate doctor so hard that he fell back and severally injured himself.");
        fortunes.add("You will gain 30 pounds of lean muscle soon.");
        fortunes.add("You will have a legendary fight with Shia Labeouf in 4 months.");
        fortunes.add("You will be given super powers for 2 minutes but forget the time when you're in the stratosphere.");
        fortunes.add("You will be fired, then promoted within the same 2 minutes");
        fortunes.add("You will win the lottery someday, but it will all go downhill when you get too greedy and bet it on the Bengals winning the Super Bowl.");
        fortunes.add("You will be the villain in the Fast and Furious 53 movie.");
        fortunes.add("You will make another Emoji Movie and realize how bad of an idea it was.");
        fortunes.add("You will refer to everything, except lamps, as 'Not Lamps' because technically, everything that isn't a lamp can be called 'Not Lamp' but your wife will soon get sick of it and divorce you and take the kids and half your money. You keep the dog though.");
        fortunes.add("You will have a wart the size of the 1989 Vince Lombardi Trophy awarded to the 49ers.");
        fortunes.add("You will be happy.");

        // TITLE
        titleLabel = new JLabel("Fortune Teller", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        getContentPane().setBackground(Color.LIGHT_GRAY);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);


        fortuneArea = new JTextArea();
        fortuneArea.setEditable(false);
        fortuneArea.setFont(new Font("Arial", Font.PLAIN, 24));


        JScrollPane scrollPane = new JScrollPane(fortuneArea);


        // FORTUNE BUTTON
        readButton = new JButton("Read My Fortune!");
        readButton.setFont(new Font("Arial", Font.BOLD, 24));
        readButton.setBackground(Color.RED);
        readButton.setForeground(Color.WHITE);
        readButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        readButton.setFocusPainted(false);
        readButton.addActionListener((ActionEvent e) -> {

            String fortune = getRandomFortune();
            fortuneArea.append(fortune + "\n");
        });

        // QUIT BUTTON
        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Arial", Font.BOLD, 24));
        quitButton.setBackground(Color.RED);
        quitButton.setForeground(Color.WHITE);
        quitButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        quitButton.setFocusPainted(false);
        quitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        // ADDING COMPONENTS
        add(titleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(readButton);
        buttonPanel.add(quitButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private String getRandomFortune() {
        int index = lastFortuneIndex;
        while (index == lastFortuneIndex) {
            index = new Random().nextInt(fortunes.size());
        }
        lastFortuneIndex = index;
        return fortunes.get(index);
    }
}