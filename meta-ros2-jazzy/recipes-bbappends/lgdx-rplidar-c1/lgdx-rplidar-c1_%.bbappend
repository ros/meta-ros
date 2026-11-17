# lgdx_rplidar_c1's package.xml lists rclcpp and rclcpp_components as
# buildtool_depend, which makes superflore generate rclcpp-native and
# rclcpp-components-native build tools (the latter drags in class-loader-native,
# which has no native variant). The package is an ordinary target program that
# links rclcpp, so depend on the target libraries instead.

ROS_BUILDTOOL_DEPENDS:remove = "rclcpp-components-native rclcpp-native"

ROS_BUILD_DEPENDS:append = " \
    rclcpp \
    rclcpp-components \
"
