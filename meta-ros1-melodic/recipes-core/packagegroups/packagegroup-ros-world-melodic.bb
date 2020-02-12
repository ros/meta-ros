# Copyright (c) 2019-2020 LG Electronics, Inc.

DESCRIPTION = "All non-test packages for the target from files/crystal/cache.yaml"
LICENSE = "MIT"

inherit packagegroup
inherit ros_distro_melodic

PACKAGES = "${PN}"

RDEPENDS_${PN} = "${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES}"

# Requires Python 3; it is not used by any other ROS 1 package.
RDEPENDS_${PN}_remove = "catkin-virtualenv"

# It is a fork of https://github.com/google/flatbuffers that's not used by any other ROS 1 package.
RDEPENDS_${PN}_remove = "flatbuffers"

# It is a "catkin-ized" edition of the upstream version that is not used by any other ROS 1 package.
RDEPENDS_${PN}_remove = "grpc"

# It has a dependency on rosparam_handler for which there isn't an entry in melodic-cache.yaml nor base.yaml nor python.yaml nor ruby.yaml; it is not used by any other ROS 1 package.
RDEPENDS_${PN}_remove = "iirob-filters"

# It is a "catkin-ized" edition of the upstream version that is not used by any other ROS 1 package.
RDEPENDS_${PN}_remove = "nanomsg"

# It has dependencies on Qt4 packages; it is not used by any other ROS 1 package.
RDEPENDS_${PN}_remove = "octovis"

# Generation of ROS package documentation will never be done on the target.
RDEPENDS_${PN}_remove = "rosdoc-lite"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT5}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT5 = " \
    adi-driver \
    agni-tf-tools \
    ainstein-radar \
    ainstein-radar-rviz-plugins \
    asmach-tutorials \
    cartographer-rviz \
    cis-camera \
    cob-command-tools \
    cob-dashboard \
    cob-manipulation \
    common-tutorials \
    dataspeed-pds-rqt \
    desktop \
    desktop-full \
    distance-map \
    distance-map-rviz \
    dynamixel-workbench \
    dynamixel-workbench-single-manager-gui \
    fetch-gazebo-demo \
    fetch-simulation \
    find-object-2d \
    fkie-potree-rviz-plugin \
    fmi-adapter-examples \
    franka-example-controllers \
    franka-ros \
    fsrobo-r \
    fsrobo-r-bringup \
    fsrobo-r-moveit-config \
    geometry-tutorials \
    gl-dependency \
    grid-map \
    grid-map-demos \
    grid-map-rviz-plugin \
    gundam-robot \
    gundam-rx78-control \
    husky-desktop \
    husky-viz \
    imagesift \
    imu-tools \
    jackal-desktop \
    jackal-viz \
    jsk-common \
    jsk-data \
    jsk-interactive \
    jsk-interactive-marker \
    jsk-interactive-test \
    jsk-pcl-ros \
    jsk-pcl-ros-utils \
    jsk-perception \
    jsk-recognition \
    jsk-recognition-utils \
    jsk-rqt-plugins \
    jsk-rviz-plugins \
    jsk-tools \
    jsk-visualization \
    kvh-geo-fog-3d \
    kvh-geo-fog-3d-rviz \
    libqt-concurrent \
    libqt-core \
    libqt-gui \
    libqt-opengl \
    libqt-opengl-rosdev \
    libqt-rosdev \
    libqt-svg-rosdev \
    libqt-network \
    libqt-widgets \
    librviz-tutorial \
    linux-networking \
    lvr2 \
    mapviz \
    mapviz-plugins \
    mir-gazebo \
    mir-robot \
    moveit \
    moveit-ros \
    moveit-ros-visualization \
    moveit-setup-assistant \
    mrpt-bridge \
    multi-map-server \
    multimaster-fkie \
    multires-image \
    neonavigation \
    neonavigation-launch \
    neonavigation-rviz-plugins \
    node-manager-fkie \
    octomap-rviz-plugins \
    open-manipulator \
    open-manipulator-control-gui \
    open-manipulator-with-tb3 \
    panda-moveit-config \
    pilz-robots \
    plotjuggler \
    pr2eus-tutorials \
    prbt-gazebo \
    prbt-grippers \
    prbt-moveit-config \
    prbt-pg70-support \
    python-qt-binding \
    qt-dotgraph \
    qt-gui \
    qt-gui-app \
    qt-gui-core \
    qt-gui-cpp \
    qt-gui-py-common \
    qt-qmake \
    rc-cloud-accumulator \
    ridgeback-desktop \
    ridgeback-viz \
    ros-controllers \
    ros-tutorials \
    rosbag-editor \
    rosmon \
    rqt \
    rqt-action \
    rqt-bag \
    rqt-bag-plugins \
    rqt-common-plugins \
    rqt-console \
    rqt-controller-manager \
    rqt-dep \
    rqt-drone-teleop \
    rqt-ez-publisher \
    rqt-graph \
    rqt-gui \
    rqt-gui-cpp \
    rqt-gui-py \
    rqt-image-view \
    rqt-joint-trajectory-controller \
    rqt-launch \
    rqt-launchtree \
    rqt-logger-level \
    rqt-moveit \
    rqt-msg \
    rqt-multiplot \
    rqt-nav-view \
    rqt-plot \
    rqt-pose-view \
    rqt-publisher \
    rqt-py-common \
    rqt-py-console \
    rqt-py-trees \
    rqt-reconfigure \
    rqt-robot-dashboard \
    rqt-robot-monitor \
    rqt-robot-plugins \
    rqt-robot-steering \
    rqt-rosmon \
    rqt-rotors \
    rqt-runtime-monitor \
    rqt-rviz \
    rqt-service-caller \
    rqt-shell \
    rqt-srv \
    rqt-tf-tree \
    rqt-top \
    rqt-topic \
    rqt-web \
    rtabmap-ros \
    rviz \
    rviz-imu-plugin \
    rviz-plugin-tutorials \
    rviz-python-tutorial \
    rviz-visual-tools \
    seed-r7-bringup \
    seed-r7-moveit-config \
    seed-r7-ros-pkg \
    seed-r7-samples \
    seed-r7-typef-moveit-config \
    sick-safetyscanners \
    simple-grasping \
    slam-toolbox \
    swri-console \
    swri-profiler-tools \
    tile-map \
    towr-ros \
    trajectory-tracker-rviz-plugins \
    turtle-actionlib \
    turtle-tf \
    turtle-tf2 \
    turtlesim \
    turtlesim-dash-tutorial \
    urdf-sim-tutorial \
    urdf-tutorial \
    visualization-tutorials \
    visualstates \
    viz \
    warthog-desktop \
    warthog-viz \
    webkit-dependency \
"

# OE won't let us build ffmpeg unless LICENSE_FLAGS_WHITELIST contains "commerical".
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ffmpeg', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FFMPEG}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FFMPEG = " \
    codec-image-transport \
    h264-encoder-core \
    h264-video-encoder \
    movie-publisher \
    mrpt1 \
    mrpt-bridge \
    mrpt-ekf-slam-2d \
    mrpt-ekf-slam-3d \
    mrpt-graphslam-2d \
    mrpt-icp-slam-2d \
    mrpt-local-obstacles \
    mrpt-localization \
    mrpt-map \
    mrpt-navigation \
    mrpt-rawlog \
    mrpt-rbpf-slam \
    mrpt-reactivenav2d \
    mrpt-slam \
    mvsim \
    parrot-arsdk \
    pose-cov-ops \
    rospilot \
    usb-cam \
    web-video-server \
"

# OE won't let us build gstreamer1.0-plugins-ugly unless LICENSE_FLAGS_WHITELIST contains "commerical".
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gst-ugly', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GSTREAMER1.0_PLUGINS_UGLY}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GSTREAMER1.0_PLUGINS_UGLY = " \
    audio-capture \
    audio-common \
    audio-play \
    jsk-3rdparty \
    jsk-pr2eus \
    jsk-topic-tools \
    julius-ros \
    pr2eus \
    pr2eus-moveit \
    resized-image-transport \
    ros-speech-recognition \
    sound-play \
    tts \
    voice-text \
"

# NB. gazebo-msgs is a dependency of non-Gazebo packages, so it doesn't appear here.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GAZEBO}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GAZEBO = " \
    ainstein-radar-gazebo-plugins \
    audibot \
    audibot-gazebo \
    blender-gazebo \
    cob-common \
    cob-description \
    cob-gazebo-objects \
    cob-gazebo-plugins \
    cob-gazebo-ros-control \
    cob-gazebo-worlds \
    cob-grasp-generation \
    cob-hardware-config \
    desistek-saga-control \
    desistek-saga-description \
    desistek-saga-gazebo \
    eca-a9-description \
    eca-a9-gazebo \
    eusurdf \
    fetch-gazebo \
    fetchit-challenge \
    fsrobo-r-description \
    gazebo-plugins \
    gazebo-ros \
    gazebo-ros-control \
    gazebo-ros-pkgs \
    gazebo-rosdev \
    hector-gazebo \
    hector-gazebo-plugins \
    hector-gazebo-thermal-camera \
    hector-gazebo-worlds \
    hector-sensors-gazebo \
    husky-gazebo \
    husky-simulator \
    igvc-self-drive-description \
    igvc-self-drive-gazebo \
    igvc-self-drive-gazebo-plugins \
    igvc-self-drive-sim \
    jackal-gazebo \
    jackal-simulator \
    ksql-airport \
    lauv-control \
    lauv-description \
    lauv-gazebo \
    mcmillan-airfield \
    mecanum-gazebo-plugin \
    mir-description \
    mir-driver \
    mir-navigation \
    nmea-gps-plugin \
    open-manipulator-gazebo \
    open-manipulator-simulations \
    open-manipulator-with-tb3-gazebo \
    open-manipulator-with-tb3-simulations \
    pr2-controller-configuration-gazebo \
    pr2-gazebo \
    pr2-gazebo-plugins \
    pr2-simulator \
    raw-description \
    rexrov2-control \
    rexrov2-description \
    rexrov2-gazebo \
    ridgeback-gazebo \
    ridgeback-gazebo-plugins \
    ridgeback-simulator \
    rotors-gazebo \
    rotors-gazebo-plugins \
    rotors-simulator \
    sand-island \
    turtlebot3-gazebo \
    turtlebot3-simulations \
    urdf-sim-tutorial \
    usv-gazebo-plugins \
    uuv-descriptions \
    uuv-gazebo-plugins \
    uuv-gazebo-ros-plugins \
    uuv-gazebo-worlds \
    uuv-sensor-ros-plugins \
    uuv-simulator \
    uuv-world-plugins \
    uuv-world-ros-plugins \
    velodyne-gazebo-plugins \
    velodyne-simulator \
    vrx-gazebo \
    wamv-gazebo \
    warthog-gazebo \
    warthog-simulator \
    wave-gazebo \
    wave-gazebo-plugins \
    yosemite-valley \
"

# Depends on libqt4-dev from https://git.yoctoproject.org/cgit/cgit.cgi/meta-qt4
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt4', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT4}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT4 = " \
    hector-geotiff \
    hector-geotiff-plugins \
    hector-slam \
    hector-slam-launch \
"

# Depends on vlc from meta-multimedia
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'multimedia', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_MULTIMEDIA}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_MULTIMEDIA = " \
    cob-android \
    cob-android-script-server \
    cob-command-gui \
    cob-default-robot-behavior \
    cob-driver \
    cob-helper-tools \
    cob-mimic \
    cob-monitoring \
    cob-script-server \
    cob-sound \
    cob-teleop \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'wxpython', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_WXPYTHON}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_WXPYTHON = " \
    smach-viewer \
    executive-smach-visualization \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lisp', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_LISP}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_LISP = " \
    actionlib-lisp \
    cl-tf \
    cl-tf2 \
    cl-transforms \
    cl-transforms-stamped \
    cl-urdf \
    cl-utils \
    euslisp \
    geneus genlisp \
    ros-emacs-utils \
    rosemacs \
    roslisp \
    roslisp-common \
    roslisp-repl \
    roslisp-utilities \
    slime-ros \
    slime-wrapper \
"

# Depends on mesa or libglu which requires opengl or vulkan DISTRO_FEATURE
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opengl', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENGL}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENGL = " \
    abb \
    abb-irb2400-moveit-config \
    abb-irb6640-moveit-config \
    cob-collision-monitor \
    cob-obstacle-distance-moveit \
    cob-moveit-bringup \
    cob-moveit-interface \
    desktop-full \
    exotica \
    exotica-aico-solver \
    exotica-collision-scene-fcl \
    exotica-collision-scene-fcl-latest \
    exotica-core \
    exotica-core-task-maps \
    exotica-examples \
    exotica-ik-solver \
    exotica-levenberg-marquardt-solver \
    exotica-ompl-solver \
    exotica-python \
    exotica-time-indexed-rrt-connect-solver \
    fetch-bringup \
    fetch-moveit-config \
    fetch-ros \
    fsrobo-r-trajectory-filters \
    industrial-core \
    industrial-trajectory-filters \
    libg2o \
    moveit-commander \
    moveit-fake-controller-manager \
    moveit-planners \
    moveit-planners-ompl \
    moveit-plugins \
    moveit-pr2 \
    moveit-ros-benchmarks \
    moveit-ros-manipulation \
    moveit-ros-move-group \
    moveit-ros-perception \
    moveit-ros-planning \
    moveit-ros-planning-interface \
    moveit-ros-robot-interaction \
    moveit-ros-warehouse \
    moveit-runtime \
    moveit-sim-controller \
    moveit-visual-tools \
    navigation-stage \
    navigation-tutorials \
    open-manipulator-controller \
    open-manipulator-moveit \
    open-manipulator-with-tb3-tools \
    open-manipulator-with-tb3-waffle-moveit \
    open-manipulator-with-tb3-waffle-pi-moveit \
    pilz-industrial-motion \
    pilz-robot-programming \
    pilz-trajectory-generation \
    pr2-moveit-config \
    rc-visard \
    robot-body-filter \
    roomba-stage \
    rtabmap \
    rtabmap-ros \
    seed-r7-navigation \
    simulators \
    stage \
    stage-ros \
    teb-local-planner \
    teb-local-planner-tutorials \
    uwsim \
    uwsim-bullet \
    uwsim-osgbullet \
    uwsim-osgocean \
    uwsim-osgworks \
    wxwidgets \
    rc-roi-manager-gui \
    rqt-pose-view \
"

# There is unbuildable dependency on virtual/egl from gstreamer1.0-plugins-base because:
# 1) gstreamer1.0-plugins-base depends on virtual/egl because of "egl" PACKAGECONFIG
#
# 2) "egl" PACKAGECONFIG is enabled by
#    meta-raspberrypi/recipes-multimedia/gstreamer/gstreamer1.0-plugins-base_%.bbappend
#    PACKAGECONFIG_GL_rpi = "egl gles2"
#
#    without respecting the "opengl" in DISTRO_FEATURES like the recipe in oe-core does
#    openembedded-core/meta/recipes-multimedia/gstreamer/gstreamer1.0-plugins-base_1.14.4.bb:
#    PACKAGECONFIG_GL ?= "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'gles2 egl', '', d)}"
#
# 3) virtual/egl is provided either by:
#    - userland (only without vc4graphics in MACHINE_FEATURES):
#      meta-raspberrypi/recipes-graphics/userland/userland_git.bb:PROVIDES += "${@bb.utils.contains("MACHINE_FEATURES", "vc4graphics", "", "virtual/libgles2 virtual/egl", d)}"
#    - mesa (selected with vc4graphics in MACHINE_FEATURES)
#      meta-raspberrypi/conf/machine/include/rpi-default-providers.inc:PREFERRED_PROVIDER_virtual/egl ?= "${@bb.utils.contains("MACHINE_FEATURES", "vc4graphics", "mesa", "userland", d)}"
#    - vc-graphics(-hardfp)
#      meta-raspberrypirecipes-graphics/vc-graphics/vc-graphics.inc:PROVIDES = "virtual/libgles2 virtual/egl"
#
# 4) vc-graphics(-hardfp) recipe are skipped in default setup, because with vc4graphics being
#    in MACHINE_FEATURES by default since:
#    https://github.com/agherzan/meta-raspberrypi/commit/690bdca57422447e49d4ef43862bf675e9acc28f
#    the PREFERRED_PROVIDER_virtual/libgles2 is set to mesa in:
#    conf/machine/include/rpi-default-providers.inc:PREFERRED_PROVIDER_virtual/libgles2 ?= "${@bb.utils.contains("MACHINE_FEATURES", "vc4graphics", "mesa", "userland", d)}"
#
#    resulting in skipping the other virtual/libgles2 providers:
#    vc-graphics-hardfp PROVIDES virtual/egl but was skipped: PREFERRED_PROVIDER_virtual/libgles2 set to mesa, not vc-graphics-hardfp
#    vc-graphics PROVIDES virtual/egl but was skipped: PREFERRED_PROVIDER_virtual/libgles2 set to mesa, not vc-graphics
#
# 5) mesa is skipped when neither opengl nor vulkan are in DISTRO_FEATURES
#
# 6) userland doesn't provide virtual/egl because we have the default vc4graphics
#    meta-raspberrypi/recipes-graphics/userland/userland_git.bb:PROVIDES += "${@bb.utils.contains("MACHINE_FEATURES", "vc4graphics", "", "virtual/libgles2 virtual/egl", d)}"
#    and it cannot be built anyway, because with the default vc4graphics it depends on libegl-mesa:
#    meta-raspberrypi/recipes-graphics/userland/userland_git.bb:RDEPENDS_${PN} += "${@bb.utils.contains("MACHINE_FEATURES", "vc4graphics", "libegl-mesa", "", d)}"
#    and libegl-mesa is provided only by mesa recipe from oe-core which in turn
#    requires either "opengl" or "vulkan" to be in DISTRO_FEATURES
#
# This causes a lot of unresolved dependencies in default setup with vc4graphics but without opengl.
# - with Yocto 2.6 Thud and older it worked, because vc4graphics wasn't enabled by default before:
#   https://github.com/agherzan/meta-raspberrypi/commit/690bdca57422447e49d4ef43862bf675e9acc28f
#
# To build these packages you have 3 options:
# A) Just add "opengl" to DISTRO_FEATURES and use the default vc4graphics with mesa providing virtual/egl
# B) Use DISABLE_VC4GRAPHICS added in
#    https://github.com/agherzan/meta-raspberrypi/commit/96c8459c9363cc6bf463aedf4d24f92a1ee7d6ba
#    to explicitly disable vc4graphics and use userland to provide virtual/egl
# C) Apply https://github.com/agherzan/meta-raspberrypi/pull/551 in meta-raspberrypi,
#    this part can be removed once upgrading to Yocto release with this applied
RDEPENDS_${PN}_remove_rpi = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', '', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENGL_AND_VC4GRAPHICS}', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENGL_AND_VC4GRAPHICS = " \
    ainstein-radar-tools \
    apriltag-ros \
    ar-track-alvar \
    aruco-detect \
    avt-vimba-camera \
    calibration \
    calibration-launch \
    calibration-setup-helper \
    camera-calibration \
    checkerboard-detector \
    cob-camera-sensors \
    cob-image-flip \
    cob-map-accessibility-analysis \
    cob-navigation \
    cob-object-detection-visualizer \
    cob-perception-common \
    cob-vision-utils \
    compressed-depth-image-transport \
    compressed-image-transport \
    costmap-converter \
    criutils \
    cv-bridge \
    cv-camera \
    depth-image-proc \
    depthcloud-encoder \
    depthimage-to-laserscan \
    distance-map-opencv \
    face-detector \
    fetch-calibration \
    fetch-depth-layer \
    fetch-navigation \
    fiducials \
    fiducial-slam \
    flir-boson-usb \
    freight-bringup \
    generic-throttle \
    grid-map-cv \
    grid-map-filters \
    grid-map-loader \
    grid-map-ros \
    grid-map-visualization \
    gscam \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-base-meta \
    handeye \
    hector-compressed-map-transport \
    image-cb-detector \
    image-geometry \
    image-pipeline \
    image-proc \
    image-publisher \
    image-rotate \
    image-transport-plugins \
    image-view \
    image-view2 \
    imagezero-image-transport \
    imagezero-ros \
    ipa-3d-fov-visualization \
    jsk-common-msgs \
    laser-cb-detector \
    leg-detector \
    libcmt \
    multi-object-tracking-lidar \
    multisense \
    multisense-bringup \
    multisense-cal-check \
    multisense-lib \
    multisense-ros \
    nerian-stereo \
    opencv \
    opencv-apps \
    openni-launch \
    openni2-launch \
    opt-camera \
    people \
    people-velocity-tracker \
    perception \
    photo \
    posedetection-msgs \
    rgbd-launch \
    robot-calibration \
    roseus-tutorials \
    slic \
    stereo-image-proc \
    swri-geometry-util \
    swri-image-util \
    swri-opencv-util \
    swri-route-util \
    swri-transform-util \
    theora-image-transport \
    turtlebot3-applications \
    turtlebot3-automatic-parking-vision \
    turtlebot3-autorace \
    turtlebot3-autorace-camera \
    turtlebot3-autorace-control \
    turtlebot3-autorace-core \
    turtlebot3-autorace-detect \
    turtlebot3-panorama \
    tuw-aruco \
    tuw-checkerboard \
    tuw-ellipses \
    tuw-geometry \
    tuw-marker-detection \
    tuw-marker-pose-estimation \
    usb-cam-controllers \
    video-stream-opencv \
    vision-opencv \
    vision-visp \
    visp \
    visp-auto-tracker \
    visp-bridge \
    visp-camera-calibration \
    visp-hand2eye-calibration \
    visp-tracker \
    web-video-server \
    webrtc-ros \
    yocs-localization-manager \
"
