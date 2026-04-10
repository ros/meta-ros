# Copyright (c) 2026 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

include qt6-support.inc
S = "${UNPACKDIR}/${BB_GIT_DEFAULT_DESTSUFFIX}/qt_gui"

ROS_BUILD_DEPENDS:remove = "python3-pyqt5"
ROS_BUILD_DEPENDS:append = " python3-pyqt6"
