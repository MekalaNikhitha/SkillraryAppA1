package pomPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
	//Declaration
	@FindBy(xpath="//h1[normalize-space(text())='Category']")
	private WebElement pageHeader;
	
	@FindBy(xpath="//a[text()=' New']")
	private WebElement newButton;
	
	@FindBy(xpath="//table/tbody/tr/td[1]")
	private List<WebElement> categoryList;
	
	private String deletepath="//td[text()='%s']/following-sibling::td/button[text()=' Delete']";
	
	@FindBy(xpath=" //h4[text()=' Success!']")
	private WebElement successMessage;
	
	@FindBy(xpath="//button[@name='delete']")
	private WebElement deleteButton;
	
	//Initialization
	public CategoryPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
		//Utilization
		public String getPageHeader() {
			return pageHeader.getText();
		}
		public void ClickNewButton() {
			newButton.click();
		}
		public List<WebElement>getCategoryList() {
			return categoryList;
			
		}
		public String getSuccessMessage() {
			return successMessage.getText();
		}
		public void clickDeleteButton(String courseName,WebDriver driver) {
			String requiredpath=String.format(deletepath,courseName);
					driver.findElement(By.xpath(requiredpath)).click();
			}
			public void clickDelete() {
				deleteButton.click();
			}
			

}
