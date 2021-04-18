package compulsory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Singleton {

        private static Singleton instance = null;
        public Connection con;

        Singleton() throws SQLException {
            con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
        }

        public static Singleton getInstance() throws SQLException {
            if (instance == null)
                instance = new Singleton();

            return instance;
        }
}

