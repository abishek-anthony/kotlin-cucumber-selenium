package selenium

import org.assertj.core.api.Assertions.assertThat
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
fun WebDriver.printPageSource() : WebDriver{
    println(this.pageSource)
    return this
}
class BasicBrowser(private val driver: WebDriver) {

    fun search(query: String) {
        driver.get(query)
    }

    fun expectedTitle(query: String) {
        assertThat(driver.title).contains(query)
    }
}
