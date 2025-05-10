# Copyright (c) 2025 Wind River Systems, Inc.

inherit pkgconfig

RDEPENDS:${PN} += "bash"

EXTRA_OECMAKE += " -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc"

# ERROR: QA Issue: package gazebo-ros contains bad RPATH .../gazebo-ros/2.9.3-1-r0/recipe-sysroot/usr/lib/gazebo-11/plugins
#     in file .../libgazebo_ros_paths_plugin.so
#     in file .../libgazebo_ros_api_plugin.so
# WARNING: gazebo-plugins-2.9.3-1-r0 do_package_qa: QA Issue: File ... in package gazebo-plugins contains reference to TMPDIR
#     Remove buildpaths from comment lines
do_compile:append() {
    chrpath --delete ${WORKDIR}/devel/${baselib}/libgazebo_ros_paths_plugin.so
    chrpath --delete ${WORKDIR}/devel/${baselib}/libgazebo_ros_api_plugin.so

    sed -i -e "s#${RECIPE_SYSROOT}##g" ${WORKDIR}/devel/include/gazebo_ros/PhysicsConfig.h
    sed -i -e "s#${WORKDIR}/devel##g" ${WORKDIR}/devel/${baselib}/${PYTHON_DIR}/site-packages/gazebo_ros/cfg/PhysicsConfig.py

    nativepython3 -mcompileall -f -s ${WORKDIR}/devel ${WORKDIR}/devel/${baselib}/${PYTHON_DIR}/site-packages/gazebo_ros/cfg/
    nativepython3 -mcompileall -f -s ${WORKDIR}/devel ${WORKDIR}/devel/${baselib}/${PYTHON_DIR}/site-packages/gazebo_ros/cfg/PhysicsConfig.py
}


