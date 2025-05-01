ROS_BUILDTOOL_DEPENDS += " \
    generate-parameter-library-py-native \
"

# QA Issue: File /opt/ros/humble/share/bicycle_steering_controller/cmake/export_bicycle_steering_controllerExport.cmake in package bicycle-steering-controller-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}[^;]*;##g" ${D}${ros_datadir}/${ROS_BPN}/cmake/export_${ROS_BPN}Export.cmake
    sed -i -e 's#${RECIPE_SYSROOT}[^"]*##g' ${D}${ros_datadir}/${ROS_BPN}/cmake/export_${ROS_BPN}Export.cmake
}
