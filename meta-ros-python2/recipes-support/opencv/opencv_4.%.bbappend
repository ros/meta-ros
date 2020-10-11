# Copyright (c) 2019-2020 LG Electronics, Inc.

ROS_PYTHON_VERSION ?= "2"

# Fix up PACKAGECONFIG if Python 2 is being used.
PACKAGECONFIG_prepend = "${@'python2 ' if d.getVar('ROS_PYTHON_VERSION') == '2' else ''}"
# _remove happens after _prepend.
PACKAGECONFIG_remove = "${@'python3' if d.getVar('ROS_PYTHON_VERSION') == '2' else ''}"

# Python variables are set to their values for Python 3 even though
# python2" appears in PACKAGECONFIG because distutils3-base has been
# already inherited by the main recipe before the PACKAGECONFIG is
# adjusted. This causes the "python-opencv" package to be empty because
# /usr/lib/python2.7/site-packages/cv2.so isn't built. Fix by inherit-ing
# distutils-base again if "python2" appears in PACKAGECONFIG. Luckily
# inheriting distutils-base after distutils3-base works OK, because it
# overwrites all variables opencv needs to configure python2 support
# correctly.
inherit ${@bb.utils.contains('PACKAGECONFIG', 'python2', 'distutils-base', '', d)}
