## Project characteristics

This project brings to table set of best practices, tools, and solutions:

* 100% Kotlin
* Model-View-View Model Architecture
* Android Jetpack
* Dependency Injection
* Material design
* Android Jetpack Compose
* Room local persistence
* Image caching

## Tech-stack

This project takes advantage of many popular libraries and tools of the Android ecosystem. Most of
the libraries are in the stable version.

* Tech-stack
    * [Kotlin](https://kotlinlang.org/)
        + [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - perform
          background operations
    * [Dagger Hilt](https://dagger.dev/hilt/) - dependency injection
    * [Jetpack](https://developer.android.com/jetpack)
        * [Flow](https://developer.android.com/kotlin/flow) - notify views about API response
        * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) -
          perform action when lifecycle state changes
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store
          and manage UI-related data in a lifecycle conscious way
    * [Room](https://developer.android.com/training/data-storage/room) - Persist Movie information
      on device for offline capabilities
    * [Landscapist](https://github.com/skydoves/landscapist) - Load and cache images for offline
      capabilities
* Architecture
    * [MVVM](https://developer.android.com/jetpack/guide?gclid=CjwKCAiAvaGRBhBlEiwAiY-yMLJgFw8dtzM8r78wKMlnykKhTDwh5vx4ZOGqGBbXQ8PEFlYsS_b_oBoCRGoQAvD_BwE&gclsrc=aw.ds)
        - Makes it easier to write modular, reusable and easy to test code
    * [Android Architecture components](https://developer.android.com/topic/libraries/architecture)
    * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)

## Getting started

There are a few ways to open this project.

### Android Studio

1. Android Studio -> File -> New -> From Version control -> Git
2. Enter `git@github.com:paulodhiambo/Gmovies.git` into URL field

### Command line + Android Studio

1. Run `git@github.com:paulodhiambo/Gmovies.git`
2. Android Studio -> File -> Open

### features to be completed

1. Movie search functionality
2. Movie filter functionality

### Application screenshots

Home Screen             |  Detail Screen
:-------------------------:|:-------------------------:
![Home screen image](screenshots/home.png)  |  ![Detail screen image](screenshots/detail.png)

### Build status
[![Build status](https://build.appcenter.ms/v0.1/apps/36c279f3-a606-49d8-863e-431cc1cc9a15/branches/master/badge)](https://appcenter.ms)

## License

 ```
 MIT License
 
 Copyright (c) 2022 Paul Odhiambo
 
 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and 
 associated documentation files (the "Software"), to deal in the Software without restriction, including 
 without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
 copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to 
 the following conditions:
 
 The above copyright notice and this permission notice shall be included in all copies or substantial 
 portions of the Software.
 
 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
 LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN 
 NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
 WHETHER IN AN ACTION OF  TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE 
 SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ```
