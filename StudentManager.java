import java.util.LinkedList;
import java.util.Comparator;
import java.util.Collections;

public class StudentManager {
	private LinkedList<Student> students;

	public StudentManager() {
		students = new LinkedList<>();
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public LinkedList<Student> getStudents() {

		Collections.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return s1.getName().compareTo(s2.getName());
			}
		});
		return students;
	}
}