DESCRIPTION = "This package contains a tool to convert Unified Robot Description Format (URDF) documents into COLLAborative Design Activity (COLLADA) documents."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "angles assimp resource-retriever collada-dom collada-parser roscpp urdf geometric-shapes tf"

require robot-model.inc

do_configure_append() {
	for f in collada_urdf.dir collada_to_urdf.dir urdf_to_collada.dir
	do 
	sed -i -e 's: /usr/lib/liboctomap.so: ${STAGING_LIBDIR}/liboctomap.so:g' \
	  -e 's: /usr/lib/liboctomath.so: ${STAGING_LIBDIR}/liboctomath.so:g' \
	  ${B}/CMakeFiles/$f/build.make
	done
}
