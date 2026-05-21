# Copyright (c) 2024 Wind River Systems, Inc.

ROS_BUILD_DEPENDS += "\
    protobuf \
    qtdeclarative \
"

ROS_BUILDTOOL_DEPENDS += "\
    protobuf-native \
    qtdeclarative-native \
"

EXTRA_OECMAKE += "\
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"

# This resolves the following error:
#   To use a cross-compiled Qt, please set the QT_HOST_PATH cache variable to
#   the location of your host Qt installation.
inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt6-layer', 'qt6-cmake', '', d)}
