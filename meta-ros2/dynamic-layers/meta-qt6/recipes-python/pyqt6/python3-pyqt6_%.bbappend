# Copyright (c) 2026 Wind River Systems, Inc.

DEPENDS += "qtsvg"

# Enable QtSvg module for SVG icon rendering in ROS rqt
PYQT_MODULES:append = " QtSvg QtWidgets"
