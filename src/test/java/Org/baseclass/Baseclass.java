package Org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

//To configure Browser

public class Baseclass {
	public static WebDriver driver;
	public void getdriver(String browser_Name ) {
		try {
			if (browser_Name.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vishnu Vardhan\\eclipse-workspace\\Cucumbertask\\Driver\\chromedriver.exe");
				driver=new ChromeDriver();
			}
			else if (browser_Name.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\Vishnu Vardhan\\eclipse-workspace\\Cucumbertask\\Driver\\chromedriver.exe");
				driver=new FirefoxDriver();
			}
			else if (browser_Name.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "C:\\Users\\Vishnu Vardhan\\eclipse-workspace\\Cucumbertask\\Driver\\chromedriver.exe");
				driver=new InternetExplorerDriver();
			}
			else {
				System.out.println("Invalid browser. Unable to launch");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.MINUTES);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
//To get URL
	public void getUrl(String url) {
		try {
			driver.get(url);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public WebElement eleId(String id) {
		WebElement element=null;
		try {
			 element = driver.findElement(By.id(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
		
	}

//find element and locators
	public WebElement find_Element_Locators(String locators, String id) {
		WebElement find_Element = null;
		try {
			if (locators.equalsIgnoreCase("id")) {
				find_Element = driver.findElement(By.id(id));
			}
			else if (locators.equalsIgnoreCase("name")) {
				find_Element=driver.findElement(By.name(id));
			}
			else if (locators.equalsIgnoreCase("xpath")) {
				 find_Element = driver.findElement(By.xpath(id));
			}
			else if (locators.equalsIgnoreCase("tagName")) {
				find_Element = driver.findElement(By.tagName(id));
			}
			else if (locators.equalsIgnoreCase("className")) {
				find_Element = driver.findElement(By.className(id));
			}
			else if (locators.equalsIgnoreCase("cssSelector")) {
				find_Element = driver.findElement(By.cssSelector(id));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return find_Element;
	}

//To pass the values (Send keys)
	public void send_Keys(WebElement element, String data) {
		try {
			element.sendKeys(data);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
//To click the button (Click)	
	public void click(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
//To get current url
	public void get_Current_Url() {
		try {
			String currentUrl = driver.getCurrentUrl();
			System.out.println(currentUrl);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
//To get the title of the page
	public void get_Title() {
		try {
			String title = driver.getTitle();
			System.out.println(title);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
//To get the text
	public void get_Text(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}
//Action class
	public void actions(WebElement element, String method) {
		Actions action=new Actions(driver);
		try {
			if (method.equalsIgnoreCase("movetoElement")) {
				action.moveToElement(element).perform();
			}
			else if (method.equalsIgnoreCase("darganddrop")) {
				action.dragAndDrop(element, element).perform();
			}
			else if (method.equalsIgnoreCase("context_click")) {
				action.contextClick(element).perform();
			}
			else if (method.equalsIgnoreCase("double_click")) {
				action.doubleClick(element).perform();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//To close the current browser
	public void close() {
		try {
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//To close all browser	
	public void quit() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//Alert class	
	public void alert(String method, String data) {
		Alert alert=driver.switchTo().alert();
		try {
			if (method.equalsIgnoreCase("accept")) {
				alert.accept();
			}
			else if (method.equalsIgnoreCase("dismiss")) {
				alert.dismiss();
			}
			else if (method.equalsIgnoreCase("send_keys")) {
				alert.sendKeys(data);
			}
			else if (method.equalsIgnoreCase("get_Text")) {
				String text = alert.getText();
				System.out.println(text);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//frames	
	public void frames(String method,String data, WebElement element,int index) {
		try {
			if (method.equalsIgnoreCase("id")) {
				driver.switchTo().frame(data);
			}
			else if (method.equalsIgnoreCase("name")) {
				driver.switchTo().frame(data);
			}
			else if (method.equalsIgnoreCase("element")) {
				driver.switchTo().frame(element);
			}
			else if (method.equalsIgnoreCase("index")) {
				driver.switchTo().frame(index);
			}
			else if (method.equalsIgnoreCase("parent_frame")) {
				driver.switchTo().parentFrame();
			}
			else if (method.equalsIgnoreCase("default_Content")) {
				driver.switchTo().defaultContent();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//Select class	
	public void select(String method,WebElement element,String data) {
		Select select=new Select(element);
		try {
			if (method.equalsIgnoreCase("index")) {
				int parseInt = Integer.parseInt(data);
				select.selectByIndex(parseInt);
			}
			else if (method.equalsIgnoreCase("value")) {
				select.selectByValue(data);
			}
			else if (method.equalsIgnoreCase("Visible_Text")) {
				select.selectByVisibleText(data);
			}
			else if (method.equalsIgnoreCase("isMultiple")) {
				boolean multiple = select.isMultiple();
				System.out.println(multiple);
			}
			else if (method.equalsIgnoreCase("getOptions")) {
				List<WebElement> options = select.getOptions();
				for (int i = 0; i < options.size(); i++) {
					WebElement ivalue = options.get(i);
					String text = ivalue.getText();
					System.out.println(text);
				}
			}
			else if (method.equalsIgnoreCase("getAllSelectedOptions")) {
				List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
				for (int i = 0; i < allSelectedOptions.size(); i++) {
					WebElement ivalue = allSelectedOptions.get(i);
					String text = ivalue.getText();
					System.out.println(text);
				}
			}
			else if (method.equalsIgnoreCase("getFirstSelectedOptions")) {
				WebElement firstSelectedOption = select.getFirstSelectedOption();
				String text = firstSelectedOption.getText();
				System.out.println(text);
			}
			else if (method.equalsIgnoreCase("deselectbyindex")) {
				int parseInt = Integer.parseInt(data);
				select.deselectByIndex(parseInt);
			}
			else if (method.equalsIgnoreCase("deselectByValue")) {
				select.deselectByValue(data);
			}
			else if (method.equalsIgnoreCase("deselectByVisibleText")) {
				select.deselectByVisibleText(data);
			}
			else if (method.equalsIgnoreCase("deselectAll")) {
				select.deselectAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
//WebTable
	public String web_Table(String method, String data,String data1,WebElement element) {
		try {
			if (method.equalsIgnoreCase("headings_only")) {
				List<WebElement> tHead = driver.findElements(By.tagName(data));
				for (int i = 0; i < tHead.size(); i++) {
					WebElement head = tHead.get(i);
					String text = head.getText();
					System.out.println(text);
				}
			}
			else if (method.equalsIgnoreCase("row_only")) {
				List<WebElement> tRows = driver.findElements(By.tagName(data));
				for (int i = 0; i < tRows.size(); i++) {
					WebElement rows = tRows.get(i);
					String text = rows.getText();
					System.out.println(text);
				}
			}
			else if (method.equalsIgnoreCase("datas_only")) {
				List<WebElement> tRows = driver.findElements(By.tagName(data));
				for (int i = 0; i < tRows.size(); i++) {
					WebElement rows = tRows.get(i);
					List<WebElement> tDatas = rows.findElements(By.tagName(data1));
					WebElement datas = tDatas.get(i);
					String text = datas.getText();
					System.out.println(text);
				}
			}
			else if (method.equalsIgnoreCase("particular_data")) {
				List<WebElement> tRows = driver.findElements(By.tagName(data));
				for (int i = 0; i < tRows.size(); i++) {
					WebElement rows = tRows.get(i);
					List<WebElement> tDatas = rows.findElements(By.tagName(data1));
					WebElement datas = tDatas.get(i);
					String text = datas.getText();
					if (text.equals(element)) {
						System.out.println(text);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data1;
	}
	
	
//Navigation commands
	public void navigation_Commands(String method,String data) {
		try {
			if (method.equalsIgnoreCase("to")) {
				driver.navigate().to(data);
			}
			else if (method.equalsIgnoreCase("back")) {
				driver.navigate().back();
			}
			else if (method.equalsIgnoreCase("forward")) {
				driver.navigate().forward();
			}
			else if (method.equalsIgnoreCase("refresh")) {
				driver.navigate().refresh();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//Methods of WebElement
	public void webElement_method(WebElement element,String method) {
		try {
			if (method.equalsIgnoreCase("isdispalyed")) {
				boolean displayed = element.isDisplayed();
				System.out.println(displayed);
			}
			else if (method.equalsIgnoreCase("isSelected")) {
				boolean selected = element.isSelected();
				System.out.println(selected);
			}
			else if (method.equalsIgnoreCase("isEnabled")) {
				boolean enabled = element.isEnabled();
				System.out.println(enabled);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
//JavaScript
	public void javaScriptExecutor1(String data,WebElement element) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
				
					try {
						js.executeScript("arguments[0].setAttribute('value','"+data+"')", element);
					}catch (Exception e) {
				e.printStackTrace();
			}
	}
	public void javaScriptExecutor2(WebElement element,String method) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		try {
			if(method.equalsIgnoreCase("click")) {
				js.executeScript("arguments[0].click()", element);
			}
			else if (method.equalsIgnoreCase("getattribute")) {
				js.executeScript("arguments[0].getAttribute('value')", element);
			}
			else if (method.equalsIgnoreCase("scrollup")) {
				js.executeScript("arguments[0].scrollIntoView(false)", element);
			}
			else if (method.equalsIgnoreCase("scrolldown")) {
				js.executeScript("arguments[0].scrollIntoView(true)", element);
			}
		} 
			catch (Exception e) {
				e.printStackTrace();
			}
	}
		
//To get a data from excel
//		public String getDataFromExcel(String pathName, String SheetName,int rowNo,int cellNo) {
//			String value=null;
//			try {
//				File file=new File(pathName);
//				FileInputStream inputStream=new FileInputStream(file);
//				Workbook book=new XSSFWorkbook(inputStream);
//				Sheet sheet = book.getSheet(SheetName);
//				Row row = sheet.getRow(rowNo);
//				Cell cell = row.getCell(cellNo);
////				int cellType = cell.getCellType();
////				if (cellType==1) {
////					value = cell.getStringCellValue();
////				}
//				else if (DateUtil.isCellDateFormatted(cell)) {
//					Date dateCellValue = cell.getDateCellValue();
//					SimpleDateFormat dateFormat=new SimpleDateFormat("dd/mm/yyyy");
//					value=dateFormat.format(dateCellValue);
//				}
//				else {
//					double numericCellValue = cell.getNumericCellValue();
//					long l=(long)numericCellValue;
//					value = String.valueOf(l);
//				}
//				FileOutputStream outputStream=new FileOutputStream(file);
//				book.write(outputStream);
//			} 
//			catch (Exception e) {
//				e.printStackTrace();
//			}
//			return value;
//		}
//	
	
//To create a new sheet in particular location.
	public String dataToExcel(String data,String location, String sheetName, int rowNo,int cellNo) {
		try {
			File file=new File(location);
			FileInputStream inputStream=new FileInputStream(file);
			Workbook workBook=new XSSFWorkbook(inputStream);
			Sheet sheet = workBook.createSheet(sheetName);
			Row row = sheet.createRow(rowNo);
			Cell cell = row.createCell(cellNo);
			cell.setCellValue(data);
			FileOutputStream outputStream =new FileOutputStream(file);
			workBook.write(outputStream);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sheetName;
	}
	
	
	//To set a data to excel
		public String getDataToExcel(String pathName, String sheetName,int rowNo,int cellNo,String method) {
			String text=null;
			try {
				File file=new File(pathName);
				FileInputStream inputStream=new FileInputStream(file);
				Workbook workBook=new XSSFWorkbook(inputStream);
				Sheet sheet = workBook.createSheet(sheetName);
				Row row = sheet.createRow(rowNo);
				row.createCell(cellNo);
				List<WebElement> tRows = driver.findElements(By.tagName("tr"));
				for (int i = 0; i < tRows.size(); i++) {
					WebElement rows = tRows.get(i);
					List<WebElement> tDatas = rows.findElements(By.tagName("td"));
					for (int j = 0; j < tDatas.size(); j++) {
						WebElement datas = tDatas.get(j);
						 text = datas.getText();
						if (method.equalsIgnoreCase("order_no")) {
							System.out.println(text);
						}
					}
					
				}
				FileOutputStream outputStream=new FileOutputStream(file);
				workBook.write(outputStream);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return text;
		}	
		public WebElement getToDataToExcel(String data, String pathName, String sheetName,int rowNo,int cellNo,WebElement element) {
			
			try {
				File file=new File(pathName);
				FileInputStream inputStream=new FileInputStream(file);
				Workbook workBook=new XSSFWorkbook(inputStream);
				Sheet sheet = workBook.createSheet(sheetName);
				Row row = sheet.createRow(rowNo);
				Cell cell = row.createCell(cellNo);
				String attribute = element.getAttribute("value");
				cell.setCellValue(attribute);
				FileOutputStream outputStream=new FileOutputStream(file);
				workBook.write(outputStream);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return element;
			
		}
	
	}