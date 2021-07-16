# Copyright (c) 2019 LG Electronics, Inc.

ALLOW_EMPTY:${PN} = "1"

# This component puts its cmake files under libdir instead of datadir.
FILES:${PN}-dev:prepend = " \
    ${libdir}/${ROS_BPN}/cmake \
"
