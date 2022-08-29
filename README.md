# EMI_Calculator_Appium
### An [EMI calculator](https://play.google.com/store/apps/details?id=com.continuum.emi.calculator) is automated by testing with varities of datasets and whether it gives correct results with correct data.Appium is utilized on an emulated device powered by Android Studio.
Here the following tasks are done:
- An EMI Calculator app extracted from [EMI calculator](https://play.google.com/store/apps/details?id=com.continuum.emi.calculator) is automated by extracting its apk.
- First , a negative test case is executed where user hits the calculate button without giving any data.
- Different data is tested where user gives Amount,Interest,Period and Processing fee and hits Calculate button.
- The monthly EMI,total interest ,processing fee and total payment generated are matched with the expected data provided in the dataset.
- Database testing is performed on a minor scale to check whether the system handles varieties of data to give correct result or not.
- It is tested for five different data and a reset button will be pressed after a test case with a single data is executed.
- JSON data will be stored for every user information.

### Technology: </br>
- Tool: Selenium Webdriver
- IDE: Intellij, Android Studio
- Build tool: Gradle
- Language: Java
- Test_Runner: Appium

### Prerequisites</br>
- Install Android Studio latest version
- Install Appium 1.17.1
- Install jdk 8 or any LTS version
- Configure **ANDROID_HOME**, **JAVA_HOME** and **GRADLE_HOME**
- Stable internet connection

### Project Run

#### Appium
- Turn on **Developer Options** on your android phone
- Connect your android phone with USB cable/ Create an emulated virtual device via Android Studio and run it.
- Open cmd and give ```adb devices``` command to get uuid.
- Open Appium and start server. Then open inspector tool.
- In the **JSON Representation** section, paste the following desired capabilities after adding your uuid and version:

```
  "deviceName": "My Device",
  "platformName": "Android",
  "uuid": Enter your uuid here,
  "platformVersion": Enter your android version,
  "appPackage": "com.continuum.emi.calculator",
  "appActivity": "com.finance.emicalci.activity.Splash_screnn"

```
- Click **Start Server**.

#### Java IDE

- Clone the repo.

#### Run the Automation Script by the following command:
 ```
 gradle clean test 
 ```
- The following report is generated:

![General report](https://user-images.githubusercontent.com/55280106/187047149-65194a11-82cf-4e13-9a8a-fdffe18de71b.png)

- After automation to view allure report , give the following commands:
 ```
allure generate allure-results --clean -o allure-report
allure serve allure-results
 ```
**Here is the Allure report overview:**

![Allure overview Report](https://user-images.githubusercontent.com/55280106/187047168-1415dcd1-f595-4539-b603-58fd45537bc1.png)

**Below the suites run are shown via Allure :**

![Allure suites report](https://user-images.githubusercontent.com/55280106/187047185-8e3573f4-9fd9-4f41-99c3-b0a988572f7c.png)

**Screenshot of the overall project run in appium**

![App inspection in appium](https://user-images.githubusercontent.com/55280106/187047271-6294584c-4dcf-4616-ad88-7ff3ee3dfb64.png)

- Watch the Project video and test run:

https://user-images.githubusercontent.com/55280106/187047459-e3c218e3-9ce0-4c6e-b057-f62267a66d38.mp4

