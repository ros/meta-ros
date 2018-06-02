DESCRIPTION = "ros2-demos package group"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS_${PN} = "\
        ros2-demo-nodes-cpp \
        ros2run \
        ros2topic \
"
