DESCRIPTION = "cv_camera uses OpenCV capture object to capture camera image. This supports camera_image and nodelet."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "opencv image-transport roscpp cv-bridge sensor-msgs nodelet camera-info-manager roslint"

SRC_URI = "https://github.com/OTL/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d52b7c7386615d649cb7c0a83b910845"
SRC_URI[sha256sum] = "f38948e279e79a7410abb341e1313a64cd8edff2e0a3086d2045a86741af14bf"

SRC_URI += "file://0001-make-rostest-in-CMakeLists-optional-ros-rosdistro-30.patch"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
