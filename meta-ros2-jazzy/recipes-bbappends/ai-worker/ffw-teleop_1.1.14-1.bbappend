# python3-tkinter is not required at build time
# we must remove the dependency as tk cannot be enabled in python3-native
ROS_BUILD_DEPENDS:remove = "python3-tkinter"
ROS_EXPORT_DEPENDS:remove = "python3-tkinter"
