DESCRIPTION = "A small image just capable of starting roscore."

IMAGE_INSTALL = "packagegroup-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE = "8192"

# add own name to hosts
# this is a simplistic setup for the qemu virtual machine with x86 architecture,
# and not a general solution.
augment_hosts_setting_file () {
	echo '127.0.0.1\tqemux86.localdomain\t\tqemux86' >> ${IMAGE_ROOTFS}/etc/hosts
}

# remove not needed ipkg informations
# create a custom hosts file
ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files ; augment_hosts_setting_file ; "

IMAGE_INSTALL += "packagegroup-core-ssh-openssh \
  roslaunch \
"
