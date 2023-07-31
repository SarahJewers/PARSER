package webparser;

import UI.NewJFrame;
import java.sql.SQLException;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws SQLException the sql exception
     */
    public static void main(String[] args) throws SQLException {
        NewJFrame newJFrame = new NewJFrame();
        newJFrame.setVisible(true);
    }
}