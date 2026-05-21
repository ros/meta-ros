ROS_BUILDTOOL_DEPENDS:append = " \
    rosidl-generator-cpp-native \
"

# Remove rmw-zenoh-cpp if zenoh-layer is not present
ROS_EXEC_DEPENDS:remove = "${@bb.utils.contains('BBFILE_COLLECTIONS', 'zenoh-layer', '', 'rmw-zenoh-cpp', d)}"
