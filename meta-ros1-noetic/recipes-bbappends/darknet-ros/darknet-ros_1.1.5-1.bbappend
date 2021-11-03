# Copyright (c) 2021 LG Electronics, Inc.

# Instead of fetching
# https://github.com/leggedrobotics/darknet_ros/releases/download/1.1.4/yolov2-tiny.weights
# https://github.com/leggedrobotics/darknet_ros/releases/download/1.1.4/yolov3.weights
# https://github.com/leggedrobotics/darknet_ros/releases/download/1.1.4/yolov2.weights
# during do_compile fetch them here
# also fetch darknet repo as darknet-ros expects it to be available in sibling directory:
# # Define path of darknet folder here.
# find_path(DARKNET_PATH
#   NAMES "README.md"
#   HINTS "${CMAKE_CURRENT_SOURCE_DIR}/../darknet/")
# message(STATUS "Darknet path dir = ${DARKNET_PATH}")
# add_definitions(-DDARKNET_FILE_PATH="${DARKNET_PATH}")

YOLO_RELEASE = "1.1.4"
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    git://github.com/leggedrobotics/darknet.git;protocol=https;name=darknet;destsuffix=darknet;branch=master \
    https://github.com/leggedrobotics/darknet_ros/releases/download/${YOLO_RELEASE}/yolov2-tiny.weights;downloadfilename=yolo-${YOLO_RELEASE}-yolov2-tiny.weights;name=yolov2-tiny \
    https://github.com/leggedrobotics/darknet_ros/releases/download/${YOLO_RELEASE}/yolov3.weights;downloadfilename=yolo-${YOLO_RELEASE}-yolov3.weights;name=yolov3 \
    https://github.com/leggedrobotics/darknet_ros/releases/download/${YOLO_RELEASE}/yolov2.weights;downloadfilename=yolo-${YOLO_RELEASE}-yolov2.weights;name=yolov2 \
    file://0001-CMakeLists.txt-fix-searching-for-darknet.patch \
"

SRCREV_darknet = "d22bbf38bd012f13d2b50c8d98149cd4a9889b7a"
SRC_URI[yolov2-tiny.sha256sum] = "16f4e870f1aed83f0089cb69bfda6b53cb7b2a4a01721be56eaf5c899dfac45f"
SRC_URI[yolov3.sha256sum] = "523e4e69e1d015393a1b0a441cef1d9c7659e3eb2d7e15f793f060a21b32f297"
SRC_URI[yolov2.sha256sum] = "d9945162ed6f54ce1a901e3ec537bdba4d572ecae7873087bd730e5a7942df3f"

do_configure:prepend() {
    # we have used "yolo-${YOLO_RELEASE}-" as a prefix in downloadfilename
    # to make sure files in DL_DIR contain a version (so that they are properly re-downloaded
    # when the YOLO_RELEASE is changed), but we need to undo this, because CMake expects the
    # original name, that's why they are downloaded into ${WORKDIR} instead of with ;subdir=git/yolo_network_config/weights
    for weight in v2-tiny v3 v2; do
        cp ${WORKDIR}/yolo-${YOLO_RELEASE}-yolo$weight.weights ${S}/yolo_network_config/weights/yolo$weight.weights
    done
}
