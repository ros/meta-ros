# Copyright (c) 2022 Acceleration Robotics S.L. <contact@accelerationrobotics.com>

# rcutils is just one of the packages provided by gcc-runtime recipe
# but gcc-runtime recipe doesn't have rcutils in PROVIDES, so we cannot map
# rcutils in rosdep to rcutils (without adding rcutils to PROVIDES in gcc-runtime
# bbappend). And we cannot leave gcc-runtime in ROS_EXEC_DEPENDS, because
# gcc-runtime recipe doesn't have PN in PACKAGES (and we would still depend
# on do_package shlibs handling to add runtime dependency on actual package
# with rcutils library)
ROS_EXEC_DEPENDS:remove = "gcc-runtime"
# there is no native support for gcc-runtime, so also no rcutils, add it only for target builds
ROS_EXEC_DEPENDS:append-class-target = " rcutils"
# and also remove it from build time depends when buiding native rc-utils
DEPENDS:remove:class-native = "gcc-runtime-native gcc-runtime"
