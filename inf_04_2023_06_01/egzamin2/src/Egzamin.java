import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Egzamin extends JFrame {
    private JPanel panel;
    private JRadioButton pocztówkaRadioButton;
    private JRadioButton listRadioButton;
    private JRadioButton paczkaRadioButton;
    private JButton sprawdźCeneButton;
    private JLabel cena;
    private JLabel zdjecie;
    private JTextField textField1;
    private JLabel ulica;
    private JLabel kodpocztowy;
    private JTextField textField2;
    private JTextField textField3;
    private JButton zatwierdźButton;

    public Egzamin() {
        setContentPane(panel);
        setTitle("Nadaj przesyłke");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);


        sprawdźCeneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kliknij();
            }
        });

        zatwierdźButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zatwierdz();
            }
        });
    }

    public void kliknij(){
        if(pocztówkaRadioButton.isSelected()){
            cena.setText("Cena: 1zł");
            zdjecie.setIcon(new ImageIcon("src/pocztowka.png"));
        }
        if(listRadioButton.isSelected()){
            cena.setText("Cena: 1,5zł");
            zdjecie.setIcon(new ImageIcon("src/list.png"));
        }
        if(paczkaRadioButton.isSelected()){
            cena.setText("Cena: 10zł");
            zdjecie.setIcon(new ImageIcon("src/paczka.png"));
        }
    }

    public void zatwierdz(){
        String kodpocz = textField2.getText();
        if(kodpocz.length() == 5 && kodpocz.matches("[0-9]+")){
            System.out.println("Dane przesyłki zostały wprowadzone!");
        }
        if(kodpocz.length() != 5){
            System.out.println("Nieprawidłowa liczba cyfr w kodzie pocztowym");
        }
        if(!kodpocz.matches("[0-9]+")){
            System.out.println("Kod pocztowy może składać się tylko z samych cyfr");
        }
    }
}
