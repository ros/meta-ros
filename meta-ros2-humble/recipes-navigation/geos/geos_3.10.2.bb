include geos.inc

SRC_URI = "git://github.com/libgeos/geos.git;protocol=https;branch=3.10"

S = "${WORKDIR}/git"

# Matching 3.10.2 in Ubuntu Jammy
SRCREV = "165ec2cb1ea14471f160d89651240e7dee57a66c"
