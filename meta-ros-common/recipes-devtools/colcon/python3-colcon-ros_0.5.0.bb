
SUMMARY = "Extension for colcon to support ROS packages."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.cfg;beginline=22;endline=22;md5=3d0bd1ac53c1dd582844ed15eee7f8e2"

SRC_URI[sha256sum] = "79a7e89f6fa636f7e4fd44a88b7860fb1da99d51f0ba7bcf0b9b624a1a578365"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-catkin-pkg \
    python3-colcon-cmake \
    python3-colcon-core \
    python3-colcon-pkg-config \
    python3-colcon-python-setup-py \
    python3-colcon-recursive-crawl \
"

BBCLASSEXTEND += "nativesdk"
