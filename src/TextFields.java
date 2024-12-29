import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextFields extends JTextField implements ActionListener {
    JTextField channelTextField;
    JTextField terminalField;
    JTextField addressHighField;
    JTextField addressLowField;
    JTextField loraInfoField;
    public static byte initialVersionNumber;
    public TextFields(){
        channelTextField = new JTextField();
        terminalField = new JTextField("");
        addressHighField = new JTextField("");
        addressLowField = new JTextField("");
        loraInfoField = new JTextField("");
    }

    public JPanel createLabeledTextField(String labelText, JTextField textField, Dimension dimension, int labelLength){
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
    panel.setBackground(Color.WHITE);

    JLabel label = new JLabel(labelText);
    label.setPreferredSize(new Dimension(labelLength, dimension.height));
    label.setMaximumSize(new Dimension(labelLength, dimension.height));
    label.setMinimumSize(new Dimension(labelLength, dimension.height));

    textField.setPreferredSize(dimension);
    textField.setMaximumSize(dimension);
    textField.setMinimumSize(dimension);
    textField.addActionListener(this);

    if(textField.equals(loraInfoField)){
    }

    panel.add(label);
    panel.add(textField);
    panel.setAlignmentX(LEFT_ALIGNMENT);

    return panel;
    }

    public JTextField getLoraInfoField(){
        return loraInfoField;
    }

    public void editLoraInfoField(){
        System.out.println("Product Model : " + initialVersionNumber);
        loraInfoField.setText("Product Model : " + initialVersionNumber);
        loraInfoField.setEditable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(channelTextField)){
            String enteredText = channelTextField.getText();
            int enteredChannelValue = Integer.parseInt(enteredText);
            if(enteredChannelValue > 31){
                channelTextField.setText("Undesired value");
            }
            else if(enteredChannelValue <= 31){
                LoRaConfig.CONFIG.chan = enteredChannelValue;
                channelTextField.setText("");
            }
            System.out.println(LoRaConfig.CONFIG.chan);
        }
        else if(e.getSource().equals(addressHighField)){
            String enteredText = addressHighField.getText();
            int enteredADDH = Integer.parseInt(enteredText);
            if(enteredADDH > 255){
                addressHighField.setText("Undesired value");
            }
            else if(enteredADDH <= 255){
                LoRaConfig.CONFIG.addH = enteredADDH;
            }
            System.out.println(LoRaConfig.CONFIG.addH);
            addressHighField.setText("");
        }
        else if(e.getSource().equals(addressLowField)){
            String enteredText = addressLowField.getText();
            int enteredADDL = Integer.parseInt(enteredText);
            if(enteredADDL > 255){
                addressHighField.setText("Undesired value");
            }
            else if(enteredADDL <= 255){
                LoRaConfig.CONFIG.addL = enteredADDL;
            }
            System.out.println(LoRaConfig.CONFIG.addL);
            addressLowField.setText("");
        }
        else if(e.getSource().equals(terminalField)){
            System.out.println("this coming from termianal");
            String terminalEnteredString = terminalField.getText();
            System.out.println(terminalEnteredString);
        }
    }

}
