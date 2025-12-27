package distpage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Distapagecls {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//*[@id=\"shopify-section-header--default\"]/header[1]/div[1]/div[3]/div[2]/a")WebElement loglink;
	@FindBy(xpath = "//*[@id=\"customer_login\"]/input[3]")WebElement email;
	@FindBy(xpath = "//*[@id=\"customer_login\"]/input[4]")WebElement password;
	@FindBy(xpath = "//*[@id=\"customer_login\"]/input[5]")WebElement signin;
	@FindBy(xpath = "//*[@id=\"shopify-section-header--default\"]/header[1]/div[2]/div/nav/span[3]/a")WebElement food;
	@FindBy(xpath = "//a[@href='/products/vellanki-foods-assorted-sweets']")WebElement foodselect;
	@FindBy(xpath = "//*[@id=\"product_form_10866820251807\"]/div[10]/button/span")WebElement cartadd;
	@FindBy(name = "st")WebElement searchitem;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div[1]/div/div/div[2]/div/aside/div/section/div")WebElement ordershot;
	@FindBy(xpath="//a[@href='/checkout']")WebElement chout;
	@FindBy(name = "countryCode")WebElement details;
	@FindBy(name = "firstName")WebElement fn;
	@FindBy(name = "lastName")WebElement ln;
	@FindBy(name="address1")WebElement adrr;
	@FindBy(name="city")WebElement ci;
	@FindBy(name="zone")WebElement cou;
	@FindBy(name="postalCode")WebElement postc;
	@FindBy(name="phone")WebElement ph;
	@FindBy(xpath="//*[@id=\"shopify-section-header--default\"]/header[1]/div[1]/div[3]/div[2]/a")WebElement loac;
	@FindBy(xpath="//a[@href='/account/logout']") WebElement logout;
	@FindBy(xpath="//a[@href='/pages/contact']")WebElement contus;
	

	public Distapagecls(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);

	}

	public void closePopup() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    
	    
	    String killAllOverlays = 
	        "function killOverlays() {" +
	        "  var selectors = ['.minicart-overlay', '.overlay', 'label[for*=\"minicart\"]', " +
	        "    'div[role=\"dialog\"]', '.klaviyo-modal-close', '[aria-label*=\"close\"]', " +
	        "    '.modal', '.popup', '[data-testid*=\"close\"]']; " +
	        "  selectors.forEach(function(sel) { " +
	        "    document.querySelectorAll(sel).forEach(function(el) { " +
	        "      el.style.display = 'none'; el.style.visibility = 'hidden'; " +
	        "      el.style.pointerEvents = 'none'; el.remove(); " +
	        "    }); " +
	        "  }); " +
	        "} " +
	        "killOverlays(); setTimeout(killOverlays, 500); setTimeout(killOverlays, 1000);";
	    
	    js.executeScript(killAllOverlays);
	    try {
	    	Thread.sleep(2000);
	    	} 
	    catch (Exception e) {
	    	
	    }
	    System.out.println("All ads are closed");
		
		}
	

		public void loginpage() {
		closePopup();
		loglink.click();
		System.out.println("Login page is clicked");
	}
		

	public void login(String emailid, String pass) {
		closePopup();
		email.sendKeys(emailid);
		password.sendKeys(pass);
		signin.click();
	}
	

	public void homepage() throws Exception {
		
		closePopup();
		searchitem.sendKeys("clothes", Keys.ENTER);
		searchitem.clear();
		searchitem.sendKeys("Women Republic Black Velvet", Keys.ENTER);

		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href*='women-republic']")));

		
		WebElement cloth = driver.findElement(By.xpath("//a[contains(@href,'women-republic-black-velvet')]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", cloth);
		Thread.sleep(1500);
		js.executeScript("arguments[0].click();", cloth);

		WebElement addToCartBtn = driver.findElement(By.xpath("//*[@id=\"product_form_7676893528223\"]/div[12]/button/span"));

		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", addToCartBtn);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", addToCartBtn);

		
   }
	

	public void addtocartpage() throws Exception {
		closePopup();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    
	    
	    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", food);
	    Thread.sleep(1000);
	    
	    
	    js.executeScript("arguments[0].click();", food);
	    System.out.println("Food menu clicked ");
	    
	    Thread.sleep(3000);
	    
	   
	    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", foodselect);
	    Thread.sleep(1000);
	    js.executeScript("arguments[0].click();", foodselect);
	    
	    
	    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", cartadd);
	    Thread.sleep(1000);
	    js.executeScript("arguments[0].click();", cartadd);
	    
	    System.out.println("Food item added to cart");
		
	}
	
	

	public void checkoutpage() throws Exception 
	{
		closePopup();
		chout.click();
		System.out.println("Items are added in the cart");
		File s = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File c = ordershot.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(c, new File("./Screenshot/ViewCart.png"));
		System.out.println("Scrolldown screenshot saved successfully");
	}
	
	

	public void deliverydetails(String fname, String lname,String address,String city,String postal,String mobile )
	{
		closePopup();
		Select dd = new Select(details);
		dd.selectByVisibleText("Ireland");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,2500);");
		fn.sendKeys(fname);
		ln.sendKeys(lname);
		adrr.sendKeys(address);
		ci.sendKeys(city);
		Select cy = new Select(cou);
		cy.selectByVisibleText("Sligo");
		postc.sendKeys(postal);
		ph.sendKeys(mobile);
		System.out.println("Invalid datas are given so unable to proceed further");
        driver.navigate().back();
	}
	
       
       public void logoutpage()
       {
    	   
         loac.click();
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollTo(0,500);");
	     logout.click();
	     System.out.println("Successfully logout");
	   }
       
       public void contactuspage()
       {
    	   contus.click();
    	   System.out.println("Successfully redirected to contactus page");
       }
	}
	
	
	

	


