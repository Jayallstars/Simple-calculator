import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class JavaCalculator extends JFrame implements ActionListener {
        JButton b10, b11, b12, b13, b14, b15;
        JButton b[] = new JButton[10];
        int i, r, n1, n2;
        JTextField numberField;
        char op;
        JFrame window;

        public JavaCalculator() {
                super("JavaCalulator");
                setLayout(new FlowLayout());
                JPanel p = new JPanel();
                p.setLayout(new GridLayout(4, 4));
                Container container = window.getContentPane();
                for (int i = 0; i <= 9; i++) {
                        b[i] = new JButton(i + "");
                        p.add(b[i]);
                        b[i].addActionListener(this);
                }
                numberField = new JTextField(10);
                b10 = new JButton("+");
                container.add(b10);
                b10.addActionListener(this);

                b11 = new JButton("-");
                container.add(b11);
                b11.addActionListener(this);

                b12 = new JButton("*");
                p.add(b12);
                b12.addActionListener(this);

                b13 = new JButton("/");
                p.add(b13);
                b13.addActionListener(this);

                b14 = new JButton("=");
                p.add(b14);
                b14.addActionListener(this);

                b15 = new JButton("C");
                p.add(b15);
                b15.addActionListener(this);

                add(p, BorderLayout.CENTER);
                add(numberField, BorderLayout.NORTH);
                setSize(250, 340);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
        }

        public void actionPerformed(ActionEvent ae) {
                JButton pb = (JButton) ae.getSource();
                if (pb == b15) {
                        r = n1 = n2 = 0;
                        numberField.setText("");
                } else if (pb == b14) {
                        n2 = Integer.parseInt(numberField.getText());
                        eval();
                        numberField.setText("" + r);
                }

                else {
                        boolean opf = false;
                        if (pb == b10) {
                                op = '+';
                                opf = true;
                        }
                        if (pb == b11) {
                                op = '-';
                                opf = true;
                        }
                        if (pb == b12) {
                                op = '*';
                                opf = true;
                        }
                        if (pb == b13) {
                                op = '/';
                                opf = true;
                        }

                        if (opf == false) {
                                for (i = 0; i < 10; i++) {
                                        if (pb == b[i]) {
                                                String t = numberField.getText();
                                                t += i;
                                                numberField.setText(t);
                                        }
                                }
                        } else {
                                n1 = Integer.parseInt(numberField.getText());
                                numberField.setText("");
                        }
                }
        }

        int eval() {
                switch (op) {
                        case '+':
                                r = n1 + n2;
                                break;
                        case '-':
                                r = n1 - n2;
                                break;
                        case '*':
                                r = n1 * n2;
                                break;
                        case '/':
                                r = n1 / n2;
                                break;

                }
                return 0;
        }

        public static void main(String arg[]) {
                new JavaCalculator();
        }
}