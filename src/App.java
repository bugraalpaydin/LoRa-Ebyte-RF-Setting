//import java.awt.Frame;
import javax.swing.JFrame;
public class App extends Serial{
    public static void main(String[] args) throws Exception {
        Serial serialPort = new Serial();
        FlwLayout guiLayout = new FlwLayout();
        guiLayout.setSize(700, 500);
        guiLayout.setTitle("LoRa Ebyte Settings");
        guiLayout.setLocationRelativeTo(null);
        guiLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiLayout.setVisible(true);
    }
}

