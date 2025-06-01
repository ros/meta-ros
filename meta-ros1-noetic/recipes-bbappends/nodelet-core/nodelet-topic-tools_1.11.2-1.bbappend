# Copyright (c) 2025 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

# ERROR: QA Issue: File /opt/ros/noetic/include/nodelet_topic_tools/NodeletThrottleConfig.h in package nodelet-topic-tools-dev contains reference to TMPDIR [buildpaths]
# ERROR: QA Issue: File /opt/ros/noetic/lib/python3.13/site-packages/nodelet_topic_tools/cfg/NodeletThrottleConfig.py in package nodelet-topic-tools contains reference to TMPDIR [buildpaths]
# ERROR: QA Issue: File /opt/ros/noetic/lib/python3.13/site-packages/nodelet_topic_tools/cfg/__pycache__/__init__.cpython-313.pyc in package nodelet-topic-tools contains reference to TMPDIR [buildpaths]
# ERROR: QA Issue: File /opt/ros/noetic/lib/python3.13/site-packages/nodelet_topic_tools/cfg/__pycache__/NodeletThrottleConfig.cpython-313.pyc in package nodelet-topic-tools contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_libdir}/${PYTHON_DIR}/site-packages/nodelet_topic_tools/cfg/NodeletThrottleConfig.py
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_includedir}/nodelet_topic_tools/NodeletThrottleConfig.h
    nativepython3 -mcompileall -s ${D} ${D}${ros_libdir}/${PYTHON_DIR}/site-packages/nodelet_topic_tools/cfg/__init__.py
    nativepython3 -mcompileall -s ${D} ${D}${ros_libdir}/${PYTHON_DIR}/site-packages/nodelet_topic_tools/cfg/NodeletThrottleConfig.py
}
