import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import static java.lang.Thread.sleep;

public class firstTest {
    public static void main(String[] args) throws InterruptedException {
            String email="Your Email or phone, that you used to create Facebook account.";
            String password= "Your facebook pass";
            System.setProperty("webdriver.chrome.driver", "Path to your chrome driver you downloaded");
            System.out.println("System Property set                                    : ✓");
            WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("\"disable-infobars\""));
            System.out.println("Started Chrome                                         : ✓");
            driver.get("http://facebook.com/login/");
            System.out.println("Start the login Page for facebook                      : ✓");
            driver.manage().window().maximize();
            System.out.println("Set page size                                          : ✓");
            sleep(2000);//We are throwing exception
            System.out.println("Page rendered                                          : ✓");
            driver.findElement(By.name("email")).sendKeys(email);
            driver.findElement(By.name("pass")).sendKeys(password);
            System.out.println("Fill Email and Password                                : ✓");
            driver.findElement(By.id("loginbutton")).click();//login
            System.out.println("Login Button Clicked                                   : ✓");
            sleep(15000);
            System.out.println("Wait till login                                        : ✓");
            sleep(20000);
            driver.findElement(By.xpath("//a[contains(@href,'/me/')]")).click();//my profile
            System.out.println("My profile clicked                                     : ✓");
            sleep(5000);
            driver.findElements(By.xpath("//a[@role = 'tab']")).get(2).click();//friends
            System.out.println("All friends clicked                                    : ✓");
            sleep(4000);
            List<WebElement> images = driver.findElements(By.xpath("//img[@height = 80]"));//create a list of images of friends
            System.out.println("List of images created with their common size 80       : ✓");
            sleep(2000);
            int myImageNumber = 0;
            while (myImageNumber < 5) {//do same for 5
                try {
                    System.out.println("Started saving image number " + myImageNumber+ "                 : ✓");
                    String imgSRC = images.get(myImageNumber).getAttribute("src");//get image src
                    System.out.println("Got the first image source                    : ✓");
                    URL imageURL = new URL(imgSRC);//make url
                    System.out.println("Created URL by the source of the image        : ✓");
                    BufferedImage saveImage = ImageIO.read(imageURL);//make buffer
                    System.out.println("Created image buffer by the URL of the image  : ✓");
                    ImageIO.write(saveImage, "jpg", new File("FacebookFreiend" + (myImageNumber+1) + ".jpg"));//save
                    System.out.println("Saving image to my current working directory  : ✓");
                    try {
                        sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Image number "+myImageNumber +" successfully saved             : ✓\n\n");

                } catch (IOException e) {
                    e.printStackTrace();
                }
                myImageNumber++;//increment the counter
            }

    }

}

/*
* First created set the property of the system to find the web driver which is chrome driver
* Then Started a new Chrome driver with some personal options added
* Then went to the facebook login page
* Then I entered my credentials(email and password) then logged in
* Then went to my profile page
* In that I went to my friends list
* I made a list of images of friends profile
* Then I looped 5 times
*   First got the image source
*   Then made an URL with the source
*   Then Made a buffer for storage
*   Then saved the image
*/