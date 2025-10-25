# It is unclear why this fix is needed for Space ROS
# and has not been an issue with ROS 2 Jazzy

# ModuleNotFoundError: No module named 'ament_package'
ROS_BUILDTOOL_DEPENDS += "\
    ament-package-native\
    python3-catkin-pkg-native\
"
