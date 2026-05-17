# Copyright (c) 2022 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    generate-parameter-library-py-native \
    python3-pyyaml-native \
"

# QA Issue: File /opt/ros/humble/share/force_torque_sensor_broadcaster/cmake/export_force_torque_sensor_broadcasterExport.cmake in package force-torque-sensor-broadcaster-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}[^;]*;##g" ${D}${ros_datadir}/${ROS_BPN}/cmake/export_${ROS_BPN}Export.cmake
    sed -i -e 's#${RECIPE_SYSROOT}[^"]*##g' ${D}${ros_datadir}/${ROS_BPN}/cmake/export_${ROS_BPN}Export.cmake
}
