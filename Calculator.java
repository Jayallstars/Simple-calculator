import java.awt.*;
import java.awt.event.*;
import java.lang.ref.Cleaner;
import java.util.Arrays;
import javax.swing.*;

public class Calculator implements ActionListener {
        JButton b10, b11, b12, b13, b14, b15;
        JButton b[] = new JButton[10];
        int i, r, n1, n2;
        char op;
        //------------------------------------------//
        JLabel numberLabel;
        JTextField numberField;
        JButton btn1, btn2, btn3, btn4, btn5, btn6,
                        btn7, btn8, btn9, btn0, btnc,
                        btnplus, btnsub, btnmulti, btndiv,
                        btnmod, btnpercent, btnpow, btndel, btnpos, btnneg, btnequal;
        JFrame window;

        public Calculator() {
                // obtain content pane and set its layout to FlowLayout
                window = new JFrame("Programm Show Text");
                Container container = window.getContentPane();
                container.setLayout(new FlowLayout());
                // create numberLabel and attach it to content pane
                numberLabel = new JLabel("Show Number : ");
                container.add(numberLabel);
                numberField = new JTextField(10);
                // numberField.setEditable( false );
                container.add(numberField);
                btn1 = new JButton(" 1 ");
                btn1.addActionListener(this);
                container.add(btn1);
                btn2 = new JButton(" 2 ");
                btn2.addActionListener(this);
                container.add(btn2);
                btn3 = new JButton(" 3 ");
                btn3.addActionListener(this);
                container.add(btn3);
                btn4 = new JButton(" 4 ");
                btn4.addActionListener(this);
                container.add(btn4);
                btn5 = new JButton(" 5 ");
                btn5.addActionListener(this);
                container.add(btn5);
                btn6 = new JButton(" 6 ");
                btn6.addActionListener(this);
                container.add(btn6);
                btn7 = new JButton(" 7 ");
                btn7.addActionListener(this);
                container.add(btn7);
                btn8 = new JButton(" 8 ");
                btn8.addActionListener(this);
                container.add(btn8);
                btn9 = new JButton(" 9 ");
                btn9.addActionListener(this);
                container.add(btn9);
                btn0 = new JButton(" 0 ");
                btn0.addActionListener(this);
                container.add(btn0);
                btnplus = new JButton(" + ");
                btnplus.addActionListener(this);
                container.add(btnplus);
                btnsub = new JButton(" - ");
                btnsub.addActionListener(this);
                container.add(btnsub);
                btnmulti = new JButton(" * ");
                btnmulti.addActionListener(this);
                container.add(btnmulti);
                btndiv = new JButton(" / ");
                btndiv.addActionListener(this);
                container.add(btndiv);
                btnmod = new JButton(" mod ");
                btnmod.addActionListener(this);
                container.add(btnmod);
                btnpercent = new JButton(" % ");
                btnpercent.addActionListener(this);
                container.add(btnpercent);
                btnpow = new JButton(" x^y ");
                btnpow.addActionListener(this);
                container.add(btnpow);
                btnneg = new JButton(" -x ");
                btnneg.addActionListener(this);
                container.add(btnneg);
                btndel = new JButton(" Del ");
                btndel.addActionListener(this);
                container.add(btndel);
                btnc = new JButton(" C ");
                btnc.addActionListener(this);
                container.add(btnc);
                btnequal = new JButton(" = ");
                btnequal.addActionListener(this);
                container.add(btnequal);

                window.setSize(250, 340);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setVisible(true);
        }

        public void actionPerformed(ActionEvent ae) {
                JButton pb = (JButton) ae.getSource();
                if (pb == btnc) {
                        r = n1 = n2 = 0;
                        numberField.setText("");
                } else if (pb == btnequal) {
                        n2 = Integer.parseInt(numberField.getText());
                        eval();
                        numberField.setText("" + r);
                }

                else {
                        boolean opf = false;
                        if (pb == btnplus) {
                                op = '+';
                                opf = true;
                        }
                        if (pb == btnsub) {
                                op = '-';
                                opf = true;
                        }
                        if (pb == btnmulti) {
                                op = '*';
                                opf = true;
                        }
                        if (pb == btndiv) {
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

        public static float calNum(String test) {
                float test_int = 0;
                String[] store = new String[2];
                char[] ch = test.toCharArray();
                if (ch[1] == '+') {
                        store[0] = String.valueOf(ch[0]);
                        store[1] = String.valueOf(ch[2]);
                        test_int = Float.parseFloat(store[0]) + Float.parseFloat(store[1]);
                }
                if (ch[1] == '-') {
                        store[0] = String.valueOf(ch[0]);
                        store[1] = String.valueOf(ch[2]);
                        test_int = Float.parseFloat(store[0]) - Float.parseFloat(store[1]);
                }
                if (ch[1] == '*') {
                        store[0] = String.valueOf(ch[0]);
                        store[1] = String.valueOf(ch[2]);
                        test_int = Float.parseFloat(store[0]) * Float.parseFloat(store[1]);
                }
                if (ch[1] == '/') {
                        store[0] = String.valueOf(ch[0]);
                        store[1] = String.valueOf(ch[2]);
                        test_int = Float.parseFloat(store[0]) / Float.parseFloat(store[1]);
                }
                if (ch[1] == '%') {
                        store[0] = String.valueOf(ch[0]);
                        store[1] = String.valueOf(ch[2]);
                        test_int = Float.parseFloat(store[0]) / 100;
                }
                if (ch[1] == 'm') {
                        store[0] = String.valueOf(ch[0]);
                        store[1] = String.valueOf(ch[2]);
                        test_int = Float.parseFloat(store[0]) % Float.parseFloat(store[1]);
                }
                return test_int;
        }

        public static void main(String[] args) {
                Calculator gui = new Calculator();
        }
}