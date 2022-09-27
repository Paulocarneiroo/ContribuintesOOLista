package EmpregadosOO.Application;

import EmpregadosOO.Entities.Address;
import EmpregadosOO.Entities.Department;
import EmpregadosOO.Entities.Employee;

import java.util.Locale;
import java.util.Scanner;

public class EmpregadosOO {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Department name: ");
        String departmentName = sc.nextLine();
        System.out.print("Payment day: ");
        int payDay = sc.nextInt();
        System.out.print("Email: ");
        sc.nextLine();
        String email = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        Address address = new Address(email, phone);
        Department department = new Department(departmentName, payDay, address);

        System.out.print("How much employees: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println((i+1)+"° Employee data:");
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            Employee employee = new Employee(name, salary);

            department.addEmployee(employee);
        }
        System.out.println();
        showReport(department);
        sc.close();
    }
    private static void showReport(Department department){
        System.out.println("PAYROLL: ");
        System.out.println(department.getName() + " Department = R$ " + String.format("%.2f", department.payroll()));
        System.out.println("PayDay: " + department.getPayDay());
        System.out.println("Employees: ");
        for (Employee e: department.getEmployees()) {
            System.out.println(e.getName());
        }
        System.out.println("Any questions, please contact " + department.getAddress().getEmail());
    }
}
