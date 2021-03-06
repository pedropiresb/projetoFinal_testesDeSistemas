package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverFactory;

public class YoutubeVideoPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final BasePage page;
    private final By videoOptions = By.cssSelector("#info #menu #top-level-buttons ~ #button");
    private final By addedToLikedVideosToast = By.xpath("//span[contains(text(),'Added to Liked videos')]");
    private final By likeButton = By.cssSelector("#info #menu #top-level-buttons " +
            "ytd-toggle-button-renderer:nth-child(1)");
    private final By dislikeButton = By.cssSelector("#info #menu #top-level-buttons " +
            "ytd-toggle-button-renderer:nth-child(2)");
    private final By shareButton = By.cssSelector("#info #menu #top-level-buttons " +
            "ytd-button-renderer:nth-child(3)");
    private final By saveButton = By.cssSelector("#info #menu #top-level-buttons " +
            "ytd-button-renderer:nth-child(4)");
    private final By saveToCloseButton = By.cssSelector("#header #close-button");
    private By playlist;
    private final By savedToWatchLaterToast = By.xpath("//span[contains(text(),'Saved to Watch later')]");

    public YoutubeVideoPage(WebDriver driver) {
        this.driver = driver;
        wait = DriverFactory.getWait();
        page = new BasePage(driver);
    }

    public void likeVideo() {
        page.waitAndClick(likeButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(addedToLikedVideosToast));
    }

    public void dislikeVideo() {
        page.waitAndClick(dislikeButton);
    }

    public void addVideoToPlaylist(String playlistName) {
        page.waitAndClick(saveButton);
        playlist = By.xpath("//div[contains(@id,'checkbox')]//yt-formatted-string[text()='" + playlistName + "']");
        page.waitAndClick(playlist);
        wait.until(ExpectedConditions.visibilityOfElementLocated(savedToWatchLaterToast));
        page.waitAndClick(saveToCloseButton);
    }

}
