[![Version](https://img.shields.io/badge/version-1.0-green.svg)](https://img.shields.io/badge/version-1.1-green.svg) [![Build status](https://img.shields.io/badge/build-passing-green.svg)](https://img.shields.io/badge/build-passing-green.svg) [![Platform](https://img.shields.io/badge/platform-OS%20X%20%7C%20Windows-lightgrey.svg)](https://img.shields.io/badge/platform-OS%20X%20%7C%20Windows-lightgrey.svg)


# Space Rocket 🚀

Java project realized in IMAC Engineering School, in April and May 2016. It works on Eclipse with Processing.

**Supported OS :**

- Mac OSX
- Windows

## Set up Space-Rocket

#### Clone the project

	git clone https://github.com/Arctic76/Space-Rocket.git

#### Create a Eclipse project

- Open Eclipse
- **Create** a new Java Project
- Do not use default location and **browse** the git project Space-Rocket
- Click on Next and **verify** if all library files have been imported
- Finish

#### Add libraries

If some librairies are not detected, you have to add the JAR files to each of them.

- In Eclipse, go to *Project* > *Properties*
- Go to the subcategory *Java Build Path*
- Go to the tab Libraries
- Click on *Add JARs*
- Go to *Space-Rocket/lib/*
- Add JAR file for each library (for LeapMotion and Processing libs, select your good OS folder)
- **Apply** and click OK

#### Check the Native Location for LeapMotion lib

- In Eclipse, go to *Project* > *Properties*
- Go to the subcategory *Java Build Path*
- Go to the tab *Libraries*
- **Check** if there is no error. If there are errors:
    - Check if the file `LeapJava.jar` is detected
    - Check if the file `LeapJava.jar` is located to the good leapmotion lib OS folder
    - Check if `Native location library` is configurated with the good leapmotion lib OS folder
    
- **Apply** and click OK


#### Play

- **Connect** your MIDI controller and your Leap Motion
- **Run** the project on Eclipse
- **Have fun**

## How to play

#### Select a level

Use your **UP** and **DOWN** keys of your keyboard to choose you level. **Enter** to select it.

#### Control my rocket

Use your **LeapMotion** or your **directionnal keys** of your keyboard.

#### Active a bonus

Use the **pads** number 1, 2, 3, 9 and 10 to active the bonus that you want. You can also use the **keys** 1, 2, 3, 4 and 5 of your keyboard. 

#### Display or hide the menu

You can use the **pad** number 11 to display/hide the menu, but you can also use the **key** "A" of your keyboard.

	
## Prior installation

You have to download [Eclipse](https://www.eclipse.org/downloads/) and buy a [Leap Motion](https://www.leapmotion.com/) and a [MIDI Controller](https://www.arturia.com/products/hybrid-synths/beatstep). If you don't have neither LeapMotion nor MIDI Controller, you can play with your keyboard. 😎

