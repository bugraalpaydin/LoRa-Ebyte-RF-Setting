
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
import javax.swing.border.LineBorder;

import com.fazecast.jSerialComm.SerialPort;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.CookieHandler;

public class FlwLayout extends JFrame implements ActionListener {
    Container mainContainer = this.getContentPane();
    Container container = this.getContentPane();
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 10, 20);

    JButton connectButton = new JButton("Connect       ");
    JButton setParametersButton = new JButton("Set Params  ");
    JButton sendDataButton = new JButton(" Send Data  ");
    JButton exitButton = new JButton("      Exit          ");

    JTextField channelTextField = new JTextField();
    JTextField portTextField = new JTextField("Communication Channel");
    JTextField terminalField = new JTextField("");
    JTextField addressHighField = new JTextField("High Address");
    JTextField addressLowField = new JTextField("Low Address");
    
    Serial availablePort = new Serial();

    String[] baudRateOptions = {"  1200", "  2400", "  4800", "  9600", " 19200", " 38400", " 57600", "115200"};
    String[] transmisionPowerOptions = {"   21", "  24", "  27", "  30"};
    String[] wakeupTimeOptions = {" 250", " 500", " 750", "1000", "1250", "1500", "1750", "2000"};
    String[] airDataOptions = {" 0.3", " 1.2", " 2.4", " 4.8", " 9.6", "19.2"};
    String[] parityBitOptions = {"8N1", "8O1", "8E1"};

    JComboBox<String> baudRatecb = new JComboBox<>(baudRateOptions);
    JComboBox<String> powercb = new JComboBox<>(transmisionPowerOptions);
    JComboBox<String> wakeupTimecb = new JComboBox<>(wakeupTimeOptions);
    JComboBox<String> airDataRatecb = new JComboBox<>(airDataOptions);
    JComboBox<String> parityBitcb = new JComboBox<>(parityBitOptions);
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
        mainContainer.add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(new LineBorder(Color.BLACK));
        bottomPanel.setBackground(Color.WHITE);
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
 
        Dimension comboBoxSize = new Dimension(150, 25);
        Dimension textFieldSize = new Dimension(150, 25);

        baudRatecb.addActionListener(this);
        powercb.addActionListener(this);
        wakeupTimecb.addActionListener(this);
        airDataRatecb.addActionListener(this);
        parityBitcb.addActionListener(this);
        channelTextField.addActionListener(this);

        configureComboBox(baudRatecb, comboBoxSize);
        configureComboBox(powercb, comboBoxSize);
        configureComboBox(wakeupTimecb, comboBoxSize);
        configureComboBox(airDataRatecb, comboBoxSize);
        configureComboBox(parityBitcb, comboBoxSize);
        configureTextField(channelTextField, textFieldSize);

        JPanel baudRatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        baudRatePanel.setBackground(Color.WHITE);
        JLabel baudRateLabel = new JLabel("Baud Rate Configs : ");
        baudRatePanel.add(baudRateLabel);
        baudRatePanel.add(baudRatecb);

        JPanel powerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        powerPanel.setBackground(Color.WHITE);
        JLabel powerLabel = new JLabel("Transmission Power Configs : ");
        powerPanel.add(powerLabel);
        powerPanel.add(powercb);

        JPanel wakeupTimePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        wakeupTimePanel.setBackground(Color.WHITE);
        JLabel wakeupTimeLabel = new JLabel("Wake Up Time Configs : ");
        wakeupTimePanel.add(wakeupTimeLabel);
        wakeupTimePanel.add(wakeupTimecb);
        
        JPanel airDataRatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        airDataRatePanel.setBackground(Color.WHITE);
        JLabel airDataRateLabel = new JLabel("Air Data Rate Configs : ");
        airDataRatePanel.add(airDataRateLabel);
        airDataRatePanel.add(airDataRatecb);

        JPanel parityBitPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        parityBitPanel.setBackground(Color.WHITE);
        JLabel parityBitLabel = new JLabel("Parity Bit Configs : ");
        parityBitPanel.add(parityBitLabel);
        parityBitPanel.add(parityBitcb);

        JPanel channelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        channelPanel.setBackground(Color.WHITE);
        JLabel channelLabel = new JLabel("Communication Channel : ");
        channelPanel.add(channelLabel);
        channelPanel.add(channelTextField);

        optionsPanel.add(baudRatePanel);
        optionsPanel.add(Box.createVerticalStrut(10));

        optionsPanel.add(powerPanel);
        optionsPanel.add(Box.createVerticalStrut(10));
        
        optionsPanel.add(wakeupTimePanel);
        optionsPanel.add(Box.createVerticalStrut(10));
          
        optionsPanel.add(airDataRatePanel);
        optionsPanel.add(Box.createVerticalStrut(10));

        optionsPanel.add(parityBitPanel);
        optionsPanel.add(Box.createVerticalStrut(10));
        
        optionsPanel.add(channelPanel);
        optionsPanel.add(Box.createVerticalStrut(10));
        
        mainContainer.add(optionsPanel);
        mainContainer.add(bottomPanel, BorderLayout.WEST);
        
    }
    private void configureComboBox(JComboBox<String> comboBox, Dimension size){
        comboBox.setPreferredSize(size);
        comboBox.setMaximumSize(size);
        comboBox.setMinimumSize(size);
        comboBox.setAlignmentX(LEFT_ALIGNMENT);
    }
    private void configureTextField(JTextField textField, Dimension size){
        textField.setPreferredSize(size);
        textField.setMaximumSize(size);
        textField.setMinimumSize(size);
        textField.setAlignmentX(LEFT_ALIGNMENT);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(exitButton)){
            dispose();
        }
        else if(e.getSource().equals(setParametersButton)){
            System.out.println("tunahan kaya");
        }
        else if(e.getSource().equals(sendDataButton)){
            System.out.println("toprak gül");
        }
        else if(e.getSource().equals(connectButton)){
            System.out.println("bugra alp aydin");
            availablePort.findLoRaPort((byte)0xc3);
        }
        else if(e.getSource().equals(baudRatecb)){
            System.out.println("this coming from baud rate combobox");
        }
        else if(e.getSource().equals(powercb)){
            System.out.println("this coming from power combobox");
        }
        else if(e.getSource().equals(airDataRatecb)){
            System.out.println("this coming from air data rate combobox");
        }
        else if(e.getSource().equals(parityBitcb)){
            System.out.println("this coming from parity combobox");
        }
        else if(e.getSource().equals(wakeupTimecb)){
            System.out.println("this coming from wake up time combobox");
        }
        else if(e.getSource().equals(channelTextField)){
            System.out.println("this coming from channel text field");
        }
        else{
            System.out.println("error gettin source");
        }
    }
}
