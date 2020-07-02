package webparser;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.File;
import java.io.IOException;


/**
 * The type Get html.
 */
public class GetHTML {

    private String url;
    private static final String PATH_NAME = "src/main/resources/htmlTemp/htmlPage";

    /**
     * Instantiates MainForm new Get html.
     *
     * @param url the url
     */
    public GetHTML(String url) {
        this.url = url;
    }

    /**
     * Gets html to text.
     */
    public void getHtmlToText() {
        try {
            Document document = Jsoup.connect(url).get();
            File file = new File(PATH_NAME);
            FileUtils.writeStringToFile(file, document.text().replaceAll("\\<.*?\\>", ""));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets path name.
     *
     * @return the path name
     */
    public String getPathName() {
        return PATH_NAME;
    }
}
