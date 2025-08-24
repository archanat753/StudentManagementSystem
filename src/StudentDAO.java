import java.sql.*;
import java.util.*;

public class StudentDAO {
    Connection conn;

    public StudentDAO() throws Exception {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "password");
    }

    public void addStudent(Student s) throws Exception {
        String query = "INSERT INTO students VALUES(?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, s.getId());
        ps.setString(2, s.getName());
        ps.setInt(3, s.getAge());
        ps.setString(4, s.getCourse());
        ps.executeUpdate();
    }

    public List<Student> getStudents() throws Exception {
        List<Student> list = new ArrayList<>();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM students");
        while (rs.next()) {
            list.add(new Student(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
        }
        return list;
    }
}

