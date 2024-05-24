LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2711a5d3f3f7dac3923e893f23bf6df3"

ROS_CN = "warehouse-ros-mongo"
ROS_BPN = "warehouse-ros-mongo"

ROS_BUILD_DEPENDS = " \
    class-loader \
    mongodb \
    mongo-cxx-driver-legacy \
    rclcpp \
    rclpy \
    rosidl-adapter \
    rosidl-typesupport-c \
    std-msgs \
    warehouse-ros \
"
# rosidl-typesupport-cpp 
# rosidl-typesupport-c 
# rosidl-typesupport-fastrtps-c 
# rosidl-typesupport-fastrtps-cpp 
# rosidl-typesupport-interface 
# rosidl-typesupport-introspection-c 
# rosidl-typesupport-introspection-cpp 
# ament-index-cpp 
# ament-index-python 
#     ament-cmake-test
#     ament-cmake-python
#     boost
#     rclpy 
#    rosidl-typesupport-cpp
 
ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=ros2"
SRC_URI = "git://github.com/ros-planning/warehouse_ros_mongo.git;${ROS_BRANCH};protocol=https"
SRCREV = "55f7e9f8d1893abb566275f8dc609785684407e5"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}

do_install:append() {
    mv ${D}${includedir}/database_connection.h ${D}${includedir}/warehouse_ros_mongo/database_connection.h
    mv ${D}${includedir}/metadata.h ${D}${includedir}/warehouse_ros_mongo/metadata.h
    mv ${D}${includedir}/message_collection.h ${D}${includedir}/warehouse_ros_mongo/message_collection.h
    mv ${D}${includedir}/query_results.h ${D}${includedir}/warehouse_ros_mongo/query_results.h
}

FILES:${PN} = " \
    ${datadir}/warehouse_ros_mongo \
    ${libdir}/warehouse_ros_mongo \
    ${libdir}/libwarehouse_ros_mongo.so \
    ${includedir}/warehouse_ros_mongo \
    ${PYTHON_SITEPACKAGES_DIR}/warehouse_ros_mongo \
    ${PYTHON_SITEPACKAGES_DIR}/warehouse_ros_mongo-2.0.3-py3.10.egg-info \
"

FILES:${PN}-dev = "${includedir}/warehouse_ros_mongo"
