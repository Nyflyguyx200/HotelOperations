package com.pluralsight;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @org.junit.jupiter.api.Test
    void punchIn_shouldSetStartTime() {
        // Arrange
        Employee employee = new Employee("001", "John Doe", "Clerk", 25.0, 0.0);

        // Act
        employee.punchIn();

        // Assert
        assertTrue(employee.getStartTime() > 0); // Check if the start time is set
    }

    @org.junit.jupiter.api.Test
    void punchIn_withSpecificTime_shouldSetStartTime() {
        // Arrange
        Employee employee = new Employee("001", "John Doe", "Clerk", 25.0, 0.0);
        double startTime = 8.0; // 8:00 am

        // Act
        employee.punchIn(startTime);

        // Assert
        assertEquals(startTime, employee.getStartTime());
    }

    @org.junit.jupiter.api.Test
    void punchOut_shouldCalculateHoursWorked() {
        // Arrange
        Employee employee = new Employee("001", "John Doe", "Clerk", 25.0, 0.0);
        double startTime = LocalDateTime.now().getHour() - 1 + LocalDateTime.now().getMinute() / 60.0; // Punch in an hour ago
        employee.punchIn(startTime);

        // Act
        employee.punchOut();

        // Assert
        assertEquals(1.0, employee.getHoursWorked()); // Should be 1 hour worked
    }

    @org.junit.jupiter.api.Test
    void punchOut_withSpecificTime_shouldCalculateHoursWorked() {
        // Arrange
        Employee employee = new Employee("001", "John Doe", "Clerk", 25.0, 0.0);
        double startTime = 8.0; // 8:00 am
        employee.punchIn(startTime);

        double endTime = 17.5; // 5:30 pm

        // Act
        employee.punchOut(endTime);

        // Assert
        assertEquals(9.5, employee.getHoursWorked());
    }
}
