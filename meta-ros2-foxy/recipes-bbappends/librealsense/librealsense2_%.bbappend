# Copyright (c) 2020 LG Electronics, Inc.

# virtual/kernel is only for build time dependencies
ROS_EXEC_DEPENDS_remove = "virtual/kernel"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI_FW = "http://realsense-hw-public.s3.amazonaws.com/Releases"
SRC_URI += " \
    ${SRC_URI_FW}/RS4xx/FW/D4XX_FW_Image-5.12.3.0.bin;name=D4XX_FW \
    ${SRC_URI_FW}/RS4xx/FW/D4XX_RC_Image-5.12.3.0.bin;name=D4XX_RC \
    ${SRC_URI_FW}/SR300/FW/SR3XX_FW_Image-3.26.1.0.bin;name=SR3XX_FW \
    ${SRC_URI_FW}/TM2/FW/target/0.2.0.926/target-0.2.0.926.mvcmd;name=T26X_FW \
    file://0001-common-fw-CMakeLists.txt-respect-_FW_URL-when-set.patch \
    file://0001-CMakeLists.txt-Don-t-include-CMake-install_config.cm.patch \
"

SRC_URI[D4XX_FW.sha256sum] = "da0dea7df616ac4605b70b957288919d4792cd87bcb20d7fd262e2ec09131d8e"
SRC_URI[D4XX_RC.sha256sum] = "da0dea7df616ac4605b70b957288919d4792cd87bcb20d7fd262e2ec09131d8e"
SRC_URI[SR3XX_FW.sha256sum] = "c4ac2144df13c3a64fca9d16c175595c903e6e45f02f0f238630a223b07c14d1"
SRC_URI[T26X_FW.sha256sum] = "b27f23bf8072dd4b3779db6917cae2defa25267f72c03a4055b8398802b8ab94"

EXTRA_OECMAKE += " \
  -DD4XX_FW_URL=file://${WORKDIR} \
  -DD4XX_RC_URL=file://${WORKDIR} \
  -DSR3XX_FW_URL=file://${WORKDIR} \
  -DT26X_FW_URL=file://${WORKDIR} \
"

# ERROR: librealsense2-2.34.0-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package contains symlink .so: librealsense2 path '/work/core2-64-oe-linux/librealsense2/2.34.0-1-r0/packages-split/librealsense2/usr/lib/librealsense2-gl.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: librealsense2 path '/work/core2-64-oe-linux/librealsense2/2.34.0-1-r0/packages-split/librealsense2/usr/lib/librealsense2.so' [dev-so]
inherit ros_insane_dev_so
