package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

public enum PayLevel {

    LOW,
    STANDARD,
    HIGH,
    EXECUTIVE;

    public static PayLevel fromGrossPay(BigDecimal grossPay) {

        if (grossPay.compareTo(new BigDecimal("500")) < 0) {
            return LOW;

        } else if (grossPay.compareTo(new BigDecimal("1000")) < 0) {
            return STANDARD;

        } else if (grossPay.compareTo(new BigDecimal("2000")) < 0) {
            return HIGH;

        } else {
            return EXECUTIVE;
        }
    }

    @Override
    public String toString() {

        switch (this) {
            case LOW:
                return "Low";

            case STANDARD:
                return "Standard";

            case HIGH:
                return "High";

            case EXECUTIVE:
                return "Executive";

            default:
                throw new IllegalStateException("Unknown pay level");
        }
    }
}
