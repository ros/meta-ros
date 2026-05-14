# Enable Qt GUI module in qtbase-native for ROS rqt support.
# The sip bindings generator requires the GUI module during
# cross-compilation of python-qt-binding and qt-gui-cpp.
PACKAGECONFIG:append = " gui"
