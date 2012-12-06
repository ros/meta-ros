DESCRIPTION = "A small image just capable of allowing a device to boot."

IMAGE_INSTALL = "packagegroup-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "CLOSED"

inherit core-image

IMAGE_ROOTFS_EXTRA_SPACE = "524288"

# remove not needed ipkg informations
ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files ; "

IMAGE_INSTALL += "boost boost-dev packagegroup-core-ssh-openssh dhcp-client file ldd python-modules python-setuptools python-rospkg python-rospkg-dev python-rosinstall git cmake python-empy python-pyyaml python-nose log4cxx log4cxx-dev libbz2-dev"
