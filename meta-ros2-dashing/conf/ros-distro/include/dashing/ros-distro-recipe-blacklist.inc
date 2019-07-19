# dashing/ros-distro-recipe-blacklist.inc
#
# Copyright (c) 2019 LG Electronics, Inc.

# This is a ROS 2 distro, so blacklist ROS 1 packages that will never be ROS 2.
PNBLACKLIST[packagegroup-ros1-comm] ?= "Not a ROS 2 package"
PNBLACKLIST[packagegroup-ros1-industrial] ?= "Not a ROS 2 package"
PNBLACKLIST[packagegroup-ros1-kobuki] ?= "Not a ROS 2 package"

# Initially, blacklist any non-platform duplicates found by "bitbake-layers show-overlayed". Remove from the blacklist once a
# PREFERRED_VERSION_<PN> setting is made in ros-distro-preferred-versions.inc .
# (none)

# Initially, blacklist any non-platform recipes with multiple versions found by "bitbake-layers show-recipes --multiple". Remove
# from the blacklist once a PREFERRED_VERSION_<PN> setting is made in ros-distro-preferred-versions.inc .
# (none)

#
# Alternative implementations not yet supported.
#
PNBLACKLIST[connext-cmake-module] ?= "Not yet supporting use of Connext"
PNBLACKLIST[rmw-connext-cpp] ?= "Not yet supporting use of Connext"
PNBLACKLIST[rmw-connext-shared-cpp] ?= "Not yet supporting use of Connext"
PNBLACKLIST[rosidl-typesupport-connext-c] ?= "Not yet supporting use of Connext"
PNBLACKLIST[rosidl-typesupport-connext-cpp] ?= "Not yet supporting use of Connext"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_remove = "connext-cmake-module"
# rmw-implementation.inc removes "rmw-connext-cpp" from ROS_BUILD_DEPENDS.
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_remove = "rmw-connext-cpp"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_remove = "rmw-connext-shared-cpp"
# rosidl-typesupport-c.inc removes "rosidl-typesupport-connext-c" from ROS_BUILD_DEPENDS.
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_remove = "rosidl-typesupport-connext-c"
# rosidl-typesupport-cpp.inc removes "rosidl-typesupport-connext-cpp" from ROS_BUILD_DEPENDS.
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_remove = "rosidl-typesupport-connext-cpp"

PNBLACKLIST[opensplice-cmake-module] ?= "Not yet supporting use of OpenSplice"
PNBLACKLIST[rmw-opensplice-cpp] ?= "Not yet supporting use of OpenSplice"
PNBLACKLIST[rosidl-typesupport-opensplice-c] ?= "Not yet supporting use of OpenSplice"
PNBLACKLIST[rosidl-typesupport-opensplice-cpp] ?= "Not yet supporting use of OpenSplice"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_remove = "opensplice-cmake-module"
# rmw-implementation.inc removes "rmw-opensplice-cpp" from ROS_BUILD_DEPENDS.
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_remove = "rmw-opensplice-cpp"
# rosidl-typesupport-c.inc removes "rosidl-typesupport-opensplice-c" from ROS_BUILD_DEPENDS.
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_remove = "rosidl-typesupport-opensplice-c"
# rosidl-typesupport-cpp.inc removes "rosidl-typesupport-opensplice-cpp" from ROS_BUILD_DEPENDS.
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_remove = "rosidl-typesupport-opensplice-cpp"

# Others
PNBLACKLIST[libyaml] ?= "Provided by libyaml-vendor"
