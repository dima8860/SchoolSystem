package step_definitions;

import com.github.javafaker.Faker;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import pages.AddTeacherPage;
import pages.SchoolHomePage;
import utilities.Config;
import utilities.DBUtility;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.sql.SQLException;
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
    String gender;
    int departmentIndex ;
    String department;
    String salary ;
    Select selectDepartment ;
    String birthdate ;
    int batchIndex ;
    Select selectBatch ;
    String batch;
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
       gender = selectGender.getFirstSelectedOption().getText();
        System.out.println("Department index: " + departmentIndex);
        selectDepartment.selectByIndex(departmentIndex);
        department = selectDepartment.getFirstSelectedOption().getText();
        addTeacherPage.birthDate.sendKeys(birthdate + Keys.ENTER);
        addTeacherPage.salary.clear();
        addTeacherPage.salary.sendKeys(salary + Keys.ENTER);
        selectBatch.selectByIndex(batchIndex);
         batch = selectBatch.getFirstSelectedOption().getText();
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
        int rowNumber = -1;
        for(int i = 0; i < data.size(); i++){
            if(data.get(i).get("teacher_id").toString().equals(teacherID)) {
                rowNumber = i;
            }
        }

       // select first_name from teacher where teacher_id = 1035;
        Assert.assertEquals(firstName, data.get(rowNumber).get("first_name").toString());
       // select last_name from teacher where teacher_id = 1035;
        Assert.assertEquals(lastName, data.get(rowNumber).get("last_name").toString());
       // select batch from teacher where teacher_id = 1035;
        Assert.assertEquals(batch, data.get(rowNumber).get("batch").toString());
       // select birth_date from teacher where teacher_id = 1035;
        Assert.assertEquals(birthdate, data.get(rowNumber).get("birth_date").toString());
       // select department from teacher where teacher_id = 1035;
        Assert.assertEquals(department, data.get(rowNumber).get("department").toString());
       // select email_address from teacher where teacher_id = 1035;
        Assert.assertEquals(email, data.get(rowNumber).get("email_address").toString());
     //   select gender from teacher where teacher_id = 1035;
        Assert.assertEquals(gender, data.get(rowNumber).get("gender").toString());
       // select join_date from teacher where teacher_id = 1035;
        Assert.assertEquals(joiningDate, data.get(rowNumber).get("join_date").toString());
       // select password from teacher where teacher_id = 1035;
        Assert.assertEquals(password, data.get(rowNumber).get("password").toString());
       // select phone from teacher where teacher_id = 1035;
        Assert.assertEquals(mobileNumber, data.get(rowNumber).get("phone").toString());
      //  select premanent_address from teacher where teacher_id = 1035;
        Assert.assertEquals(address, data.get(rowNumber).get("premanent_address").toString());
       // select salary from teacher where teacher_id = 1035;
        Assert.assertEquals(salary, data.get(rowNumber).get("salary").toString());
       // select section from teacher where teacher_id = 1035;
        Assert.assertEquals(sectionNumber, data.get(rowNumber).get("section").toString());
       // select subject from teacher where teacher_id = 1035;
        Assert.assertEquals(subject, data.get(rowNumber).get("subject").toString());

        DBUtility.close();

    }
}
