# Copyright (c) Stephen Street stephen@redrocketcomputing.com

SUMMARY = "Add ROS2 SDK enviroment variable"
HOMEPAGE = "https://github.com/meta-ros"
SECTION = "devel"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

FILESEXTRAPATHS:prepend := "${THISDIR}/ros-sdk-env:"

inherit python3native ros_opt_prefix

FILES:${PN} = "${base_prefix}/environment-setup.d/ros-sdk-env.sh"

S = "${WORKDIR}"

# This was pulled from meta-ros/meta-ros2/classes/ros_ament_cmake.bbclass
PYTHON_SOABI_ARCH = "${TUNE_ARCH}-${TARGET_OS}"
PYTHON_SOABI_ARCH_SUFFIX = "-gnu"

# The suffix is already included in TARGET_OS
PYTHON_SOABI_ARCH_SUFFIX:arm = ""

# Another exception is i686 TUNE_ARCH in dunfell and newer with this change:
# https://git.openembedded.org/openembedded-core/commit/?h=dunfell&id=6beab388e73b3ac6157650855a6c1fb1d71e8015
PYTHON_SOABI_ARCH:i686 = "i386-${TARGET_OS}"

PYTHON_SOABI = "cpython-${@d.getVar('PYTHON_BASEVERSION').replace('.', '')}${PYTHON_ABI}-${PYTHON_SOABI_ARCH}${PYTHON_SOABI_ARCH_SUFFIX}"

do_install () {
    echo "export ROS_VERSION=${ROS_VERSION}" > ${S}/ros-sdk-env.sh
    echo "export ROS_PYTHON_VERSION=${ROS_PYTHON_VERSION}" >> ${S}/ros-sdk-env.sh
    echo "export ROS_DISTRO=${ROS_DISTRO}" >> ${S}/ros-sdk-env.sh
    echo "export PYTHONPATH="'$OECORE_NATIVE_SYSROOT'"/usr/lib/python${PYTHON_BASEVERSION}/site-packages:"'$OECORE_TARGET_SYSROOT'"${ros_base_prefix}/lib/python${PYTHON_BASEVERSION}/site-packages"  >> ${S}/ros-sdk-env.sh
    echo "export AMENT_PREFIX_PATH="'$OECORE_TARGET_SYSROOT'"${ros_base_prefix}" >> ${S}/ros-sdk-env.sh
    echo "export PYTHON_SOABI=${PYTHON_SOABI}.so" >> ${S}/ros-sdk-env.sh
    echo "export CMAKE_PYTHON_SOABI=${PYTHON_SOABI}" >> ${S}/ros-sdk-env.sh
    echo "export PYTHON3_NUMPY_INCLUDE_DIR="'$OECORE_TARGET_SYSROOT'"/usr/lib/python${PYTHON_BASEVERSION}/site-packages/numpy/core/include" >> ${S}/ros-sdk-env.sh
    echo "export PYTHONWARNINGS=ignore"  >> ${S}/ros-sdk-env.sh
    mkdir -p ${D}${base_prefix}/environment-setup.d
    install -m 644 ${S}/ros-sdk-env.sh ${D}${base_prefix}/environment-setup.d
}

BBCLASSEXTEND = "native nativesdk"
