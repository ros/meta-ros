# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
    generate-parameter-library-py-native \
"

# QA Issue: File /opt/ros/humble/share/imu_sensor_broadcaster/cmake/export_imu_sensor_broadcasterExport.cmake in package imu-sensor-broadcaster-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}[^;]*;##g" ${D}${ros_datadir}/${ROS_BPN}/cmake/export_${ROS_BPN}Export.cmake
    sed -i -e 's#${RECIPE_SYSROOT}[^"]*##g' ${D}${ros_datadir}/${ROS_BPN}/cmake/export_${ROS_BPN}Export.cmake
}
