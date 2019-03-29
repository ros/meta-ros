SUMMARY = "C++ nodes which were previously in the ros2/examples repository but are now just used for demo purposes."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=12c26a18c7f493fdc7e8a93b16b7c04f"
DEPENDS = " \
    example-interfaces \
    rclcpp \
    ros2-sensor-msgs \
"

ROS_BPN = "demo_nodes_cpp"

include ros2-demos.inc
