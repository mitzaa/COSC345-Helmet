![workflow badge](https://github.com/mitzaa/COSC345-Helmet/actions/workflows/gradle.yml/badge.svg)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/2981b8a37e00499fa7ccb5ddc87c7e5f)](https://www.codacy.com/gh/mitzaa/COSC345-Helmet/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=mitzaa/COSC345-Helmet&amp;utm_campaign=Badge_Grade)
[![codecov](https://codecov.io/gh/mitzaa/COSC345-Helmet/branch/main/graph/badge.svg?token=WH6JSPL0OA)](https://codecov.io/gh/mitzaa/COSC345-Helmet)

Beta Release: September 23rd, 2022
The Beta release of Culturle if finally here!
Here's some of the things we have been working on since the alpha:
- Increased the number of countries in-game to 90.
- Addressed and fixed over 100 compiler warnings in the Kotlin files. Remaining warnings are spelling or style issues.
- Responded to Codacy's suggestions: We went from 8% issues in our code to 3% by solving 7 of the 14 error-prone issues. Remaining error-prone issues are not
a serious detriment to our code as they are issues such as a line being too long or using the same string literal in the same line.
- New Look! We have changed up the UI and designed custom buttons
- Bug fixes (Daily mode not resetting at the right time, certain country images out of order, wrong sized images etc)
- Our early user-testing indiciated that users found the game challenging so we added a feature where the distance from the correct country to the country 
which you guessed is shown.
- Added daily standardisation between users so that everyone playing the game on any given day will be have the same country for that day.
- We used Android Studio's built-in CPU Time Profiler to anaylse what parts of our code are the least efficient. We found there didn't seem to be any major
bottlenecks at this stage but will continue monitoring as we continue through development.
![Time Profiling](https://user-images.githubusercontent.com/97869940/191952723-d800d4eb-0956-407b-a9bc-1d67c5873967.png)

Important things for us to work on at this stage:
- We haven't been able to get our Documentation to be hosted on GitHub pages
- CodeCov indicates we have 0% code coverage because our unit tests are failing. 
- We need to write more unit tests but it has been hard to see if they are working since our CI pipeline is failing.


Alpha Release: August 26th, 2022
The team at Helmet is excited to release our first functioning version of Culturle!
Culturle is written in Kotlin, for Android, and is designed to run optimally on a Pixel 4a API 33.
Our proposed questionaire for volunteer testers can be found in the file Questionaire.pdf.

In order to run and test Cultural on your own device: 
1) Download the repo 
2) In Android Studio open the file "app" (COSC345-Helmet/culturle/app)
3) Create a device in "Device Manager" within Android Studio, search for and choose "Pixel 4a API 33". 
4) Select the green hammer "Make Project" to build the app. 
5) The 'Run\Debug configuration' should resemble the image below. Run by pressing the green "Run app" button.

![image](https://user-images.githubusercontent.com/97869940/186905801-83cd22b8-167a-47d4-938f-d939cb58300d.png) 


Notes:
  SharedPreferences will be saved on the emulated device. The emulated device will need to be reset in order to reset the SharedPreferences for repeated testing.

Known issues to be addressed asap:
  Generating documentation has drastically lowered our code quality as measured by Codacy.
  Documentation had been generated but isn't hosted on a GitHub page yet.
  
  
  
