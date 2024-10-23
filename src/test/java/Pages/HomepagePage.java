package Pages;


import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepagePage extends BaseTest {
        public HomepagePage() {
            PageFactory.initElements(driver, this);
        }

        @FindBy(className = "app_logo")
        public WebElement header;

        @FindBy(id = "react-burger-menu-btn")
        public WebElement btnBurgerMenu;

        @FindBy(id = "logout_sidebar_link")
        public WebElement linkLogout;



// metode

        public void clickOnHamburgerMenuIfDisplayed() {
            btnBurgerMenu.click();
        }

        public void clickOnLogoutLink() {
            linkLogout.click();
        }
    }

