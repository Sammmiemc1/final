import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		StudentManager manager = new StudentManager();
		while (true) {
			System.out.print("Enter name or exit to close ");
			String name = scnr.nextLine();
			if (name.equalsIgnoreCase("exit")) {
				break;
			}
			System.out.print("Enter address ");
			String address = scnr.nextLine();
			double GPA = 0.0;
			while (true) {
				System.out.print("Enter GPA ");
				String gpaInput = scnr.nextLine();
				try {
					GPA = Double.parseDouble(gpaInput);
					break;
				} catch (NumberFormatException e) {
					System.out.println("Invalid Please enter GPA in numeric format");
				}
			}
			Student student = new Student(name, address, GPA);
			manager.addStudent(student);
		}
		scnr.close();
		writeStudentsToFile(manager.getStudents());
		{
		}
	}

	public static void writeStudentsToFile(LinkedList<Student> students) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("list.txt"))) {
			for (Student student : students) {
				writer.write("Name " + student.getName());
				writer.newLine();
				writer.write("Address " + student.getAddress());
				writer.newLine();
				writer.write("GPA " + student.getGPA());
				writer.newLine();
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
