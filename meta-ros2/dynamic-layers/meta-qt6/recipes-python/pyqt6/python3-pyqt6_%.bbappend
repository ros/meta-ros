# Copyright (c) 2026 Wind River Systems, Inc.

PYQT_MODULES:append = " QtWidgets"

DISABLED_FEATURES += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '', 'PyQt_Wayland', d)} \
"
