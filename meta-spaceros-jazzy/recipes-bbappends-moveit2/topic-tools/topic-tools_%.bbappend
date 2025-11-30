# Copyright (c) 2025 Wind River Systems, Inc.

# QA Issue: /opt/ros/jazzy/lib/topic_tools/transform maximum shebang size exceeded, the maximum size is 128. [shebang-size]
# QA Issue: /opt/ros/jazzy/lib/topic_tools/relay_field maximum shebang size exceeded, the maximum size is 128. [shebang-size]
do_install:append() {
    # Modify the Python scripts to use the runtime path to Python
    sed -i -e '1s|^#!.*|#!/usr/bin/env python3|' ${D}${ros_libdir}/topic_tools/transform
    sed -i -e '1s|^#!.*|#!/usr/bin/env python3|' ${D}${ros_libdir}/topic_tools/relay_field
}
