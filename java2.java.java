import java.util.ArrayList;
import java.util.Scanner;
public class PartA{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<3;i++){
            System.out.print("Enter the value of the index "+i);
            System.out.println();
            int num=sc.nextInt();
            list.add(num);
        }
        sc.close();
        int sum=0;
        for(int nums:list){
            sum+=nums;
        }
        System.out.println("Sum is:"+sum);
    }
}

Part B:

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class PartB {
    public static void main(String[] args) {
        student st1 = new student(1, "Neeraj Chandel");
        String filename = "byteData.txt";

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(st1);
            oos.close();
            System.out.println("Data added");
            st1.display();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            student st2 = (student) ois.readObject();
            ois.close();
            st2.display();  // Use display() to print student details
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class student implements Serializable {
    int id;
    String name;

    student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println("id :" + id + " Name: " + name);
    }
}

Part C:

import java.io.*;
import java.util.Scanner;

public class PartC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many employee entries would you like to add?");
        int numEntries = sc.nextInt();
       
        for (int i = 0; i < numEntries; i++) {
            addEmployee();
        }

        display();
    }

    static void addEmployee() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the ID:");
        int id = sc.nextInt();
        sc.nextLine();  

        System.out.println("Enter the Name:");
        String name = sc.nextLine();

        System.out.println("Enter the Salary:");
        double salary = sc.nextDouble();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Employee.txt", true))) {
            writer.write("ID: " + id + ", Name: " + name + ", Salary: " + salary);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void display() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Employee.txt"))) {
            String line;
            System.out.println("\nEmployee Records:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}