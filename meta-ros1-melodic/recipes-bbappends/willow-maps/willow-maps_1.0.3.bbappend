# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fix-build-without-catkin-testing-enab.patch"

# It's using catkin_download_test_data to fetch the
# data for installation during do_compile and
# catkin_download_test_data isn't enabled because
# CATKIN_ENABLE_TESTING is disabled for our build
# fetch it manually
# catkin_download_test_data(download_data_willow-willow-full-0.025.pgm http://download.ros.org/data/maps/willow-full-0.025.pgm FILENAME willow-full-0.025.pgm MD5 e66b17ee374f2d7657972efcb3e2e4f7)
# catkin_download_test_data(download_data_willow-willow-full-0.05.pgm http://download.ros.org/data/maps/willow-full-0.05.pgm FILENAME willow-full-0.05.pgm  MD5 b61694296e08965096c5e78611fd9765)
# catkin_download_test_data(download_data_willow-willow-full-0.10.pgm http://download.ros.org/data/maps/willow-full-0.10.pgm FILENAME willow-full-0.10.pgm MD5 b84465cdbbfe3e2fb9eb4579e0bcaf0e)
# catkin_download_test_data(download_data_willow-willow-sans-whitelab-0.025.pgm http://download.ros.org/data/maps/willow-sans-whitelab-0.025.pgm FILENAME willow-sans-whitelab-0.025.pgm  MD5 dce0081e83a9e2eb8b29c51c8cd3ffac)
# catkin_download_test_data(download_data_willow-willow.tmap http://download.ros.org/data/maps/willow.tmap FILENAME willow.tmap MD5 48864073990c66173dade2bfcae5669d)
SRC_URI_MAPS = "http://download.ros.org/data/maps"
SRC_URI += "\
    ${SRC_URI_MAPS}/willow-full-0.025.pgm;name=willow-full-0.025.pgm \
    ${SRC_URI_MAPS}/willow-full-0.05.pgm;name=willow-full-0.05.pgm \
    ${SRC_URI_MAPS}/willow-full-0.10.pgm;name=willow-full-0.10.pgm \
    ${SRC_URI_MAPS}/willow-sans-whitelab-0.025.pgm;name=willow-sans-whitelab-0.025.pgm \
    ${SRC_URI_MAPS}/willow.tmap;name=willow.tmap \
"

SRC_URI[willow-full-0.025.pgm.md5sum] = "e66b17ee374f2d7657972efcb3e2e4f7"
SRC_URI[willow-full-0.025.pgm.sha256sum] = "85f2e436ff794e1f6313f6d21ab61ec8e210abb2d3c4c9c017406930a13891e1"
SRC_URI[willow-full-0.05.pgm.md5sum] = "b61694296e08965096c5e78611fd9765"
SRC_URI[willow-full-0.05.pgm.sha256sum] = "ccbc0d8240fad4c430b6d094e2ba9ad058fb7f51a8a646f77f1eda22e4dd9753"
SRC_URI[willow-full-0.10.pgm.md5sum] = "b84465cdbbfe3e2fb9eb4579e0bcaf0e"
SRC_URI[willow-full-0.10.pgm.sha256sum] = "78c859cb6649952f7b02e447712f941ac24ea51ed1572c2c4dd4ff233f49e893"
SRC_URI[willow-sans-whitelab-0.025.pgm.md5sum] = "dce0081e83a9e2eb8b29c51c8cd3ffac"
SRC_URI[willow-sans-whitelab-0.025.pgm.sha256sum] = "65fa7a94b68d46a18577a0761f5ccf19134409b3e47bc69dfd2c369d8bc56ca4"
SRC_URI[willow.tmap.md5sum] = "48864073990c66173dade2bfcae5669d"
SRC_URI[willow.tmap.sha256sum] = "f3dcc1c37e98c4227fb9296501bbe7a79fe64a6bea1f2f05168aa8d7d38f9706"

do_install_prepend() {
    install -m0644 ${WORKDIR}/*.pgm ${WORKDIR}/*.tmap ${B}
}
