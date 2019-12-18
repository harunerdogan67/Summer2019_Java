package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;

public class CalendarEventsPage extends BasePage{

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement CreateCalendarEvent;

    public void clickToCreateCalendarEvent(){
        BrowserUtils.waitForVisibility(CreateCalendarEvent, 5);
        BrowserUtils.waitForClickablility(CreateCalendarEvent, 5);
        CreateCalendarEvent.click();
    }

}
