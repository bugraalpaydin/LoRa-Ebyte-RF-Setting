
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextFields extends JTextField implements ActionListener {
    JTextField channelTextField;
    JTextArea terminalField;
    JTextField addressHighField;
    JTextField addressLowField;
    JTextField loraInfoField;
    public static byte initialVersionNumber;
    public static byte initialAddressHigh;
    public static int initialAddressLow;
    public static int initialChannel;

    public TextFields(){
        channelTextField = new JTextField();
        terminalField = new JTextArea("");
        addressHighField = new JTextField("");
        addressLowField = new JTextField("");
        loraInfoField = new JTextField("");
    }
    public JPanel createLabeledTextArea(String labelText, JTextArea textArea, Dimension dimension, int labelLength){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBackground(Color.WHITE);

        // Label kısmı
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(labelLength, dimension.height));
        label.setMaximumSize(new Dimension(labelLength, dimension.height));
        label.setMinimumSize(new Dimension(labelLength, dimension.height));

        textArea.setBorder(BorderFactory.createEtchedBorder());

        // JTextArea kısmı
        textArea.setPreferredSize(dimension);
        textArea.setMaximumSize(dimension);
        textArea.setMinimumSize(dimension);
        textArea.setLineWrap(true);  // Satır sonlarına sarması için
        textArea.setWrapStyleWord(true);  // Kelime sarma

        // JPanel'e eklemeler
        panel.add(label);
        panel.add(textArea);
        panel.setAlignmentX(LEFT_ALIGNMENT);

        return panel;
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
            textField.setEditable(false);
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
        loraInfoField.setEditable(true);
        System.out.println("Product Model : " + initialVersionNumber);
        loraInfoField.setText("Product Model : " + initialVersionNumber);
        loraInfoField.setEditable(false);
    }

    public void editAddressField(){
        System.out.println("Product Model : " + initialVersionNumber);
        addressHighField.setText(Integer.toString(initialAddressHigh));
        addressLowField.setText(Integer.toString(initialAddressLow));
        channelTextField.setText(Integer.toString(initialChannel));
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
