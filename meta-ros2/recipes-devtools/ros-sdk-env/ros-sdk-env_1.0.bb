# Copyright (c) Stephen Street stephen@redrocketcomputing.com

SUMMARY = "Add ROS2 SDK enviroment variable"
HOMEPAGE = "https://github.com/meta-ros"
SECTION = "devel"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

inherit python3native ros_opt_prefix

FILES:${PN} = "${SDKPATHNATIVE}/post-relocate-setup.d/ros-sdk-env.sh ${SDKPATHNATIVE}/post-relocate-setup.d/ros-sdk-setup.sh"

S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

# This was pulled from meta-ros/meta-ros2/classes/ros_ament_cmake.bbclass
PYTHON_SOABI_ARCH = "${TUNE_ARCH}-${TARGET_OS}"
PYTHON_SOABI_ARCH_SUFFIX = "-gnu"

# The suffix is already included in TARGET_OS
PYTHON_SOABI_ARCH_SUFFIX:arm = ""

# Another exception is i686 TUNE_ARCH in dunfell and newer with this change:
# https://git.openembedded.org/openembedded-core/commit/?h=dunfell&id=6beab388e73b3ac6157650855a6c1fb1d71e8015
PYTHON_SOABI_ARCH:i686 = "i386-${TARGET_OS}"

PYTHON_SOABI = "cpython-${@d.getVar('PYTHON_BASEVERSION').replace('.', '')}${PYTHON_ABI}-${PYTHON_SOABI_ARCH}${PYTHON_SOABI_ARCH_SUFFIX}"

do_install:append:class-nativesdk () {
    echo "export PYTHON_SOABI=${PYTHON_SOABI}" > ${S}/ros-sdk-env.sh
    echo "export PYTHON3_NUMPY_INCLUDE_DIR="'$OECORE_TARGET_SYSROOT'"/usr/lib/python${PYTHON_BASEVERSION}/site-packages/numpy/core/include" >> ${S}/ros-sdk-env.sh
    echo "export PYTHONWARNINGS=ignore" >> ${S}/ros-sdk-env.sh
    echo "export AMENT_SKIP_SHELL_PATH=1" >> ${S}/ros-sdk-env.sh

    if [ -n "${ROS_SDK_UNIFY}" ]; then
        echo '. $OECORE_TARGET_SYSROOT'"${ros_base_prefix}/setup.${ROS_SDK_UNIFY}" >> ${S}/ros-sdk-env.sh
    fi
    echo "export PYTHONPATH="'$OECORE_TARGET_SYSROOT'"/usr/lib/python${PYTHON_BASEVERSION}/site-packages:"'$PYTHONPATH' >> ${S}/ros-sdk-env.sh

    mkdir -p ${D}${SDKPATHNATIVE}/post-relocate-setup.d
    install -m 644 ${UNPACKDIR}/ros-sdk-env.sh ${D}${SDKPATHNATIVE}/post-relocate-setup.d/ros-sdk-env.sh

    echo "#! /usr/bin/env sh" > ${S}/ros-sdk-setup.sh
    echo 'mkdir -p $OECORE_NATIVE_SYSROOT/environment-setup.d' >> ${S}/ros-sdk-setup.sh
    echo 'install -m 755 $OECORE_NATIVE_SYSROOT/post-relocate-setup.d/ros-sdk-env.sh $OECORE_NATIVE_SYSROOT/environment-setup.d/ros-sdk-env.sh'  >> ${S}/ros-sdk-setup.sh

    install -m 755 ${UNPACKDIR}/ros-sdk-setup.sh ${D}${SDKPATHNATIVE}/post-relocate-setup.d/ros-sdk-setup.sh
}

BBCLASSEXTEND = " nativesdk"
