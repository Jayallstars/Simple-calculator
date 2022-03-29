import java.awt.*;
import java.awt.event.*;
import java.lang.ref.Cleaner;
import java.util.Arrays;
import javax.swing.*;

public class JavaCalculator extends JFrame implements ActionListener {
        JButton btnplus, btnsub, btnmul, btndiv, btnequals, btnclear,
        btnmod, btnpercent, btnpow, btndel, btnpos, btnneg;
        JButton b[] = new JButton[10];
        float n1, n2, r;
        int i ,n3;
        JTextField numberField;
        String op,store;
        JFrame window;

        public JavaCalculator() {
                window = new JFrame("Java Calculator");
                Container container = window.getContentPane();
                container.setLayout(new FlowLayout());
                numberField = new JTextField(25);
                container.add(numberField);
                for (int i = 0; i <= 9; i++) {
                        b[i] = new JButton(i + "");
                        container.add(b[i]);
                        b[i].addActionListener(this);
                }
                btnplus = new JButton("+");
                container.add(btnplus);
                btnplus.addActionListener(this);

                btnsub = new JButton("-");
                container.add(btnsub);
                btnsub.addActionListener(this);

                btnmul = new JButton("*");
                container.add(btnmul);
                btnmul.addActionListener(this);

                btndiv = new JButton("/");
                container.add(btndiv);
                btndiv.addActionListener(this);

                btnmod = new JButton("mod");
                container.add(btnmod);
                btnmod.addActionListener(this);

                btnpercent = new JButton("%");
                container.add(btnpercent);
                btnpercent.addActionListener(this);

                btnpow = new JButton("x^y");
                container.add(btnpow);
                btnpow.addActionListener(this);

                btnpos = new JButton("-/+");
                container.add(btnpos);
                btnpos.addActionListener(this);

                btndel = new JButton("Del");
                container.add(btndel);
                btndel.addActionListener(this);

                btnequals = new JButton("=");
                container.add(btnequals);
                btnequals.addActionListener(this);

                btnclear = new JButton("C");
                container.add(btnclear);
                btnclear.addActionListener(this);

                window.setSize(300, 300);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setVisible(true);
        }

        public void actionPerformed(ActionEvent ae) {
                JButton pb = (JButton) ae.getSource();
                if (pb == btnclear) {
                        r = n1 = n2 = 0;
                        numberField.setText("");
                } else if (pb == btnequals) {
                        n2 = Integer.parseInt(numberField.getText());
                        eval();
                        numberField.setText("" + r);
                } else if (pb == btnpercent){
                        n1 = Float.parseFloat(numberField.getText());
                        n1 = n1 / 100;
                        numberField.setText(String.valueOf(n1));
                } else if (pb == btnpos){
                        n1 = Integer.parseInt(numberField.getText());
                        numberField.setText("-" + String.valueOf(n1));
                } else if (pb == btndel){
                        n3 = Integer.parseInt(numberField.getText());
                        store = Integer.toString(n3);
                        char [] arr = store.toCharArray();
                        arr = Arrays.copyOf(arr, arr.length - 1);
                        store = String.valueOf(arr);
                        numberField.setText(store);
                }

                else {
                        boolean opf = false;
                        if (pb == btnplus) {
                                op = "+";
                                opf = true;
                        }
                        if (pb == btnsub) {
                                op = "-";
                                opf = true;
                        }
                        if (pb == btnmul) {
                                op = "*";
                                opf = true;
                        }
                        if (pb == btndiv) {
                                op = "/";
                                opf = true;
                        }
                        if (pb == btnmod){
                                op = "%";
                                opf = true;
                        }
                        if (pb == btnpow){
                                op = "pow";
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
                        case "+":
                                r = n1 + n2;
                                break;
                        case "-":
                                r = n1 - n2;
                                break;
                        case "*":
                                r = n1 * n2;
                                break;
                        case "/":
                                r = n1 / n2;
                                break;
                        case "%":
                                r = n1 % n2;
                                break;
                        case "pow":
                                r = (float) Math.pow(n1, n2);
                                break;
                }
                return 0;
        }

        public static void main(String arg[]) {
                new JavaCalculator();
        }
}