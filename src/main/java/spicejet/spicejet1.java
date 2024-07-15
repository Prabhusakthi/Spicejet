package spicejet;

import java.time.Duration;



import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class spicejet1 {

    private WebDriver driver;

   	@SuppressWarnings("unused")
	@Before
    public void setUp() {
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
     // 2. Search for flights
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1200));
        driver = new ChromeDriver();
         }

    
    public void testSpiceJetAutomation() {
        // Navigate to SpiceJet website
        driver.get("http://www.spicejet.com");

        // Signup process
        WebElement signupLink = driver.findElement(By.linkText("SIGN UP"));
        signupLink.click();

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("prabhu");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("sakthivel");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("prabhu2631994@gmail.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Prabhu03!");

        WebElement confirmPassword = driver.findElement(By.id("confirmPassword"));
        confirmPassword.sendKeys("Prabhu03!");

        WebElement phone = driver.findElement(By.id("phone"));
        phone.sendKeys("7871761680");

        WebElement signupButton = driver.findElement(By.id("signupButton"));
        signupButton.click();

        WebElement successMessage = driver.findElement(By.id("successMessage"));
        assertTrue(successMessage.isDisplayed());

        // Login process
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        WebElement emailField = driver.findElement(By.id("loginEmail"));
        emailField.sendKeys("prabhu2631994@gmail.com");

        WebElement passwordField = driver.findElement(By.id("loginPassword"));
        passwordField.sendKeys("Prabhu03!");

        WebElement loginSubmit = driver.findElement(By.id("loginSubmit"));
        loginSubmit.click();

        // Search for a flight (One-way and Round-trip)
        WebElement fromCity = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
        fromCity.sendKeys("Bengaluru (BLR)");

        WebElement toCity = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
        toCity.sendKeys("Delhi (DEL)");

        WebElement departureDate = driver.findElement(By.id("ctl00_mainContent_view_date1"));
        departureDate.sendKeys("25-07-2024");

        WebElement searchButton = driver.findElement(By.id("ctl00_mainContent_btn_FindFlights"));
        searchButton.click();

        // Validate search results
        WebElement searchResults = driver.findElement(By.id("flightResults"));
        assertTrue(searchResults.isDisplayed());

        // Select a flight and proceed to booking
        WebElement selectFlightButton = driver.findElement(By.id("selectFlightButton"));
        selectFlightButton.click();

        // Fill out booking form
        WebElement passengerName = driver.findElement(By.id("passengerName"));
        passengerName.sendKeys("John Doe");

        WebElement passengerPhone = driver.findElement(By.id("passengerPhone"));
        passengerPhone.sendKeys("7871761680");

        WebElement passengerEmail = driver.findElement(By.id("passengerEmail"));
        passengerEmail.sendKeys("johndoe@example.com");

        WebElement paymentMethod = driver.findElement(By.id("paymentMethod"));
        paymentMethod.sendKeys("Credit Card");

        WebElement cardNumber = driver.findElement(By.id("cardNumber"));
        cardNumber.sendKeys("4111111111111111");

        WebElement cardExpiry = driver.findElement(By.id("cardExpiry"));
        cardExpiry.sendKeys("12/25");

        WebElement cardCVC = driver.findElement(By.id("cardCVC"));
        cardCVC.sendKeys("123");

        WebElement bookButton = driver.findElement(By.id("bookButton"));
        bookButton.click();

        // Verify booking was successful
        WebElement bookingConfirmation = driver.findElement(By.id("bookingConfirmation"));
        assertTrue(bookingConfirmation.isDisplayed());

        // Validate fields available on webpage
        WebElement checkIn = driver.findElement(By.id("checkIn"));
        assertTrue(checkIn.isDisplayed());

        WebElement flightStatus = driver.findElement(By.id("flightStatus"));
        assertTrue(flightStatus.isDisplayed());

        WebElement manageBooking = driver.findElement(By.id("manageBooking"));
        assertTrue(manageBooking.isDisplayed());
    }

    private void assertTrue(boolean displayed) {
		// TODO Auto-generated method stub
		
	}


	@After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
