import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComboBoxes extends JComboBox implements ActionListener{
    String[] baudRateOptions = {"  1200", "  2400", "  4800", "  9600", " 19200", " 38400", " 57600", "115200"};
    String[] transmisionPowerOptions = {"  21", "  24", "  27", "  30"};
    String[] wakeupTimeOptions = {" 250", " 500", " 750", "1000", "1250", "1500", "1750", "2000"};
    String[] airDataOptions = {" 0.3", " 1.2", " 2.4", " 4.8", " 9.6", "19.2"};
    String[] parityBitOptions = {"8N1", "8O1", "8E1"};

    JComboBox<String> baudRatecb; 
    JComboBox<String> powercb;
    JComboBox<String> wakeupTimecb;
    JComboBox<String> airDataRatecb;
    JComboBox<String> parityBitcb;

    public ComboBoxes(){
        baudRatecb = new JComboBox<>(baudRateOptions);
        powercb = new JComboBox<>(transmisionPowerOptions);
        wakeupTimecb = new JComboBox<>(wakeupTimeOptions);
        airDataRatecb = new JComboBox<>(airDataOptions);
        parityBitcb = new JComboBox<>(parityBitOptions);
    }
    public JPanel createLabeledComboBox(String labelText, JComboBox<String> comboBox, Dimension dimension, int labelLength){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBackground(Color.WHITE);

        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(labelLength, dimension.height));
        label.setMaximumSize(new Dimension(labelLength, dimension.height));
        label.setMinimumSize(new Dimension(labelLength, dimension.height));

        comboBox.setPreferredSize(new Dimension(labelLength, dimension.height));
        comboBox.setMinimumSize(new Dimension(labelLength, dimension.height));
        comboBox.setMaximumSize(new Dimension(labelLength, dimension.height));
        comboBox.addActionListener(this);
        comboBox.setAlignmentX(LEFT_ALIGNMENT);

        panel.add(label);
        panel.add(comboBox);

        panel.setAlignmentX(LEFT_ALIGNMENT);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(baudRatecb)){
            String selectedBaudRate = (String) baudRatecb.getSelectedItem();
            System.out.println(selectedBaudRate.trim());
        }
        else if(e.getSource().equals(powercb)){
            String selectedTransmissionPower = (String) powercb.getSelectedItem();
            System.out.println(selectedTransmissionPower.trim());
        }
        else if(e.getSource().equals(airDataRatecb)){
            String selectedAirDataRate = (String) airDataRatecb.getSelectedItem();
            System.out.println(selectedAirDataRate.trim());
        }
        else if(e.getSource().equals(parityBitcb)){
            String selectedParityBit = (String) parityBitcb.getSelectedItem();
            System.out.println(selectedParityBit.trim());
        }
        else if(e.getSource().equals(wakeupTimecb)){
            String selectedWakeupTime = (String) wakeupTimecb.getSelectedItem();
            System.out.println(selectedWakeupTime.trim());
        }
        else{
            System.out.println("error gettin source");
        }
    }
}
