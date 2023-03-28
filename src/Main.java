package src;

import javax.swing.*;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        JOptionPane.setDefaultLocale(new Locale("hu_HU"));
        Locale.setDefault(new Locale("hu_HU"));

        GUI.inputWindow();

    }
}
