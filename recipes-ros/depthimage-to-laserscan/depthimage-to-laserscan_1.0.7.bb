DESCRIPTION = "Converts a depth image to a laser scan for use with navigation and localization."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "roscpp sensor-msgs nodelet image-transport image-geometry dynamic-reconfigure ${PYTHON_PN}-rospkg"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz \
           file://0001-Add-missing-std-namespace-prefixes.patch \
           "
SRC_URI[md5sum] = "b8fb5b855be4f7a8d22377d5d866bb47"
SRC_URI[sha256sum] = "3aa236f81cfd26e55718edfb50ef837a59b57169cb20a5b24f9a4e99602a09e8"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RRECOMMENDS_${PN} = "roscpp sensor-msgs nodelet image-transport image-geometry dynamic-reconfigure"
