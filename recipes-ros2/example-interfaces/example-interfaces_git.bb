SUMMARY = "Contains message and service definitions used by the examples."
HOMEPAGE = "https://github.com/ros2/example_interfaces"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"
DEPENDS = " \
    rosidl-default-generators \
    rosidl-cmake \
    rosidl-parser \
    rosidl-generator-c \
    rosidl-generator-cpp \
    rosidl-generator-py \
    rmw-implementation-cmake \
    rmw \
    rmw-fastrtps-cpp \
    rosidl-typesupport-c \
    rosidl-typesupport-cpp \
    python-cmake-module \
"

SRCREV = "b9f9477cd7f368e61f81d55c5021f4c70ad1fe12"
SRC_URI = "git://github.com/ros2/example_interfaces.git;protocol=git;"

inherit ament pythonpath-insane

S = "${WORKDIR}/git"

FILES_${PN} += "${datadir}/${ROS_BPN}/mapping_rules.yaml"
