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
        textField.setEditable(false);
    }

    panel.add(label);
    panel.add(textField);
    panel.setAlignmentX(LEFT_ALIGNMENT);

    return panel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(channelTextField)){
            String enteredText = channelTextField.getText();
            System.out.println("Entered comminucation channel : " + enteredText);
            channelTextField.setText("");
        }
        else if(e.getSource().equals(addressHighField)){
            String enteredAddressHigh = addressHighField.getText();
            System.out.println("Entered address high : " + enteredAddressHigh);
            addressHighField.setText("");
        }
        else if(e.getSource().equals(addressLowField)){
            String enteredAddressLow = addressLowField.getText();
            System.out.println("Entered address low : " + enteredAddressLow);
            addressLowField.setText("");
        }
        else if(e.getSource().equals(terminalField)){
            System.out.println("this coming from termianal");
            String terminalEnteredString = terminalField.getText();
            System.out.println(terminalEnteredString);
        }
    }

}
