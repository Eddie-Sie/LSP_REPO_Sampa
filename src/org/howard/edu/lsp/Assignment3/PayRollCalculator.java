package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PayrollCalculator {

    public BigDecimal calculateGrossPay(Employee employee) {

        double hoursWorked = employee.getHoursWorked();
        double hourlyRate = employee.getHourlyRate();

        double grossPay;

        if (hoursWorked <= 40) {

            // Regular pay
            grossPay = hoursWorked * hourlyRate;

        } else {

            // First 40 hours are regular
            double regularPay = 40 * hourlyRate;

            // Hours above 40 are overtime
            double overtimeHours = hoursWorked - 40;

            // Overtime is paid at 1.5 times the hourly rate
            double overtimePay = overtimeHours * hourlyRate * 1.5;

            grossPay = regularPay + overtimePay;
        }

        // IT employees receive a 5% bonus
        if (employee.getDepartment().equals("IT")) {
            grossPay = grossPay * 1.05;
        }

        // Meaning assignment #2 requires HALF_UP rounding for monetary operations
        return BigDecimal.valueOf(grossPay)
                .setScale(2, RoundingMode.HALF_UP);
    }
}
