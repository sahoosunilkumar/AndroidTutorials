# UT-RoboElectric-And-Jacoco
Unit Testing using Roboelectric and reporting using Jacoco

Jacoco = It provides code coverage report

step-1 : Add testCoverageEnabled = true in build.gradle of application under debug buildtypes

step-2 : Add apply plugin: 'jacoco'

step-3 : Add classpath 'org.jacoco:org.jacoco.core:0.7.5.+' under dependency in Module level build.gradle

step-4 : Add task under allprojects in Module level build.gradle

step-5 : Run following command in gradle terminal to build to generate testDebugUnitTest.exec

./gradlew build

step-6 : Run following command in gradle terminal to create code coverage

./gradlew jacocoTestReportDebug


