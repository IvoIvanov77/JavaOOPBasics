package defining_classes.exercise.company_roster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Map<String, Department> departments = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            Employee employee = Employee.getInstance(line);
            String department = employee.getDepartment();
            if(!departments.containsKey(department)){
                departments.put(department, new Department(department));
            }
            departments.get(department).addEmployee(employee);
        }

        Optional<Department> optDepartment = departments.values().stream()
                .max(Comparator.comparing(Department::getAverageSalary));

        if(optDepartment.isPresent()){
            System.out.printf("Highest Average Salary: %s%n", optDepartment.get());
            optDepartment.get().printEmployees();
        }




    }
}
