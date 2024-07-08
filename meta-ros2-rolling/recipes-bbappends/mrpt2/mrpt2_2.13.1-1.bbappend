# Copyright (c) 2024 Wind River Systems, Inc.

inherit pkgconfig

# See package.xml: "Required for cmake scripts to find ament_cmake and
# then realize we are in ROS 2, not ROS 1"
ROS_BUILD_TYPE = "ament_cmake"
inherit ros_${ROS_BUILD_TYPE}

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://no-cmake-find-root-path-for-nanogui-ttf.patch \
            file://set-cmake-toolchain-file-for-nanoflann.patch \
            file://add-prefix-to-hwdrivers-isystem.patch \
            file://move-dtor-to-its-proper-translation-unit.patch \
"

# Remove the suitesparse libraries from the generated recipe
# This is necessary to use the package's internal copy of CSparse
ROS_BUILD_DEPENDS:remove = "suitesparse-cholmod"
ROS_BUILD_DEPENDS:remove = "suitesparse-cxsparse"
ROS_EXPORT_DEPENDS:remove = "suitesparse-cholmod"
ROS_EXPORT_DEPENDS:remove = "suitesparse-cxsparse"
ROS_EXEC_DEPENDS:remove = "suitesparse-cholmod"
ROS_EXEC_DEPENDS:remove = "suitesparse-cxsparse"

# ament-package-native
#   do_configure: ModuleNotFoundError: No module named 'ament_package.templates'
# wx-widgets-native
#   needed for wx-config in cmakemodules/script_wxwidgets.cmake
ROS_BUILDTOOL_DEPENDS += " \
    ament-package-native \
    wxwidgets-native \
"

export VERBOSE="1"

ROS_BUILD_DEPENDS += " \
    ament-cmake-libraries \
    ament-cmake-export-definitions \
    ament-cmake-export-include-directories \
    ament-cmake-export-interfaces \
    ament-cmake-export-libraries \
    ament-cmake-export-link-flags \
    ament-cmake-export-interfaces \
    ament-cmake-export-targets \
    ament-cmake-gen-version-h \
    ament-cmake-include-directories \
    ament-cmake-python \
    ament-cmake-target-dependencies \
    ament-cmake-test \
    ament-cmake-version \ 
    octomap \
    rosidl-typesupport-c \
    rosidl-typesupport-cpp \
    rosidl-typesupport-fastrtps-c \
    rosidl-typesupport-fastrtps-cpp \
    rosidl-typesupport-introspection-cpp \
"

FILES:${PN}-dev =+ "${ros_libdir}/lib*${SOLIBSDEV}"
