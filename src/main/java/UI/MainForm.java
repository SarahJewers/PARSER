package UI;

import DAO.DAOImplementation;
import entities.ResultsEntity;
import webparser.GetHTML;
import webparser.TextAnalysis;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class MainForm extends JFrame {
    private JTextArea textArea1;
    private JPanel panel1;
    private JButton button1;
    private JTextField textField1;

    public MainForm(){
        this.setSize(500, 600);
        setContentPane(panel1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //JFrame jFrame = new JFrame();
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GetHTML getHTML = new GetHTML(textField1.getText().toString());
                getHTML.getHtmlToText();
                TextAnalysis textAnalysis = new TextAnalysis();
                textAnalysis.setSplitWords(getHTML.getPathName());
                Map<String, Integer> occurrences = null;
                try {
                    occurrences = textAnalysis.wordCount();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                textAnalysis.printWords(occurrences);
                DAOImplementation daoImplementation = new DAOImplementation();
                List<ResultsEntity> list = daoImplementation.getAll();
                for (ResultsEntity s : list) {
                    textArea1.append(s.getWords() + " " + s.getWords_quantity() + "\n");
                }
            }
        });

    }
}
