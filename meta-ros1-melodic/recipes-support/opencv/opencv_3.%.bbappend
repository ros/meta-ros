# Copyright (c) 2019-2021 LG Electronics, Inc.

# Fix up PACKAGECONFIG if Python 2 is being used.
PACKAGECONFIG:prepend = "${@'python2 ' if d.getVar('ROS_PYTHON_VERSION') == '2' else ''}"
# :remove happens after :prepend.
PACKAGECONFIG:remove = "${@'python3' if d.getVar('ROS_PYTHON_VERSION') == '2' else ''}"

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

# This is needed only for webOS OSE and it's not in meta-ros-webos, because
# then meta-ros-webos would need to include this .bbappend just when
# meta-ros1-melodic layer is included
VIRTUAL-RUNTIME_bash ?= "bash"
RDEPENDS:${PN}-apps:append:class-target:webos = " ${VIRTUAL-RUNTIME_bash}"
RDEPENDS:${PN}-apps:remove:class-target:webos = "${@oe.utils.conditional('WEBOS_PREFERRED_PROVIDER_FOR_BASH', 'busybox', 'bash', '', d)}"

# opencv/3.4.5-r0/git/3rdparty/openexr/Imath/ImathVec.h:227:41: error: ISO C++17 does not allow dynamic exception specifications
#  227 |     const Vec2 &        normalizeExc () throw (Iex::MathExc);
#      |                                         ^~~~~
# ...
CXXFLAGS += "-std=gnu++14"
