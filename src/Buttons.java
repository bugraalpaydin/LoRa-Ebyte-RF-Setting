import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Buttons extends JButton implements ActionListener{
    JButton connectButton;
    JButton setParametersButton;
    JButton sendDataButton;
    JButton exitButton;

    Serial loraPort = new Serial();

    public Buttons(){
        connectButton = new JButton("Connect       ");
        setParametersButton = new JButton("Set Params  ");
        sendDataButton = new JButton(" Send Data  ");
        exitButton = new JButton("      Exit          ");

        connectButton.addActionListener(this);
        setParametersButton.addActionListener(this);
        sendDataButton.addActionListener(this);
        exitButton.addActionListener(this);
    }   

    public JButton connectButtonGetter(){
        return connectButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(exitButton)){
            //dispose();
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
    }
}
