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
    String[] transmisionPowerOptions = {"  30", "  27", "  24", "  21"};
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

    public void changeComboBoxes(){
        baudRatecb.setSelectedIndex(LoRaConfig.SPEED.uartBaudRate);
        powercb.setSelectedIndex(LoRaConfig.OPTION.transmissionPower);
        wakeupTimecb.setSelectedIndex(LoRaConfig.OPTION.wirelessWakeupTime);
        airDataRatecb.setSelectedIndex(LoRaConfig.SPEED.airDataRate);
        parityBitcb.setSelectedIndex(LoRaConfig.SPEED.uartParity);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(baudRatecb)){
            String selectedBaudRate = (String) baudRatecb.getSelectedItem();
            selectedBaudRate = selectedBaudRate.trim();
            switch(selectedBaudRate){
                case "1200":
                LoRaConfig.SPEED.uartBaudRate = LoRaStatesDefine.UART_BPS_RATE.UART_BPS_1200;
                break;
                case "2400":
                LoRaConfig.SPEED.uartBaudRate = LoRaStatesDefine.UART_BPS_RATE.UART_BPS_2400;
                break;
                case "4800":
                LoRaConfig.SPEED.uartBaudRate = LoRaStatesDefine.UART_BPS_RATE.UART_BPS_4800;
                break;
                case "9600":
                LoRaConfig.SPEED.uartBaudRate = LoRaStatesDefine.UART_BPS_RATE.UART_BPS_9600;
                break;
                case "19200":
                LoRaConfig.SPEED.uartBaudRate = LoRaStatesDefine.UART_BPS_RATE.UART_BPS_19200;
                break;
                case "38400":
                LoRaConfig.SPEED.uartBaudRate = LoRaStatesDefine.UART_BPS_RATE.UART_BPS_38400;
                break;
                case "57600":
                LoRaConfig.SPEED.uartBaudRate = LoRaStatesDefine.UART_BPS_RATE.UART_BPS_57600;
                break;
                case "115200":
                LoRaConfig.SPEED.uartBaudRate = LoRaStatesDefine.UART_BPS_RATE.UART_BPS_115200;
                break;
            }
        }
        else if(e.getSource().equals(powercb)){
            String selectedTransmissionPower = (String) powercb.getSelectedItem();
            selectedTransmissionPower = selectedTransmissionPower.trim();
            switch (selectedTransmissionPower) {
                case "30":
                    LoRaConfig.OPTION.transmissionPower = LoRaStatesDefine.TRANSMISSION_POWER.POWER_30;
                    break;
                case "27":
                    LoRaConfig.OPTION.transmissionPower = LoRaStatesDefine.TRANSMISSION_POWER.POWER_27;
                    break;
                case "24":
                    LoRaConfig.OPTION.transmissionPower = LoRaStatesDefine.TRANSMISSION_POWER.POWER_24;
                    break;
                case "21":
                    LoRaConfig.OPTION.transmissionPower = LoRaStatesDefine.TRANSMISSION_POWER.POWER_21;
                    break;
                default:
                    System.out.println("Error setting transmission power");
                    break;
            }
        }
        else if(e.getSource().equals(airDataRatecb)){
            String selectedAirDataRate = (String) airDataRatecb.getSelectedItem();
            selectedAirDataRate = selectedAirDataRate.trim();
            switch (selectedAirDataRate) {
                case "0.3":
                    LoRaConfig.SPEED.airDataRate = LoRaStatesDefine.AIR_DATA_RATE.AIR_DATA_RATE_000_03;
                    break;
                case "1.2":
                    LoRaConfig.SPEED.airDataRate = LoRaStatesDefine.AIR_DATA_RATE.AIR_DATA_RATE_001_12;
                    break;
                case "2.4":
                    LoRaConfig.SPEED.airDataRate = LoRaStatesDefine.AIR_DATA_RATE.AIR_DATA_RATE_010_24;
                    break;
                case "4.8":
                    LoRaConfig.SPEED.airDataRate = LoRaStatesDefine.AIR_DATA_RATE.AIR_DATA_RATE_011_48;
                    break;
                case "9.6":
                    LoRaConfig.SPEED.airDataRate = LoRaStatesDefine.AIR_DATA_RATE.AIR_DATA_RATE_100_96;
                    break;
                case "19.2":
                    LoRaConfig.SPEED.airDataRate = LoRaStatesDefine.AIR_DATA_RATE.AIR_DATA_RATE_101_192;
                    break;
                default:
                    break;
            }
        }
        else if(e.getSource().equals(parityBitcb)){
            String selectedParityBit = (String) parityBitcb.getSelectedItem();
            selectedParityBit = selectedParityBit.trim();
            switch(selectedParityBit){
                case "8N1":
                    LoRaConfig.SPEED.uartParity = LoRaStatesDefine.E32_UART_PARITY.MODE_00_8N1;
                    break;
                case "801":
                    LoRaConfig.SPEED.uartParity = LoRaStatesDefine.E32_UART_PARITY.MODE_01_8O1;
                    break;
                case "8E1":
                    LoRaConfig.SPEED.uartParity = LoRaStatesDefine.E32_UART_PARITY.MODE_10_8E1;
                    break;
            }
        }
        else if(e.getSource().equals(wakeupTimecb)){
            String selectedWakeupTime = (String) wakeupTimecb.getSelectedItem();
            selectedWakeupTime = selectedWakeupTime.trim();
            switch(selectedWakeupTime){
                case "250":
                LoRaConfig.OPTION.wirelessWakeupTime = LoRaStatesDefine.WIRELESS_WAKE_UP_TIME.WAKE_UP_250;
                break;
                case "500":
                LoRaConfig.OPTION.wirelessWakeupTime = LoRaStatesDefine.WIRELESS_WAKE_UP_TIME.WAKE_UP_500;
                break;
                case "750":
                LoRaConfig.OPTION.wirelessWakeupTime = LoRaStatesDefine.WIRELESS_WAKE_UP_TIME.WAKE_UP_750;
                break;
                case "1000":
                LoRaConfig.OPTION.wirelessWakeupTime = LoRaStatesDefine.WIRELESS_WAKE_UP_TIME.WAKE_UP_1000;
                break;
                case "1250":
                LoRaConfig.OPTION.wirelessWakeupTime = LoRaStatesDefine.WIRELESS_WAKE_UP_TIME.WAKE_UP_1250;
                break;
                case "1500":
                LoRaConfig.OPTION.wirelessWakeupTime = LoRaStatesDefine.WIRELESS_WAKE_UP_TIME.WAKE_UP_1500;
                break;
                case "1750":
                LoRaConfig.OPTION.wirelessWakeupTime = LoRaStatesDefine.WIRELESS_WAKE_UP_TIME.WAKE_UP_1750;
                break;
                case "2000":
                LoRaConfig.OPTION.wirelessWakeupTime = LoRaStatesDefine.WIRELESS_WAKE_UP_TIME.WAKE_UP_2000;
                break;
            }
        }
        else{
            System.out.println("error gettin source");
        }
    }
}
