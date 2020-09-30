SUMMARY = "Python library that provides an easy interface to read and write a wide range of image data, including animated images, video, volumetric data, and scientific formats."

LICENSE = "PIL"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c6379001ecb47e2a0420c40177fc1125"

DEPENDS = "jpeg zlib tiff freetype libpng jpeg"

inherit pkgconfig

inherit ${@bb.utils.contains("BBFILE_COLLECTIONS", "meta-python2", "setuptools", "", d)}

python() {
    if 'meta-python2' not in d.getVar('BBFILE_COLLECTIONS').split():
        raise bb.parse.SkipRecipe('Requires meta-python2 to be present.')
}

SRCREV = "fda33d5c09142c4bb0e99964919d01c2cc5f5995"
SRC_URI = "git://github.com/python-pillow/Pillow;protocol=https \
           file://0001-build-always-disable-platform-guessing.patch \
          "


S = "${WORKDIR}/git"

# Yes, both this and the export in do_compile_prepend are needed :/
CFLAGS_append = " -I${STAGING_INCDIR}"
LDFLAGS_append = " -L${STAGING_LIBDIR}"

do_compile_prepend() {
    export LDFLAGS="$LDFLAGS -L${STAGING_LIBDIR}"
    export CFLAGS="$CFLAGS -I${STAGING_INCDIR}"
}
