# Backport https://lists.openembedded.org/g/openembedded-core/message/144297
PACKAGECONFIG[opengl] = "-DENABLE_GRAPHICS_CONTEXT_GL=ON,-DENABLE_GRAPHICS_CONTEXT_GL=OFF,virtual/libgl"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://include_xutil.patch"
