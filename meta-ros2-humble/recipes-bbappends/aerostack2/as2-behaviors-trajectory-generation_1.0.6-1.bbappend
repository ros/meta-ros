# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
  file://add-geographiclib-find-package.patch \
  file://add-dynamic-trajectory-generator.patch \
  file://add-project-dependencies.patch \
"

DEPENDS += "dynamic-trajectory-generator"

EXTRA_OECMAKE += " \
    -DDYNAMIC_TRAJECTORY_GENERATOR_INCLUDE_DIRS=${STAGING_INCDIR}/dynamic_trajectory_generator \
    -DDYNAMIC_TRAJECTORY_GENERATOR_LIBRARY=${STAGING_LIBDIR}/libdynamic_trajectory_generator.a \
    -DMAV_TRAJECTORY_GENERATION_LIBRARY=${STAGING_LIBDIR}/libmav_trajectory_generation.a \
"
