public class LoRaStatesDefine {


    public static class E32_UART_PARITY {
        public static final int MODE_00_8N1 = 0b00; // Default 8N1
        public static final int MODE_01_8O1 = 0b01; // 8O1
        public static final int MODE_10_8E1 = 0b10; // 8E1
        public static final int MODE_11_8N1 = 0b11; // 8N1 (equal to 0b00)
    }

    public static class UART_BPS_RATE {
        public static final int UART_BPS_1200 = 0b000;    // BaudRate 1200
        public static final int UART_BPS_2400 = 0b001;    // BaudRate 2400
        public static final int UART_BPS_4800 = 0b010;    // BaudRate 4800
        public static final int UART_BPS_9600 = 0b011;    // BaudRate 9600 (Default)
        public static final int UART_BPS_19200 = 0b100;   // BaudRate 19200
        public static final int UART_BPS_38400 = 0b101;   // BaudRate 38400
        public static final int UART_BPS_57600 = 0b110;   // BaudRate 57600
        public static final int UART_BPS_115200 = 0b111;  // BaudRate 115200
    }

    public static class UART_BPS_AIR_RATE {
        public static final int UART_BPS_AIR_RATE_1200 = 1200;
        public static final int UART_BPS_AIR_RATE_2400 = 2400;
        public static final int UART_BPS_AIR_RATE_4800 = 4800;
        public static final int UART_BPS_AIR_RATE_9600 = 9600;
        public static final int UART_BPS_AIR_RATE_19200 = 19200;
        public static final int UART_BPS_AIR_RATE_38400 = 38400;
        public static final int UART_BPS_AIR_RATE_57600 = 57600;
        public static final int UART_BPS_AIR_RATE_115200 = 115200;
    }

    public static class AIR_DATA_RATE {
        public static final int AIR_DATA_RATE_000_03 = 0b000; // 0.3k Air Data Rate
        public static final int AIR_DATA_RATE_001_12 = 0b001; // 1.2k Air Data Rate
        public static final int AIR_DATA_RATE_010_24 = 0b010; // 2.4k (Default) Air Data Rate
        public static final int AIR_DATA_RATE_011_48 = 0b011; // 4.8k Air Data Rate
        public static final int AIR_DATA_RATE_100_96 = 0b100; // 9.6k Air Data Rate
        public static final int AIR_DATA_RATE_101_192 = 0b101; // 19.2k Air Data Rate
        public static final int AIR_DATA_RATE_110_192 = 0b110; // 19.2k (same to 101) Air Data Rate
        public static final int AIR_DATA_RATE_111_192 = 0b111; // 19.2k (same to 101) Air Data Rate
    }

    public static class FIDEX_TRANSMISSION {
        public static final int FT_TRANSPARENT_TRANSMISSION = 0b0; // Transparent transmission mode
        public static final int FT_FIXED_TRANSMISSION = 0b1;       // Fixed transmission mode
    }

    public static class IO_DRIVE_MODE {
        public static final int IO_D_MODE_OPEN_COLLECTOR = 0b0;    // TXD and AUX push-pull outputs, RXD pull-up inputs
        public static final int IO_D_MODE_PUSH_PULLS_PULL_UPS = 0b1; // TXD, AUX open-collector outputs, RXD open-collector inputs
    }

    public static class WIRELESS_WAKE_UP_TIME {
        public static final int WAKE_UP_250 = 0b000;   // 250ms (default) wakeup time
        public static final int WAKE_UP_500 = 0b001;   // 500ms wakeup time
        public static final int WAKE_UP_750 = 0b010;   // 750ms wakeup time
        public static final int WAKE_UP_1000 = 0b011;  // 1000ms wakeup time
        public static final int WAKE_UP_1250 = 0b100;  // 1250ms wakeup time
        public static final int WAKE_UP_1500 = 0b101;  // 1500ms wakeup time
        public static final int WAKE_UP_1750 = 0b110;  // 1750ms wakeup time
        public static final int WAKE_UP_2000 = 0b111;  // 2000ms wakeup time
    }

    public static class FORWARD_ERROR_CORRECTION_SWITCH {
        public static final int FEC_0_OFF = 0b0;       // Turn off FEC
        public static final int FEC_1_ON = 0b1;        // Turn on FEC (default)
    }

    public static class TRANSMISSION_POWER {
        public static final int POWER_30 = 0b00; // 30dBm (default) transmission power
        public static final int POWER_27 = 0b01; // 27dBm transmission power
        public static final int POWER_24 = 0b10; // 24dBm transmission power
        public static final int POWER_21 = 0b11; // 21dBm transmission power
    }

    public static final int BROADCAST_ADDRESS = 0xFF; // Broadcast Address
}
