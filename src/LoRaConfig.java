public class LoRaConfig{

    //public static int speedConfig;
    //public static int optionConfig;

    public static class MODE_TYPE {
        public static final int MODE_0_NORMAL = 0;       // UART and wireless channel are open M0: 0, M1: 0
        public static final int MODE_1_WAKE_UP = 1;      // Adds code before data packet, awakens receiver in mode 2
        public static final int MODE_2_POWER_SAVING = 2; // UART disabled, wireless module works in WOR mode
        public static final int MODE_3_SLEEP = 3;        // Sleep & Parameter setting
        public static final int MODE_4_PROGRAM = 3;      // Equivalent to MODE_3_SLEEP
    }

    public static class PROGRAM_COMMAND {
        public static final int SET_CFG_PWR_DWN_SAVE = 0xC0; // Set config, save when power off
        public static final int SET_CFG_PWR_DWN_LOSE = 0xC2; // Set config, do not save when power off
    }

    public static class SPEED {
        public static int airDataRate;    // 3 bits
        public static int uartBaudRate;   // 3 bits
        public static int uartParity;     // 2 bits
        public SPEED(int airDataRate, int uartBaudRate, int uartParity) {
        }
    }

    public static class OPTION {
        public static int transmissionPower;  
        public static int fec;                
        public static int wirelessWakeupTime; 
        public static int ioDriveMode;        
        public static int fixedTransmission;  

        public OPTION(int transmissionPower, int fec, int wirelessWakeupTime, int ioDriveMode, int fixedTransmission) {
        }
    }

    public static class CONFIG {
        public static int head; // 0xC0 or 0xC2
        public static int addL; // Low address byte
        public static int addH; // High address byte
        public SPEED speed;
        public static int speedConfig;
        public static int optionConfig;
        public static int chan; // Channel (0x00 to 0x1F)
        public OPTION option;
        
        public CONFIG(int head, int addL, int addH, SPEED speed, int chan, OPTION option) {
        }
    }

    public static class MODULE_INFORMATION {
        public int head;
        public int freq;
        public int version;
        public int features;

        public MODULE_INFORMATION(int head, int freq, int version, int features) {
        }
    }

    public void setConfiguration() {
        LoRaConfig.OPTION.fixedTransmission = 1;
        LoRaConfig.OPTION.ioDriveMode  = 1;
        LoRaConfig.OPTION.fec = 1;
        LoRaConfig.CONFIG.head = 0xC2;
        CONFIG.speedConfig = (LoRaConfig.SPEED.uartParity << 6) | (LoRaConfig.SPEED.uartBaudRate << 3) | (LoRaConfig.SPEED.airDataRate); 
        CONFIG.optionConfig = (LoRaConfig.OPTION.fixedTransmission << 7) | (LoRaConfig.OPTION.ioDriveMode << 6) | (LoRaConfig.OPTION.wirelessWakeupTime << 3) | (LoRaConfig.OPTION.fec << 2) | (LoRaConfig.OPTION.transmissionPower);
        System.out.println("Speed config is : " + CONFIG.speedConfig);
        System.out.println("Option config is : " + CONFIG.optionConfig);
    }

    public static void getConfiguration() {
    }

    public static void getModuleInformation() {
    }

    public static void resetModule() {
    }

    public static void sendFixedMessage() {
    }
}
