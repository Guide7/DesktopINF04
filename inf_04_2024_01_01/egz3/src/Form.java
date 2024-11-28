import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Form extends JFrame {
    private JPanel main_panel;
    private JTextField numer;
    private JTextField textField2;
    private JTextField textField3;
    private JRadioButton niebieskieRadioButton;
    private JRadioButton zieloneRadioButton;
    private JRadioButton piwneRadioButton;
    private JLabel zdjecie1;
    private JLabel zdjecie2;
    private JButton OKButton;

     public JLabel jLabel;

    public Form() throws HeadlessException {
        setContentPane(main_panel);
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Wprowadzenie danych paszportu. Wykonał: debil");
        setVisible(true);


        numer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num = numer.getText();

                if(Objects.equals(num, "111")){
                    zdjecie1.setIcon(new ImageIcon("src\\111-zdjecie.jpg"));
                    zdjecie2.setIcon(new ImageIcon("src\\111-odcisk.jpg"));
                }
                if(Objects.equals(num, "333")){
                    zdjecie1.setIcon(new ImageIcon("src\\333-zdjecie.jpg"));
                    zdjecie2.setIcon(new ImageIcon("src\\333-odcisk.jpg"));
                }
                if(Objects.equals(num, "000")){
                    zdjecie1.setIcon(new ImageIcon("src\\000-zdjecie.jpg"));
                    zdjecie2.setIcon(new ImageIcon("src\\000-odcisk.jpg"));
                }
            }
        });

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String imie = textField2.getText();
                String nazwisko = textField3.getText();

                boolean niebieskie = niebieskieRadioButton.isSelected();
                boolean zielone = zieloneRadioButton.isSelected();
                boolean piwne = piwneRadioButton.isSelected();

                JDialog jDialog = new JDialog();

                if(Objects.equals(imie, "") || Objects.equals(nazwisko, "")){
                    jDialog.setVisible(true);
                    jDialog.setSize(300, 200);
                    JLabel jLabel = new JLabel("Wprowadź dane");
                    jDialog.add(jLabel);
                }else{
                    jDialog.setVisible(true);
                    jDialog.setSize(300, 200);
                    if(niebieskie){
                        jLabel = new JLabel(imie + " " + nazwisko + " kolor oczu: niebieskie");
                    }else if(zielone){
                        jLabel = new JLabel(imie + " " + nazwisko + " kolor oczu: zielone ");
                    }else if(piwne){
                        jLabel = new JLabel(imie + " " + nazwisko + " kolor oczu: piwne ");
                    }

                    jDialog.add(jLabel);
                }
            }
        });
    }

    public static void main(String[] args) {
        new Form();
    }
}
