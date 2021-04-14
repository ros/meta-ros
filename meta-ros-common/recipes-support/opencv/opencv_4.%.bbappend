# Copyright (c) 2021 LG Electronics, Inc.

# required by meta-ros1-noetic/generated-recipes/dnn-detect/dnn-detect_0.1.0-1.bb
PACKAGECONFIG_append = " dnn"

# backport fixes from:
# https://lists.openembedded.org/g/openembedded-devel/message/90807
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-sfm-link-with-Glog_LIBS.patch;patchdir=../contrib"

# and
# https://lists.openembedded.org/g/openembedded-devel/message/90808
SRCREV_wechat-qrcode = "a8b69ccc738421293254aec5ddb38bd523503252"
SRC_URI += "git://github.com/WeChatCV/opencv_3rdparty.git;branch=wechat_qrcode;destsuffix=wechat_qrcode;name=wechat-qrcode"
do_unpack_extra_append() {
    cache wechat_qrcode ${WORKDIR}/wechat_qrcode/*.caffemodel
    cache wechat_qrcode ${WORKDIR}/wechat_qrcode/*.prototxt
}
