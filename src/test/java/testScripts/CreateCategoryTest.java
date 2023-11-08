package testScripts;

import java.util.Map;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class CreateCategoryTest extends BaseClass {
	@Test
	public void createCategoryTest() throws InterruptedException  {
		SoftAssert soft=new SoftAssert();
		home.clickCoursesTab();
		home.clickCategoryLink();
		soft.assertTrue(category.getPageHeader().contains("Category"));
		category.ClickNewButton();
		Thread.sleep(3000);
		soft.assertEquals(addCategory.getPageHeader(),"Add new Category");
		Map<String, String> map=excel.readFromExcel("Sheet1","Add Category");
		String categoryName = map.get("Name")+jutil.generateRandomNum(100);
		addCategory.setName(categoryName);
		addCategory.clickSave();
		soft.assertTrue(category.getSuccessMessage().contains("Success"));
		boolean isPresent = false;
		List<WebElement>categoryList=category.getCategoryList();
		for(WebElement e: categoryList) {
			if(e.getText().endsWith(categoryName)) {
				isPresent=true;
				break;
			}
			
		}
		soft.assertTrue(isPresent);
		
		category.clickDeleteButton(categoryName, driver);
		category.clickDelete();
		soft.assertTrue(category.getSuccessMessage().contains("Success"));
		soft.assertAll();
	}
}
		
		
		
		
		
	
	


