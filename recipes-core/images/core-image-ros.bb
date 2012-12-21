DESCRIPTION = "A small image just capable of allowing a device to boot."

IMAGE_INSTALL = "packagegroup-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "CLOSED"

inherit core-image

IMAGE_ROOTFS_EXTRA_SPACE = "524288"

IMAGE_FEATURES += "tools-sdk"

# add own name to hosts
augment_hosts_setting_file () {
	echo '127.0.0.1\tqemux86-64.localdomain\t\tqemux86-64' >> ${IMAGE_ROOTFS}/etc/hosts
}

# remove not needed ipkg informations
# create a custom hosts file
ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files ; augment_hosts_setting_file ; "

IMAGE_INSTALL += "packagegroup-core-ssh-openssh git cmake \
  boost boost-dev log4cxx log4cxx-dev libbz2-dev \
  python-modules python-empy python-pyyaml python-nose \
  python-setuptools python-rospkg python-dateutil python-vcstools python-rosinstall"
