package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AddTeacherPage {
    public AddTeacherPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//label[.='Firstname']/preceding-sibling::*[1]")
    public WebElement firstName ;

    @FindBy(xpath = "//label[.='Lastname']/preceding-sibling::*[1]")
    public WebElement lastName ;

    @FindBy(xpath = "//label[.='Email']/preceding-sibling::*[1]")
    public WebElement email ;

    //Joining Date
    @FindBy(xpath = "//label[.='Joining Date']/preceding-sibling::*[1]")
    public WebElement joiningDate ;


    @FindBy(xpath = "//label[.='Password']/preceding-sibling::*[1]")
    public WebElement password;

    @FindBy(xpath = "//label[.='Confirm Password']/preceding-sibling::*[1]")
    public WebElement passwordConfirm;

    @FindBy(xpath = "//label[.='Subject']/preceding-sibling::*[1]")
    public WebElement subject ;

    @FindBy(xpath = "//label[.='Mobile number']/preceding-sibling::*[1]")
    public WebElement mobileNumber ;

    //select
    @FindBy(xpath = "//label[.='Gender']/preceding-sibling::*[1]")
    public WebElement gender ;

    //select
    @FindBy(xpath = "//label[.='Department']/preceding-sibling::*[1]")
    public WebElement department;


    @FindBy(xpath = "//label[.='Birth Date']/preceding-sibling::*[1]")
    public WebElement birthDate;

    // needs to be cleared, default value 10000
    @FindBy(xpath = "//label[.='Salary']/preceding-sibling::*[1]")
    public WebElement salary;

    //select
    @FindBy(xpath = "//label[.='Batch']/preceding-sibling::*[1]")
    public WebElement batch;

    // 1.0, 2.0, 3.0
    @FindBy(xpath = "//label[.='Section']/preceding-sibling::*[1]")
    public WebElement section;


    @FindBy(xpath = "//label[.='Premanent Address']/preceding-sibling::*[1]")
    public WebElement permanentAddress;

    //button[type='Submit']

    @FindBy(css = "button[type='Submit']")
    public WebElement submitButton;

    @FindBy(xpath = "(//div[@class='col-md-4 col-sm-6 col-12 col-lg-4 col-xl-3'][last()]//a)[1]")
    public WebElement lastTeacherCreated;

    @FindBy(xpath = "//span[.='Teacher ID:']/following-sibling::*[1]/a")
    public WebElement teacherID;





}
