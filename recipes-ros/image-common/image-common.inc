SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "521131894d5913b517a1dc0df77609c5"
SRC_URI[sha256sum] = "7268c166edcd6c74d618c8a2b9bc33bd41725afeced12c5e727b590fd81433ee"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_common"
