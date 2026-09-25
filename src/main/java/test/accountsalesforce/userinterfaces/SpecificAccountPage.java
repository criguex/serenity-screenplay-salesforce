package test.accountsalesforce.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SpecificAccountPage {
    public final static Target DASHBOARD_HORIZONTAL_BAR= Target.the("Horizontal bar of the dashboard")
            .located(By.xpath("//div[@class='slds-grid primaryFieldRow']"));

    public final static Target DASHBOARD_LETF_VERTCAL_BAR= Target.the("Vertical left bar of the dashboard")
            .located(By.xpath("//div[@class='record-layout-container']"));

    public final static Target DASHBOARD_MAIN_PANEL= Target.the("Dashboard of main panel")
            .located(By.xpath("//div[@class='slds-card-wrapper activityPanel']"));

    public final static Target TEXT_BUTTON_ABOUT= Target.the("Text of button 'About' ")
            .located(By.xpath("//h3[@data-target-reveals='sfdc:RecordField.Account.Name,sfdc:RecordField.Account.Website,sfdc:RecordField.Account.Type,sfdc:RecordField.Account.Description,sfdc:RecordField.Account.ParentId,sfdc:RecordField.Account.OwnerId']/button/span[2]"));

    public final static Target TEXT_SUCCESSFUL_CREATE= Target.the("Message of successful")
            .located(By.xpath("//div[@role='alertdialog']"));
}
