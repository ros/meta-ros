# Copyright (c) 2024 Wind River Systems, Inc.
SUMMARY = "Classes and functions for robot applications"
DESCRIPTION = "Gazebo Utils, a component of Gazebo, provides general purpose classes and functions designed for robotic applications."
HOMEPAGE = "https://gazebosim.org/libs/utils/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "\
    file://LICENSE;md5=388d6baacb3a7c79a82bd82a679c65f3 \
    file://cli/LICENSE;md5=b73927b18d5c6cd8d2ed28a6ad539733"

DEPENDS = "gz-cmake5 spdlog"

SRC_URI = "git://github.com/gazebosim/gz-utils.git;protocol=https;branch=${BPN}"

SRCREV = "27bc661ba65a9274e232ce3ff38b92efad27138e"

inherit cmake

BBCLASSEXTEND = "native nativesdk"
