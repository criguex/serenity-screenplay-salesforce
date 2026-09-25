package test.accountsalesforce.userinterfaces;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
public class AccountPage {
    public final static Target BUTTON_NEW_ACCOUNT= Target.the("Button for create new account")
            .located(By.xpath("//ul/li[@data-target-selection-name='sfdc:StandardButton.Account.New']/a"));

    public final static Target BUTTON_OPTIONS_ACCOUNT= Target.the("Button for options of created account")
            .located(By.xpath("//td[@role='gridcell']/span/div/a"));

    public final static Target BUTTON_EDIT_ACCOUNT= Target.the("Button for edit created account")
            .located(By.xpath("//a[@data-target-selection-name='sfdc:StandardButton.Account.Edit']"));

    public final static Target TEXT_NAME_ACCOUNT_EDITED= Target.the("Text for name account edited")
            .located(By.xpath("//a[contains(text(), 'Test edit')]"));

    public final static Target INPUT_NAME= Target.the("Input to enter name new account")
            .located(By.xpath("//input[@name='Name']"));

    public final static Target INPUT_WEBSITE = Target.the("Input to enter name web site")
            .located(By.xpath("//input[@name='Website']"));

    public final static Target INPUT_DESCRIPTION= Target.the("Input to enter description")
            .located(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.Account.Description']/span/slot/records-record-layout-text-area/lightning-textarea/div/textarea"));

    public final static Target INPUT_PHONE= Target.the("Input to enter phone number")
            .located(By.xpath("//input[@name='Phone']"));

    public final static Target INPUT_BILLING_ADDRESS_STREET= Target.the("Input to enter billing address")
            .located(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.Account.BillingAddress']/span/slot/records-record-layout-input-address/lightning-input-address/fieldset/div/div/div/lightning-textarea/div/textarea"));

    public final static Target BUTTON_LIST_TYPE_ROLE= Target.the("Button type of role")
            .located(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.Account.Type']/span/slot/records-record-picklist/records-form-picklist/lightning-picklist/lightning-combobox/div/div/lightning-base-combobox/div/div/div/button"));

    public final static Target BUTTON_SELECT_TYPE_ROLE= Target.the("Select of roles in list")
            .located(By.xpath("//div[@aria-label='Tipo']/lightning-base-combobox-item/span/span"));

    public final static Target INPUT_BILLING_CITY= Target.the("Input to enter billing City")
            .located(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.Account.BillingAddress']/span/slot/records-record-layout-input-address/lightning-input-address/fieldset/div/div/div/lightning-input/lightning-primitive-input-simple/div/div/input[@name='city']"));

    public final static Target INPUT_BILLING_PROVINCE= Target.the("Input to billing province")
            .located(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.Account.BillingAddress']/span/slot/records-record-layout-input-address/lightning-input-address/fieldset/div/div/div/lightning-input/lightning-primitive-input-simple/div/div/input[@name='province']"));

    public final static Target INPUT_BILLING_POSTALCODE= Target.the("Input to billing podtal code")
            .located(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.Account.BillingAddress']/span/slot/records-record-layout-input-address/lightning-input-address/fieldset/div/div/div/lightning-input/lightning-primitive-input-simple/div/div/input[@name='postalCode']"));

    public final static Target INPUT_BULLING_COUNTRY= Target.the("Input to billing contry")
            .located(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.Account.BillingAddress']/span/slot/records-record-layout-input-address/lightning-input-address/fieldset/div/div/div/lightning-input/lightning-primitive-input-simple/div/div/input[@name='country']"));

    public final static Target INPUT_SHIPPING_ADDRESS= Target.the("Input to shipping address")
            .located(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.Account.ShippingAddress']/span/slot/records-record-layout-input-address/lightning-input-address/fieldset/div/div/div/lightning-textarea/div/textarea"));

    public final static Target INPUT_SHIPPING_CITY= Target.the("Input to shipping City")
            .located(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.Account.ShippingAddress']/span/slot/records-record-layout-input-address/lightning-input-address/fieldset/div/div/div/lightning-input/lightning-primitive-input-simple/div/div/input[@name='city']"));

    public final static Target INPUT_SHIPPING_PROVINCE= Target.the("Input to shipping province")
            .located(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.Account.ShippingAddress']/span/slot/records-record-layout-input-address/lightning-input-address/fieldset/div/div/div/lightning-input/lightning-primitive-input-simple/div/div/input[@name='province']"));

    public final static Target INPUT_SHIPPING_POSTALCODE= Target.the("Input to shipping podtal code")
            .located(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.Account.ShippingAddress']/span/slot/records-record-layout-input-address/lightning-input-address/fieldset/div/div/div/lightning-input/lightning-primitive-input-simple/div/div/input[@name='postalCode']"));

    public final static Target INPUT_SHIPPING_COUNTRY= Target.the("Input to shipping contry")
            .located(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.Account.ShippingAddress']/span/slot/records-record-layout-input-address/lightning-input-address/fieldset/div/div/div/lightning-input/lightning-primitive-input-simple/div/div/input[@name='country']"));

    public final static Target BUTTON_SAVE_ACCOUNT= Target.the("Button to save info")
            .located(By.xpath("//button[@name='SaveEdit']"));

    public final static Target TEXT_SUCCESSFUL_EDIT= Target.the("Message of successful")
            .located(By.xpath("//div[@role='alertdialog']"));

}
