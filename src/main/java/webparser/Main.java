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
        /*GetHTML getHTML = new GetHTML("https://www.simbirsoft.com/");
        getHTML.getHtmlToText();
        TextAnalysis textAnalysis = new TextAnalysis();
        textAnalysis.setSplitWords(getHTML.getPathName());
        Map<String, Integer> occurrences = textAnalysis.wordCount();
        textAnalysis.printWords(occurrences);*/
    }
}
