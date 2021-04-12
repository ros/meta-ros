# Copyright (c) 2021 LG Electronics, Inc.

# Fails with webOS OSE which by default uses -Werror=return-type
# industrial-robot-status-controller/0.1.2-1-r0/git/src/controller.cpp: In function 'industrial_msgs::TriState_<std::allocator<void> >::_val_type industrial_robot_status_controller::convert(const industrial_robot_status_interface::TriState&)':
# industrial-robot-status-controller/0.1.2-1-r0/git/src/controller.cpp:89:1: error: control reaches end of non-void function [-Werror=return-type]
# industrial-robot-status-controller/0.1.2-1-r0/git/src/controller.cpp: In function 'industrial_msgs::RobotMode_<std::allocator<void> >::_val_type industrial_robot_status_controller::convert(const industrial_robot_status_interface::RobotMode&)':
# industrial-robot-status-controller/0.1.2-1-r0/git/src/controller.cpp:100:1: error: control reaches end of non-void function [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"
