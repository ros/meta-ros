FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-remove-shadow-error-compile-option.patch"

ROS_BUILDTOOL_DEPENDS += " \
    generate-parameter-library-py-native \
"

CXXFLAGS += "-Wno-deprecated-declarations"

# QA Issue: File /opt/ros/humble/share/pose_broadcaster/cmake/export_pose_broadcasterExport.cmake in package pose-broadcaster-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}[^;]*;##g" ${D}${ros_datadir}/${ROS_BPN}/cmake/export_${ROS_BPN}Export.cmake
    sed -i -e 's#${RECIPE_SYSROOT}[^"]*##g' ${D}${ros_datadir}/${ROS_BPN}/cmake/export_${ROS_BPN}Export.cmake
}