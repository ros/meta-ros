# Copyright (c) 2020 LG Electronics, Inc.

# Backport fix from newer meta-oe, because robot-upstart has runtime dependency on daemontools:
# generated-recipes/robot-upstart/robot-upstart_0.3.0.bb:    ${ROS_UNRESOLVED_PLATFORM_PKG_daemontools}
# so it pulls it into the *-world image causing following error:
# update-alternatives: Error: not linking webos-melodic-zeus/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/webos-image-ros-world/1.0-r3/rootfs/usr/bin/svc to /usr/bin/busybox.nosuid since webos-melodic-zeus/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/webos-image-ros-world/1.0-r3/rootfs/usr/bin/svc exists and is not a link
# update-alternatives: Error: not linking webos-melodic-zeus/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/webos-image-ros-world/1.0-r3/rootfs/usr/bin/svok to /usr/bin/busybox.nosuid since webos-melodic-zeus/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/webos-image-ros-world/1.0-r3/rootfs/usr/bin/svok exists and is not a link
# which is fatal for read-only images:
# WARNING: webos-image-ros-world-1.0-r3 do_rootfs: busybox.postinst returned 1, marking as unpacked only, configuration required on target.
# ERROR: webos-image-ros-world-1.0-r3 do_rootfs: Postinstall scriptlets of ['busybox'] have failed. If the intention is to defer them to first boot,
# then please place them into pkg_postinst_ontarget_${PN} ().
# Deferring to first boot via 'exit 1' is no longer supported.
# Details of the failure are in webos-melodic-zeus/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/webos-image-ros-world/1.0-r3/temp/log.do_rootfs.
# ERROR: Logfile of failure stored in: webos-melodic-zeus/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/webos-image-ros-world/1.0-r3/temp/log.do_rootfs.6260
inherit update-alternatives
ALTERNATIVE_PRIORITY = "100"
ALTERNATIVE_${PN} = "svc svok"
