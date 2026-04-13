# Copyright (c) 2019-2020 LG Electronics, Inc.

# This component puts *_proc files under libdir.
FILES:${PN}:prepend = " \
    ${datadir}/lib/${ROS_BPN} \
"

