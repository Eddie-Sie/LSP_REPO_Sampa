package org.howard.edu.lsp.midterm.inheritance;
/** Common superclass for employees paid according to hours and rate.
 * @author Edward Sie
 */
public abstract class Employee {
    protected final double hoursWorked;
    protected final double hourlyRate;
    /** Creates an employee.
     * @param hoursWorked nonnegative hours worked
     * @param hourlyRate nonnegative hourly rate
     */
    public Employee(double hoursWorked, double hourlyRate) {
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    /** @return pay calculated according to the employee type */
    public abstract double calculatePay();
}
