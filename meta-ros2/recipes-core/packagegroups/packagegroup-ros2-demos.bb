DESCRIPTION = "ros2-demos package group"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS_${PN} = "\
        demo-nodes-cpp \
        ros2run \
        ros2topic \
"
