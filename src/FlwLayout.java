import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlwLayout extends JFrame implements ActionListener {
    Container mainContainer = this.getContentPane();
    Container container = this.getContentPane();
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 10, 20);

    JButton connectButton = new JButton("Connect       ");
    JButton setParametersButton = new JButton("Set Params  ");
    JButton sendDataButton = new JButton(" Send Data  ");
    JButton exitButton = new JButton("      Exit          ");

    JTextField channelTextField = new JTextField();
    JTextField terminalField = new JTextField("");
    JTextField addressHighField = new JTextField("");
    JTextField addressLowField = new JTextField("");
    JTextField loraInfoField = new JTextField("");

    Serial loraPort = new Serial();

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

    Dimension comboBoxSize = new Dimension(150, 25);
    Dimension textFieldSize = new Dimension(150, 25);
    Dimension terminalSize = new Dimension(500, 170);
    public FlwLayout(){
        setLayout(layout);
        mainContainer.setLayout(new BorderLayout(10, 10));
        mainContainer.setBackground(Color.WHITE);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));

        exitButton.addActionListener(this);
        sendDataButton.addActionListener(this);
        setParametersButton.addActionListener(this);
        connectButton.addActionListener(this);        

        JPanel topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(Color.BLACK, 2));
        topPanel.setBackground(Color.WHITE); 
        topPanel.setLayout(new FlowLayout(5)); 
        topPanel.add(createLabeledTextField("LoRa Info : ", loraInfoField, textFieldSize, 100));
        mainContainer.add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(new LineBorder(Color.BLACK));
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.add(Box.createVerticalStrut(10));
        bottomPanel.add(connectButton);
        bottomPanel.add(Box.createVerticalStrut(10));
        bottomPanel.add(sendDataButton);
        bottomPanel.add(Box.createVerticalStrut(10));
        bottomPanel.add(setParametersButton);
        bottomPanel.add(Box.createVerticalGlue());
        bottomPanel.add(Box.createVerticalStrut(10));
        bottomPanel.add(exitButton);
        
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

        JPanel optionsPanel = new JPanel();
        optionsPanel.setBorder(new LineBorder(Color.BLACK));
        optionsPanel.setBackground(Color.WHITE);
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));

        optionsPanel.add(Box.createVerticalStrut(10));
        optionsPanel.add(createLabeledComboBox("    Baud Rate Configs :  ", baudRatecb, comboBoxSize, 200));
        optionsPanel.add(Box.createVerticalStrut(10));
        
        optionsPanel.add(createLabeledComboBox("    Transmission Power Configs : ", powercb, comboBoxSize, 200));
        optionsPanel.add(Box.createVerticalStrut(10));
          
        optionsPanel.add(createLabeledComboBox("    Wake Up Time Configs : ", wakeupTimecb, comboBoxSize, 200));
        optionsPanel.add(Box.createVerticalStrut(10));

        optionsPanel.add(createLabeledComboBox("    Air data Rate Configs : ", airDataRatecb, comboBoxSize, 200));
        optionsPanel.add(Box.createVerticalStrut(10));
        
        optionsPanel.add(createLabeledComboBox("    Parity Bit Configs : ", parityBitcb, comboBoxSize, 200));
        optionsPanel.add(Box.createVerticalStrut(10));
        
        optionsPanel.add(createLabeledTextField("   Communication Channel :", channelTextField, textFieldSize, 200));
        optionsPanel.add(Box.createVerticalStrut(10));
        optionsPanel.add(createLabeledTextField("   Address High : ", addressHighField, textFieldSize, 200));
        optionsPanel.add(Box.createVerticalStrut(10));
        optionsPanel.add(createLabeledTextField("   Address Low : ", addressLowField, textFieldSize, 200));
        optionsPanel.add(Box.createVerticalGlue());
        optionsPanel.add(Box.createHorizontalStrut(50));
        optionsPanel.add(createLabeledTextField("Termial : ", terminalField, terminalSize, 100));
        optionsPanel.add(Box.createVerticalStrut(10));
        mainContainer.add(optionsPanel);
        mainContainer.add(bottomPanel, BorderLayout.WEST);
    }

    private JPanel createLabeledTextField(String labelText, JTextField textField, Dimension dimension, int labelLength){
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
    private JPanel createLabeledComboBox(String labelText, JComboBox<String> comboBox, Dimension dimension, int labelLength){
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
        if(e.getSource().equals(exitButton)){
            dispose();
        }
        else if(e.getSource().equals(setParametersButton)){
            loraPort.setParameters();
        }
        else if(e.getSource().equals(sendDataButton)){
            loraPort.sendData((byte)30);
        }
        else if(e.getSource().equals(connectButton)){
            loraPort.findLoRaPort((byte) 0xc3);
        }
        else if(e.getSource().equals(baudRatecb)){
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
        else if(e.getSource().equals(channelTextField)){
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
        else{
            System.out.println("error gettin source");
        }
    }
}
