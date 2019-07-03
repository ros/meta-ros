DESCRIPTION = "Launch files for freenect_camera to produce rectified, \
registered or disparity images.  Also produce point clouds and \
registered point clouds.  Based on the openni_launch package."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

require freenect-stack.inc

RRECOMMENDS_${PN} = "freenect-camera image-proc nodelet rgbd-launch tf"

inherit distro_features_check

# Depends on freenect-camera which depends on libfreenect which depends on freeglut libxi libxmu which need x11 in DISTRO_FEATURES
REQUIRED_DISTRO_FEATURES = "x11"
