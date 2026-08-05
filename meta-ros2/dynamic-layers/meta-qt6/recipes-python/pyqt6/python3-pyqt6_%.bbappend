# Copyright (c) 2026 Wind River Systems, Inc.
PYQT_MODULES:append = " QtWidgets"

# Enable QtSvg module for SVG icon rendering in ROS rqt
PYQT_MODULES:append = " QtSvg"
DEPENDS += "qtsvg"
