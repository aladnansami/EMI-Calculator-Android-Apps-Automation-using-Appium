# EMI_Calculator_Appium
# APP
### [EMI calculator](https://play.google.com/store/apps/details?id=com.continuum.emi.calculator)

Here the following tasks are done:
- An EMI Calculator app extracted from https://apps.evozi.com/apk-downloader/  by extracting its apk.
- First , a negative test case is executed where user hits the calculate button without giving any data.
- Different data is tested where user gives Amount,Interest,Period and Processing fee and hits Calculate button.
- The monthly EMI,total interest ,processing fee and total payment generated are matched with the expected data provided in the dataset.
- Database testing is performed on a minor scale to check whether the system handles varieties of data to give correct result or not.
- It is tested for five different data and a reset button will be pressed after a test case with a single data is executed.
- JSON data will be stored for every user information.


## APK Downloader
https://apps.evozi.com/apk-downloader/

### Technology: </br>
- Tool: Selenium Webdriver
- Build tool: Gradle
- Test_Runner: Appium Application 

# Languages 
Java

# IDE
Intellij, Android Studio

### Project Run

#### Appium
- Turn on **Developer Options** on your android phone
- Connect your android phone with USB cable/ Create an emulated virtual device via Android Studio and run it.
- Open cmd and give ```adb devices``` command to get uuid.
- Open Appium and start server. Then open inspector tool.
- In the **JSON Representation** section, paste the following desired capabilities after adding your uuid and version:




