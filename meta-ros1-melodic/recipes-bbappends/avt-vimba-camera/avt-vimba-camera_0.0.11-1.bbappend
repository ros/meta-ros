# Copyright (c) 2020 LG Electronics, Inc.

# Contains couple prebuilt binaries which weren't built with GNU_HASH
# ./lib/arm_64bit/libVimbaC.so
# ./lib/arm_64bit/libVimbaCPP.so
# ./lib/arm_32bit/libVimbaC.so
# ./lib/arm_32bit/libVimbaCPP.so
# ./lib/64bit/libVimbaC.so
# ./lib/64bit/libVimbaCPP.so
# ./lib/32bit/libVimbaC.so
# ./lib/32bit/libVimbaCPP.so
# causing:
# ERROR: avt-vimba-camera-0.0.11-1-r0 do_package_qa: QA Issue: No GNU_HASH in the ELF binary /jenkins/mjansa/build-ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/avt-vimba-camera/0.0.11-1-r0/packages-split/avt-vimba-camera/usr/opt/ros/melodic/lib/libVimbaC.so, didn't pass LDFLAGS? [ldflags]
INSANE_SKIP_${PN} += "ldflags"
