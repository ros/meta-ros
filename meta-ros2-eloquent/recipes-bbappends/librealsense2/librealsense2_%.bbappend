# Copyright (c) 2020-2021 LG Electronics, Inc.

# ERROR: librealsense2-2.38.1-4-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package contains symlink .so: librealsense2 path '/work/core2-64-oe-linux/librealsense2/2.38.1-4-r0/packages-split/librealsense2/usr/lib/librealsense2.so' [dev-so]
inherit ros_insane_dev_so

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI_FW = "http://realsense-hw-public.s3.amazonaws.com/Releases"
SRC_URI += " \
    file://0001-common-fw-CMakeLists.txt-respect-_FW_URL-when-set.patch \
    ${SRC_URI_FW}/RS4xx/FW/D4XX_FW_Image-5.12.7.100.bin;name=D4XX_FW \
    ${SRC_URI_FW}/SR300/FW/SR3XX_FW_Image-3.26.1.0.bin;name=SR3XX_FW \
    ${SRC_URI_FW}/TM2/FW/target/0.2.0.951/target-0.2.0.951.mvcmd;name=T26X_FW \
    ${SRC_URI_FW}/L5xx/FW/L5XX_FW_Image-1.5.0.0.bin;name=L5XX_FW \
"

SRC_URI[D4XX_FW.sha256sum] = "f6a06019a59b963c6e53a5299af49a4e375989866587c20c17d432b689679b50"
SRC_URI[SR3XX_FW.sha256sum] = "c4ac2144df13c3a64fca9d16c175595c903e6e45f02f0f238630a223b07c14d1"
SRC_URI[T26X_FW.sha256sum] = "0265fd111611908b822cdaf4a3fe5b631c50539b2805d2f364c498aa71c007c0"
SRC_URI[L5XX_FW.sha256sum] = "0266d63992ce461a087293b0e87cd0bf79e404854c08aa612781db73419de5a8"

EXTRA_OECMAKE += " \
  -DD4XX_FW_URL=file://${WORKDIR} \
  -DSR3XX_FW_URL=file://${WORKDIR} \
  -DT26X_FW_URL=file://${WORKDIR} \
  -DL5XX_FW_URL=file://${WORKDIR} \
"
