**2019-offseason-code**

# 6238 FRC Instructions
## FRC Visual Studio Code - Mac, PC, Linux
- [https://wpilib.screenstepslive.com/s/currentCS/m/java/l/1027503-installing-c-and-java-development-tools-for-frc](https://wpilib.screenstepslive.com/s/currentCS/m/java/l/1027503-installing-c-and-java-development-tools-for-frc)
- Download latest version for your OS from [https://github.com/wpilibsuite/allwpilib/releases](https://github.com/wpilibsuite/allwpilib/releases)
- Necessary to deploy code to robot

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

## Fork (Git Client, Optional) - Mac, PC
- You can use a different git client if you prefer, as long as you know how to use it
- [https://git-scm.com](https://git-scm.com) (official git website) has basic git clients, lists of git GUI clients
- Download Fork from [https://git-fork.com](https://git-fork.com)
- Mac: Drag Fork app to /Applications folder (or wherever you want)
- Windows: Run ForkInstaller.exe
- Whatever git client & OS: clone [https://github.com/6238/2019-offseason-code.git](https://github.com/6238/2019-offseason-code.git) and [https://github.com/6238/2019-robot-new.git](https://github.com/6238/2019-robot-new.git) (https) or git\@github\.com:6238/2019-offseason-code.git and git\@github\.com:6238/2019-robot-code-new.git (ssh)
- If you don’t know or care about the differences between https and ssh, just go with https

## LabView - PC Only
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

## FRC Suite - PC Only
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

## CTRE Phoenix Libraries - Mac, PC, Linux
- [https://github.com/CrossTheRoadElec/Phoenix-Releases/releases](https://github.com/CrossTheRoadElec/Phoenix-Releases/releases)

### Windows:
- Extract “CTRE Phoenix Framework vX.X.X.X.exe” and run
- Check all install boxes available
- Complete installation

###Mac/Linux:
- Unzip “CTRE_Phoenix_FRC_nonWindows_X.X.X.zip”
- Drag “vendordeps” folder from unzipped folder to ~/frc2019
- Drag “ctre” folder from maven/com (inside unzipped folder) to ~/frc2019/maven/com
- Open VSCode
- In command palette (Cmd + Shift + P) type/select “WPILib: Manage Vendor Libraries”
- Select “Install new libraries (offline)”, check box next to “CTRE-Phoenix”, click “OK”
- Click “Yes” in “Recommended to run a Build” window

##Radio Configuration Utility - PC Only
- [https://wpilib.screenstepslive.com/s/4485/m/13503/l/144986-programming-your-radio-for-home-use](https://wpilib.screenstepslive.com/s/4485/m/13503/l/144986-programming-your-radio-for-home-use)
- Download From: [https://firstfrc.blob.core.windows.net/frc2019/Radio/FRC_Radio_Configuration\_19\_1_1.zip](https://firstfrc.blob.core.windows.net/frc2019/Radio/FRC_Radio_Configuration_19_1_1.zip)
- Extract exe installer from zip, follow installation instructions
- Instructions on using configuration utility & configuring radios at screenstepslive website above
- Make sure to check with Ishan before configuring a radio
