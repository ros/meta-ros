SUMMARY = "ROS2 SDK Image"
DESCRIPTION = "${SUMMARY}"

inherit core-image
inherit ros_distro_${ROS_DISTRO}
inherit ${ROS_DISTRO_TYPE}_image

IMAGE_FEATURES:append = " \
"

IMAGE_INSTALL:append = " \
    packagegroup-core-boot \
    ${CORE_IMAGE_EXTRA_INSTALL} \
"

inherit core-image
inherit ros_distro_${ROS_DISTRO}
inherit ${ROS_DISTRO_TYPE}_image

TOOLCHAIN_TARGET_TASK:append = " \
    opencv-staticdev \
    python3-numpy-staticdev \
    libeigen \
    eigen3-cmake-module \
    boost \
    libstdc++-staticdev \
    pcl-dev \
    python3-pykdl \
    bullet \
    qhull-staticdev \
    orocos-kdl \
    yaml-cpp-vendor \
    pybind11-vendor \
    rttest \
    tlsf-staticdev \
    tlsf-cpp \
    python-cmake-module \
    python3-opencv \
    tinyxml-vendor \
"
