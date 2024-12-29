//import java.awt.Frame;
import javax.swing.JFrame;
public class App extends Serial{
    public static void main(String[] args) throws Exception {
        FlwLayout guiLayout = new FlwLayout();
        guiLayout.setSize(800, 600);
        guiLayout.setTitle("LoRa Ebyte Settings");
        guiLayout.setLocationRelativeTo(null);
        guiLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiLayout.setVisible(true);
    }
}


