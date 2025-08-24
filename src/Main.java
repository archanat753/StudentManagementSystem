
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("1. Add Student\n2. View Students\n3. Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Age: ");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Course: ");
                String course = sc.nextLine();

                Student s = new Student(id, name, age, course);
                dao.addStudent(s);
                System.out.println("Student Added!");
            } else if (choice == 2) {
                for (Student s : dao.getStudents()) {
                    System.out.println(s.getId() + " | " + s.getName() + " | " + s.getAge() + " | " + s.getCourse());
                }
            } else {
                break;
            }
        }
    }
}

