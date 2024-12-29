import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Buttons extends JButton implements ActionListener{
    JButton connectButton;
    JButton getParametersButton;
    JButton setParametersButton;
    JButton sendDataButton;
    JButton exitButton;
    JFrame frame;
    public LoRaConfig loraConfig;
    public Serial loraPort;
    LoRaConfig.CONFIG config;
    public Buttons(JFrame frame, TextFields textFields, ComboBoxes comboBoxes){
        connectButton = new JButton("Connect       ");
        getParametersButton = new JButton("Get Params  ");
        setParametersButton = new JButton("Set Params  ");
        sendDataButton = new JButton(" Send Data  ");
        exitButton = new JButton("      Exit          ");
        loraConfig = new LoRaConfig(comboBoxes);
        loraPort = new Serial(textFields, loraConfig);
        this.frame = frame;
        connectButton.addActionListener(this);
        setParametersButton.addActionListener(this);
        sendDataButton.addActionListener(this);
        exitButton.addActionListener(this);
        getParametersButton.addActionListener(this);
    }   

    public JButton connectButtonGetter(){
        return connectButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(exitButton)){
            //frame.dispose();
        }
        else if(e.getSource().equals(setParametersButton)){
            loraConfig.setConfiguration();
            loraPort.sendParameters();
        }
        else if(e.getSource().equals(sendDataButton)){
            loraPort.sendData((byte)30);
        }
        else if(e.getSource().equals(connectButton)){
            loraPort.findLoRaPort((byte) 0xc3);
        }
        else if(e.getSource().equals(getParametersButton)){
            loraPort.getLoRaParameters((byte) 0xc1);
        }
    }
}
