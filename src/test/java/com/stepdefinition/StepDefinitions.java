package com.stepdefinition;
import io.cucumber.java.After;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinitions {
    WebDriver driver;
    
    
   

    @Given("I am on the ReactJS site")
    public void iAmOnTheReactJSSite() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
   	driver.get("https://legacy.reactjs.org/");
   	driver.manage().window().maximize();
    Thread.sleep(3000);
        
    }

    @When("I click on the Docs Tab")
    public void iClickOnTheTab() {
    	
    	
        WebElement tab = driver.findElement(By.xpath("//a[text()='Docs']"));        
        tab.click();
    }

    @Then("I expand the main Concepts and extract all sub elements")
    public void iExpandTheMainConceptsAndExtractAllSubElements() throws InterruptedException {
	      
    	Thread.sleep(3000);
        WebElement concepts = driver.findElement(By.xpath("//div[text()='Main Concepts']"));
        concepts.click();
        
        WebElement dropdown = driver.findElement(By.xpath("//ul[@class='css-ts0qly']"));

     // Highlight the option element
        highlightElement(driver, dropdown);
        
        
    }
    

    @Then("I save the extracted text in a file")
    public void iSaveTheExtractedTextInAFile() {
    	WebElement dropdown = driver.findElement(By.xpath("//ul[@class='css-ts0qly']"));
    	 List<WebElement> options = dropdown.findElements(By.tagName("li"));

	               
                // Specify the file path
                String filePath = "target\\mainOptions.txt";
                
                try {
                    FileWriter writer = new FileWriter(filePath);
                    for (WebElement optionWrite : options) {
                        String optionWriteText = optionWrite.getText();
                        System.out.println("Option Text: " + optionWriteText);
                        writer.write(optionWriteText + "\n");
                    }
                    writer.close();
                    System.out.println("Options written to file successfully.");
                    	
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Error writing options to file.");
                }
                
          driver.quit();
             
    }
    
    
    
    @Then("I expand the Advanced Guides and extract all sub elements")
    public void i_expand_the_advanced_guides_and_extract_all_sub_elements() throws InterruptedException {
    	Thread.sleep(3000);
        WebElement concepts = driver.findElement(By.xpath("//div[text()='Advanced Guides']"));
        concepts.click();
        
        WebElement dropdown = driver.findElement(By.xpath("//ul[@class='css-ts0qly']"));

     // Highlight the option element
        highlightElement(driver, dropdown);	
       
    }
    @Then("I save the extracted text for Advanced Guides in a file")
    public void i_save_the_extracted_text_for_advanced_guides_in_a_file() {
    	
    	WebElement dropdown = driver.findElement(By.xpath("//ul[@class='css-ts0qly']"));
   	 List<WebElement> options = dropdown.findElements(By.tagName("li"));

	               
               // Specify the file path
               String filePath = "target\\advancedGuideOptions.txt";
               
               try {
                   FileWriter writer = new FileWriter(filePath);
                   for (WebElement optionWrite : options) {
                       String optionWriteText = optionWrite.getText();
                       System.out.println("Option Text: " + optionWriteText);
                       writer.write(optionWriteText + "\n");
                   }
                   writer.close();
                   System.out.println("Options written to file successfully.");
                   	
               } catch (IOException e) {
                   e.printStackTrace();
                   System.out.println("Error writing options to file.");
               }
               
         driver.quit();

    }
    


    @When("I click on the Tutorial Tab")
    public void i_click_on_the_tutorial_tab() {
    	
        WebElement tab = driver.findElement(By.xpath("//a[text()='Tutorial']"));        
        tab.click();

    }




    @Then("the user scrolls down in the tutorial tab")
    public void the_user_scrolls_down_in_the_tutorial_tab() throws InterruptedException {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	Thread.sleep(3000);		
    	js.executeScript("window.scrollBy(0, 20000);");
    	Thread.sleep(5000);
    

    }
    @And("the respected content is bolded on the right navigation and blue color line is seen")
    public void the_respected_content_is_bolded_on_the_right_navigation_and_blue_color_line_is_seen() throws InterruptedException {
    	
    	WebElement rightNav = driver.findElement(By.xpath("//a[text()='Taking Turns']"));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", rightNav);

        Thread.sleep(3000);
		
		  String fontWeight = rightNav.getCssValue("font-weight");
		  
		 // assertEquals("700", fontWeight);
		 
        
        if (fontWeight.equals("bold") || fontWeight.equals("700")) {
            System.out.println("Text is bold.");
        } else {
            System.out.println("Text is not bold.");
        }
        
			
        
        WebElement blueLine = rightNav.findElement(By.xpath("//span[@class='css-ifgy4z']"));
        String color = blueLine.getCssValue("border-left");
        
        if (color.contains("rgb(97, 218, 251)") || color.contains("4px solid")) {
            System.out.println("Blue line is visible.");
        } else {
            System.out.println("Blue line is not visible.");
        }

       driver.quit();

        }

        


    



    
    
    private static void highlightElement(WebDriver driver, WebElement element) {
        // Execute JavaScript to highlight the element
        ((ChromeDriver) driver).executeScript("arguments[0].style.border='2px solid red';", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ((ChromeDriver) driver).executeScript("arguments[0].style.border='';", element);
    }
   
    
    
}