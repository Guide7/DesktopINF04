import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Form extends JFrame {
    private JPanel form;
    private JButton button1;
    private JButton button2;
    private JButton pobierzButton;
    private JLabel pobrania;
    private JLabel data;
    private JLabel liczbaUtworow;
    private JLabel album;
    private JLabel artysta;

    public Form(){
        setContentPane(form);
        setTitle("Moje Dźwięki wykonał: Idiota");
        setSize(800, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        List<Structure> list = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("D:\\szkola\\JAVA\\egzamin3\\egzamintrudny\\src\\Data.txt"));

            while (scanner.hasNextLine()) {
                Structure record = new Structure();

                record.setArtist(scanner.nextLine());
                record.setAlbum(scanner.nextLine());
                record.setSongsNumber(Integer.parseInt(scanner.nextLine()));
                record.setDate(scanner.nextLine());
                record.setDownloads(new BigInteger(scanner.nextLine()));

                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }

                list.add(record);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error in number format: " + e.getMessage());
        }

        for (Structure record : list) {
            System.out.println(record);
        }

        final int[] current_record = {0};

        artysta.setText(list.get(current_record[0]).getArtist());
        album.setText(list.get(current_record[0]).getAlbum());
        liczbaUtworow.setText(String.valueOf(list.get(current_record[0]).getSongsNumber()) + " utworów");
        data.setText(list.get(current_record[0]).getDate());
        pobrania.setText(String.valueOf(new BigInteger(String.valueOf(list.get(current_record[0]).getDownloads()))));

        pobierzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BigInteger val = list.get(current_record[0]).getDownloads();
                BigInteger val2 = BigInteger.valueOf(1);
                BigInteger valfinal = val.add(val2);
                pobrania.setText(String.valueOf(valfinal));
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(current_record[0] != 0){
                    current_record[0] = current_record[0] - 1;
                }
                artysta.setText(list.get(current_record[0]).getArtist());
                album.setText(list.get(current_record[0]).getAlbum());
                liczbaUtworow.setText(String.valueOf(list.get(current_record[0]).getSongsNumber()) + " utworów");
                data.setText(list.get(current_record[0]).getDate());
                pobrania.setText(String.valueOf(new BigInteger(String.valueOf(list.get(current_record[0]).getDownloads()))));
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(current_record[0] < list.size()){
                    current_record[0] = current_record[0] + 1;
                }else{
                    current_record[0] = 0;
                }
                artysta.setText(list.get(current_record[0]).getArtist());
                album.setText(list.get(current_record[0]).getAlbum());
                liczbaUtworow.setText(String.valueOf(list.get(current_record[0]).getSongsNumber()) + " utworów");
                data.setText(list.get(current_record[0]).getDate());
                pobrania.setText(String.valueOf(new BigInteger(String.valueOf(list.get(current_record[0]).getDownloads()))));
            }
        });
    }
}
