import java.util.ArrayList;

import javax.xml.soap.Text;

import com.fazecast.jSerialComm.*;

public class Serial{
    SerialPort[] availablePorts;
    public byte[] loraBytes;
    public int versionNumber;
    TextFields textFields = new TextFields();
    SerialPort loraPort;
    public Serial(TextFields textFields){    //Serial class constructor
        availablePorts = SerialPort.getCommPorts(); //this works fine tested with stm32-nucleo and it detects its port
        this.textFields = textFields;
    }

    public Serial(){
        availablePorts = SerialPort.getCommPorts();
    }

    public SerialPort loraPortGetter(){ //getter method for LoRa Port
        return loraPort;
    }
    
    public void loraMessageSetter(byte loraMessage){ //setter method for LoRa message or maybe config
        this.loraMessage = loraMessage;
    }
    
    public void findLoRaPort(byte initialLoRaMessage){
        int bytesWritten = 0;
        for (int i = 0; i < availablePorts.length; i++) {       //try every available ports
            SerialPort dummyPort = availablePorts[i];           //dummyPort is used cause writeBytes method won't work with SerialPort[] obj
            setPortParameters(dummyPort);                       //configure baudrate, word length, stop bit, and parity bit for port
            byte[] initialBytes = new byte[1];
            initialBytes[0] = initialLoRaMessage;
            for(int k = 0; k < 3; k++)
                bytesWritten = dummyPort.writeBytes(initialBytes, initialBytes.length); //i cant write to stm32-nucleo serial port ACM0 idk why :(
            if(bytesWritten!= 1){
                System.out.println("Error writing to" +  dummyPort.getSystemPortName() + ":" + bytesWritten + " bytes written.");
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        
            if(portRead(dummyPort) == true){
                loraPort = dummyPort;
                System.out.println(dummyPort.getSystemPortName() + " port is LoRa");
            }
            else{
                System.out.println(dummyPort.getSystemPortName() + " port is not LoRa");
            }
        }

        if(loraPort == null){
            System.out.println("null");
        }
    }

    public void setPortParameters(SerialPort port){     //method for setting port parameters
        System.out.println("Settin parameters for port" + port.getSystemPortName());
        if(port.openPort()){    //open port and check return value 
            System.out.println(port.getSystemPortName() + " Port opened successfully");
        }
        else{   //if port can't open
            System.out.println(port.getSystemPortName() + " Failed to open the port");
        }
        port.setComPortParameters(9600, 8, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY); //set port for 9600 baud rate 8 word length, one stop bit and no parity bit
        port.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 1000, 1000);
    }


    /*@brief
        we use arraylist because lora sends its info with 866ms delay 
        and i think java doesn't know how to handle it. Java assume only 1 data comes
    */
    public boolean portRead(SerialPort port) {
        ArrayList<Byte> comingBytes = new ArrayList<>(); // Gelen verileri tutacak ArrayList
        int bytesAvailable = port.bytesAvailable();
        while (comingBytes.size() < 4 && bytesAvailable > 0) { // 4 byte tamamlanana kadar devam et
            if (bytesAvailable > 0) {
                byte[] buffer = new byte[bytesAvailable];
                int bytesRead = port.readBytes(buffer, bytesAvailable); // Veri oku
                for (int i = 0; i < bytesRead; i++) {
                    comingBytes.add(buffer[i]); // Okunan veriyi listeye ekle
                }
                // Gelen veriyi logla
                for (int i = 0; i < buffer.length; i++) {
                    System.out.println("Byte received: " + buffer[i]);
                }
            }
            try {
                Thread.sleep(50); // Verilerin gelmesi için biraz bekle
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Complete data: " + comingBytes);
        if(comingBytes.size() == 4){
            updateLoraInfo(comingBytes);
            return true; // 4 byte alındığında true döndür
        }
        else
            return false;
    }

    public void updateLoraInfo(ArrayList<Byte> comingBytes){
        TextFields.initialVersionNumber = comingBytes.get(1);
        textFields.editLoraInfoField();
    }

    public void sendData(byte data){
        System.out.println("in sendData method");
    }

    public void sendParameters(){
        byte[] bytes = new byte[6];
        bytes[0] = (byte) LoRaConfig.CONFIG.head;
        bytes[1] = (byte) LoRaConfig.CONFIG.addH;
        bytes[2] = (byte) LoRaConfig.CONFIG.addL;
        bytes[3] = (byte) LoRaConfig.CONFIG.speedConfig;
        bytes[4] = (byte) LoRaConfig.CONFIG.chan;
        bytes[5] = (byte) LoRaConfig.CONFIG.optionConfig;

        int bytesWritten = loraPort.writeBytes(bytes, bytes.length);
        System.out.println("in setParameters method");
        System.out.println(bytesWritten);
    }
}

