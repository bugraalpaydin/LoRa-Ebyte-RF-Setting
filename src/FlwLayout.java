import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class FlwLayout extends JFrame {
    Container mainContainer = this.getContentPane();
    Container container = this.getContentPane();
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 10, 20);
    JFrame frame = new JFrame();
    Serial loraPort = new Serial();
    Buttons buttons = new Buttons(frame);
    ComboBoxes comboBoxes = new ComboBoxes();
    TextFields textFields = new TextFields();

    Dimension comboBoxSize = new Dimension(150, 25);
    Dimension textFieldSize = new Dimension(150, 25);
    Dimension terminalSize = new Dimension(500, 170);

    public FlwLayout(){
        setLayout(layout);
        mainContainer.setLayout(new BorderLayout(10, 10));
        mainContainer.setBackground(Color.WHITE);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));

        JPanel topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(Color.BLACK, 2));
        topPanel.setBackground(Color.WHITE); 
        topPanel.setLayout(new FlowLayout(5)); 
        topPanel.add(textFields.createLabeledTextField("LoRa Info : ", textFields.loraInfoField, textFieldSize, 100));
        mainContainer.add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(new LineBorder(Color.BLACK));
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.add(Box.createVerticalStrut(10));
        bottomPanel.add(buttons.connectButton);
        bottomPanel.add(Box.createVerticalStrut(10));
        bottomPanel.add(buttons.sendDataButton);
        bottomPanel.add(Box.createVerticalStrut(10));
        bottomPanel.add(buttons.setParametersButton);
        bottomPanel.add(Box.createVerticalGlue());
        bottomPanel.add(Box.createVerticalStrut(10));
        bottomPanel.add(buttons.exitButton);
        
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

        JPanel optionsPanel = new JPanel();
        optionsPanel.setBorder(new LineBorder(Color.BLACK));
        optionsPanel.setBackground(Color.WHITE);
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));

        optionsPanel.add(Box.createVerticalStrut(10));
        optionsPanel.add(comboBoxes.createLabeledComboBox("    Baud Rate Configs :  ", comboBoxes.baudRatecb, comboBoxSize, 200));
        optionsPanel.add(Box.createVerticalStrut(10));
        
        optionsPanel.add(comboBoxes.createLabeledComboBox("    Transmission Power Configs : ", comboBoxes.powercb, comboBoxSize, 200));
        optionsPanel.add(Box.createVerticalStrut(10));
          
        optionsPanel.add(comboBoxes.createLabeledComboBox("    Wake Up Time Configs : ", comboBoxes.wakeupTimecb, comboBoxSize, 200));
        optionsPanel.add(Box.createVerticalStrut(10));

        optionsPanel.add(comboBoxes.createLabeledComboBox("    Air data Rate Configs : ", comboBoxes.airDataRatecb, comboBoxSize, 200));
        optionsPanel.add(Box.createVerticalStrut(10));
        
        optionsPanel.add(comboBoxes.createLabeledComboBox("    Parity Bit Configs : ", comboBoxes.parityBitcb, comboBoxSize, 200));
        optionsPanel.add(Box.createVerticalStrut(10));
        
        optionsPanel.add(textFields.createLabeledTextField("   Communication Channel :", textFields.channelTextField, textFieldSize, 200));
        optionsPanel.add(Box.createVerticalStrut(10));
        optionsPanel.add(textFields.createLabeledTextField("   Address High : ", textFields.addressHighField, textFieldSize, 200));
        optionsPanel.add(Box.createVerticalStrut(10));
        optionsPanel.add(textFields.createLabeledTextField("   Address Low : ", textFields.addressLowField, textFieldSize, 200));
        optionsPanel.add(Box.createVerticalGlue());
        optionsPanel.add(Box.createHorizontalStrut(50));
        optionsPanel.add(textFields.createLabeledTextField("", textFields.terminalField, terminalSize, 100));
        optionsPanel.add(Box.createVerticalStrut(10));

        mainContainer.add(optionsPanel);
        mainContainer.add(bottomPanel, BorderLayout.WEST);
    }

}
