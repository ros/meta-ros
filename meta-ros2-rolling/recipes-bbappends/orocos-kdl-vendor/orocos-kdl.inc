# Copyright (c) 2022 Wind River Systems, Inc.

HOMEPAGE = "https://orocos.org/kdl.html"

SRC_URI = " \
    git://github.com/ros2-gbp/orocos_kdl_vendor-release;name=release;${ROS_BRANCH};protocol=https \
    git://github.com/orocos/orocos_kinematics_dynamics.git;protocol=https;name=orocos-kdl;destsuffix=git/orocos-kdl;branch=master \
    "

SRCREV_release = "f1bbaed1b5190dbfefd08ca445e53d20d1a0066e"
SRCREV_orocos-kdl = "507de66205e14b12c8c65f25eafc05c4dc66e21e"
SRCREV_FORMAT = "release_orocos-kdl"
