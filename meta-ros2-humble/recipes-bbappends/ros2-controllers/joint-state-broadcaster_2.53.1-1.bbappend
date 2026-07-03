# Copyright (c) 2021 LG Electronics, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    generate-parameter-library-py-native \
"

# QA Issue: File /opt/ros/humble/share/joint_state_broadcaster/cmake/export_joint_state_broadcasterExport.cmake in package joint-state-broadcaster-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}[^;]*;##g" ${D}${ros_datadir}/${ROS_BPN}/cmake/export_${ROS_BPN}Export.cmake
    sed -i -e 's#${RECIPE_SYSROOT}[^"]*##g' ${D}${ros_datadir}/${ROS_BPN}/cmake/export_${ROS_BPN}Export.cmake
}
