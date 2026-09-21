package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;

public class ETLPipeline {

    public static void main(String[] args) throws IOException {

        Path inputPath = Path.of("data/employees.csv");
        Path outputPath = Path.of("data/transformed_employees.csv");

        int rowsRead = 0;
        int rowsTransformed = 0;
        int rowsSkipped = 0;

        EmployeeParser parser = new EmployeeParser();
        PayrollCalculator payrollCalculator = new PayrollCalculator();

        try (
            BufferedReader reader = Files.newBufferedReader(inputPath);
            BufferedWriter writer = Files.newBufferedWriter(outputPath)
        ) {

            // Writing the required output header
            writer.write(
                    "EmployeeID,Name,Department,HoursWorked,HourlyRate,"
                            + "GrossPay,PayLevel,EmploymentStatus"
            );
            writer.newLine();

            // Skipping the input header
            reader.readLine();

            String line;

            while ((line = reader.readLine()) != null) {

                rowsRead++;

                // Converting CSV row into an Employee
                Employee employee = parser.parse(line);

                // checking for invalid row
                if (employee == null) {
                    rowsSkipped++;
                    continue;
                }

                // Calculating gross pay
                BigDecimal grossPay =
                        payrollCalculator.calculateGrossPay(employee);

                // Determining pay level
                PayLevel payLevel =
                        PayLevel.fromGrossPay(grossPay);

                // Determining employment status
                EmploymentStatus employmentStatus =
                        EmploymentStatus.fromHours(
                                employee.getHoursWorked()
                        );

                // Writing transformed employee
                writer.write(
                        employee.getEmployeeId() + ","
                                + employee.getName() + ","
                                + employee.getDepartment() + ","
                                + String.format(
                                        "%.2f",
                                        employee.getHoursWorked()
                                ) + ","
                                + String.format(
                                        "%.2f",
                                        employee.getHourlyRate()
                                ) + ","
                                + grossPay.toPlainString() + ","
                                + payLevel + ","
                                + employmentStatus
                );

                writer.newLine();

                rowsTransformed++;
            }
        }

        System.out.println("Rows read: " + rowsRead);
        System.out.println("Rows transformed: " + rowsTransformed);
        System.out.println("Rows skipped: " + rowsSkipped);
        System.out.println(
                "Output file: data/transformed_employees.csv"
        );
    }
}
