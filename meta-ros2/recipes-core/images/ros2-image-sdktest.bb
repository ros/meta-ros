SUMMARY = "ROS 2 SDK Test Image"
DESCRIPTION = "${SUMMARY}"

inherit core-image
inherit ros_distro_${ROS_DISTRO}
inherit ${ROS_DISTRO_TYPE}_image

IMAGE_INSTALL = " \
    packagegroup-core-boot \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    ${ROS_SDK_EXTRA_INSTALL} \
"
TOOLCHAIN_HOST_TASK:append = "${ROS_SDK_HOST_PACKAGES}"
TOOLCHAIN_TARGET_TASK:append = "${ROS_SDK_TARGET_PACKAGES}"

ROS_SDK_EXTRA_INSTALL = " \
    boost \
    bullet \
    eigen3-cmake-module \
    libeigen \
    libstdc++-staticdev \
    opencv-staticdev \
    orocos-kdl \
    pcl-dev \
    pybind11-vendor \
    python-cmake-module \
    python3-numpy-staticdev \
    python3-opencv \
    python3-pykdl \
    qhull-staticdev \
    rttest \
    tlsf-staticdev \
    tlsf-cpp \
    tinyxml-vendor \
    yaml-cpp-vendor \
"
