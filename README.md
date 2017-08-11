## Java-TestNG-Appium-Android-Dynamic

>This code is presented as an example only, since your tests and testing environments may require specialized scripting. This information should be taken only as an
>illustration of how one would set up tests with Sauce Labs, and any modifications will not be supported. For questions regarding Sauce Labs integration, please see
>our documentation at https://wiki.saucelabs.com/.

### Environment Setup

1. Global Dependencies
    * Install Maven
    	https://maven.apache.org/install.html
    * Or Install Maven with Homebrew
    	http://brew.sh/
    ```
    $ brew install maven
    ```
    * Install gradle
        https://gradle.org/install/
    * Or Install gradle with Homebrew
        http://brew.sh/
    ```
    $ brew install gradle
    ```

2. TestObject Credentials and Appium Endpoint
    * Export your API key to authenticate to TestObject
    ```
    $ export TESTOBJECT_API_KEY=<your_api_key>
    ```
    * Export the TestObject Appium endpoint of your choosing
    ```
    $ export APPIUM_URL=<your_api_key>
    ```

3. TestObject Devices
    * Ensure that your account has access to the devices below. If not, adjust accordingly
    ```
    {"LG_Nexus_5X_free"}, {"Motorola_Moto_E_2nd_gen_free"}, {"Google_Pixel_real"}
    ```

4. Project Dependencies
    * Check your dependencies
    ```
    $ gradle dependencies
    ```

5. Application
    * Application can be downloaded by clicking [here](https://github.com/testobject/calculator-test-gradle/blob/master/Calculator_2.0.apk)

### Running Tests
```
$ gradle clean test
```

### Advice/Troubleshooting
1. It may be useful to use a Java IDE such as IntelliJ or Eclipse to help troubleshoot potential issues.

### Resources
##### [TestObject REST API Documentation](https://api.testobject.com/)

##### [Sauce Labs Documentation](https://wiki.saucelabs.com/)

##### [JUnit Documentation](http://junit.org/junit4/)

##### [Java Documentation](https://docs.oracle.com/javase/8/docs/api/)

##### [Stack Overflow](http://stackoverflow.com/)
* A great resource to search for issues not explicitly covered by documentation.
