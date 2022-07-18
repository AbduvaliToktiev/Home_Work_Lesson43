import java.sql.*;

public class Connect {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "abdutokt2004";


    public Connection connection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void getStudentsCount() {
        String SQL = "SELECT count(*) FROM \"it-academy\".students where students.fio like '%а%'";
        int count = 0;

        try (Connection conn = connection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println("Студентов с буквой <<а>> " + count + " штук");
    }

    public void allGroups() {
        String SQL = "SELECT id, name FROM \"it-academy\".groupss ";

        try (Connection conn = connection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                System.out.print(rs.getInt("id") + " ");
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }
}


