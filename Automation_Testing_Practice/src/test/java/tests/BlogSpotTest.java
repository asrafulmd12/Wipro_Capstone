package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.BlogSpotPage;
import utils.ExcelUtils;
import org.testng.Assert;

public class BlogSpotTest extends BaseTest {

    private BlogSpotPage page;

    @BeforeClass
    public void setupPage() {
        page = new BlogSpotPage(driver);
    }

    @Test(priority = 1)
    public void formDetailsTest() {

        String path = "D:\\ExcelTest\\testdata.xlsx";

        Object[] data = ExcelUtils.getSingleRowData(path, "Sheet1");

        String name = data[0].toString();
        String email = data[1].toString();
        String phone = data[2].toString();
        String address = data[3].toString();

        page.fillUserDetails(name, email, phone, address);

        page.selectGenderAndDays();
        
        System.out.println("Validating Name Field...");

        Assert.assertEquals(
                page.getEnteredName(),
                name,
                "Name field validation failed");

        System.out.println("Name Field Validation Passed");
    }


    @Test(priority = 2)
    public void dropdownSelectionTest() {

        page.selectCountry();

        page.selectColorsAndAnimals();
        
        System.out.println("Validating Country Selection...");

        Assert.assertEquals(
                page.getSelectedCountry(),
                "India");

        System.out.println("Country Selection Validation Passed");
    }

    @Test(priority = 3)
    public void datePickerTest() {

        page.enterDateOne();
        
        System.out.println("Validating Date Picker Value...");

        Assert.assertEquals(
                page.getDateOneValue(),
                "19/07/2002");

        System.out.println("Date Picker Validation Passed");

        page.selectDateTwo();

        page.selectDateRange();
    }

    @Test(priority = 4)
    public void fileUploadTest() {

        page.uploadSingleFile("E:\\Text\\ABC.txt");

        page.uploadMultipleFiles(
                "E:\\Text2\\T\\f.txt\n"
                        + "E:\\Text2\\T\\file2.txt\n"
                        + "E:\\Text2\\T\\t.txt");
        
        Assert.assertTrue(true);
    }

    @Test(priority = 5)
    public void paginationTableTest() {

        page.selectPaginationTableRows();
        
        System.out.println("Validating Pagination Table Selection...");

        Assert.assertTrue(
                page.isPaginationRowSelected(),
                "Pagination row checkbox not selected");

        System.out.println("Pagination Table Validation Passed");
    }

    @Test(priority = 6)
    public void inputFormSectionTest() {

        page.handleInputFormSection();
        
        System.out.println("Validating Input Form Section...");

        Assert.assertEquals(page.getInput1Value(), "Hello");
        Assert.assertEquals(page.getInput2Value(), "Hii");
        Assert.assertEquals(page.getInput3Value(), "Bye");

        System.out.println("Input Form Validation Passed");
    }

    @Test(priority = 7)
    public void wikipediaTest() {

        page.searchWikipedia("Java");
        
        System.out.println("Validating Wikipedia Search Result...");

        Assert.assertTrue(
                page.isWikipediaResultDisplayed(),
                "Wikipedia result not displayed");

        System.out.println("Wikipedia Validation Passed");

        page.clickStartButton();
    }

    @Test(priority = 8)
    public void alertTest() {

        page.handleSimpleAlert();

        page.handleConfirmAlert();

        page.handlePromptAlert();
        
        Assert.assertTrue(true);
    }

    @Test(priority = 9)
    public void windowAndTabTest() {

        page.closePopupWindow();

        page.closeNewTab();
        
        System.out.println("Validating Window Count...");

        Assert.assertEquals(
                page.getWindowCount(),
                1,
                "More than one window remains open");

        System.out.println("Window Validation Passed");
    }

    @Test(priority = 10)
    public void actionsLaptopBrokenLinksAndShadowDomTest() {

        page.mouseHover();

        page.doubleClickButton();

        page.dragAndDrop();
        
        System.out.println("Validating Drag and Drop Result...");

        Assert.assertEquals(
                page.getDroppedText(),
                "Dropped!",
                "Drag and Drop failed");

        System.out.println("Drag and Drop Validation Passed");

        page.moveSlider();

        page.selectScrollableDropdown();
        
        page.handleLaptopLink();

        page.handleBrokenLink();
        
        page.handleShadowDom("E:\\Text\\ABC.txt");
        
        System.out.println("Validating Shadow DOM Input...");

        Assert.assertEquals(
                page.getShadowInputValue(),
                "Hii");

        Assert.assertTrue(
                page.isShadowCheckboxSelected());

        System.out.println("Shadow DOM Validation Passed");
    }
}