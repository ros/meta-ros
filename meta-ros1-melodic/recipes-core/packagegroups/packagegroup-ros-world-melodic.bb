# Copyright (c) 2019-2020 LG Electronics, Inc.

DESCRIPTION = "All non-test packages for the target from files/crystal/cache.yaml"
LICENSE = "MIT"

# ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_* variables are MACHINE specific
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup
inherit ros_distro_melodic

PACKAGES = "${PN}"

RDEPENDS_${PN} = "${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES}"

# Requires Python 3; it is not used by any other ROS 1 package.
RDEPENDS_${PN}_remove = "catkin-virtualenv"
# Depends on blacklisted catkin-virtualenv
RDEPENDS_${PN}_remove = "haros-catkin"
RDEPENDS_${PN}_remove = "sesame-ros"

# Contains only dev, dbg and staticdev files, so PN is empty and not created
RDEPENDS_${PN}_remove = "sophus"

# Contains only dev, dbg and staticdev files, so PN is empty and not created
RDEPENDS_${PN}_remove = "cloudwatch-metrics-common"

# Contains only dev, dbg and staticdev files, so PN is empty and not created
RDEPENDS_${PN}_remove = "lex-common"

# Contains only dev files, so PN is empty and not created
RDEPENDS_${PN}_remove = "qpmad"

# It is a fork of https://github.com/google/flatbuffers that's not used by any other ROS 1 package.
RDEPENDS_${PN}_remove = "flatbuffers"

# It is a "catkin-ized" edition of the upstream version that is not used by any other ROS 1 package.
RDEPENDS_${PN}_remove = "grpc"

# It is a "catkin-ized" edition of the upstream version that is not used by any other ROS 1 package.
RDEPENDS_${PN}_remove = "nanomsg"

# It has dependencies on Qt4 packages; it is not used by any other ROS 1 package.
RDEPENDS_${PN}_remove = "octovis"

# Expects jderobot header files in wrong directory (/opt/jderobot/include/jderobot/types/image.h) and not compatible with opencv version we're using
RDEPENDS_${PN}_remove = "jderobot-camviz"

# Generation of ROS package documentation will never be done on the target.
RDEPENDS_${PN}_remove = "rosdoc-lite"
# Depends on blacklisted rosdoc-lite
RDEPENDS_${PN}_remove = "jackal-tutorials"
RDEPENDS_${PN}_remove = "odom-frame-publisher"

# Fetches depot_tools during do_configure and then tries to use vpython which isn't in dependencies
RDEPENDS_${PN}_remove = "webrtc"
RDEPENDS_${PN}_remove = "webrtc-ros"

# Not compatible with newer libftdi included in meta-oe: https://github.com/kobuki-base/kobuki_ftdi/issues/3
RDEPENDS_${PN}_remove = "kobuki-ftdi"

# ERROR: Nothing PROVIDES 'UNRESOLVED-python-requests-oauthlib' (but generated-recipes/jsk-3rdparty/rostwitter_2.1.13-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "rostwitter"

# Depends on unavailable UNRESOLVED-atlas, UNRESOLVED-jython UNRESOLVED-f2c
RDEPENDS_${PN}_remove = "openhrp3"

# Depends on unavailable UNRESOLVED-libirrlicht-dev, UNRESOLVED-net-tools, UNRESOLVED-procps, UNRESOLVED-ipython, UNRESOLVED-hostname and blacklisted openhrp3
RDEPENDS_${PN}_remove = "hrpsys-ros-bridge"

# Depends on unavailable UNRESOLVED-libirrlicht-dev, UNRESOLVED-net-tools, UNRESOLVED-procps, UNRESOLVED-ipython, UNRESOLVED-hostname and blacklisted openhrp3 and hrpsys-ros-bridge
RDEPENDS_${PN}_remove = "rtmros-common"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python-mechanize', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_MECHANIZE}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_MECHANIZE = " \
    pr2-bringup \
    pr2-bringup-tests \
    pr2-self-test \
    wifi-ddwrt \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python-speechrecognition-pip', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_SPEECHRECOGNITION_PIP}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_SPEECHRECOGNITION_PIP = " \
    respeaker-ros \
    ros-speech-recognition \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python-gi', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_GI}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_GI = " \
    audio-common \
    sound-play \
    tts \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python-imageio', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_IMAGEIO}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_IMAGEIO = " \
    movie-publisher \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'nkf', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_NKF}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_NKF = " \
    voice-text \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'rospilot', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROSPILOT}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROSPILOT = " \
    rospilot \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'parrot-arsdk', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PARROT_ARSDK}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PARROT_ARSDK = " \
    parrot-arsdk \
"

# ERROR: Nothing PROVIDES 'UNRESOLVED-python-docker' (but generated-recipes/dockeros/dockeros_1.1.0-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "dockeros"

# ERROR: Nothing PROVIDES 'python-twisted-core' (but generated-recipes/linux-networking/multi-interface-roam_1.0.16-1.bb DEPENDS on or otherwise requires it). Close matches:
RDEPENDS_${PN}_remove = "multi-interface-roam"
RDEPENDS_${PN}_remove = "linux-networking"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python-omniorb', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_OMNIORB}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_OMNIORB = " \
    hrpsys \
    hrpsys-ros-bridge \
    hrpsys-tools \
    openhrp3 \
    openrtm-aist-python \
    openrtm-aist \
    openrtm-ros-bridge \
    openrtm-tools \
    rosnode-rtc \
    rtctree \
    rtmbuild \
    rtmros-common \
    rtshell \
    rtsprofile \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python-dialogflow-pip', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_DIALOGFLOW_PIP}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_DIALOGFLOW_PIP = " \
    dialogflow-task-executive \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'pydrive-pip', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYDRIVE_PIP}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYDRIVE_PIP = " \
    gdrive-ros \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'pugixml', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PUGIXML}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PUGIXML = " \
    lanelet2 \
    lanelet2-examples \
    lanelet2-io \
    lanelet2-projection \
    lanelet2-python \
    lanelet2-validation \
"

# ERROR: Nothing PROVIDES 'UNRESOLVED-libxmlrpc-c++"
RDEPENDS_${PN}_remove = "ifm3d"
RDEPENDS_${PN}_remove = "ifm3d-core"

# ERROR: Nothing PROVIDES 'UNRESOLVED-python-libpgm-pip' (but generated-recipes/jsk-3rdparty/pgm-learner_2.1.13-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "pgm-learner"

ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_LIBREFLEXXESTYPE2_x86_64 = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_LIBREFLEXXESTYPE2 = "\
    libreflexxestype2 \
    ros-reflexxes \
    ipr-extern \
"

ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_LIBNTCAN_x86 = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_LIBNTCAN_x86_64 = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_LIBNTCAN = "\
    libntcan \
    cob-base-drive-chain \
    cob-canopen-motor \
    cob-extern \
    cob-generic-can \
    schunk-libm5api \
    schunk-modular-robotics \
    schunk-powercube-chain \
    schunk-sdh \
    schunk-simulated-tactile-sensors \
"
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_PROSILICA_GIGE_SDK_x86 = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_PROSILICA_GIGE_SDK_x86_64 = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_PROSILICA_GIGE_SDK_armv7a = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', 'prosilica-gige-sdk prosilica-camera', '', d)}"
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_PROSILICA_GIGE_SDK_armv7ve = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', 'prosilica-gige-sdk prosilica-camera', '', d)}"
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_PROSILICA_GIGE_SDK_ppc = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_PROSILICA_GIGE_SDK = "\
    prosilica-camera \
    prosilica-gige-sdk \
"

ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API_x86 = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API_x86_64 = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API_armv7a = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', 'rc-genicam-api', '', d)}"
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API_armv7ve = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', 'rc-genicam-api', '', d)}"
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API_aarch64 = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API = "\
    rc-genicam-api \
"

ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC = " \
    ${ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_PROSILICA_GIGE_SDK} \
    ${ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API} \
    ${ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_LIBREFLEXXESTYPE2} \
    ${ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_LIBNTCAN} \
"

RDEPENDS_${PN}_remove = "${ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC}"

# There is recipe for glfw in meta-oe in dunfell:
# http://cgit.openembedded.org/meta-openembedded/commit/meta-oe/recipes-core/glfw/glfw_3.3.bb?id=a7464eaa69a7ee4734001aab2e232102e7135772
# but we don't have a backports layer from dunfell yet, lets skip it for now
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'glfw', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GLFW}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GLFW = " \
    librealsense2 \
    mrpt2 \
    realsense2-camera \
"

# recipes depending on various unavailable python modules
# ERROR: Nothing PROVIDES 'UNRESOLVED-python-cairosvg' (but generated-recipes/fiducials/aruco-detect_0.11.0-1.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'UNRESOLVED-python-joblib' (but generated-recipes/fiducials/aruco-detect_0.11.0-1.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'UNRESOLVED-python-urlgrabber' (but generated-recipes/jsk-visualization/jsk-rqt-plugins_2.1.5.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'UNRESOLVED-python-sklearn' (but generated-recipes/jsk-visualization/jsk-rqt-plugins_2.1.5.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'UNRESOLVED-python-cairo' (but generated-recipes/rqt-bag/rqt-bag-plugins_0.4.12.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'UNRESOLVED-python-opengl' (but generated-recipes/rqt-pose-view/rqt-pose-view_0.5.8.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing RPROVIDES 'UNRESOLVED-python-termcolor' (but generated-recipes/criutils/criutils_0.1.3-2.bb RDEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python-deps', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_DEPS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_DEPS = " \
    aruco-detect \
    criutils \
    desktop \
    fiducials \
    handeye \
    jsk-rqt-plugins \
    rqt-bag-plugins \
    rqt-common-plugins \
    rqt-pose-view \
    rqt-py-trees \
    rqt-robot-plugins \
    viz \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'pyqt5', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYQT5}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYQT5 = " \
    adi-driver \
    cob-command-tools \
    cob-dashboard \
    dataspeed-pds-rqt \
    dingo-desktop \
    dingo-viz \
    fmi-adapter-examples \
    gl-dependency \
    gundam-rx78-control \
    hrpsys-ros-bridge \
    jderobot-drones \
    leo-desktop \
    leo-viz \
    mesh-tools \
    moose-desktop \
    moose-viz \
    mrp2-desktop \
    mrp2-viz \
    pilz-status-indicator-rqt \
    pr2-motor-diagnostic-tool \
    python-qt-binding \
    qt-gui \
    qt-gui-app \
    qt-gui-core \
    qt-gui-cpp \
    radial-menu \
    radial-menu-example \
    radial-menu-rviz \
    ros-controllers \
    rosmon \
    rqt \
    rqt-action \
    rqt-bag \
    rqt-console \
    rqt-controller-manager \
    rqt-dep \
    rqt-drone-teleop \
    rqt-ez-publisher \
    rqt-graph \
    rqt-ground-robot-teleop \
    rqt-gui \
    rqt-gui-cpp \
    rqt-gui-py \
    rqt-image-view \
    rqt-joint-trajectory-controller \
    rqt-joint-trajectory-plot \
    rqt-launch \
    rqt-launchtree \
    rqt-logger-level \
    rqt-moveit \
    rqt-msg \
    rqt-multiplot \
    rqt-nav-view \
    rqt-plot \
    rqt-publisher \
    rqt-py-common \
    rqt-py-console \
    rqt-reconfigure \
    rqt-robot-dashboard \
    rqt-robot-monitor \
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
    rqt-virtual-joy \
    rqt-web \
    rtmros-common \
    rviz-map-plugin \
    rviz-mesh-plugin \
    sick-safetyscanners \
    visualstates \
    webkit-dependency \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'vtk-qt', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_VTK_QT}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_VTK_QT = " \
    ira-laser-tools \
    lvr2 \
    rc-cloud-accumulator \
    rtabmap \
    rtabmap-ros \
    simple-grasping \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'x11', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_X11}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_X11 = " \
    cob-collision-monitor \
    cob-obstacle-distance-moveit \
    exotica-aico-solver \
    exotica-cartpole-dynamics-solver \
    exotica-collision-scene-fcl \
    exotica-collision-scene-fcl-latest \
    exotica-core-task-maps \
    exotica-core \
    exotica-ddp-solver \
    exotica-double-integrator-dynamics-solver \
    exotica-dynamics-solvers \
    exotica-examples \
    exotica-ik-solver \
    exotica-ilqg-solver \
    exotica-ilqr-solver \
    exotica-levenberg-marquardt-solver \
    exotica-ompl-control-solver \
    exotica-ompl-solver \
    exotica-pendulum-dynamics-solver \
    exotica-pinocchio-dynamics-solver \
    exotica-python \
    exotica-quadrotor-dynamics-solver \
    exotica-scipy-solver \
    exotica-time-indexed-rrt-connect-solver \
    freenect-camera \
    freenect-launch \
    freenect-stack \
    fsrobo-r-trajectory-filters \
    heifu-bringup \
    heifu-tools \
    image-pipeline \
    image-view \
    image-view2 \
    industrial-core \
    industrial-trajectory-filters \
    mapviz \
    mapviz-plugins \
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
    moveit-servo \
    moveit-sim-controller \
    mpc-local-planner-examples \
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
    mrpt1 \
    mrpt2 \
    multires-image \
    mvsim \
    navigation-stage \
    navigation-tutorials \
    nextage-moveit-config \
    open-manipulator-controller \
    open-manipulator-with-tb3-tools \
    perception \
    pilz-industrial-motion-testutils \
    pilz-industrial-motion \
    pilz-robot-programming \
    pilz-trajectory-generation \
    play-motion \
    pose-cov-ops \
    pr2-bringup-tests \
    pr2-calibration-launch \
    pr2-calibration \
    pr2-moveit-config \
    pr2-se-calibration-launch \
    pr2-self-test \
    rc-roi-manager-gui \
    rc-visard \
    robot-body-filter \
    roomba-stage \
    safe-teleop-stage \
    stage \
    stage-ros \
    teb-local-planner-tutorials \
    tile-map \
    tuw-checkerboard \
    tuw-marker-detection \
    uwsim-bullet \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'mongodb', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MONGODB}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MONGODB = " \
    mongodb-log \
    mongodb-store \
    warehouse-ros-mongo \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'mongodb-legacy-cxx-driver', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MONGODB_LEGACY_CXX_DRIVER}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MONGODB_LEGACY_CXX_DRIVER = " \
    mongodb-log \
    mongodb-store \
    warehouse-ros-mongo \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'vlc', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_VLC}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_VLC = " \
    cob-android \
    cob-android-script-server \
    cob-cartesian-controller \
    cob-command-gui \
    cob-control \
    cob-default-robot-behavior \
    cob-driver \
    cob-helper-tools \
    cob-mimic \
    cob-monitoring \
    cob-moveit-interface \
    cob-script-server \
    cob-sound \
    cob-teleop \
    cob-twist-controller \
"

# ERROR: Nothing PROVIDES 'UNRESOLVED-python-pyusb-pip' (but generated-recipes/jsk-3rdparty/respeaker-ros_2.1.13-1.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'UNRESOLVED-python-speechrecognition-pip' (but generated-recipes/jsk-3rdparty/respeaker-ros_2.1.13-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "respeaker-ros"

# ERROR: Nothing PROVIDES 'UNRESOLVED-python-catkin-tools' (but generated-recipes/jsk-3rdparty/collada-urdf-jsk-patch_2.1.13-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "collada-urdf-jsk-patch"

# ERROR: Nothing PROVIDES 'UNRESOLVED-python-avahi' (but generated-recipes/multimaster-fkie/master-discovery-fkie_0.8.12.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "master-discovery-fkie"
# ERROR: Nothing PROVIDES 'master-discovery-fkie' (but generated-recipes/multimaster-fkie/master-sync-fkie_0.8.12.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing RPROVIDES 'master-discovery-fkie' (but generated-recipes/multimaster-fkie/master-sync-fkie_0.8.12.bb, generated-recipes/cpr-multimaster-tools/multimaster-launch_0.0.2-1.bb RDEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "master-sync-fkie"
RDEPENDS_${PN}_remove = "node-manager-fkie"
RDEPENDS_${PN}_remove = "multimaster-fkie"
# ERROR: Nothing RPROVIDES 'master-discovery-fkie' (but generated-recipes/multimaster-fkie/master-sync-fkie_0.8.12.bb, generated-recipes/cpr-multimaster-tools/multimaster-launch_0.0.2-1.bb RDEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "multimaster-launch"
# ERROR: Nothing PROVIDES 'multimaster-launch' (but generated-recipes/husky/husky-control_0.4.2-1.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing RPROVIDES 'multimaster-launch' (but generated-recipes/husky/husky-control_0.4.2-1.bb, generated-recipes/cpr-multimaster-tools/cpr-multimaster-tools_0.0.2-1.bb RDEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "husky-control"
# ERROR: Nothing RPROVIDES 'multimaster-launch' (but generated-recipes/husky/husky-control_0.4.2-1.bb, generated-recipes/cpr-multimaster-tools/cpr-multimaster-tools_0.0.2-1.bb RDEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "cpr-multimaster-tools"
# ERROR: Nothing PROVIDES 'husky-control' (but generated-recipes/husky/husky-base_0.4.2-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "husky-base"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python-cwiid', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_CWIID}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_CWIID = " \
    joystick-drivers \
    wiimote \
"

# ERROR: Nothing PROVIDES 'UNRESOLVED-libopenvdb' (but generated-recipes/spatio-temporal-voxel-layer/spatio-temporal-voxel-layer_1.3.5-2.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'UNRESOLVED-libopenexr-dev' (but generated-recipes/spatio-temporal-voxel-layer/spatio-temporal-voxel-layer_1.3.5-2.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'UNRESOLVED-libopenvdb-dev' (but generated-recipes/spatio-temporal-voxel-layer/spatio-temporal-voxel-layer_1.3.5-2.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "spatio-temporal-voxel-layer"

# ERROR: Nothing PROVIDES 'UNRESOLVED-gfortran' (but generated-recipes/optpp-catkin/optpp-catkin_2.4.0-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "optpp-catkin"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'openni', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENNI}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENNI = " \
    openni-camera \
    openni-launch \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'openni2', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENNI2}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENNI2 = " \
    fetch-bringup \
    hironx-calibration \
    hironx-moveit-config \
    hironx-ros-bridge \
    nextage-ros-bridge \
    nextage-moveit-config \
    openni2-camera \
    openni2-launch \
    rtmros-hironx \
"

# ERROR: Nothing PROVIDES 'UNRESOLVED-gforth' (but generated-recipes/wge100-driver/wge100-camera-firmware_1.8.2-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "wge100-camera-firmware"

# ERROR: Nothing PROVIDES 'UNRESOLVED-arduino-core' (but generated-recipes/rosserial/rosserial-arduino_0.8.0.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "rosserial-arduino"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'coinor-libipopt', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_COINOR_LIBIPOPT}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_COINOR_LIBIPOPT = " \
    control-box-rst \
    ifopt \
    mpc-local-planner-examples \
    mpc-local-planner \
    towr-ros \
    towr \
"

# ERROR: Nothing PROVIDES 'UNRESOLVED-npm-native' (but generated-recipes/vapor-master/vapor-master_0.3.0.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "vapor-master"

# ERROR: Nothing PROVIDES 'UNRESOLVED-libopenscenegraph' (but generated-recipes/visualization-osg/osg-utils_1.0.2-2.bb, generated-recipes/visualization-osg/osg-interactive-markers_1.0.2-2.bb, generated-recipes/visualization-osg/osg-markers_1.0.2-2.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'osg', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OSG}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OSG = " \
    osg-interactive-markers \
    osg-markers \
    osg-utils \
    uwsim \
    uwsim-osgbullet \
    uwsim-osgocean \
    uwsim-osgworks \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'muparser', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MUPARSER}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MUPARSER = " \
    canopen-motor-node \
    pilz-robots \
    prbt-grippers \
    prbt-moveit-config \
    prbt-pg70-support \
    prbt-support \
    ros-canopen \
"

# ERROR: Nothing PROVIDES 'UNRESOLVED-java' (but generated-recipes/nao-meshes/nao-meshes_0.1.12-2.bb, generated-recipes/pepper-meshes/pepper-meshes_0.2.4-3.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "nao-meshes"
RDEPENDS_${PN}_remove = "pepper-meshes"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'clang-tidy', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CLANG_TIDY}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CLANG_TIDY = " \
    pilz-control \
    pilz-robots \
    pilz-status-indicator-rqt \
    pilz-utils \
    prbt-hardware-support \
    prbt-moveit-config \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'libspnav', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBSPNAV}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBSPNAV = " \
    moveit-servo \
    spacenav-node \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lcm', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LCM}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LCM = " \
    dataspeed-pds \
    dataspeed-pds-lcm \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'libpqxx', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBPQXX}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBPQXX = " \
    knowledge-representation \
"

# ERROR: Nothing PROVIDES 'ifopt' (but generated-recipes/towr/towr_1.4.1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "towr"

# ERROR: Nothing PROVIDES 'pilz-utils' (but generated-recipes/pilz-robots/prbt-hardware-support_0.5.13-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "prbt-hardware-support"

# ERROR: Nothing PROVIDES 'osg-markers' (but generated-recipes/visualization-osg/visualization-osg_1.0.2-2.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'osg-utils' (but generated-recipes/visualization-osg/visualization-osg_1.0.2-2.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'osg-interactive-markers' (but generated-recipes/visualization-osg/visualization-osg_1.0.2-2.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "visualization-osg"

# ERROR: Nothing PROVIDES 'wge100-camera-firmware' (but generated-recipes/wge100-driver/wge100-driver_1.8.2-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "wge100-driver"

# ERROR: Nothing RPROVIDES 'canopen-motor-node' (but generated-recipes/pilz-robots/prbt-support_0.5.13-1.bb, generated-recipes/ros-canopen/ros-canopen_0.8.2-1.bb RDEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "prbt-support"
RDEPENDS_${PN}_remove = "ros-canopen"

# ERROR: Nothing RPROVIDES 'UNRESOLVED-python-pandas' (but generated-recipes/rosbag-pandas/rosbag-pandas_0.5.3.bb RDEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "rosbag-pandas"

# ERROR: Nothing RPROVIDES 'UNRESOLVED-python-termcolor' (but generated-recipes/py-trees-ros/py-trees-ros_0.5.18.bb RDEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "py-trees-ros"

# ERROR: Nothing RPROVIDES 'UNRESOLVED-python-msgpack' (but generated-recipes/json-transport/json-transport_0.0.3.bb RDEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "json-transport"

# ERROR: Nothing RPROVIDES 'UNRESOLVED-python-catkin-lint' (but generated-recipes/fetch-tools/fetch-tools_0.2.1.bb RDEPENDS on or otherwise requires it)
# ERROR: Nothing RPROVIDES 'UNRESOLVED-python-argcomplete' (but generated-recipes/fetch-tools/fetch-tools_0.2.1.bb RDEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "fetch-tools"

# Conflicts with platform fcl, causing
# ERROR: moveit-core-1.0.2-1-r0 do_package: moveit-core: Multiple shlib providers for libfcl.so.0.6: fcl, fcl-catkin (used by files: /jenkins/home/workspace/jansa/webos-melodic-dunfell/webos-melodic-dunfell/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/moveit-core/1.0.2-1-r0/packages-split/moveit-core/usr/opt/ros/melodic/lib/libmoveit_collision_detection_fcl.so.1.0.2)
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'fcl-catkin', 'fcl-catkin', '', d)}"

# ERROR: Nothing RPROVIDES 'UNRESOLVED-network-manager' (but generated-recipes/network-autoconfig/network-autoconfig_0.1.1-2.bb RDEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "network-autoconfig"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python-scipy', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_SCIPY}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_SCIPY = " \
    calibration \
    calibration-estimation \
    cis-camera \
    eca-a9-control \
    exotica-examples \
    exotica-scipy-solver \
    husky-bringup \
    husky-robot \
    imagesift \
    jsk-common \
    jsk-data \
    jsk-interactive-marker \
    jsk-interactive-test \
    jsk-interactive \
    jsk-pcl-ros-utils \
    jsk-pcl-ros \
    jsk-perception \
    jsk-recognition-utils \
    jsk-recognition \
    jsk-rviz-plugins \
    jsk-tools \
    jsk-topic-tools \
    jsk-visualization \
    multi-map-server \
    pgm-learner \
    pr2-calibration-launch \
    pr2-calibration \
    pr2-se-calibration-launch \
    pr2eus-tutorials \
    resized-image-transport \
    uuv-control-utils \
    uuv-trajectory-control \
"

# ERROR: Nothing PROVIDES 'UNRESOLVED-libnlopt-dev' (but generated-recipes/trac-ik/trac-ik-lib_1.5.1-1.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'UNRESOLVED-libnlopt0' (but generated-recipes/trac-ik/trac-ik-lib_1.5.1-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'trac-ik', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_TRAC_IK}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_TRAC_IK = " \
    nextage-moveit-config \
    trac-ik \
    trac-ik-examples \
    trac-ik-kinematics-plugin \
    trac-ik-lib \
    trac-ik-python \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ogre', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OGRE}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OGRE = " \
    abb \
    abb-irb2400-moveit-config \
    abb-irb2400-support \
    abb-irb4400-support \
    abb-irb5400-support \
    abb-irb6600-support \
    abb-irb6640-moveit-config \
    abb-irb6640-support \
    adi-driver \
    agni-tf-tools \
    ainstein-radar-rviz-plugins \
    cartographer-rviz \
    cob-interactive-teleop \
    cob-manipulation \
    cob-mapping-slam \
    cob-moveit-bringup \
    cob-navigation \
    cob-navigation-global \
    cob-navigation-local \
    cob-navigation-slam \
    cob-obstacle-distance \
    dingo-desktop \
    dingo-viz \
    distance-map \
    distance-map-rviz \
    exotica-examples \
    fake-joint \
    fake-joint-launch \
    fetch-moveit-config \
    fetch-ros \
    fkie-potree-rviz-plugin \
    franka-example-controllers \
    franka-ros \
    grid-map \
    grid-map-demos \
    grid-map-rviz-plugin \
    gundam-rx78-description \
    husky-desktop \
    husky-viz \
    imu-tools \
    jackal-desktop \
    jackal-viz \
    kvh-geo-fog-3d \
    kvh-geo-fog-3d-rviz \
    leo-desktop \
    leo-viz \
    leuze-bringup \
    leuze-description \
    leuze-ros-drivers \
    librviz-tutorial \
    mesh-tools \
    moose-desktop \
    moose-viz \
    moveit \
    moveit-ros \
    moveit-ros-visualization \
    moveit-setup-assistant \
    moveit-visual-tools \
    mrp2-desktop \
    mrp2-viz \
    neonavigation \
    neonavigation-launch \
    neonavigation-rviz-plugins \
    nextage-moveit-config \
    octomap-rviz-plugins \
    open-manipulator \
    open-manipulator-moveit \
    open-manipulator-with-tb3 \
    open-manipulator-with-tb3-waffle-moveit \
    open-manipulator-with-tb3-waffle-pi-moveit \
    panda-moveit-config \
    psen-scan \
    radial-menu \
    radial-menu-example \
    radial-menu-rviz \
    ridgeback-desktop \
    ridgeback-viz \
    rqt-rviz \
    rviz \
    rviz-imu-plugin \
    rviz-map-plugin \
    rviz-mesh-plugin \
    rviz-python-tutorial \
    rviz-plugin-tutorials \
    rviz-visual-tools \
    seed-r7-bringup \
    seed-r7-moveit-config \
    seed-r7-typef-moveit-config \
    slam-toolbox \
    trajectory-tracker-rviz-plugins \
    turtlebot3-automatic-parking-vision \
    urdf-tutorial \
    vision-visp \
    visp \
    visp-auto-tracker \
    visp-bridge \
    visp-camera-calibration \
    visp-hand2eye-calibration \
    visp-tracker \
    visualization-tutorials \
    warthog-desktop \
    warthog-viz \
"

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
    dingo-desktop \
    dingo-viz \
    distance-map \
    distance-map-rviz \
    dynamixel-workbench \
    dynamixel-workbench-single-manager-gui \
    fetch-bringup \
    fetch-gazebo-demo \
    fetch-ros \
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
    hrpsys-ros-bridge \
    husky-desktop \
    husky-viz \
    imagesift \
    imu-tools \
    jackal-desktop \
    jackal-viz \
    jderobot-drones \
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
    leo-desktop \
    leo-viz \
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
    mesh-tools \
    mir-gazebo \
    mir-robot \
    moose-desktop \
    moose-viz \
    moveit \
    moveit-ros \
    moveit-ros-visualization \
    moveit-setup-assistant \
    mrp2-desktop \
    mrp2-viz \
    mrpt-bridge \
    multi-map-server \
    multimaster-fkie \
    multires-image \
    neonavigation \
    neonavigation-launch \
    neonavigation-rviz-plugins \
    nextage-moveit-config \
    node-manager-fkie \
    octomap-rviz-plugins \
    open-manipulator \
    open-manipulator-control-gui \
    open-manipulator-with-tb3 \
    panda-moveit-config \
    pilz-robots \
    pilz-status-indicator-rqt \
    plotjuggler \
    pr2-motor-diagnostic-tool \
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
    radial-menu \
    radial-menu-example \
    radial-menu-rviz \
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
    rqt-ground-robot-teleop \
    rqt-gui \
    rqt-gui-cpp \
    rqt-gui-py \
    rqt-image-view \
    rqt-joint-trajectory-controller \
    rqt-joint-trajectory-plot \
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
    rqt-virtual-joy \
    rqt-web \
    rtabmap-ros \
    rtmros-common \
    rviz \
    rviz-imu-plugin \
    rviz-map-plugin \
    rviz-mesh-plugin \
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

# OE won't let us build ffmpeg unless LICENSE_FLAGS_WHITELIST contains "commercial" or "commercial_ffmpeg" or "ffmpeg".
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ffmpeg', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FFMPEG}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FFMPEG = " \
    codec-image-transport \
    h264-encoder-core \
    h264-video-encoder \
    movie-publisher \
    mrpt1 \
    mrpt2 \
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

# OE won't let us build x264 (and ffmpeg which depends on it) unless LICENSE_FLAGS_WHITELIST contains "commercial" or "commercial_x264" or "x264".
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'x264', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_X264}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_X264 = " \
    codec-image-transport \
    h264-encoder-core \
    h264-video-encoder \
    movie-publisher \
    mrpt1 \
    mrpt2 \
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
# Recipes which need widgets enabled in qtbase PACKAGECONFIG which webOS OSE explicitly disables:
# meta-webos/recipes-qt/qt5/qtbase_git.bbappend:PACKAGECONFIG_remove = "widgets"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5-widgets', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_QT5_WIDGETS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_QT5_WIDGETS = " \
    asmach-tutorials \
    common-tutorials \
    dynamixel-workbench \
    dynamixel-workbench-single-manager-gui \
    find-object-2d \
    geometry-tutorials \
    open-manipulator-control-gui \
    plotjuggler \
    ros-tutorials \
    swri-console \
    swri-profiler-tools \
    turtle-actionlib \
    turtle-tf \
    turtle-tf2 \
    turtlesim \
    turtlesim-dash-tutorial \
"

# OE won't let us build gstreamer1.0-plugins-ugly unless LICENSE_FLAGS_WHITELIST contains "commercial".
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gst-ugly', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GSTREAMER1.0_PLUGINS_UGLY}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GSTREAMER1.0_PLUGINS_UGLY = " \
    audio-capture \
    audio-common \
    audio-play \
    cis-camera \
    imagesift \
    jsk-3rdparty \
    jsk-common \
    jsk-data \
    jsk-interactive \
    jsk-interactive-marker \
    jsk-interactive-test \
    jsk-pcl-ros-utils \
    jsk-pcl-ros \
    jsk-perception \
    jsk-pr2eus \
    jsk-recognition \
    jsk-recognition-utils \
    jsk-rviz-plugins \
    jsk-tools \
    jsk-topic-tools \
    jsk-visualization \
    julius-ros \
    multi-map-server \
    pr2-bringup \
    pr2-bringup-tests \
    pr2-self-test \
    pr2eus-moveit \
    pr2eus-tutorials \
    pr2eus \
    resized-image-transport \
    ros-speech-recognition \
    sound-play \
    tts \
    voice-text \
"

# NB. gazebo-msgs is a dependency of non-Gazebo packages, so it doesn't appear here.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GAZEBO}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GAZEBO = " \
    ainstein-radar \
    ainstein-radar-gazebo-plugins \
    ati-force-torque \
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
    cob-manipulation \
    cob-moveit-bringup \
    desistek-saga-control \
    desistek-saga-description \
    desistek-saga-gazebo \
    desktop-full \
    dingo-gazebo \
    dingo-simulator \
    drone-wrapper \
    eca-a9-description \
    eca-a9-gazebo \
    eusurdf \
    fetch-gazebo \
    fetch-gazebo-demo \
    fetch-simulation \
    fetchit-challenge \
    fsrobo-r \
    fsrobo-r-bringup \
    fsrobo-r-description \
    fsrobo-r-moveit-config \
    gazebo-plugins \
    gazebo-ros \
    gazebo-ros-control \
    gazebo-ros-pkgs \
    gazebo-rosdev \
    gazebo-video-monitor-plugins \
    gundam-robot \
    gundam-rx78-gazebo \
    hector-gazebo \
    hector-gazebo-plugins \
    hector-gazebo-thermal-camera \
    hector-gazebo-worlds \
    hector-sensors-gazebo \
    heron-gazebo \
    husky-gazebo \
    husky-simulator \
    igvc-self-drive-description \
    igvc-self-drive-gazebo \
    igvc-self-drive-gazebo-plugins \
    igvc-self-drive-sim \
    jackal-gazebo \
    jackal-simulator \
    jderobot-assets \
    jderobot-drones \
    ksql-airport \
    lauv-control \
    lauv-description \
    lauv-gazebo \
    leo-gazebo \
    leo-simulator \
    mcmillan-airfield \
    mecanum-gazebo-plugin \
    mir-description \
    mir-driver \
    mir-gazebo \
    mir-navigation \
    mir-robot \
    moose-gazebo \
    moose-simulator \
    mrp2-gazebo \
    mrp2-simulator \
    nextage-gazebo \
    nmea-gps-plugin \
    open-manipulator-gazebo \
    open-manipulator-simulations \
    open-manipulator-with-tb3-gazebo \
    open-manipulator-with-tb3-simulations \
    pr2-controller-configuration-gazebo \
    pr2-gazebo \
    pr2-gazebo-plugins \
    pr2-simulator \
    prbt-gazebo \
    raw-description \
    rexrov2-control \
    rexrov2-description \
    rexrov2-gazebo \
    ridgeback-gazebo \
    ridgeback-gazebo-plugins \
    ridgeback-simulator \
    robosense-gazebo-plugins \
    robosense-simulator \
    roboticsgroup-upatras-gazebo-plugins \
    rosflight-pkgs \
    rosflight-sim \
    rosflight-utils \
    rotors-gazebo \
    rotors-gazebo-plugins \
    rotors-simulator \
    rr-openrover-description \
    rr-openrover-simulation \
    rr-openrover-stack \
    rtmros-nextage \
    sand-island \
    simulators \
    turtlebot3-gazebo \
    turtlebot3-simulations \
    urdf-sim-tutorial \
    uos-common-urdf \
    uos-gazebo-tools \
    uos-gazebo-worlds \
    uos-tools \
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
    qt-ros \
    qt-tutorials \
"

# Depends on vlc from meta-multimedia
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'multimedia', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_MULTIMEDIA}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_MULTIMEDIA = " \
    cob-android \
    cob-android-script-server \
    cob-cartesian-controller \
    cob-command-gui \
    cob-command-tools \
    cob-control \
    cob-default-robot-behavior \
    cob-driver \
    cob-helper-tools \
    cob-mimic \
    cob-monitoring \
    cob-moveit-interface \
    cob-script-server \
    cob-sound \
    cob-teleop \
    cob-twist-controller \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'wxpython', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_WXPYTHON}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_WXPYTHON = " \
    executive-smach-visualization \
    jsk-planning \
    seed-r7-ros-pkg \
    seed-r7-samples \
    smach-viewer \
    task-compiler \
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
    eus-assimp \
    euslime \
    euslisp \
    geneus \
    genlisp \
    jskeus \
    jsk-model-tools \
    jsk-planning \
    jsk-pr2eus \
    jsk-roseus \
    pr2eus-moveit \
    pr2eus \
    ros-emacs-utils \
    rosemacs \
    roseus \
    roseus-mongo \
    roseus-smach \
    roseus-tutorials \
    roslisp \
    roslisp-common \
    roslisp-repl \
    roslisp-utilities \
    slime-ros \
    slime-wrapper \
    task-compiler \
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
    exotica-cartpole-dynamics-solver \
    exotica-collision-scene-fcl \
    exotica-collision-scene-fcl-latest \
    exotica-core \
    exotica-core-task-maps \
    exotica-ddp-solver \
    exotica-double-integrator-dynamics-solver \
    exotica-dynamics-solvers \
    exotica-examples \
    exotica-ik-solver \
    exotica-ilqg-solver \
    exotica-ilqr-solver \
    exotica-levenberg-marquardt-solver \
    exotica-ompl-solver \
    exotica-ompl-control-solver \
    exotica-pendulum-dynamics-solver \
    exotica-pinocchio-dynamics-solver \
    exotica-python \
    exotica-quadrotor-dynamics-solver \
    exotica-scipy-solver \
    exotica-time-indexed-rrt-connect-solver \
    fetch-bringup \
    fetch-moveit-config \
    fetch-ros \
    freenect-camera \
    freenect-launch \
    freenect-stack \
    fsrobo-r-trajectory-filters \
    industrial-core \
    industrial-trajectory-filters \
    libg2o \
    librealsense2 \
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
    moveit-servo \
    moveit-sim-controller \
    moveit-visual-tools \
    mpc-local-planner-examples \
    navigation-stage \
    navigation-tutorials \
    nextage-moveit-config \
    open-manipulator-controller \
    open-manipulator-moveit \
    open-manipulator-with-tb3-tools \
    open-manipulator-with-tb3-waffle-moveit \
    open-manipulator-with-tb3-waffle-pi-moveit \
    pilz-industrial-motion-testutils \
    pilz-industrial-motion \
    pilz-robot-programming \
    pilz-trajectory-generation \
    play-motion \
    pr2-moveit-config \
    realsense2-camera \
    rc-visard \
    robot-body-filter \
    roomba-stage \
    rtabmap \
    rtabmap-ros \
    safe-teleop-stage \
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

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'heifu-ros-utils', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROS_UTILS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROS_UTILS = " \
    heifu-diagnostic \
    heifu-mavros \
    heifu-safety \
    heifu-simple-waypoint \
"

# do_configure failures
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'dccomms-ros', 'dccomms-ros' , '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'pyros-utils', 'pyros-utils' , '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'dynamic-graph-python', 'dynamic-graph-python dynamic-graph-tutorial sot-core' , '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'hdf5-map-io', 'hdf5-map-io mesh-msgs-hdf5' , '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'jderobot-carviz', 'jderobot-carviz' , '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lanelet2-traffic-rules', 'lanelet2-traffic-rules lanelet2-routing' , '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'novatel-oem7-driver', 'novatel-oem7-driver' , '', d)}"

# do_compile failures
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt-gui-cpp', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_QT_GUI_CPP}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_QT_GUI_CPP = " \
    mapviz-plugins \
    mapviz \
    multires-image \
    qt-gui-core \
    qt-gui-cpp \
    rosmon \
    rqt-gui-cpp \
    rqt-image-view \
    rqt-multiplot \
    rqt-rosmon \
    rqt-rviz \
    rqt \
    tile-map \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'assimp-devel', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ASSIMP_DEVEL}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ASSIMP_DEVEL = " \
    assimp-devel \
    euscollada \
    hrpsys-ros-bridge \
    pr2eus-moveit \
    pr2eus \
    rtmros-common \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'bayesian-belief-networks', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_BAYESIAN_BELIEF_NETWORKS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_BAYESIAN_BELIEF_NETWORKS = " \
    bayesian-belief-networks \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'canopen-master', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CANOPEN_MASTER}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CANOPEN_MASTER = " \
    canopen-402 \
    canopen-chain-node \
    canopen-master \
    cob-elmo-homing \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'cob-generic-can', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_COB_GENERIC_CAN}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_COB_GENERIC_CAN = " \
    cob-base-drive-chain \
    cob-canopen-motor \
    cob-generic-can \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'cob-obstacle-distance-moveit', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_COB_OBSTACLE_DISTANCE_MOVEIT}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_COB_OBSTACLE_DISTANCE_MOVEIT = " \
    cob-obstacle-distance-moveit \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'downward', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_DOWNWARD}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_DOWNWARD = " \
    downward \
    jsk-planning \
    pddl-planner \
    pddl-planner-viewer \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'exotica-collision-scene-fcl', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_EXOTICA_COLLISION_SCENE_FCL}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_EXOTICA_COLLISION_SCENE_FCL = " \
    exotica \
    exotica-examples \
    exotica-collision-scene-fcl \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'fetch-drivers', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FETCH_DRIVERS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FETCH_DRIVERS = " \
    fetch-drivers \
    freight-bringup \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ff', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FF}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FF = " \
    ff \
    jsk-planning \
    pddl-planner \
    pddl-planner-viewer \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ffha', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FFHA}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FFHA = " \
    ffha \
    jsk-planning \
    pddl-planner \
    pddl-planner-viewer \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'fmi-adapter', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FMI_ADAPTER}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FMI_ADAPTER = " \
    fmi-adapter \
    fmi-adapter-examples \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'hpp-fcl', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_HPP_FCL}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_HPP_FCL = " \
    hpp-fcl \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'julius', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_JULIUS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_JULIUS = " \
    jsk-3rdparty \
    julius-ros \
    julius \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'libg2o', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBG2O}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBG2O = " \
    libg2o \
    seed-r7-navigation \
    teb-local-planner \
    teb-local-planner-tutorials \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'libphidget21', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBPHIDGET21}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBPHIDGET21 = " \
    libphidget21 \
    phidgets-api \
    phidgets-drivers \
    phidgets-high-speed-encoder \
    phidgets-ik \
    phidgets-imu \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'libphidgets', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBPHIDGETS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBPHIDGETS = " \
    cob-extern \
    cob-phidget-em-state \
    cob-phidget-power-state \
    cob-phidgets \
    cob-voltage-control \
    libphidgets \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'libsiftfast', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBSIFTFAST}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBSIFTFAST = " \
    libsiftfast \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'libuvc-camera', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBUVC_CAMERA}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBUVC_CAMERA = " \
    libuvc-camera \
    libuvc-ros \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'map-merge-3d', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MAP_MERGE_3D}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MAP_MERGE_3D = " \
    map-merge-3d \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'multisense-ros', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MULTISENSE_ROS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MULTISENSE_ROS = " \
    multisense \
    multisense-bringup \
    multisense-cal-check \
    multisense-ros \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'naoqi-libqi', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_NAOQI_LIBQI}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_NAOQI_LIBQI = " \
    naoqi-driver \
    naoqi-libqi \
    naoqi-libqicore \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'nerian-stereo', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_NERIAN_STEREO}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_NERIAN_STEREO = " \
    nerian-stereo \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'nlopt', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_NLOPT}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_NLOPT = " \
    nlopt \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'obj-to-pointcloud', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OBJ_TO_POINTCLOUD}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OBJ_TO_POINTCLOUD = " \
    obj-to-pointcloud \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'odva-ethernetip', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ODVA_ETHERNETIP}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ODVA_ETHERNETIP = " \
    odva-ethernetip \
    omron-os32c-driver \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'p2os-urdf', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_P2OS_URDF}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_P2OS_URDF = " \
    p2os-launch \
    p2os-urdf \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'pr2-description', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PR2_DESCRIPTION}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PR2_DESCRIPTION = " \
    imu-monitor \
    joint-qualification-controllers \
    moveit-pr2 \
    pr2-apps \
    pr2-bringup \
    pr2-bringup-tests \
    pr2-calibration \
    pr2-calibration-controllers \
    pr2-calibration-launch \
    pr2-common \
    pr2-controller-configuration \
    pr2-controller-manager \
    pr2-controllers \
    pr2-counterbalance-check \
    pr2-description \
    pr2-ethercat \
    pr2-gripper-action \
    pr2-gripper-sensor \
    pr2-gripper-sensor-action \
    pr2-gripper-sensor-controller \
    pr2-robot \
    pr2-mannequin-mode \
    pr2-mechanism \
    pr2-mechanism-controllers \
    pr2-moveit-config \
    pr2-se-calibration-launch \
    pr2-self-test \
    pr2-teleop-general \
    pr2eus-moveit \
    pr2eus \
    robot-mechanism-controllers \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'rail-mesh-icp', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_RAIL_MESH_ICP}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_RAIL_MESH_ICP = " \
    rail-mesh-icp \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'rc-dynamics-api', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_RC_DYNAMICS_API}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_RC_DYNAMICS_API = " \
    rc-dynamics-api \
    rc-visard \
    rc-visard-driver \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'robot-body-filter', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROBOT_BODY_FILTER}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROBOT_BODY_FILTER = " \
    robot-body-filter \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ros-reflexxes', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROS_REFLEXXES}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROS_REFLEXXES = " \
    ipr-extern \
    ros-reflexxes \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'rosbag-editor', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROSBAG_EDITOR}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROSBAG_EDITOR = " \
    rosbag-editor \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'rosmon-core', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROSMON_CORE}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROSMON_CORE = " \
    rosmon-core \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'sainsmart-relay-usb', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_SAINSMART_RELAY_USB}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_SAINSMART_RELAY_USB = " \
    sainsmart-relay-usb \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'sbpl-lattice-planner', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_SBPL_LATTICE_PLANNER}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_SBPL_LATTICE_PLANNER = " \
    navigation-experimental \
    sbpl-lattice-planner \
    sbpl-recovery \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'schunk-libm5api', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_SCHUNK_LIBM5API}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_SCHUNK_LIBM5API = " \
    schunk-libm5api \
    schunk-modular-robotics \
    schunk-powercube-chain \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'schunk-sdh', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_SCHUNK_SDH}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_SCHUNK_SDH = " \
    schunk-modular-robotics \
    schunk-sdh \
    schunk-simulated-tactile-sensors \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'soem', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_SOEM}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_SOEM = " \
    soem \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'stage-ros', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_STAGE_ROS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_STAGE_ROS = " \
    navigation-stage \
    navigation-tutorials \
    roomba-stage \
    stage-ros \
    teb-local-planner-tutorials \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'usb-cam-controllers', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_USB_CAM_CONTROLLERS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_USB_CAM_CONTROLLERS = " \
    usb-cam-controllers \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'wamv-description', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_WAMV_DESCRIPTION}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_WAMV_DESCRIPTION = " \
    wamv-description \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'hector-pose-estimation-core', 'hector-pose-estimation-core hector-localization hector-pose-estimation' , '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'mobile-robot-simulator', 'mobile-robot-simulator' , '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'pointgrey-camera-driver', 'pointgrey-camera-driver' , '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'rosflight', 'rosflight' , '', d)}"

# do_install failures
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'omnibase-description', 'omnibase-description' , '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'omnibase-gazebo', 'omnibase-gazebo' , '', d)}"
