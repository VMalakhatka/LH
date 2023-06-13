import javax.swing.*;
import java.awt.*;



public class Main  extends JFrame {
    static DBHandling dbHandling = new DBHandling();

    public static void main(String[] args) {
       dbHandling.open();
    }
}
