# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE
LICENSE = "Unknown"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2711a5d3f3f7dac3923e893f23bf6df3"

SRC_URI = "git://github.com/ros-planning/warehouse_ros_mongo.git;protocol=https;branch=ros2"

# Modify these as desired
PV = "2.0.3+git${SRCPV}"
SRCREV = "55f7e9f8d1893abb566275f8dc609785684407e5"

S = "${WORKDIR}/git"

# NOTE: unable to map the following CMake package dependencies: MONGODB rclcpp ament_lint_auto std_msgs warehouse_ros class_loader launch_testing_ament_cmake rclpy ament_cmake_gtest ament_cmake_python ament_cmake
DEPENDS = "boost"

inherit cmake

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""

