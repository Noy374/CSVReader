package org.example;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
        List<Person> people = new ArrayList<>();
        List<Department> departments = new ArrayList<>();

        String csvFilePath = "src/main/resources/foreign_names 2.csv";
        String line = "";
        String separator = ";";

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(separator);
                String id = data[0];
                String name = data[1];
                String gender = data[2];
                String birthDate = data[3];
                String division=data[4];
                double salary = Double.parseDouble(data[5]);

                int departmentId= (int) (Math.random()*100);
                Department department = new Department(departmentId);
                people.add(new Person(id, name, gender, birthDate,division,salary,department));

                departments.add(department);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("People:");
        for (Person person : people) {
            System.out.println(person);
        }

        System.out.println("\nDepartments:");
        for (Department department : departments) {
            System.out.println(department);
        }
    }
}
