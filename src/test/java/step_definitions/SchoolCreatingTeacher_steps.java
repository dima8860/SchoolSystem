package step_definitions;

import com.github.javafaker.Faker;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AddTeacherPage;
import pages.SchoolHomePage;
import utilities.Config;
import utilities.DBUtility;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SchoolCreatingTeacher_steps {
    SchoolHomePage schoolHomePage = new SchoolHomePage();
    AddTeacherPage addTeacherPage = new AddTeacherPage();

    Faker faker = new Faker();
    String firstName;
    String lastName;
    String email ;
    String password;
    String joiningDate;
    String subject;
    String mobileNumber;
    Select selectGender;
    Random random ;
    int genderIndex ;
    int departmentIndex ;
    String salary ;
    Select selectDepartment ;
    String birthdate ;
    int batchIndex ;
    Select selectBatch ;
    String sectionNumber ;
    String address ;
    String teacherID;


    @Given("User is on home school page")
    public void user_is_on_home_school_page() {
        Driver.getDriver().get(Config.getProperty("schoolURL"));
    }

    @Then("user navigate to teacher module")
    public void user_navigate_to_teacher_module() {
    schoolHomePage.teacherModule.click();
    }

    @Then("user clicks on button to create teacher")
    public void user_clicks_on_button_to_create_teacher() {
        schoolHomePage.addTeacher.click();
    }

    @Then("user fill out all information about teacher")
    public void user_fill_out_all_information_about_teacher() throws InterruptedException {
        // first name
         firstName = faker.name().firstName();
         lastName = faker.name().lastName();
         email = faker.internet().emailAddress();
         password = faker.internet().password();
         joiningDate = "03/02/2016";
         subject  = faker.educator().course();
         mobileNumber = "7731234900";
         selectGender = new Select(addTeacherPage.gender);
         random = new Random();
         genderIndex = random.nextInt(2);
         departmentIndex = random.nextInt(5);
         salary = String.valueOf((random.nextInt(9) + 1)*10000);
         selectDepartment = new Select(addTeacherPage.department);
         birthdate = "03/02/1978";
         batchIndex = random.nextInt(12);
         selectBatch = new Select(addTeacherPage.batch);
         sectionNumber = String.valueOf(3.0);
         address = faker.address().fullAddress();





        SeleniumUtils.waitForVisibility(addTeacherPage.firstName,10);
        SeleniumUtils.waitForVisibility(addTeacherPage.lastName,10);
        Thread.sleep(2000);
       addTeacherPage.firstName.sendKeys(firstName + Keys.ENTER);
        System.out.println(firstName);
       addTeacherPage.lastName.sendKeys(lastName + Keys.ENTER);
        System.out.println(lastName);
       addTeacherPage.email.sendKeys(email + Keys.ENTER);
       addTeacherPage.joiningDate.sendKeys(joiningDate + Keys.ENTER);
       addTeacherPage.password.sendKeys(password + Keys.ENTER);
       addTeacherPage.subject.sendKeys(subject + Keys.ENTER);
        SeleniumUtils.waitForVisibility(addTeacherPage.mobileNumber,10);
       addTeacherPage.mobileNumber.sendKeys(mobileNumber + Keys.ENTER);
        System.out.println("Gender index: " + genderIndex);
       selectGender.selectByIndex(genderIndex);
        System.out.println("Department index: " + departmentIndex);
        selectDepartment.selectByIndex(departmentIndex);
        addTeacherPage.birthDate.sendKeys(birthdate + Keys.ENTER);
        addTeacherPage.salary.clear();
        addTeacherPage.salary.sendKeys(salary + Keys.ENTER);
        selectBatch.selectByIndex(batchIndex);
        addTeacherPage.section.sendKeys(sectionNumber + Keys.ENTER);
        addTeacherPage.permanentAddress.sendKeys(address + Keys.ENTER);

    }

    @Then("user clicks on button submit to submit teacher info")
    public void user_clicks_on_button_submit_to_submit_teacher_info() {
        addTeacherPage.submitButton.click();
        addTeacherPage.lastTeacherCreated.click();
        teacherID = addTeacherPage.teacherID.getText();
    }

    @Then("verifying that teacher's info matching database info")
    public void verifyingThatTeacherSInfoMatchingDatabaseInfo() throws SQLException {
        DBUtility.createConnection();
        List<Map<Object,Object>> data = DBUtility.executeQuery("select * from teacher");
        for(Map row: data) {
            if(data.get(row).get())
        }

        /*select first_name from teacher where teacher_id = 1035;
        select last_name from teacher where teacher_id = 1035;
        select batch from teacher where teacher_id = 1035;
        select birth_date from teacher where teacher_id = 1035;
        select department from teacher where teacher_id = 1035;
        select email_address from teacher where teacher_id = 1035;
        select gender from teacher where teacher_id = 1035;
        select join_date from teacher where teacher_id = 1035;
        select password from teacher where teacher_id = 1035;
        select phone from teacher where teacher_id = 1035;
        select premanent_address from teacher where teacher_id = 1035;
        select salary from teacher where teacher_id = 1035;
        select section from teacher where teacher_id = 1035;
        select subject from teacher where teacher_id = 1035;*/

        DBUtility.close();

    }
}
