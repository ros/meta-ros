LICENSE = "LGPL-2.1-only & WxWindows-exception-3.1 & GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=1997b5e8aad6beab407654a49b4ac50c \
                    file://src/osgPlugins/3ds/lib3ds/COPYING;md5=94d55d512a9ba36caa9b7df079bae19f \
                    file://src/osgPlugins/lwo/COPYING;md5=dcf3c825659e82539645da41a7908589 \
                    file://src/osgPlugins/x/LICENSE;md5=84e0bc9b7ca6053d5e8c673021069d2a"

SRC_URI = "git://github.com/openscenegraph/OpenSceneGraph.git;protocol=https;branch=OpenSceneGraph-3.6"

# Modify these as desired
PV = "3.6.5+git${SRCPV}"
SRCREV = "a827840baf0786d72e11ac16d5338a4ee25779db"

S = "${WORKDIR}/git"

# NOTE: unable to map the following CMake package dependencies: QTKit LIBLAS CoreVideo QuartzCore DirectInput ZeroConf FLTK OpenCascade Lua52 Inventor COLLADA Asio DCMTK GDAL FOX ilmbase GTA Lua51 Poppler-glib AVFoundation QuickTime wxWidgets OpenEXR DirectShow GLCORE RSVG NVTT Jasper GtkGl FBX CoreMedia LibVNCServer FFmpeg OSGCORE GIFLIB GStreamer
DEPENDS = "jpeg zlib tiff virtual/egl libpng glib-2.0 virtual/libgl curl libsdl libsdl2 freetype libx11"

inherit cmake

EXTRA_OECMAKE += " -D_OPENTHREADS_ATOMIC_USE_GCC_BUILTINS_EXITCODE=0 -D_OPENTHREADS_ATOMIC_USE_GCC_BUILTINS_EXITCODE__TRYRUN_OUTPUT=0"

FILES:${PN} += "${libdir}/osgPlugins-3.6.5/osgdb_*.so"
