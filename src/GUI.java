package src;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class GUI {
    static Dimension res = Toolkit.getDefaultToolkit().getScreenSize();

    private static final JFrame frame = new JFrame("Futkosó kutya"); //TODO: talán ezeket private-re
    static JTextField p1Speed = new JTextField(30);
    static JTextField p2Speed = new JTextField(30);
    static JTextField distance = new JTextField(30);
    static JTextField dogSpeed = new JTextField(30);
    static JLabel dogRounds = new JLabel("0");
    static JLabel dogDistanceRanInACycle = new JLabel("0");
    static JLabel dogAllDistance = new JLabel("0");
    static JTextField stepTime = new JTextField(30);
    static JButton next = new JButton("Következő");
    public static void inputWindow() {

        //set up main panel
        JPanel mainPanel = new JPanel();
        BoxLayout mainLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
        mainPanel.setLayout(mainLayout);
        mainPanel.setBorder(new CompoundBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10),
                BorderFactory.createTitledBorder("Paraméterek")), new EmptyBorder(5, 5, 5, 5)));
        mainPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.setMaximumSize(new Dimension(res.width/4, res.height/2));


        //set up person subpanel
        JPanel p1Panel = new JPanel();
        p1Panel.setLayout(new BoxLayout(p1Panel, BoxLayout.LINE_AXIS));
        JLabel p1Label = new JLabel("1. személy sebessége:");
        p1Panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        p1Speed.setAlignmentX(Component.LEFT_ALIGNMENT);
        p1Speed.setMaximumSize(new Dimension(200, 30));
        p1Panel.add(p1Label);
        p1Panel.add(Box.createHorizontalGlue());
        p1Panel.add(p1Speed);

        //person 2 subpanel
        JPanel p2Panel = new JPanel();
        p2Panel.setLayout(new BoxLayout(p2Panel, BoxLayout.LINE_AXIS));
        JLabel p2Label = new JLabel("2. személy sebessége:");
        p2Panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        p2Speed.setAlignmentX(Component.LEFT_ALIGNMENT);
        p2Speed.setMaximumSize(new Dimension(200, 30));
        p2Panel.add(p2Label);
        p2Panel.add(Box.createHorizontalGlue());
        p2Panel.add(p2Speed);

        //disatnce subpabel
        JPanel distancePanel = new JPanel();
        distancePanel.setLayout(new BoxLayout(distancePanel, BoxLayout.LINE_AXIS));
        JLabel distanceLabel = new JLabel("Személyek távolsága:");
        distancePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        distance.setAlignmentX(Component.LEFT_ALIGNMENT);
        distance.setMaximumSize(new Dimension(200, 30));
        distancePanel.add(distanceLabel);
        distancePanel.add(Box.createHorizontalGlue());
        distancePanel.add(distance);

        //dog speed subpanel
        JPanel dogSpeedPanel = new JPanel();
        dogSpeedPanel.setLayout(new BoxLayout(dogSpeedPanel, BoxLayout.LINE_AXIS));
        JLabel dogSpeedLabel = new JLabel("Kutya sebessége:");
        dogSpeedPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        dogSpeed.setAlignmentX(Component.LEFT_ALIGNMENT);
        dogSpeed.setMaximumSize(new Dimension(200, 30));
        dogSpeedPanel.add(dogSpeedLabel);
        dogSpeedPanel.add(Box.createHorizontalGlue());
        dogSpeedPanel.add(dogSpeed);

        //dog rounds label
        JPanel dogRoundsPanel = new JPanel();
        dogRoundsPanel.setLayout(new BoxLayout(dogRoundsPanel, BoxLayout.LINE_AXIS));
        JLabel dogRoundsLabel = new JLabel("Kutya körei: ");
        dogRoundsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        dogRounds.setAlignmentX(Component.LEFT_ALIGNMENT);
        dogRounds.setMaximumSize(new Dimension(200, 30));
        dogRoundsPanel.add(dogRoundsLabel);
        dogRoundsPanel.add(Box.createHorizontalGlue());
        dogRoundsPanel.add(dogRounds);

        //dog distanceRanInACycle label
        JPanel dogCycleDistancePanel = new JPanel();
        dogCycleDistancePanel.setLayout(new BoxLayout(dogCycleDistancePanel, BoxLayout.LINE_AXIS));
        JLabel dogCycleDistanceLabel = new JLabel("Kutya távolsága a jelenlegi körben: ");
        dogCycleDistancePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        dogDistanceRanInACycle.setAlignmentX(Component.LEFT_ALIGNMENT);
        dogDistanceRanInACycle.setMaximumSize(new Dimension(200, 30));
        dogCycleDistancePanel.add(dogCycleDistanceLabel);
        dogCycleDistancePanel.add(Box.createHorizontalGlue());
        dogCycleDistancePanel.add(dogDistanceRanInACycle);

        //dog all distance
        JPanel dogTraveledPanel = new JPanel();
        dogTraveledPanel.setLayout(new BoxLayout(dogTraveledPanel, BoxLayout.LINE_AXIS));
        JLabel dogTraveledLabel = new JLabel("Kutya összes útja: ");
        dogTraveledPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        dogAllDistance.setAlignmentX(Component.LEFT_ALIGNMENT);
        dogAllDistance.setMaximumSize(new Dimension(200, 30));
        dogTraveledPanel.add(dogTraveledLabel);
        dogTraveledPanel.add(Box.createHorizontalGlue());
        dogTraveledPanel.add(dogAllDistance);

        //steptime, simulate and nextbutton
        JPanel stepTimePanel = new JPanel();
        stepTimePanel.setLayout(new BoxLayout(stepTimePanel, BoxLayout.LINE_AXIS));
        JLabel stepTimeLabel = new JLabel("Következő pillanatig eltelt idő: ");
        stepTimePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        stepTime.setAlignmentX(Component.LEFT_ALIGNMENT);
        stepTime.setMaximumSize(new Dimension(200, 30));

        stepTimePanel.add(stepTimeLabel);
        stepTimePanel.add(Box.createHorizontalGlue());
        stepTimePanel.add(stepTime);
        stepTimePanel.add(Box.createHorizontalGlue());
        stepTimePanel.add(next);


        //store subpanels in aray to add to main panel
        Component[] components = {p1Panel, p2Panel, distancePanel, Box.createRigidArea(new Dimension(0,15)),
        dogSpeedPanel, Box.createRigidArea(new Dimension(0,30)), dogRoundsPanel, dogCycleDistancePanel,
                dogTraveledPanel, Box.createVerticalGlue(),  stepTimePanel};

        //add subpanels to main panel
        for (Component x : components) {
            mainPanel.add(x);
        }


        frame.setSize(res.width/4, res.height/2);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon("src/icon.png").getImage());
        frame.setLocationRelativeTo(null);

        frame.add(mainPanel);

        frame.setVisible(true);
        next.addActionListener(new ActionListener() {
            Calculator calc;
            boolean constructed = false;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (verify()) {
                    if (!constructed) {
                        calc = new Calculator(GUI.Get.p1Speed(), GUI.Get.p2Speed(), GUI.Get.dogSpeed(), GUI.Get.distance());
                        constructed = true;
                    }
                    calc.nextState(Get.stepTime());
                } else {
                    inform("Hiba", "Nem megfelelő paraméterek. Csak nem negatív tizedes vagy egész számok " +
                            "lehetnek.", 0);
                }
            }
        });
    }

    public static void inform(String title, String text, int messageType) {
        JOptionPane.setDefaultLocale(new Locale("hu", "HU"));
        Locale.setDefault(new Locale("hu", "HU"));
        JOptionPane.showMessageDialog(frame, text, title, messageType);
    }

    /**
     * Megkérdezi a felhasználot, hogy üresítse-e ki a mezőket.*/
    public static void askDeleteEntries() {
         if (JOptionPane.showConfirmDialog(frame, "Paraméter mezők kiüresítése és újra kezdés", "Újra?",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                GUI.Set.p1Speed("");
                GUI.Set.p2Speed("");
                GUI.Set.distance("");
                GUI.Set.dogSpeed("");
                GUI.Set.dogRounds("0");
                GUI.Set.dogDistanceRanInACycle("0");
                GUI.Set.dogAllDistance("0");
                GUI.Set.stepTime("");
         }
    }

    /**
     * Megnézi, hogy a beírt adatok double-ök-e és nem negatívak.
     * @return true, ha helyesek a paraméterek*/
    private static boolean verify() {
        try {
            String[] texts = {p1Speed.getText(), p2Speed.getText(), distance.getText(),
                    dogSpeed.getText(), stepTime.getText()};
            for (String text : texts) {
                if (Double.parseDouble(text) < 0) {
                    return false;
                }
            }
            return true;

        } catch(NumberFormatException e){
            return false;
        }
    }

    static class Set {
        /*
        * Set the GUI's JTextFields and JLabels.*/
        public static void p1Speed(String s) {
            p1Speed.setText(s);
        }

        public static void p2Speed(String s) {
            p2Speed.setText(s);
        }

        public static void distance(String d) {
            distance.setText(d);
        }

        public static void dogSpeed(String d) {
            dogSpeed.setText(d);
        }

        public static void dogRounds(String rounds) {
            dogRounds.setText(rounds);
        }

        public static void dogDistanceRanInACycle(String distance) {
            dogDistanceRanInACycle.setText(distance);
        }

        public static void dogAllDistance(String distance) {
            dogAllDistance.setText(distance);
        }

        public static void stepTime(String time) {
            stepTime.setText(time);
        }
    }

    static class Get {
        /*
        * Get data from GUI.*/
        public static double p1Speed() {
            return Double.parseDouble(p1Speed.getText());
        }

        public static double p2Speed() {
            return Double.parseDouble(p2Speed.getText());
        }

        public static double dogSpeed() {
            return Double.parseDouble(dogSpeed.getText());
        }

        public static double distance() {
            return Double.parseDouble(distance.getText());
        }

        public static double stepTime() {
            return Double.parseDouble(stepTime.getText());
        }

    }


}
//TODO: JMenu, ahol cellák kiüresítése van és grafikon exportálása