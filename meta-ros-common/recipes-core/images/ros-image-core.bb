require ros-image-minimal.bb

SUMMARY = "A small image just capable of starting core ROS."
DESCRIPTION = "Extends ros-image-minimal with standard Linux tools normally in Ubuntu Server that are used by ROS."

CORE_IMAGE_EXTRA_INSTALL += "\
    bash \
    "

