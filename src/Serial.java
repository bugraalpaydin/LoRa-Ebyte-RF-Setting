import com.fazecast.jSerialComm.*;

public class Serial{
    SerialPort[] availablePorts;
    public byte[] loraBytes;
    private byte loraMessage;
    SerialPort loraPort;
    public Serial(){        //Serial class constructor
        availablePorts = SerialPort.getCommPorts(); //this works fine tested with stm32-nucleo and it detects its port
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
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(portRead(dummyPort) == false){
                System.out.println(dummyPort.getSystemPortName() + " port is not LoRa");
            }
            else if(portRead(dummyPort) == true){
                System.out.println(dummyPort.getSystemPortName() + " port is LoRa");
            }

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
    }

    public boolean portRead(SerialPort port) {
        int bytesAvailable = port.bytesAvailable();
        if(bytesAvailable > 0) {
            byte[] comingBytes = new byte[bytesAvailable];
            int bytesRead = port.readBytes(comingBytes, bytesAvailable); // Correct usage of readBytes
            if (bytesRead > 0) {
                return true; 
            } 
        }
        return false;
    }
    public void sendData(byte data){
        System.out.println("in sendData method");
    }
    public void setParameters(){
        System.out.println("in setParameters method");
    }
}

