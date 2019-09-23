**2019-offseason-code**

# 6238 FRC Software Install Instructions
Instructions to deploy and run code can be found below.
## FRC Visual Studio Code - Mac, Windows, Linux
- [https://wpilib.screenstepslive.com/s/currentCS/m/java/l/1027503-installing-c-and-java-development-tools-for-frc](https://wpilib.screenstepslive.com/s/currentCS/m/java/l/1027503-installing-c-and-java-development-tools-for-frc)
- Download latest version for your OS from [https://github.com/wpilibsuite/allwpilib/releases](https://github.com/wpilibsuite/allwpilib/releases)
- Necessary to write, build, and deploy code to robot

### Windows:
- Launch the installer, go through the screens it gives you:
- Choose to install for All Users or Current User
- Select “Download” to download a new copy of VSCode (FRC VSCode does not work with the standard versions from Microsoft)
- Select “Open Downloaded File” from window with checkboxes, select OfflineVsCodeFiles.zip
- Check all boxes in window (unless automatically unchecked)
- Desktop Icon for VSCode should have been created
### Mac/Linux:
- Download Visual Studio Code from [https://code.visualstudio.com](https://code.visualstudio.com) (if on Linux, use .deb)
- Double click on VSCode .zip or .deb file
- Mac: Drag Visual Studio Code app to /Applications folder (or wherever you want)
- Linux: Click “Install” in install window
- Open the WPILib_Mac-2019.X.X.tar.gz or WPILib_Linux-2019.X.X.tar.gz file downloaded from GitHub (double click)
- Drag contents to frc2019 folder in your home folder
- Open Terminal, type “cd frc2019/tools”, hit enter (don’t type the quotes)
- Type “ls”, hit enter, files in folder should be listed, including ToolsUpdater.py
- Type “python ToolsUpdater.py” on Mac, “python3 ToolsUpdater.py” on Linux, hit enter, should leave 1-2 lines of space
- Open Visual Studio Code
- Type Cmd + Shift + P, type “Install from VSIX” in window that pops up (command palette), select “Extensions: Install from VSIX…” command
- Find, select Cpp.vsix file in vsCodeExtensions folder in frc2019 folder
- Repeat previous 2 steps, select in this order:
    - JavaLang.vsix
    - JavaDeps.vsix
    - JavaDebug.vsix
    - WPILib.vsix
- VSCode should prompt to reload window to install extensions in bottom right after installing all 5 extensions, click “Reload Window” button. If the pop-up doesn’t show up, go to the extensions tab on VSCode’s sidebar (looks like 2 nested squares) and click “Reload Window” under any of the extensions.
- Click on red hexagon “W” logo in top left (WPILib command palette), search for & select “Set VS Code Java Home to FRC Home”

## Fork (Git Client, Optional) - Mac, Windows
- You can use a different git client if you prefer, as long as you know how to use it
- [https://git-scm.com](https://git-scm.com) (official git website) has basic git clients, lists of git GUI clients
- Download Fork from [https://git-fork.com](https://git-fork.com)
- Mac: Drag Fork app to /Applications folder (or wherever you want)
- Windows: Run ForkInstaller.exe
- Whatever git client & OS: clone [https://github.com/6238/2019-offseason-code.git](https://github.com/6238/2019-offseason-code.git) and [https://github.com/6238/2019-robot-new.git](https://github.com/6238/2019-robot-new.git) (https) or git<span>@</span>github.com:6238/2019-offseason-code.git and git<span>@</span>github.com:6238/2019-robot-code-new.git (ssh)
- If you don’t know or care about the differences between https and ssh, just go with https

## LabView - Windows Only
- [https://wpilib.screenstepslive.com/s/currentCS/m/labview/l/1027501-installing-labview-for-frc-2019-labview-only](https://wpilib.screenstepslive.com/s/currentCS/m/labview/l/1027501-installing-labview-for-frc-2019-labview-only)
- While LabView should be optional, the FRC Suite may not work without it, and it is highly recommended to download it
- Download from: [http://www.ni.com/download/labview-for-frc-18.0/7841/en/](http://www.ni.com/download/labview-for-frc-18.0/7841/en/)
- If previous version is still installed, uninstall all “National Instruments Software” from Control Panel (Uninstall or Change a Program)
- Download LabView installer (“NI_FRC2019.zip”), extract all
- Close all programs
- Run “autorun.exe” in extract folder
- Select “Install everything for LabView Development”
- Go through installer, uncheck box to search for important messages and updates
- Organization name is FRC Team 6238, leave serial number blank
- Accept all license agreements, follow all instructions given by installer
- Check “Run License Manager…”, we can give it a shot (ask Ishan for license key)
- Restart computer (the installer should give you a message)
- Ignore any NI update notifications unless directed by FRC

## FRC Suite - Windows Only
- [https://wpilib.screenstepslive.com/s/currentCS/m/labview/l/1027502-installing-the-frc-update-suite-all-languages](https://wpilib.screenstepslive.com/s/currentCS/m/labview/l/1027502-installing-the-frc-update-suite-all-languages)
- Contains Driver Station, necessary to control robot**
- Not necessary to deploy to robot
- Download from: [http://www.ni.com/download/first-robotics-software-2017/7904/en/](http://www.ni.com/download/first-robotics-software-2017/7904/en/)
- If previous versions not already uninstalled from LabView install, uninstall all “National Instruments Software” from Control Panel (Uninstall or Change a Program)
- Download FRC Suite installer, extract all
- Run “setup.exe” in extract folder
- Make sure all 4 components are being installed (If LabView not installed, ignore LabView Update)
- Uncheck box to search for important messages and updates
- Go through installer
- Organization name is FRC Team 6238, leave serial number blank
- Accept all license agreements, follow all instructions given by installer
- Check “Run License Manager…”, we can give it a shot (ask Ishan for license key)
- Ignore any NI update notifications unless directed by FRC

## CTRE Phoenix Libraries - Mac, Windows, Linux
- [https://github.com/CrossTheRoadElec/Phoenix-Releases/releases](https://github.com/CrossTheRoadElec/Phoenix-Releases/releases)

### Windows:
- Extract “CTRE Phoenix Framework vX.X.X.X.exe” and run
- Check all install boxes available
- Complete installation

### Mac/Linux:
- Unzip “CTRE_Phoenix_FRC_nonWindows_X.X.X.zip”
- Drag “vendordeps” folder from unzipped folder to ~/frc2019
- Drag “ctre” folder from maven/com (inside unzipped folder) to ~/frc2019/maven/com
- Open VSCode
- In command palette (Cmd + Shift + P) type/select “WPILib: Manage Vendor Libraries”
- Select “Install new libraries (offline)”, check box next to “CTRE-Phoenix”, click “OK”
- Click “Yes” in “Recommended to run a Build” window

## Radio Configuration Utility - Windows Only
- [https://wpilib.screenstepslive.com/s/4485/m/13503/l/144986-programming-your-radio-for-home-use](https://wpilib.screenstepslive.com/s/4485/m/13503/l/144986-programming-your-radio-for-home-use)
- Download From: [https://firstfrc.blob.core.windows.net/frc2019/Radio/FRC_Radio_Configuration\_19\_1_1.zip](https://firstfrc.blob.core.windows.net/frc2019/Radio/FRC_Radio_Configuration_19_1_1.zip)
- Extract exe installer from zip, follow installation instructions
- Instructions on using configuration utility & configuring radios at screenstepslive website above
- Make sure to check with Ishan before configuring a radio

# Testing Code
## Build and Deploy (Mac, Windows, Linux)
- Open the project in FRC VS Code
- Ensure that the current computer is connected to the robot, either by a USB A to B cable, an Ethernet cable, or by Wi-Fi using a robot radio
- The RoboRIO must be powered on, the rest of the robot doesn't matter at this point
- Open the command palette (Cmd/Ctrl + Shift + P or click the red "W" hexagon at the top right)
- Find the "Build Robot Code" option and click it
- If there are no buildtime errors, the code should compile completely and the Terminal will inform you that the task is completed
- Open the command palette again and find/click "Deploy Robot Code" (Shortcut: Shift + F5)
- If the robot is connected properly, the code will deploy to the robot without any errors

## Operate the Robot (Windows only)
### Starting the robot
- Launch the FRC Driver Station
- Ensure that under the settings tab on the left side, the team number is set to 6238, and the Dashboard Type is set to Shuffleboard
- Ensure that the joystick and robot are both connected
- Ensure that the RoboRIO and any necessary electronics are powered on, and properly wired and connected
- Ensure that the current robot mode is set to Teleoperated (Top left of Driver Station)
- The middle of the driver station should say "Teleoperated Disabled" or "No Robot Code"
- If "Teleoperated Disabled", the robot is functioning properly
- If "No Robot Code", follow the previous instructions to build and deploy code to the robot. It may take a few moments for the robot to recognize that code has been deployed
- If "No Robot Communication", check again that the RoboRIO is powered on and properly connected to the Driver Station computer
- If "Emergency Shutoff", power cycle the robot
- If any other message is displayed, look it up or talk to someone who might know
- Above the message, there should be three green or red boxes with labels, all three should be green
### Drive/Control the robot
- Make sure the robot's surroundings are clear and everyone in the workspace knows you are about to run the robot
- Click enable at the bottom left of the Driver Station window
- The robot should now be controllable by the joystick and the Dashboard
- Any error messages, warnings, or print statements will appear in the console on the right side of the Driver Station
    - By default, only error messages show up. To enable warnings and prints, click on the settings gear at the top left of the console box
    - Clicking on the settings gear will also give the option to "Show Console" which presents a larger console window and "Show Log File" which shows a graph of all the diagnostics data from the robot, including network, CPU, power, and operation mode
    - Log data can also be found in the Charts tab on the right edge of the Driver Station window
### Disable the robot
- Click disable in the bottom left (next to enable)
- **Any code in robotPeriodic() will continue to run even when the robot is disabled**
