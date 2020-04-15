DESCRIPTION = "Fast Library for Approximate Nearest Neighbors"
AUTHOR = "Marius Muja and David G. Lowe"
HOMEPAGE = "http://www.cs.ubc.ca/~mariusm/index.php/FLANN/FLANN"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=395adad2339bd9ce5fef13d564a9681c"

SRCREV = "06a49513138009d19a1f4e0ace67fbff13270c69"
ROS_BRANCH ?= "branch=master"
SRC_URI = "git://github.com/mariusmuja/flann;${ROS_BRANCH};protocol=https"

S = "${WORKDIR}/git"

inherit cmake

# Prevent it finding python
EXTRA_OECMAKE += "-UPYTHON_EXECUTABLE"

SRC_URI += "file://0001-Use-object-libraries-instead-of-empty-file-list-in-C.patch"
