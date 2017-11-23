DESCRIPTION = "sound_play provides a ROS node that translates commands on a ROS topic \
(<tt>robotsound</tt>) into sounds. The node supports built-in sounds, playing OGG/WAV files, \
and doing speech synthesis via festival. C++ and Python bindings allow this node to be used \
without understanding the details of the message format, allowing faster development and \
resilience to message format changes."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=a3ae2ba3f0f44e61270955e8cd98afcf"

DEPENDS = "roscpp roslib audio-common-msgs diagnostic-msgs"

require audio-common.inc

SRC_URI += "file://0002-sound_play-Fix-build-with-DCATKIN_ENABLE_TESTING-OFF.patch;striplevel=2"

RRECOMMENDS_${PN} += "roscpp roslib audio-common-msgs diagnostic-msgs gst-plugins-base gst-plugins-ugly gst-plugins-good rospy festival python-gst gst-meta-audio"
