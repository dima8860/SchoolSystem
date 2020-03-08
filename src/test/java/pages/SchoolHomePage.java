package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SchoolHomePage {
    public SchoolHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//span[.=' Teachers']/..")
    public WebElement teacherModule;

    @FindBy (xpath = "//a[.='Add Teacher']/..")
    public WebElement addTeacher;
}
