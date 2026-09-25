package test.accountsalesforce.userinterfaces;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
public class LoginPage {
    public static  final Target INPUT_USERNAME= Target.the("Input to enter username")
            .located(By.xpath("//div[@id='username_container']/input[@id='username']"));

    public static  final Target INPUT_PASSWORD= Target.the("Input to enter password")
            .located(By.xpath("//input[@id='password' and @type='password']"));

    public static  final Target BUTTON_LOGIN= Target.the("Button for login")
            .located(By.xpath("//input[@id='Login' and @type='submit']"));



}
