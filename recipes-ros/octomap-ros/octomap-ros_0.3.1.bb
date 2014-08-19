DESCRIPTION = "octomap_ros provides conversion functions between ROS / PCL and OctoMap's native types."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "octomap-msgs octomap pcl-ros sensor-msgs tf"

SRC_URI = "https://github.com/OctoMap/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "eb831d70d2cfe0589e58ecbebb5b5637"
SRC_URI[sha256sum] = "63803af415840fd4adcea5888f6a330f061800541142eeb0fe2075971dc5c3b3"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

do_configure_append() {
    sed -i -e 's: /usr/lib/liboctomap.so: ${STAGING_LIBDIR}/liboctomap.so:g' \
        -e 's: /usr/lib/liboctomath.so: ${STAGING_LIBDIR}/liboctomath.so:g' \
        ${B}/CMakeFiles/octomap_ros.dir/build.make
}
