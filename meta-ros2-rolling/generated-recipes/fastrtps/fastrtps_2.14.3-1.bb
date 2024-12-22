# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "*eprosima Fast DDS* (formerly Fast RTPS) is a C++ implementation of the DDS (Data Distribution Service) standard of the OMG (Object Management Group). eProsima Fast DDS implements the RTPS (Real Time Publish Subscribe) protocol, which provides publisher-subscriber communications over unreliable transports such as UDP, as defined and maintained by the Object Management Group (OMG) consortium. RTPS is also the wire interoperability protocol defined for the Data Distribution Service (DDS) standard. *eProsima Fast DDS* expose an API to access directly the RTPS protocol, giving the user full access to the protocol internals."
AUTHOR = "Miguel Company <miguelcompany@eprosima.com>"
HOMEPAGE = "https://www.eprosima.com/"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=da5a1be2927e3a58d7e126f7c5d3ddbd"

ROS_CN = "fastrtps"
ROS_BPN = "fastrtps"

ROS_BUILD_DEPENDS = " \
    asio \
    fastcdr \
    foonathan-memory-vendor \
    libtinyxml2 \
    openssl \
    python3 \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    fastcdr \
    foonathan-memory-vendor \
    libtinyxml2 \
    openssl \
    python3 \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    fastcdr \
    foonathan-memory-vendor \
    libtinyxml2 \
    openssl \
    python3 \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/fastrtps-release/archive/release/rolling/fastrtps/2.14.3-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/fastrtps"
SRC_URI = "git://github.com/ros2-gbp/fastrtps-release;${ROS_BRANCH};protocol=https"
SRCREV = "9d6f48dc2ecfe0bc33d20f96717755d11826616f"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
