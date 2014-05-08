SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "253985d33cf4e1ca745bdeeab79cbde3"
SRC_URI[sha256sum] = "9053c54762e22e90590c93fddfcd5d38214d3e5af1b7301aa7bdb7e21b82025c"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "diagnostics"
