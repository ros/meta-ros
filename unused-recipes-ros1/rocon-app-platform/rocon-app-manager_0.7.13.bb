DESCRIPTION = "The public interface and retaskable interface for a robot."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "roslint"

require rocon-app-platform.inc

RDEPENDS_${PN} = "capabilities gateway-msgs rocon-app-manager-msgs rocon-app-utilities \
  rocon-apps rocon-console rocon-gateway-utils rocon-gateway rocon-hub rocon-interactions \
  rocon-master-info rocon-python-comms rocon-python-utils rocon-std-msgs rocon-uri \
  roslib rosmaster rospy std-msgs"
