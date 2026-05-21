LICENSE = "BSD-3-Clause"

ROS_BUILD_DEPENDS:remove = "${ROS_UNRESOLVED_DEP-pyqt5-dev-tools}"

ROS_EXEC_DEPENDS:remove = "python3-pyqt5"
ROS_EXEC_DEPENDS:append = "python3-pyqt6"
