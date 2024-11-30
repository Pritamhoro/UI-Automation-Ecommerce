package com.mystore.basepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class BaseClass 
{
	public static Properties prop;
	public static WebDriver driver;
	@BeforeTest
	public void loadconfig() 
	{
		try
		{
			prop=new Properties();
			System.out.println("Super constructor invoked");
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"/Configuration/Config.properties");
			prop.load(ip);
			System.out.println("driver :"+ driver);
		}
		catch(FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
}
