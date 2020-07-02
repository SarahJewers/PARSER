package webparser;


import DAO.DAOImplementation;
import entities.ResultsEntity;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * The type Text analysis.
 */
public class TextAnalysis {

    private String[] splitWords;

    /**
     * Sets split words.
     *
     * @param path the path
     */
    public void setSplitWords(String path) {
        try {
            String content = new Scanner(new File(path)).useDelimiter("\\Z").next().toUpperCase();
            this.splitWords = content.split("['\\s', '\\n', '\\r', '\\t', ',', '.', '!', '?', '\"', ';', ':', '[', ']', '(', ')']");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Word count map.
     *
     * @return the map
     * @throws SQLException the sql exception
     */
    public Map wordCount() throws SQLException {
        Map<String, Integer> occurrences = new HashMap<String, Integer>();

        for (String word : splitWords) {
            if (word.matches("^[a-zA-Z,а-яА-Я]+$")) {
                Integer oldCount = occurrences.get(word);
                if (oldCount == null) {
                    oldCount = 0;
                }
                occurrences.put(word, oldCount + 1);
            }
        }
        DAOImplementation dao = new DAOImplementation();
        dao.clearTable();
        for (Map.Entry entity: occurrences.entrySet()) {
            ResultsEntity resultsEntity = new ResultsEntity(entity.getKey().toString(), Integer.parseInt(entity.getValue().toString()));
            dao.add(resultsEntity);
        }
        return occurrences;
    }

    /**
     * Print words.
     *
     * @param occurrences the occurrences
     */
    public void printWords(Map<String, Integer> occurrences){
        DAOImplementation daoImplementation = new DAOImplementation();
        List<ResultsEntity> list = daoImplementation.getAll();
        for (ResultsEntity s : list) {
            System.out.println(s.getWords() + " " + s.getWords_quantity());
        }
    }

}
