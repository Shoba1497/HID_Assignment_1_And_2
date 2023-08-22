package com.baseClass;

public class highlightElement  {
	
	private static void highlightElement(WebDriver driver, WebElement element) (){
	
	((ChromeDriver) driver).executeScript("arguments[0].style.border='2px solid red';", element);
    try {
        Thread.sleep(500); // Add a small delay for highlighting effect
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    ((ChromeDriver) driver).executeScript("arguments[0].style.border='';", element);

}
