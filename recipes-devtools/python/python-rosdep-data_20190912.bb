# Copyright (c) 2019 LG Electronics, Inc.

SUMMARY = "Results of 'rosdep init; rosdep update' to be used when packages expect this to have been done on the target"
AUTHOR = "Herb Kuta <herb.kuta@lge.com>"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Create python-rosdep-data.tar.gz by running the following on the target:
#   rosdep init
#   rosdep update
#   cd /
#   tar -cvzf python-rosdep-data.tar.gz etc/ros/rosdep ROS_HOME/.ros/rosdep
# Set the version field of the name of this file to the YYYYMMDD when this was done.
# ASSERT(${sysconfdir} == /etc) as the tarball contents are under etc/.
SRC_URI = "file://${BPN}.tar.gz;subdir=${P}"
S = "${WORKDIR}/${P}"

inherit bin_package
