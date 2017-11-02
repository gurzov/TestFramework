import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;
import utils.DBHelper;
import utils.DriverFactory;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class UITests {

    @Before


    @After
    public void tearDown() {
        DriverFactory.shutDownDriver();
    }

    @Test
    public void duckNameShouldBeTheSameAsInDb() throws SQLException {
        List<String> duckNamesFromUI = new MainPage()
                .openMainPage()
                .openRubberDucksPage()
                .getDuckNames();
//
//        duckNamesFromUI.forEach(name -> System.out.println(name));

        List<String> duckNamesFromDB = DBHelper.getDuckNames();

        Collections.sort(duckNamesFromUI);
        Collections.sort(duckNamesFromDB);

        assertEquals(duckNamesFromDB,duckNamesFromUI);

    }
}
