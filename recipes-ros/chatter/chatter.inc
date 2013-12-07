SRC_URI = "https://github.com/bmwcarit/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c26fdc13d96d1b65d0c1e03b41572550"
SRC_URI[sha256sum] = "b18f8a08fe8bdc4d7a89ee9ab15892348c25d508dad1bed87e795805506f315f"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_chatter"
