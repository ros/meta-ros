# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Example usage of a parameter header generated in another package."
AUTHOR = "Paul Gesel <paul.gesel@picknik.ai>"
ROS_AUTHOR = "Auguste Bourgois <auguste@forssea-robotics.fr>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=4633480cdd27d7906aaf3ef4b72014b2"

ROS_CN = "generate_parameter_library"
ROS_BPN = "generate_parameter_library_example_external"

ROS_BUILD_DEPENDS = " \
    generate-parameter-library-example \
    rclcpp \
    rclcpp-components \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    generate-parameter-library-example \
    rclcpp \
    rclcpp-components \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = " \
    ament-cmake-core-native \
"

ROS_EXEC_DEPENDS = " \
    generate-parameter-library-example \
    rclcpp \
    rclcpp-components \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/generate_parameter_library-release/archive/release/rolling/generate_parameter_library_example_external/0.4.0-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/generate_parameter_library_example_external"
SRC_URI = "git://github.com/ros2-gbp/generate_parameter_library-release;${ROS_BRANCH};protocol=https"
SRCREV = "310de35b1bcad540e8ca46573626d410872c02ec"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}