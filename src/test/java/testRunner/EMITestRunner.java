package testRunner;

import Base.Setup;
import Screeens.EMIPageScreen;
import Utilities.Dataset;
import Utilities.Utils;
import io.qameta.allure.Allure;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.math.BigDecimal;

public class EMITestRunner extends Setup {
    EMIPageScreen emiPageScreen;

    @BeforeTest
    public void emiCalculatorClick() throws InterruptedException {
        emiPageScreen = new EMIPageScreen(driver);
        emiPageScreen.btnEmiCalc.click();
        Thread.sleep(1000);
    }

    @Test(priority = 1, description = "Clicking on Calculate button without giving any data")
    public void emptyFields() throws InterruptedException {
        emiPageScreen = new EMIPageScreen(driver);
        boolean warningAlert = emiPageScreen.emptyFields();
        Assert.assertTrue(warningAlert);
        Assert.assertTrue(emiPageScreen.msgWarning.getText().contains("fill all the info"));
        emiPageScreen.btnOk.click();
        Thread.sleep(1000);
        Allure.description("If the user provides no data in the input boxes and press on Calculate " +
                "an warning box will appear which will prompt the user to fill all the information");
    }

    @Test(priority = 2, dataProvider = "data-provider-emi", dataProviderClass = Dataset.class, description = "Verified whether the emi and other fields are calculated according to the dataset or not.")
    public void emiCalculation(double amount, double interest, int period, double processingFee, double monthlyEmi, double totalInterest, int totalProcessingFee, double totalPayment) throws InterruptedException, IOException, ParseException {
        emiPageScreen = new EMIPageScreen(driver);
        Utils utils=new Utils();
        emiPageScreen.emiCalculation(amount, interest, period, processingFee);
        String mEmi = emiPageScreen.monthlyEmiResult.getText();
        String tInterest = emiPageScreen.totalInterestResult.getText();
        String pFee = emiPageScreen.processingFeeResult.getText();
        String tPayment = emiPageScreen.totalPaymentResult.getText();
        System.out.println(mEmi);
        System.out.println(tInterest);
        System.out.println(pFee);
        System.out.println(tPayment);
//        Assert.assertEquals(Double.parseDouble(mEmi.replace(",", "")),monthlyEmi );
        org.junit.Assert.assertEquals(mEmi.replaceAll(",", ""),Double.toString(monthlyEmi));
        //done as very large data cannot be handled by double datatype that's why converted to BigDecimal.
        if(Double.toString(totalInterest).length()<11){
            org.junit.Assert.assertEquals(tInterest.replaceAll(",",""),Double.toString(totalInterest));
        }
        else{
            org.junit.Assert.assertEquals(tInterest.replaceAll(",",""),BigDecimal.valueOf(totalInterest).toString());
        }
        org.junit.Assert.assertEquals(pFee.replaceAll(",", ""),Integer.toString(totalProcessingFee));
        if(Double.toString(totalPayment).length()<11){
            org.junit.Assert.assertEquals(tPayment.replaceAll(",", ""),Double.toString(totalPayment));
        }
        else{
            org.junit.Assert.assertEquals(tPayment.replaceAll(",", ""),BigDecimal.valueOf(totalPayment).toString());
        }
        Allure.description("After giving all the inputs correctly,it will be checked whether " +
                "all inputs matches with the expected data of the dataset and the actual result or not");
        emiPageScreen.btnReset.click();
        utils.setAmount(Double.toString(amount));
        utils.setInterest(Double.toString(interest));
        utils.setPeriod(Integer.toString(period));
        utils.setProcessingFee(Double.toString(processingFee));
        utils.setMonthlyEmi(mEmi);
        utils.setTotalInterest(tInterest);
        utils.setTotalProcessingFee(pFee);
        utils.setTotalPayment(tPayment);
        utils.writeUserInfo();
    }
}
