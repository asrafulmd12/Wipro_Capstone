package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlogSpotPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public BlogSpotPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.actions = new Actions(driver);
    }

    // =========================
    // FORM SECTION
    // =========================

    public void fillUserDetails(String name, String email, String phone, String address) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")))
                .clear();
        driver.findElement(By.id("name")).sendKeys(name);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")))
                .clear();
        driver.findElement(By.id("email")).sendKeys(email);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone")))
                .clear();
        driver.findElement(By.id("phone")).sendKeys(phone);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("textarea")))
                .clear();
        driver.findElement(By.id("textarea")).sendKeys(address);
    }

    public void selectGenderAndDays() {

        wait.until(ExpectedConditions.elementToBeClickable(By.id("male")))
                .click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("saturday")))
                .click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("sunday")))
                .click();
    }

    public void selectCountry() {

        WebElement country =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("country")));

        Select select = new Select(country);

        select.selectByIndex(9);
    }

    public void selectColorsAndAnimals() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='colors']/option[7]")))
                .click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='animals']/option[8]")))
                .click();
    }

    // =========================
    // DATE PICKERS
    // =========================

    public void enterDateOne() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("datepicker")))
                .sendKeys("19/07/2002");
    }

    public void selectDateTwo() {

    	wait.until(ExpectedConditions.elementToBeClickable(By.id("txtDate")))
        .click();

WebElement month = wait.until(
        ExpectedConditions.visibilityOfElementLocated(
                By.className("ui-datepicker-month")));

Select monthSelect = new Select(month);
monthSelect.selectByIndex(2); 

WebElement year = wait.until(
        ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//select[@aria-label='Select year']")));

Select yearSelect = new Select(year);
yearSelect.selectByVisibleText("2016");


wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='11']")))
        .click();

    }

    public void selectDateRange() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("start-date")))
                .sendKeys("03/01/2003");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("end-date")))
                .sendKeys("05/06/2026");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.className("submit-btn")))
                .click();
    }

    // =========================
    // FILE UPLOAD
    // =========================

    public void uploadSingleFile(String path) {

        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("singleFileInput")))
                .sendKeys(path);

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='singleFileForm']/button")))
                .click();
    }

    public void uploadMultipleFiles(String files) {

        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("multipleFilesInput")))
                .sendKeys(files);

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='multipleFilesForm']/button")))
                .click();
    }

    // =========================
    // PAGINATION TABLE
    // =========================

    public void selectPaginationTableRows() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='productTable']/tbody/tr[1]/td[4]/input")))
                .click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='productTable']/tbody/tr[3]/td[4]/input")))
                .click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='productTable']/tbody/tr[5]/td[4]/input")))
                .click();
    }

    // =========================
    // DYNAMIC BUTTONS
    // =========================

    public void handleInputFormSection() {

        wait.until(ExpectedConditions.elementToBeClickable(By.id("input1")))
                .sendKeys("Hello");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("btn1")))
                .click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("input2")))
                .sendKeys("Hii");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("btn2")))
                .click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("input3")))
                .sendKeys("Bye");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("btn3")))
                .click();
    }

    // =========================
    // WIKIPEDIA
    // =========================

    public void searchWikipedia(String keyword) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("Wikipedia1_wikipedia-search-input")))
                .sendKeys(keyword);

        wait.until(ExpectedConditions.elementToBeClickable(
                By.className("wikipedia-search-button")))
                .click();
    }

    public void clickStartButton() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.className("start")))
                .click();
    }

    // =========================
    // ALERTS
    // =========================

    public void handleSimpleAlert() {

        WebElement alertBtn =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("alertBtn")));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        alertBtn);

        alertBtn.click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        alert.accept();
    }

    public void handleConfirmAlert() {

        driver.findElement(By.id("confirmBtn")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        alert.dismiss();
    }

    public void handlePromptAlert() {

        driver.findElement(By.id("promptBtn")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        alert.sendKeys("Harry Potter");

        alert.accept();
    }

    // =========================
    // WINDOWS & TABS
    // =========================

    public void closeNewTab() {

        String parent = driver.getWindowHandle();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("PopUp")))
                .click();

        wait.until(d -> d.getWindowHandles().size() > 1);

        for (String handle : driver.getWindowHandles()) {

            if (!handle.equals(parent)) {

                driver.switchTo().window(handle);

                driver.close();
            }
        }

        driver.switchTo().window(parent);
    }

    public void closePopupWindow() {

        String parent = driver.getWindowHandle();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='HTML4']/div[1]/button")))
                .click();

        wait.until(d -> d.getWindowHandles().size() > 1);

        for (String handle : driver.getWindowHandles()) {

            if (!handle.equals(parent)) {

                driver.switchTo().window(handle);

                driver.close();

                break;
            }
        }

        driver.switchTo().window(parent);
    }

    
    // =========================
    // ACTIONS
    // =========================

    public void mouseHover() {

        WebElement menu =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.className("dropbtn")));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        menu);

        actions.moveToElement(menu).perform();
    }

    public void doubleClickButton() {

        WebElement button =
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[@id='HTML10']/div[1]/button")));

        actions.doubleClick(button).perform();
    }

    public void dragAndDrop() {

        WebElement source =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("draggable")));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        source);

        WebElement target =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("droppable")));

        actions.dragAndDrop(source, target).perform();
    }

    public void moveSlider() {

        WebElement slider =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[@id='slider-range']/span[1]")));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        slider);

        actions.dragAndDropBy(slider, 100, 0).perform();
    }

    public void selectScrollableDropdown() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("comboBox")))
                .click();

        WebElement option =
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[@id='dropdown']/div[7]")));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        option);

        option.click();
    }

    public void handleLaptopLink() {

        // =========================
        // LAPTOP LINK (Apple)
        // =========================

        WebElement laptopLink = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Apple")));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        laptopLink);

        laptopLink.click();

        wait.until(ExpectedConditions.urlContains("apple"));

        System.out.println("===== APPLE PAGE =====");
        System.out.println("Page Title : " + driver.getTitle());
        System.out.println("Current URL : " + driver.getCurrentUrl());

        driver.navigate().back();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("name")));

        System.out.println("Returned to Home Page after Apple link");
    }

        // =========================
        // BROKEN LINK (404)
        // =========================
public void handleBrokenLink() {
        WebElement broken404 = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Errorcode 404")));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        broken404);

        broken404.click();

        wait.until(ExpectedConditions.urlContains("404"));

        System.out.println("===== 404 ERROR PAGE =====");
        System.out.println("Page Title : " + driver.getTitle());
        System.out.println("Current URL : " + driver.getCurrentUrl());

        driver.navigate().back();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("name")));

        System.out.println("Returned to Home Page after 404 link");
    }
    // =========================
    // SHADOW DOM
    // =========================

    public void handleShadowDom(String filePath) {

        WebElement shadowHost =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("shadow_host")));

        SearchContext shadowRoot = shadowHost.getShadowRoot();

        WebElement textBox =
                shadowRoot.findElement(By.cssSelector("input[type='text']"));

        textBox.clear();
        textBox.sendKeys("Hii");

        WebElement checkbox =
                shadowRoot.findElement(By.cssSelector("input[type='checkbox']"));

        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        WebElement upload =
                shadowRoot.findElement(By.cssSelector("input[type='file']"));

        upload.sendKeys(filePath);
    }
 // =========================
 // ASSERTION METHODS
 // =========================

 public String getEnteredName() {

     return driver.findElement(By.id("name"))
             .getAttribute("value");
 }

 public String getSelectedCountry() {

     Select select = new Select(
             driver.findElement(By.id("country")));

     return select.getFirstSelectedOption().getText();
 }

 public String getDateOneValue() {

     return driver.findElement(By.id("datepicker"))
             .getAttribute("value");
 }

 public boolean isPaginationRowSelected() {

     return driver.findElement(
             By.xpath("//*[@id='productTable']/tbody/tr[1]/td[4]/input"))
             .isSelected();
 }
 
 public String getInput1Value() {
	    return driver.findElement(By.id("input1"))
	            .getAttribute("value");
	}

	public String getInput2Value() {
	    return driver.findElement(By.id("input2"))
	            .getAttribute("value");
	}

	public String getInput3Value() {
	    return driver.findElement(By.id("input3"))
	            .getAttribute("value");
	}

 public boolean isWikipediaResultDisplayed() {

     return wait.until(
             ExpectedConditions.visibilityOfElementLocated(
                     By.xpath("//div[@id='wikipedia-search-result-link']")))
             .isDisplayed();
 }

 public int getWindowCount() {

     return driver.getWindowHandles().size();
 }

 public String getDroppedText() {

     return driver.findElement(By.id("droppable"))
             .getText();
 }

 public String getShadowInputValue() {

     SearchContext shadowRoot =
             driver.findElement(By.id("shadow_host"))
                     .getShadowRoot();

     return shadowRoot
             .findElement(By.cssSelector("input[type='text']"))
             .getAttribute("value");
 }

 public boolean isShadowCheckboxSelected() {

     SearchContext shadowRoot =
             driver.findElement(By.id("shadow_host"))
                     .getShadowRoot();

     return shadowRoot
             .findElement(By.cssSelector("input[type='checkbox']"))
             .isSelected();
 }

 public String getCurrentUrl() {

     return driver.getCurrentUrl();
 }

 public String getPageTitle() {

     return driver.getTitle();
 }
}
