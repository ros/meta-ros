# Copyright (c) 2019 LG Electronics, Inc.

SUMMARY = "All ROS packages for the TurtleBot 3, including those usually run on a remote PC, excepting those requiring a display"

inherit packagegroup
inherit ros_distro_${ROS_DISTRO}

# From http://emanual.robotis.com/docs/en/platform/turtlebot3/slam/#run-slam-nodes. (The others mentioned there are not part of
# Melodic.)
TURTLEBOT3_PACKAGES_ADDITIONAL_SLAM_METHODS ??= " \
    cartographer-ros \
    slam-karto \
"

# From http://emanual.robotis.com/docs/en/platform/turtlebot3/pc_setup/#install-dependent-ros-packages, without rqt-image-view
# and rosserial-arduino (which doesn't seem to be needed by anything).
TURTLEBOT3_PACKAGES_REMOTE_PC_DEPENDENCIES = " \
    compressed-image-transport \
    depthimage-to-laserscan \
    joy \
    teleop-twist-joy \
    teleop-twist-keyboard \
    urdf \
"

# Anticipate eventual TurtleBot 3 support under ROS 2, when the package names will be different.
TURTLEBOT3_PACKAGES_REMOTE_PC_DEPENDENCIES_append_ros1-distro = " \
    amcl \
    gmapping \
    interactive-markers \
    laser-proc \
    map-server \
    move-base \
    navigation \
    rgbd-launch \
    rosserial-client \
    rosserial-msgs \
    rosserial-python \
    rosserial-server \
    xacro \
"

RDEPENDS_${PN} = " \
    turtlebot3 \
    turtlebot3-applications \
    turtlebot3-applications-msgs \
    turtlebot3-autorace \
    ${TURTLEBOT3_PACKAGES_ADDITIONAL_SLAM_METHODS} \
    ${TURTLEBOT3_PACKAGES_REMOTE_PC_DEPENDENCIES} \
"
