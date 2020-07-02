package DAO;

import java.io.File;

/**
 * The type Dao hsqldb.
 */
public class DAOHsqldb {


    /**
     * The type Hsqldb dao.
     */

        /**
         * @value url
         */
        private static String url;
        /**
         * @value constant user name "root"
         */
        private static final String USER = "root";
        /**
         * @value constant null password
         */
        private static final String PASSWORD = "root";
        /**
         * @value constant name "database"
         */
        private static final String NAME = "database";
        /**
         * @value connection
         */
        private static DAOHsqldb hsqldb;

        /**
         * Instantiates MainForm new HsqldbDAO.
         */
        private DAOHsqldb() {
            try {
                Class.forName("org.hsqldb.jdbc.JDBCDriver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getURL() {
            return url;
        }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
            return NAME;
        }

    /**
     * Gets user.
     *
     * @return the user
     */
    public String getUser() {
            return USER;
        }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
            return PASSWORD;
        }

    /**
     * Gets hsqldb.
     *
     * @return the hsqldb
     */
    public static synchronized DAOHsqldb getHsqldb() {
            if (hsqldb == null) {
                hsqldb = new DAOHsqldb();
                String path = new File("").getAbsolutePath()
                        .replaceAll("[\\\\/]", "/");
                url = "jdbc:hsqldb:file:"+path+"/database/database";
                System.out.println(path);
                System.out.println (url);
            }
            return hsqldb;
        }
}
