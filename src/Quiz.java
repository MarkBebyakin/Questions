import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener{

    String[] questions = {
            "Years of first 'Chechen war'?",
            "Is there a place for pineapple on pizza?",
            "What happened in Tienanmen Square in 1989?",
            "Name the most famous sphinx in the world?"

    };

    String[][] options = {
            {"1994 - 2023 maybe?", "1773 - 1778", "1979 - 1988", "1994 - 1996"},
            {"What is a 'Pizza'? (I'M DUMB)", "No, that's disgusting!", "it's a personal taste of each person", "Yes"},
            {"Nothing", "Protests and massacre!", "I am Uighur! ", "I heard something about it"},
            {"Alex", "Bingus", "Floppa", "Jinx"}
    };

    char[] rightAnswers = {
            'D',
            'C',
            'A',
            'B'
    };

    char answer;
    int index;
    int correctGuesses = 0;
    int totalQuestions = questions.length;
    int result;
    int seconds = 10;

    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();

    JLabel answerLabelA = new JLabel();
    JLabel answerLabelB = new JLabel();
    JLabel answerLabelC = new JLabel();
    JLabel answerLabelD = new JLabel();
    JLabel timeLabel = new JLabel();
    JLabel secondsLeft = new JLabel();

    JTextField numberRight = new JTextField();
    JTextField percentage = new JTextField();

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            secondsLeft.setText(String.valueOf(seconds));
            if(seconds<= 0 ) {
                displayAnswer();
            }

        }
    });

    public Quiz() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,590);
        frame.getContentPane().setBackground(new Color(255, 85, 85));
        frame.setLayout(null);
        frame.setResizable(false);

        textField.setBounds(0, 0, 800, 50);
        textField.setBackground(new Color(210, 65, 65));
        textField.setForeground(new Color(255, 117, 117));
        textField.setFont(new Font("Ink Free", Font.BOLD, 30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);

        textArea.setBounds(0, 50, 800, 50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(210, 65, 65));
        textArea.setForeground(new Color(255, 117, 117));
        textArea.setFont(new Font("MV Boli", Font.BOLD, 25));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);

        buttonA.setBounds(10,110,165,100);
        buttonA.setFont(new Font("MV Boli", Font.BOLD, 40));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(10,220,165,100);
        buttonB.setFont(new Font("MV Boli", Font.BOLD, 40));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(10,330,165,100);
        buttonC.setFont(new Font("MV Boli", Font.BOLD, 40));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(10,440,165,100);
        buttonD.setFont(new Font("MV Boli", Font.BOLD, 40));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        answerLabelA.setBounds(185, 105, 500, 100);
        answerLabelA.setBackground(new Color(50, 50, 50));
        answerLabelA.setForeground(new Color(210, 250, 0));
        answerLabelA.setFont(new Font("MV Boli", Font.PLAIN, 25));


        answerLabelB.setBounds(185, 215, 500, 100);
        answerLabelB.setBackground(new Color(50, 50, 50));
        answerLabelB.setForeground(new Color(210, 250, 0));
        answerLabelB.setFont(new Font("MV Boli", Font.PLAIN, 25));


        answerLabelC.setBounds(185, 325, 500, 100);
        answerLabelC.setBackground(new Color(50, 50, 50));
        answerLabelC.setForeground(new Color(210, 250, 0));
        answerLabelC.setFont(new Font("MV Boli", Font.PLAIN, 25));


        answerLabelD.setBounds(185, 435, 500, 100);
        answerLabelD.setBackground(new Color(50, 50, 50));
        answerLabelD.setForeground(new Color(210, 250, 0));
        answerLabelD.setFont(new Font("MV Boli", Font.PLAIN, 25));

        secondsLeft.setBounds(700, 470, 70, 70);
        secondsLeft.setBackground(new Color(210, 65, 65));
        secondsLeft.setForeground(new Color(210, 250, 0));
        secondsLeft.setFont(new Font("Ink Free", Font.BOLD, 50));
        secondsLeft.setBorder(BorderFactory.createBevelBorder(1));
        secondsLeft.setOpaque(true);
        secondsLeft.setHorizontalAlignment(JTextField.CENTER);
        secondsLeft.setText(String.valueOf(seconds));

        timeLabel.setBounds(430, 490, 300, 25);
        timeLabel.setBackground(new Color(210, 65, 65));
        timeLabel.setForeground(new Color(162, 53, 53));
        timeLabel.setFont(new Font("MV Boli", Font.PLAIN, 30));
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        timeLabel.setText("Timer >;) --->");

        numberRight.setBounds(300,185, 200, 100);
        numberRight.setBackground(new Color(210, 65, 65));
        numberRight.setForeground(new Color(210, 250, 0));
        numberRight.setFont(new Font("Ink Free", Font.BOLD, 50));
        numberRight.setBorder(BorderFactory.createBevelBorder(1));
        numberRight.setHorizontalAlignment(JTextField.CENTER);
        numberRight.setEditable(false);

        percentage.setBounds(300, 285, 200, 100);
        percentage.setBackground(new Color(210, 65, 65));
        percentage.setForeground(new Color(210, 250, 0));
        percentage.setFont(new Font("Ink Free", Font.BOLD, 40));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);


        frame.add(timeLabel);
        frame.add(secondsLeft);
        frame.add(answerLabelA);
        frame.add(answerLabelB);
        frame.add(answerLabelC);
        frame.add(answerLabelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textArea);
        frame.add(textField);
        frame.setVisible(true);

        nextQuestion();

    }
    public void nextQuestion() {
        if(index>=totalQuestions) {
            results();
        }
        else {
            textField.setText("Question " + (index + 1));
            textArea.setText(questions[index]);
            answerLabelA.setText(options[index][0]);
            answerLabelB.setText(options[index][1]);
            answerLabelC.setText(options[index][2]);
            answerLabelD.setText(options[index][3]);

            timer.start();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (e.getSource()==buttonA) {
            answer = 'A';
            if(answer == rightAnswers[index]) {
                correctGuesses++;
            }
        }
        if (e.getSource()==buttonB) {
            answer = 'B';
            if(answer == rightAnswers[index]) {
                correctGuesses++;
            }
        }
        if (e.getSource()==buttonC) {
            answer = 'C';
            if(answer == rightAnswers[index]) {
                correctGuesses++;
            }
        }
        if (e.getSource()==buttonD) {
            answer = 'D';
            if(answer == rightAnswers[index]) {
                correctGuesses++;
            }
        }
        displayAnswer();

    }
    public void displayAnswer() {

        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(rightAnswers[index] != 'A')
            answerLabelA.setForeground(new Color(227, 30, 30));
        if(rightAnswers[index] != 'B')
            answerLabelB.setForeground(new Color(227, 30, 30));
        if(rightAnswers[index] != 'C')
            answerLabelC.setForeground(new Color(227, 30, 30));
        if(rightAnswers[index] != 'D')
            answerLabelD.setForeground(new Color(227, 30, 30));

        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                answerLabelA.setForeground(new Color(210, 255, 0));
                answerLabelB.setForeground(new Color(210, 255, 0));
                answerLabelC.setForeground(new Color(210, 255, 0));
                answerLabelD.setForeground(new Color(210, 255, 0));

                answer = ' ';
                seconds = 10;
                secondsLeft.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();
    }
    public void results() {

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result = (int)((correctGuesses/(double)totalQuestions) * 100);

        textField.setText("RESULTS!");
         textArea.setText(" ");
        answerLabelA.setText(" ");
        answerLabelB.setText(" ");
        answerLabelC.setText(" ");
        answerLabelD.setText(" ");

        numberRight.setText("(" + correctGuesses + "/" + totalQuestions + ")");
        percentage.setText(result + "%");

        frame.add(percentage);
        frame.add(numberRight);
    }
}
