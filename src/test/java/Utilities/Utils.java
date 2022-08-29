package Utilities;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    private String amount;
    private String interest;
    private String period;
    private String processingFee;
    private String monthlyEmi;
    private String totalInterest;
    private String totalProcessingFee;
    private String totalPayment;


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(String processingFee) {
        this.processingFee = processingFee;
    }

    public String getMonthlyEmi() {
        return monthlyEmi;
    }

    public void setMonthlyEmi(String monthlyEmi) {
        this.monthlyEmi = monthlyEmi;
    }

    public String getTotalInterest() {
        return totalInterest;
    }

    public void setTotalInterest(String totalInterest) {
        this.totalInterest = totalInterest;
    }

    public String getTotalProcessingFee() {
        return totalProcessingFee;
    }

    public void setTotalProcessingFee(String totalProcessingFee) {
        this.totalProcessingFee = totalProcessingFee;
    }

    public String getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(String totalPayment) {
        this.totalPayment = totalPayment;
    }
    public void writeUserInfo() throws IOException, ParseException {
        String fileName="./src/test/resources/userDataset.json";
        JSONParser jsonParser=new JSONParser();
        Object obj=jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray=(JSONArray) obj;
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("Amount",this.getAmount());
        jsonObject.put("Interest",this.getInterest());
        jsonObject.put("Period:",this.getPeriod());
        jsonObject.put("Processing Fee",this.getProcessingFee());
        jsonObject.put("Monthly EMI",this.getMonthlyEmi());
        jsonObject.put("Total Interest",this.getTotalInterest());
        jsonObject.put("Total Processing Fee",this.getTotalProcessingFee());
        jsonObject.put("Total Payment",this.getTotalPayment());
        jsonArray.add(jsonObject);
        FileWriter file=new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();
        System.out.println("Saved!");
        System.out.println(jsonArray);

    }




}
