package test.accountsalesforce.userinterfaces;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
public class HomePage {
    public final static Target BUTTON_ACCOUNTS = Target.the("Button of accounts functionality")
            .located(By.xpath("//ul[@class='verticalNavMenuList slds-text-align_center slds-text-color_inverse slds-p-left_x-small slds-p-right_x-small']/li[3]/runtime_sales_easy-vertical-nav-app-item"));
    public final static Target BUTTON_HOME = Target.the("Button of home functionality")
            .located(By.xpath("//ul[@class='verticalNavMenuList slds-text-align_center slds-text-color_inverse slds-p-left_x-small slds-p-right_x-small']/li[1]/runtime_sales_easy-vertical-nav-app-item"));
}
