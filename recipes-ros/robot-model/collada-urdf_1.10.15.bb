DESCRIPTION = "This package contains a tool to convert Unified Robot Description Format (URDF) documents into COLLAborative Design Activity (COLLADA) documents."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=68b329da9893e34099c7d8ad5cb9c940"

DEPENDS = "angles assimp resource-retriever collada-dom collada-parser roscpp urdf geometric-shapes"

require robot-model.inc

SRC_URI += "file://0001-collada-urdf-CMakeLists-fix.patch;striplevel=2"
