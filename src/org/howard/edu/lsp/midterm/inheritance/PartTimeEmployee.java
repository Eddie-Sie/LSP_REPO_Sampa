package org.howard.edu.lsp.midterm.inheritance;
/** Part-time employee paid a straight hourly rate.
 * @author Edward Sie
 */
public class PartTimeEmployee extends Employee {
    /** @param hoursWorked hours worked
     * @param hourlyRate hourly pay rate
     */
    public PartTimeEmployee(double hoursWorked, double hourlyRate) {
        super(hoursWorked, hourlyRate);
    }
    /** @return straight hourly pay */
    @Override public double calculatePay() { return hoursWorked * hourlyRate; }
}
