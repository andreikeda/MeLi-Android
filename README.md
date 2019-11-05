# Mercado Libre Android Version

This application was developed as technical test to ingress Mercado Libre. The application contains a fake Login Screen, a Search Screen and a Detail Screen.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. This project is not designed to be release on production.

### Prerequisites

What things you need to install the software and how to install them

* Android Studio (version 3.5.1)
* Gradle (version 5.4.1)
* JDK (version 1.8.0_121)

### Installing

After installing JDK and Android Studio, clone the project.

```
git clone https://github.com/andreikeda/MeLi-Android.git
```

Open Android Studio and select MeLi-Android project

## Running the tests

To execute Unit test, run the command below (Windows)
```
gradlew test
```

To execute Instrumented test, run the command below (Windows)
```
adb shell am instrument -w -r -e package com.example.meli -e debug false com.example.meli.test/androidx.test.runner.AndroidJUnitRunner
```

To execute Unit test, run the command below (Mac/Linux)
```
./gradlew test
```

To execute Instrumented test, run the command below (Mac/Linux)
```
./adb shell am instrument -w -r -e package com.example.meli -e debug false com.example.meli.test/androidx.test.runner.AndroidJUnitRunner
```

## Built With

* [Android Studio](https://developer.android.com/studio) - The IDE used
* [Gradle](https://developer.android.com/studio/build/gradle-tips) - Dependency Management
* [Ktlint](https://github.com/jlleitschuh/ktlint-gradle) - Used to adapt code style to Kotlin

## Authors

* **Andre Ikeda** - *Initial work* - [AndreIkeda](https://github.com/andreikeda)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
