SRC_URI = "https://github.com/orocos/${SPN}/archive/v${PV}.tar.gz;downloadfilename=${SPN}-${PV}.tar.gz"
SRC_URI[md5sum] = "710b6ab202cc062d1ad08afde9c9b21a"
SRC_URI[sha256sum] = "b35c3264ccbbde5b5dbb562cbca6cab5b69f30ebfb8d347314d844e084d037ef"

S = "${WORKDIR}/${SPN}-${PV}/${@d.getVar('BPN', True).replace('-', '_')}"

inherit cmake

SPN = "orocos_kinematics_dynamics"
