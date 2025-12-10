
package GreenGain;

import java.util.HashMap;
import javax.swing.JOptionPane;


public class testDb {
     static HashMap<String, Integer> userPoints = new HashMap<>();

    public static void main(String[] args) {

        while (true) {
            String menu = """
                    TRASH TO CASH
                    1. Submit Trash
                    2. View Points
                    3. Convert Points to Money
                    4. Exit
                    """;

            String choice = JOptionPane.showInputDialog(menu);

            if (choice == null) break;

            switch (choice) {
                case "1" -> submitTrash();
                case "2" -> viewPoints();
                case "3" -> convertPoints();
                case "4" -> System.exit(0);
                default -> JOptionPane.showMessageDialog(null, "Invalid choice!");
            }
        }
    }

   
    static void submitTrash() {
        String name = JOptionPane.showInputDialog("Enter your name:");
        if (name == null) return;

        String[] trashTypes = {"Plastic Bottle (5 points)", "Paper (3 points)", "Metal Can (10 points)"};
        String selected = (String) JOptionPane.showInputDialog(
                null, "Choose trash:", "Trash Type",
                JOptionPane.QUESTION_MESSAGE, null, trashTypes, trashTypes[0]
        );

        if (selected == null) return;

        int points = 0;
        if (selected.contains("Plastic")) points = 5;
        if (selected.contains("Paper")) points = 3;
        if (selected.contains("Metal")) points = 10;

        int current = userPoints.getOrDefault(name, 0);
        userPoints.put(name, current + points);

        JOptionPane.showMessageDialog(null, "You earned " + points + " points!");
    }

    
    static void viewPoints() {
        String name = JOptionPane.showInputDialog("Enter your name:");
        if (name == null) return;

        int pts = userPoints.getOrDefault(name, 0);
        JOptionPane.showMessageDialog(null, name + ", you have " + pts + " points.");
    }

    // ============= CONVERT POINTS =============
    static void convertPoints() {
        String name = JOptionPane.showInputDialog("Enter your name:");
        if (name == null) return;

        int pts = userPoints.getOrDefault(name, 0);
        double money = pts * 0.10; // 1 point = 0.10 pesos

        JOptionPane.showMessageDialog(null,
                name + ", your " + pts + " points = ₱" + money);

    }

    
}
