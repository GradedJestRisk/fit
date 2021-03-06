package fit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.StringWriter;
import java.io.PrintWriter;

public class FileRunnerTest {
    Parse tempParse;

    String simpleHtml =
            "<table>" +
            "    <tr><td>fit.Fixture</td></tr>" +
            "</table>";

    String wikiHtml =
            "<table><tr><td>extra formatting" +
            "   <wiki>" +
            "       <table>" +
            "           <tr><td>fit.Fixture</td></tr>" +
            "       </table>" +
            "   </wiki>" +
            "</td></tr></table>";


    @Test public void testRunningFileWithWikiTag() {
        testHtml(simpleHtml);
        testHtml(wikiHtml);
    }

    @Test private void testHtml(String html) {
        FileRunner runner = new FileRunner();
        runner.fixture = new Fixture() {
            public void doTables(Parse tables) {
                tempParse = tables;
            }
        };
        runner.input = html;
        runner.output = new PrintWriter(new StringWriter());
        runner.process();

        assertEquals("fit.Fixture", tempParse.leaf().text());
    }
}

