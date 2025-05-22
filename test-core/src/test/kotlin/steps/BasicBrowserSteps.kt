package steps

import io.cucumber.java.After
import io.cucumber.java.Before
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import selenium.BasicBrowser
import selenium.printPageSource
import java.nio.file.Files

class BasicBrowserSteps {
    private lateinit var driver: WebDriver
    private lateinit var basicBrowser: BasicBrowser

    @Before
    fun setUp() {
    }

    private fun chromeDriver(): WebDriver {
        val userDataDir = Files.createTempDirectory("chrome-profile")

        val options = ChromeOptions().apply {
            addArguments("--headless=new")
            addArguments("--no-sandbox")
            addArguments("--disable-dev-shm-usage")
            addArguments("--user-data-dir=${userDataDir.toAbsolutePath()}")
        }

        driver = ChromeDriver(options)
        return driver;
    }

    @Given("Chrome is open")
    fun browserIsOpen() {
        basicBrowser = BasicBrowser(driver = chromeDriver())
    }

    @When("browsing for {string}")
    fun browsingFor(query: String) {
        basicBrowser.search(query)
    }

    @Then("the title should be {string}")
    fun expectedTitle(query: String) {
        basicBrowser.expectedTitle(query)
    }

    @After
    fun tearDown() {
        driver.printPageSource()
        driver.quit()
    }
}
