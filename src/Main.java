import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n=================================");
            System.out.println("     EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewEmployees();
                    break;

                case 3:
                    searchEmployee();
                    break;

                case 4:
                    updateEmployee();
                    break;

                case 5:
                    deleteEmployee();
                    break;

                case 6:
                    System.out.println("Thank you for using Employee Management System!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Add Employee
    public static void addEmployee() {

        System.out.println("\n---- Add Employee ----");

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();

        scanner.nextLine();

        // Check if ID already exists
        for (Employee employee : employees) {

            if (employee.getId() == id) {
                System.out.println("Employee ID already exists!");
                return;
            }
        }

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(
                id,
                name,
                department,
                salary
        );

        employees.add(employee);

        System.out.println("Employee added successfully!");
    }

    // View Employees
    public static void viewEmployees() {

        System.out.println("\n--- All Employees ---");

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee employee : employees) {
            employee.displayEmployee();
        }
    }

    // Search Employee
    public static void searchEmployee() {

        System.out.println("\n--- Search Employee ---");

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();

        for (Employee employee : employees) {

            if (employee.getId() == id) {

                System.out.println("Employee Found!");
                employee.displayEmployee();

                return;
            }
        }

        System.out.println("Employee not found.");
    }

    // Update Employee
    public static void updateEmployee() {

        System.out.println("\n--- Update Employee ---");

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();

        scanner.nextLine();

        for (Employee employee : employees) {

            if (employee.getId() == id) {

                System.out.print("Enter new name: ");
                String name = scanner.nextLine();

                System.out.print("Enter new department: ");
                String department = scanner.nextLine();

                System.out.print("Enter new salary: ");
                double salary = scanner.nextDouble();

                employee.setName(name);
                employee.setDepartment(department);
                employee.setSalary(salary);

                System.out.println("Employee updated successfully!");

                return;
            }
        }

        System.out.println("Employee not found.");
    }

    // Delete Employee
    public static void deleteEmployee() {

        System.out.println("\n--- Delete Employee ---");

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();

        for (Employee employee : employees) {

            if (employee.getId() == id) {

                employees.remove(employee);

                System.out.println("Employee deleted successfully!");

                return;
            }
        }

        System.out.println("Employee not found.");
    }
}