package UI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webparser.GetHTML;

class NewJFrameTest {

    private NewJFrame newJFrameUnderTest;

    @BeforeEach
    void setUp() {
        newJFrameUnderTest = new NewJFrame();
    }

    @Test
    void testMain() {
        // Setup

        // Run the test
        GetHTML getHTML = new GetHTML("https://www.simbirsoft.com/");
        getHTML.getHtmlToText();

        // Verify the results
    }
}
