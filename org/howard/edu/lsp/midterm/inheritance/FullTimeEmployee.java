package org.howard.edu.lsp.midterm.inheritance;
/** Full-time employee paid time-and-a-half for hours above 40.
 * @author Edward Sie
 */
public class FullTimeEmployee extends Employee {
    /** @param hoursWorked hours worked
     * @param hourlyRate hourly pay rate
     */
    public FullTimeEmployee(double hoursWorked, double hourlyRate) {
        super(hoursWorked, hourlyRate);
    }
    /** @return regular pay plus overtime pay */
    @Override public double calculatePay() {
        if (hoursWorked <= 40) return hoursWorked * hourlyRate;
        return 40 * hourlyRate + (hoursWorked - 40) * hourlyRate * 1.5;
    }
}
