import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.util.Random;

public class Egz extends JFrame {

    private JPanel panel;
    private JPanel lewy;
    private JPanel prawy;
    private JPanel dolny;
    private JTextField imie;
    private JTextField nazwisko;
    private JComboBox stanowisko;
    private JTextField ilosc_znakow;
    private JCheckBox małeIWielkieLiteryCheckBox;
    private JCheckBox cyfryCheckBox;
    private JCheckBox znakiSpecjalneCheckBox;
    private JButton generujHasłoButton;
    private JButton zatwierdźButton;
    private JLabel ileznakow;
    private JLabel stanowiskoo;
    private JLabel nazwiskoo;
    private JLabel imiee;
    StringBuilder haslo;

    public Egz(){
        setContentPane(panel);
        setTitle("Egzamin");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        lewy.setBorder(new TitledBorder( new LineBorder(Color.WHITE, 2), "Dane pracownika"));
        prawy.setBorder(new TitledBorder( new LineBorder(Color.WHITE, 2), "Generowanie hasła"));
        stanowisko.addItem("Kierownik");
        stanowisko.addItem("Starszy programista");
        stanowisko.addItem("Młodszy programista");
        stanowisko.addItem("Tester");
        System.out.println("xd");


        generujHasłoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generowanieHasla();
            }
        });

        zatwierdźButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                glownyPrzycisk();
            }
        });
    }

    public void glownyPrzycisk(){
        String imieValue = imie.getText();
        String naziwskoValue = nazwisko.getText();
        String stanowiskoValue = (String) stanowisko.getSelectedItem();

        JDialog dialog = new JDialog();
        JLabel l = new JLabel("Dane pracownika: " + imieValue + " " + naziwskoValue + " " + stanowiskoValue + " Hasło: " + haslo );
        dialog.add(l);
        dialog.setSize(300,100);
        dialog.setVisible(true);
    }

    public void generowanieHasla(){

        int iloscznakow = Integer.parseInt(ilosc_znakow.getText());

        System.out.println("nie podano liczby");

        Random r = new Random();

        boolean malewielkie = małeIWielkieLiteryCheckBox.isSelected();
        boolean cyfry = cyfryCheckBox.isSelected();
        boolean znaki = znakiSpecjalneCheckBox.isSelected();

        String[] duzeLitery = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] maleLitery = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] cyfrytab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        String[] znakitab = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")"};

        haslo = new StringBuilder();

        while (haslo.length() < iloscznakow) {
            int randomPick = r.nextInt(4);

            if (randomPick == 0 && malewielkie) {
                haslo.append(duzeLitery[r.nextInt(duzeLitery.length)]);
            } else if (randomPick == 1 && cyfry) {
                haslo.append(cyfrytab[r.nextInt(cyfrytab.length)]);
            } else if (randomPick == 2 && znaki) {
                haslo.append(znakitab[r.nextInt(znakitab.length)]);
            } else if (randomPick == 3) {
                haslo.append(maleLitery[r.nextInt(maleLitery.length)]);
            }
        }

        JDialog dialog = new JDialog();
        JLabel l = new JLabel(String.valueOf(haslo));
        dialog.add(l);
        dialog.setSize(300,100);
        dialog.setVisible(true);

        System.out.println(haslo);
    }


    public static void main(String[] args) {
        new Egz();
    }
}
