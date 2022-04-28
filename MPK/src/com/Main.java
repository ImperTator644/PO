package com;

import com.mpk.Biletomat;
import com.mpk.Klient;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Klasa Main. Otwiera ekran glowny aplikacji, z wyborem dwoch kategorii:
 * "Nowy klient"
 * "Wybierz klienta"
 */
public class Main {
    public static ArrayList<Klient> klienci = new ArrayList<>(5);
    public static Biletomat biletomat = new Biletomat();
    public static CheckBox checkBox;
    public static void main(String[] args) {
        klienci.add(new Klient("Lukasz", "Kaczynski", "2000-03-07", true));
        klienci.get(0).portfel.addMoney(7, 60);
        checkBox = new CheckBox();
    }

    /**
     * Dodaje klienta do listy klientow
     * @param name imie klienta
     * @param surname nazwisko klienta
     * @param dateOfBirth data urodzenia klienta w formacie ("YYYY-MM-DD")
     * @param student czy klient jest studentem
     * @param zl ilosc zlotowek w portfelu klienta
     * @param gr ilosc groszt w portfelu klienta
     */
    public static void addKlient(String name, String surname, String dateOfBirth, boolean student, int zl, int gr){
        Klient temp = new Klient(name, surname, dateOfBirth, student);
        temp.portfel.addMoney(zl, gr);
        klienci.add(temp);
        temp.showInfo();
    }
}

/**
 * Klasa wyswietla ekran glowny aplikacji z wyborem dwoch kategorii
 */
class CheckBox extends JFrame implements ActionListener{
    JLabel l;
    JCheckBox nowyKlient;
    JCheckBox wybierzKlienta;
    JButton submit;

    public CheckBox(){
        l=new JLabel("Ekran glowny");
        l.setBounds(50,50,300,20);
        nowyKlient=new JCheckBox("Nowy klient");
        nowyKlient.setBounds(100,100,150,20);
        wybierzKlienta=new JCheckBox("Wybierz klienta");
        wybierzKlienta.setBounds(100,150,150,20);
        submit = new JButton("OK");
        submit.setBounds(100,250,80,30);
        submit.addActionListener(this);
        add(l);add(nowyKlient);add(wybierzKlienta);add(submit);
        setSize(400,400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e){
        if(nowyKlient.isSelected()){
            String imie = JOptionPane.showInputDialog(this, "IMIE:");
            String nazwisko = JOptionPane.showInputDialog(this, "NAZWISKO:");
            String dataUrodzenia = JOptionPane.showInputDialog(this, "DATA URODZENIA (RRRR-MM-DD)");
            int czyStudent = JOptionPane.showConfirmDialog(this, "CZY STUDENT");
            boolean student;
            student = czyStudent == 0;
            int zlotowki = Integer.parseInt(JOptionPane.showInputDialog(this, "STAN ZLOTOWEK"));
            int grosze = Integer.parseInt(JOptionPane.showInputDialog(this, "STAN GROSZY"));
            Main.addKlient(imie, nazwisko, dataUrodzenia, student, zlotowki, grosze);
        }
        if(wybierzKlienta.isSelected()){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<Main.klienci.size();i++){
                sb.append((i+1)).append(". ").append(Main.klienci.get(i).getName()).append(" ").append(Main.klienci.get(i).getSurname()).append("\n");
            }
            JOptionPane.showMessageDialog(this, sb.toString());
            int wybor = Integer.parseInt(JOptionPane.showInputDialog(this, "WYBIERZ KLIENTA"));
            Main.biletomat.showCheckBox(Main.klienci.get((wybor-1)));
        }
    }
}