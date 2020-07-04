package steps;

import com.sun.tools.internal.jxc.ap.Const;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import util.Constants;
import util.DriverFactory;

public class BasicInteractions {
    WebDriver driver = DriverFactory.getDriver();

    @Given("I open the youtube main page")
    public void openYoutubeMainPage() {
        driver.get(Constants.YOUTUBE_MAIN_URL);

    }
}