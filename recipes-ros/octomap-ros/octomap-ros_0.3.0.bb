DESCRIPTION = "octomap_ros provides conversion functions between ROS / PCL and OctoMap's native types."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "octomap-msgs octomap pcl-ros sensor-msgs tf"

SRC_URI = "https://github.com/OctoMap/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "bb532a09683512adb2f5d6ce6589914f"
SRC_URI[sha256sum] = "0a43b252916905eca03b893211d9fc1f031480909a5fde8a2d904f7d408bde10"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

do_configure_append() {
	sed -i -e 's: /usr/lib/liboctomap.so: ${STAGING_LIBDIR}/liboctomap.so:g' \
	  -e 's: /usr/lib/liboctomath.so: ${STAGING_LIBDIR}/liboctomath.so:g' \
	  ${B}/CMakeFiles/octomap_ros.dir/build.make
}
