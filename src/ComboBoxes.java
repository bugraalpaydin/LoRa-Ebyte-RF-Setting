import javax.swing.JComboBox;

public class ComboBoxes extends JComboBox {
    public ComboBoxes(){
        String[] baudRateOptions = {"  1200", "  2400", "  4800", "  9600", " 19200", " 38400", " 57600", "115200"};
        String[] transmisionPowerOptions = {"  21", "  24", "  27", "  30"};
        String[] wakeupTimeOptions = {" 250", " 500", " 750", "1000", "1250", "1500", "1750", "2000"};
        String[] airDataOptions = {" 0.3", " 1.2", " 2.4", " 4.8", " 9.6", "19.2"};
        String[] parityBitOptions = {"8N1", "8O1", "8E1"};

        JComboBox<String> baudRatecb = new JComboBox<>(baudRateOptions);
        JComboBox<String> powercb = new JComboBox<>(transmisionPowerOptions);
        JComboBox<String> wakeupTimecb = new JComboBox<>(wakeupTimeOptions);
        JComboBox<String> airDataRatecb = new JComboBox<>(airDataOptions);
        JComboBox<String> parityBitcb = new JComboBox<>(parityBitOptions);
    }
}
