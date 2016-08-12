DESCRIPTION = "MAVLink message marshaling library"
DEPENDS = ""
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=54ad3cbe91bebcf6b1823970ff1fb97f"

SRC_URI = "https://github.com/mavlink/mavlink-gbp-release/archive/release/indigo/${PN}/${PV}-0.tar.gz"
SRC_URI[md5sum] = "f4a33b867010e1df83240c201bb28a35"
SRC_URI[sha256sum] = "20afe71b71f851a68dd9f467959635a9a1239aaaa16837b790d3b13913c52d52"

S = "${WORKDIR}/mavlink-gbp-release-release-indigo-${PN}-${PV}-0"

inherit catkin




