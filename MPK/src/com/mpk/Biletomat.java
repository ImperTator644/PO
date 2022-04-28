package com.mpk;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Klasa biletomat, ktora zawiera metody "sprzedawania" biletow
 * Otwiera ekran "Biletomat" z opcjami:
 * "Kup bilet"
 * "Pokaz informacje o kliencie"
 * "Pokaz transakcje"
 */
public class Biletomat {
    private static final ArrayList<Bilet> transakcje = new ArrayList<>(5); //zastosowany mechanizm kompozycji
    private final CheckBox checkBox;

    /**
     * Tworzy ekran "Biletomat"
     */
    public Biletomat(){
        checkBox = new CheckBox();
    }

    /**
     * Otwiera ekran "Biletomat" dla wybranego klienta
     * @param klient wybrany klient
     */
    public void showCheckBox(Klient klient){
        checkBox.client = klient;
        checkBox.setVisible(true);
    }

    /**
     * Dodaje bilet do listy transakcji
     * @param b bilet do dodania
     */
    public static void addTransakcja(Bilet b){
        transakcje.add(b);
    }

    /**
     * Pokazuje ekran z wypisanymi transakcjami
     */
    public static void showTransakcje(){
        StringBuilder sb = new StringBuilder();
        for(Bilet b:transakcje){
            sb.append(b).append("\n------------");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}

/**
 * Klasa tworzaca ekran "Biletomat"
 */
class CheckBox extends JFrame implements ActionListener {
    private final JLabel l;
    private final JCheckBox kupBilet;
    private final JCheckBox pokazInfoKlient;
    private final JCheckBox pokazTransakcje;
    private final JButton submit;
    public Klient client;

    public CheckBox(){
        l=new JLabel("Biletomat");
        l.setBounds(50,50,300,20);

        kupBilet=new JCheckBox("Kup bilet");
        kupBilet.setBounds(100,100,150,20);

        pokazInfoKlient=new JCheckBox("Pokaz info klient");
        pokazInfoKlient.setBounds(100,150,150,20);

        pokazTransakcje=new JCheckBox("Pokaz transakcje");
        pokazTransakcje.setBounds(100,200,150,20);

        submit = new JButton("OK");
        submit.setBounds(100,250,80,30);
        submit.addActionListener(this);
        add(l);add(kupBilet);add(pokazInfoKlient);add(pokazTransakcje);add(submit);
        setSize(400,400);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e){
        if(pokazInfoKlient.isSelected()){
            client.showInfo();
        }
        if(kupBilet.isSelected()){
            String bilety = "1. 24-godzinny 8.50zl/17zl\n2. 20-minutowy 2zl/4zl\n3. 60-cio minutowy 3zl/6zl\n4. 90-cio minutowy 4zl/8zl";
            JOptionPane.showMessageDialog(this, bilety);
            int wybor = Integer.parseInt(JOptionPane.showInputDialog(this, "WYBIERZ BILET"));
            int czyUlga = JOptionPane.showConfirmDialog(this, "ULGOWY?");
            int ilosc = Integer.parseInt(JOptionPane.showInputDialog(this, "IlOSC BILETOW"));
            String u;
            if(czyUlga==0) u="U";
            else u="N";
            for(int i=0;i<ilosc;i++) {
                Bilet bilet = new Bilet(wybor, u);
                if (client.addTicket(bilet)) {
                    JOptionPane.showMessageDialog(this, bilet.toString(), "ZAKUPIONO", JOptionPane.INFORMATION_MESSAGE);
                    Biletomat.addTransakcja(bilet);

                } else {
                    JOptionPane.showMessageDialog(this, "BRAK SRODKOW", "INFO", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        if(pokazTransakcje.isSelected()){
            Biletomat.showTransakcje();
        }
    }
}