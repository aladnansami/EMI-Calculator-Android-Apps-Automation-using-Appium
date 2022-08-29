package Screeens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EMIPageScreen {
    public static final String PACKAGE_ID="com.continuum.emi.calculator";
    @FindBy(id = PACKAGE_ID+":id/btnStart")
    public AndroidElement btnEmiCalc;
    @FindBy(id = PACKAGE_ID+":id/btnCompare")
    public AndroidElement btnCompareLoan;
    @FindBy(id = PACKAGE_ID+":id/etLoanAmount")
    public AndroidElement amountLoan;
    @FindBy(id = PACKAGE_ID+":id/etInterest")
    public AndroidElement interest;
    @FindBy(id =PACKAGE_ID+":id/etYears" )
    public AndroidElement years;
    @FindBy(id = PACKAGE_ID+":id/etMonths")
    public AndroidElement months;
    @FindBy(id = PACKAGE_ID+":id/etFee")
    public AndroidElement processingFee;
    @FindBy(id = PACKAGE_ID+":id/btnCalculate")
    public AndroidElement btnCalculate;
    @FindBy(id = PACKAGE_ID+":id/alertTitle")
    public AndroidElement warningAlert;
    @FindBy(id = "android:id/message")
    public AndroidElement msgWarning;
    @FindBy(id = "android:id/button2")
    public AndroidElement btnOk;
    @FindBy(id = PACKAGE_ID+":id/btnReset")
    public AndroidElement btnReset;
    @FindBy(id = PACKAGE_ID+":id/monthly_emi_result")
    public AndroidElement monthlyEmiResult;
    @FindBy(id = PACKAGE_ID+":id/total_interest_result")
    public AndroidElement totalInterestResult;
    @FindBy(id = PACKAGE_ID+":id/processing_fee_result")
    public AndroidElement processingFeeResult;
    @FindBy(id = PACKAGE_ID+":id/total_payment_result")
    public AndroidElement totalPaymentResult;

    public EMIPageScreen(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    public boolean emptyFields() throws InterruptedException {
        btnCalculate.click();
        Thread.sleep(1000);
        boolean warningSign=warningAlert.isDisplayed();
        return warningSign;
    }
    public void emiCalculation(double amount,double loanInterest,int period,double loanProcessingfee) throws InterruptedException {
        Thread.sleep(1000);
        amountLoan.sendKeys(String.valueOf(amount));
        Thread.sleep(1000);
        interest.sendKeys(String.valueOf(loanInterest));
        Thread.sleep(1000);
        years.sendKeys(String.valueOf(period));
        Thread.sleep(1000);
        processingFee.sendKeys(String.valueOf(loanProcessingfee));
        btnCalculate.click();
    }
}
