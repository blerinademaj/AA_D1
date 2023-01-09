package Detyra1;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class TimeTest {
    // frame
    JFrame f;
    // tabela
    JTable j;

    Non_rekursive obj = new Non_rekursive();
    Metoda_rekursive obj2 = new Metoda_rekursive();

    public TimeTest() {
        f = new JFrame();
        f.setTitle("Testimi i kohës së ekzekutimit të dy algoritmeve të klasave");

        double a = obj.time_millis();
        double b = obj2.time_millis();
        double c = obj.time_nano();
        double d = obj2.time_nano();
        // Të dhënat e shfaqura në JTable(tabelë)
        String[][] data = {
                { "  Koha në sekonda", "    " + obj.time_second(), " " + "    " + obj2.time_second() },
                { "  Koha në milisekonda", "    " + a, "    " + b },
                { "  Koha në mikrosekonda", "    " + obj.time_microsecond(), "    " + obj2.time_microsecond() },
                { "  Koha në nanosekonda", "    " + c, "    " + d },
                { "  Koha në pikosekonda", "    " + obj.time_picosecond(), "    " + obj2.time_picosecond() }
        };

        // Emrat e kolonave
        String[] columnNames = { "Koha e ekzekutimit", "Klasa Non_rekursive", "Klasa Metoda_rekursive" };

        // Initializimi i tabelës
        j = new JTable(data, columnNames);
        JTableHeader tableHeader = j.getTableHeader();
        tableHeader.setBackground(new Color(109, 109, 231, 50));
        tableHeader.setPreferredSize(new Dimension(35, 35));
        j.setBackground(new Color(109, 109, 231, 51));
        j.setRowHeight(27);
        // I shtojmë JScrollPane
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        f.setSize(500, 210);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new TimeTest();
    }
}
