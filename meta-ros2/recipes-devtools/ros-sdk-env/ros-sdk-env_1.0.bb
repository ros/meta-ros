# Copyright (c) Stephen Street stephen@redrocketcomputing.com

SUMMARY = "Add ROS2 SDK enviroment variable"
HOMEPAGE = "https://github.com/ros/meta-ros"
SECTION = "devel"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

inherit python3native ros_opt_prefix

FILES:${PN} = "\
    ${SDKPATHNATIVE}/post-relocate-setup.d/ros-sdk-env.sh \
    ${SDKPATHNATIVE}/post-relocate-setup.d/ros-sdk-setup.sh \
    ${datadir}/ros-sdk/ros-colcon-toolchain.cmake \
"

ROS_SDK_UNIFY ??= "bash"

do_compile:class-nativesdk () {
    # No SRC_URI means nothing guarantees S exists by do_install time.
    mkdir -p ${S}

    # Quoted heredoc: this block is runtime shell for the SDK's setup, not
    # something bitbake should expand. It contains no ${...}, so bitbake
    # passes it through untouched.
    cat > ${S}/ros-sdk-env.sh <<'ROSSDKEOF'
# Derive the target Python SOABI from a real extension module in the target
# sysroot, e.g. array.cpython-314-x86_64-linux-gnu.so -> the middle field.
_ros_sdk_so=$(ls $OECORE_TARGET_SYSROOT/usr/lib/python*/lib-dynload/*.cpython-*.so 2>/dev/null | head -1)
if [ -n "$_ros_sdk_so" ]; then
    PYTHON_SOABI=$(basename "$_ros_sdk_so" | sed -e 's/^[^.]*\.//' -e 's/\.so$//')
    export PYTHON_SOABI
fi
unset _ros_sdk_so
ROSSDKEOF

    echo "export PYTHON3_NUMPY_INCLUDE_DIR="'$OECORE_TARGET_SYSROOT'"/usr/lib/python${PYTHON_BASEVERSION}/site-packages/numpy/core/include" >> ${S}/ros-sdk-env.sh
    echo "export PYTHONWARNINGS=ignore" >> ${S}/ros-sdk-env.sh
    echo "export AMENT_SKIP_SHELL_PATH=1" >> ${S}/ros-sdk-env.sh

    if [ -n "${ROS_SDK_UNIFY}" ]; then
        echo '. $OECORE_TARGET_SYSROOT'"${ros_base_prefix}/setup.${ROS_SDK_UNIFY}" >> ${S}/ros-sdk-env.sh
    fi
    echo "export PYTHONPATH="'$OECORE_TARGET_SYSROOT'"/usr/lib/python${PYTHON_BASEVERSION}/site-packages:"'$PYTHONPATH' >> ${S}/ros-sdk-env.sh


    echo "#! /usr/bin/env sh" > ${S}/ros-sdk-setup.sh
    echo 'mkdir -p $OECORE_NATIVE_SYSROOT/environment-setup.d' >> ${S}/ros-sdk-setup.sh
    echo 'install -m 755 $OECORE_NATIVE_SYSROOT/post-relocate-setup.d/ros-sdk-env.sh $OECORE_NATIVE_SYSROOT/environment-setup.d/ros-sdk-env.sh'  >> ${S}/ros-sdk-setup.sh

    cat > ${S}/ros-colcon-toolchain.cmake <<'ROSCOLCONTOOLCHAIN'
cmake_path(SET OECMAKE_TOOLCHAIN_FILE NORMALIZE "$ENV{OECORE_NATIVE_SYSROOT}/usr/share/cmake/OEToolchainConfig.cmake")

if(EXISTS "${OECMAKE_TOOLCHAIN_FILE}")
    message(STATUS "OE CMake toolchain file found: ${OECMAKE_TOOLCHAIN_FILE}")
    include(${OECMAKE_TOOLCHAIN_FILE})
else()
    message(FATAL_ERROR "OE CMake toolchain file missing: ${OECMAKE_TOOLCHAIN_FILE}")
endif()

if(EXISTS "$ENV{ROS_WORKSPACE}")
    message(STATUS "ROS workspace found: $ENV{ROS_WORKSPACE}")
else()
    message(FATAL_ERROR "ROS workspace missing: $ENV{ROS_WORKSPACE}")
endif()

set(STAGING_PREFIX "$ENV{ROS_WORKSPACE}/install")

set(CMAKE_FIND_ROOT_PATH $ENV{OECORE_TARGET_SYSROOT} ${STAGING_PREFIX})
set(CMAKE_FIND_ROOT_PATH_MODE_PROGRAM BOTH)

set(Python3_EXECUTABLE "$ENV{OECORE_NATIVE_SYSROOT}/usr/bin/python3")
ROSCOLCONTOOLCHAIN
}

do_install:class-nativesdk () {
    install -d ${D}${SDKPATHNATIVE}/post-relocate-setup.d
    install -m 644 ${S}/ros-sdk-env.sh ${D}${SDKPATHNATIVE}/post-relocate-setup.d/ros-sdk-env.sh
    install -m 755 ${S}/ros-sdk-setup.sh ${D}${SDKPATHNATIVE}/post-relocate-setup.d/ros-sdk-setup.sh

    install -d ${D}${datadir}/ros-sdk
    install -m 755 ${S}/ros-colcon-toolchain.cmake ${D}${datadir}/ros-sdk/ros-colcon-toolchain.cmake
}

BBCLASSEXTEND = " nativesdk"
