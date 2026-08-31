DESCRIPTION = "Packages for development with colcon workspaces"
LICENSE = "MIT"

inherit packagegroup
inherit ros_distro_${ROS_DISTRO}

PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
    python3-colcon-common-extensions \
    python3-colcon-python-setup-py \
    python3-colcon-pkg-config \
    \
    cmake \
    git \
    pkgconfig \
    python3-dev \
    python3-setuptools \
    python3-numpy \
    \
    ${ROS_SDK_TARGET_PACKAGES} \
"
