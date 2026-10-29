package org.howard.edu.lsp.midterm.inheritance;
/** Contractor paid a 15 percent premium on all hours.
 * @author Edward Sie
 */
public class Contractor extends Employee {
    /** @param hoursWorked hours worked
     * @param hourlyRate hourly pay rate
     */
    public Contractor(double hoursWorked, double hourlyRate) {
        super(hoursWorked, hourlyRate);
    }
    /** @return hourly pay with contractor premium */
    @Override public double calculatePay() { return hoursWorked * hourlyRate * 1.15; }
}
