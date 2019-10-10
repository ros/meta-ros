# melodic/ros-distro.inc
# General configuration settings that are dependent on ROS_DISTRO.
#
# Copyright (c) 2019 LG Electronics, Inc.

ROS_DISTRO_CODENAME = "Melodic Morenia"

# The platform release that the metadata for this ROS distro targets. This determines the versions of the platform packages that
# OE must provide. It must be one of the values of ROS_DISTRO_RELEASE_PLATFORMS (which is set in
# generated/superflore-ros-distro.inc).
ROS_DISTRO_BASELINE_PLATFORM = "ubuntu-bionic"

require conf/ros-distro/include/melodic/generated/superflore-datetime.inc
require conf/ros-distro/include/melodic/generated/superflore-ros-distro.inc
require conf/ros-distro/include/melodic/ros-distro-recipe-blacklist.inc
require conf/ros-distro/include/melodic/ros-distro-preferred-versions.inc
require conf/ros-distro/include/melodic/ros-distro-preferred-providers.inc

# Override settings from generated/superflore-ros-distro.inc here.

# Since superflore doesn't know when it's generating a recipe that it will be for a build tool, it can't know that what's in
# ROS_EXEC_DEPEND are also build tools. Manually add them here.
ROS_SUPERFLORE_GENERATED_BUILDTOOLS += " \
"

ROS_BUILD_TYPE_pn-python-orocos-kdl = "catkin"

# python-backports-ssl@meta-python
ROS_UNRESOLVED_PLATFORM_PKG_python-backports.ssl-match-hostname = "python-backports-ssl"

# python-pillow@meta-ros v5.1.0
ROS_UNRESOLVED_PLATFORM_PKG_python-imaging = "python-pillow"

# python-tornado45@meta-ros v4.5.3
ROS_UNRESOLVED_PLATFORM_PKG_python-tornado = "python-tornado45"

# python-twisted-core@meta-python (v18.4.0 instead of  bionic's v17.9.0)
ROS_UNRESOLVED_PLATFORM_PKG_python-twisted-core = "python-twisted-core"
