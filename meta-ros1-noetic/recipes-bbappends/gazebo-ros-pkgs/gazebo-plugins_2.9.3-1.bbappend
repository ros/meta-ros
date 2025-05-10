# Copyright (c) 2025 Wind River Systems, Inc.

inherit pkgconfig

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://use-ogre19.patch"

DEPENDS += " \
    ogre19 \
"

EXTRA_OECMAKE += " -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc"

# WARNING: gazebo-plugins-2.9.3-1-r0 do_package_qa: QA Issue: File ... in package gazebo-plugins contains reference to TMPDIR
#do_configure:append() {
#    sed -i -e "s#${RECIPE_SYSROOT}##g" ${WORKDIR}/devel/include/gazebo_plugins/GazeboRosCameraConfig.h
#    sed -i -e "s#${RECIPE_SYSROOT}##g" ${WORKDIR}/devel/${baselib}/${PYTHON_DIR}/site-packages/gazebo_plugins/cfg/CameraSynchronizerConfig.py
#    nativepython3 -mcompileall -s ${WORKDIR}/devel ${WORKDIR}/devel/${baselib}/${PYTHON_DIR}/site-packages/gazebo_plugins/cfg/CameraSynchronizerConfig.py
#
#    sed -i -e "s#${RECIPE_SYSROOT}##g" ${WORKDIR}/devel/include/gazebo_plugins/GazeboRosOpenniKinectConfig.h
#    sed -i -e "s#${RECIPE_SYSROOT}##g" ${WORKDIR}/devel/${baselib}/${PYTHON_DIR}/site-packages/gazebo_plugins/cfg/GazeboRosCameraConfig.py
#    nativepython3 -mcompileall -s ${WORKDIR}/devel ${WORKDIR}/devel/${baselib}/${PYTHON_DIR}/site-packages/gazebo_plugins/cfg/GazeboRosCameraConfig.py
#
#    sed -i -e "s#${RECIPE_SYSROOT}##g" ${WORKDIR}/devel/include/gazebo_plugins/CameraSynchronizerConfig.h
#    sed -i -e "s#${RECIPE_SYSROOT}##g" ${WORKDIR}/devel/${baselib}/${PYTHON_DIR}/site-packages/gazebo_plugins/cfg/GazeboRosOpenniKinectConfig.py
#    nativepython3 -mcompileall -s ${WORKDIR}/devel ${WORKDIR}/devel/${baselib}/${PYTHON_DIR}/site-packages/gazebo_plugins/cfg/GazeboRosOpenniKinectConfig.py
#
#    sed -i -e "s#${RECIPE_SYSROOT}##g" ${WORKDIR}/devel/include/gazebo_plugins/HokuyoConfig.h
#    sed -i -e "s#${RECIPE_SYSROOT}##g" ${WORKDIR}/devel/${baselib}/${PYTHON_DIR}/site-packages/gazebo_plugins/cfg/HokuyoConfig.py
#    nativepython3 -mcompileall -s ${WORKDIR}/devel ${WORKDIR}/devel/${baselib}/${PYTHON_DIR}/site-packages/gazebo_plugins/cfg/HokuyoConfig.py
#
#    sed -i -e "s#${RECIPE_SYSROOT}##g" ${WORKDIR}/devel/include/gazebo_plugins/WheelSlipConfig.h
#    sed -i -e "s#${RECIPE_SYSROOT}##g" ${WORKDIR}/devel/${baselib}/${PYTHON_DIR}/site-packages/gazebo_plugins/cfg/WheelSlipConfig.py
#    nativepython3 -mcompileall -s ${WORKDIR}/devel ${WORKDIR}/devel/${baselib}/${PYTHON_DIR}/site-packages/gazebo_plugins/cfg/WheelSlipConfig.py
#}

#do_install:append() {
#    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_includedir}/gazebo_plugins/GazeboRosCameraConfig.h
#    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_libdir}/${PYTHON_DIR}/site-packages/gazebo_plugins/cfg/CameraSynchronizerConfig.py
#    nativepython3 -mcompileall -s ${D} ${D}${ros_libdir}/${PYTHON_DIR}/site-packages/gazebo_plugins/cfg/CameraSynchronizerConfig.py
#
#    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_includedir}/gazebo_plugins/GazeboRosOpenniKinectConfig.h
#    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_libdir}/${PYTHON_DIR}/site-packages/gazebo_plugins/cfg/GazeboRosCameraConfig.py
#    nativepython3 -mcompileall -s ${D} ${D}${ros_libdir}/${PYTHON_DIR}/site-packages/gazebo_plugins/cfg/GazeboRosCameraConfig.py
#
#    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_includedir}/gazebo_plugins/CameraSynchronizerConfig.h
#    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_libdir}/${PYTHON_DIR}/site-packages/gazebo_plugins/cfg/GazeboRosOpenniKinectConfig.py
#    nativepython3 -mcompileall -s ${D} ${D}${ros_libdir}/${PYTHON_DIR}/site-packages/gazebo_plugins/cfg/GazeboRosOpenniKinectConfig.py
#
#    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_includedir}/gazebo_plugins/HokuyoConfig.h
#    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_libdir}/${PYTHON_DIR}/site-packages/gazebo_plugins/cfg/HokuyoConfig.py
#    nativepython3 -mcompileall -s ${D} ${D}${ros_libdir}/${PYTHON_DIR}/site-packages/gazebo_plugins/cfg/HokuyoConfig.py
#
#    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_includedir}/gazebo_plugins/WheelSlipConfig.h
#    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_libdir}/${PYTHON_DIR}/site-packages/gazebo_plugins/cfg/WheelSlipConfig.py
#    nativepython3 -mcompileall -s ${D} ${D}${ros_libdir}/${PYTHON_DIR}/site-packages/gazebo_plugins/cfg/WheelSlipConfig.py
#}
