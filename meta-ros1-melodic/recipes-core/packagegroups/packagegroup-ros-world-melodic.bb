# Copyright (c) 2019-2021 LG Electronics, Inc.

DESCRIPTION = "All non-test packages for the target from files/crystal/cache.yaml"
LICENSE = "MIT"

# ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_* variables are MACHINE specific
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup
inherit ros_distro_melodic

PACKAGES = "${PN}"

RDEPENDS:${PN} = "${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES}"

# Provides the same library as prbt-ikfast-manipulator-plugin:
# webos-image-ros-world/1.0-r3/rootfs/usr/opt/ros/melodic/lib/libprbt_manipulator_moveit_ikfast_plugin.so
# with some patches applied on top of prbt-ikfast-manipulator-plugin source
RDEPENDS:${PN}:remove = "moveit-resources-prbt-ikfast-manipulator-plugin"

# Renamed to fuse-ros and fuse-ros-doc in recipes-bbappends/fuse to avoid conflict with
# meta-filesystems/recipes-support/fuse/fuse_2.9.9.bb
RDEPENDS:${PN}:remove = "fuse fuse-doc"

# Depends on blacklisted catkin-virtualenv (which requires Python 3)
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'catkin-virtualenv' , '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CATKIN_VIRTUALENV}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CATKIN_VIRTUALENV = " \
    catkin-virtualenv \
    clover \
    euslime \
    haros-catkin \
    ros-speech-recognition \
    sesame-ros \
"

# Contains only dev, dbg and staticdev files, so PN is empty and not created
RDEPENDS:${PN}:remove = "sophus"

# Contains only dev, dbg and staticdev files, so PN is empty and not created
# in neotic there was only 1 file in PN:
# azure-iot-sdk-c/1.7.0-4-r0/packages-split/azure-iot-sdk-c/usr/share/azure-iot-sdk-c/package.xml
RDEPENDS:${PN}:remove = "azure-iot-sdk-c"

# Contains only dev, dbg and staticdev files, so PN is empty and not created
RDEPENDS:${PN}:remove = "cloudwatch-metrics-common"

# Contains only dev, dbg and staticdev files, so PN is empty and not created
RDEPENDS:${PN}:remove = "lex-common"

# Contains only dev files, so PN is empty and not created
RDEPENDS:${PN}:remove = "qpmad"

# It is a fork of https://github.com/google/flatbuffers that's not used by any other ROS 1 package.
RDEPENDS:${PN}:remove = "flatbuffers"

# It is a "catkin-ized" edition of the upstream version that is not used by any other ROS 1 package.
RDEPENDS:${PN}:remove = "grpc"

# It is a "catkin-ized" edition of the upstream version that is not used by any other ROS 1 package.
# and meta-oe version is restricted to corei7 and armv8 with crypto enabled until:
# https://git.openembedded.org/meta-openembedded/commit/?id=7223513f400d63d1fb50d65b123d00ceb94f3695
RDEPENDS:${PN}:remove = "abseil-cpp"

# It is a "catkin-ized" edition of the upstream version that is not used by any other ROS 1 package.
RDEPENDS:${PN}:remove = "nanomsg"

# It has dependencies on Qt4 packages; it is not used by any other ROS 1 package.
RDEPENDS:${PN}:remove = "octovis"

# Expects jderobot header files in wrong directory (/opt/jderobot/include/jderobot/types/image.h) and not compatible with opencv version we're using
RDEPENDS:${PN}:remove = "jderobot-camviz"

# Generation of ROS package documentation will never be done on the target.
RDEPENDS:${PN}:remove = "rosdoc-lite"
# Depends on blacklisted rosdoc-lite
RDEPENDS:${PN}:remove = "jackal-tutorials"
RDEPENDS:${PN}:remove = "odom-frame-publisher"

# Fetches depot_tools during do_configure and then tries to use vpython which isn't in dependencies
RDEPENDS:${PN}:remove = "webrtc"
RDEPENDS:${PN}:remove = "webrtc-ros"

# Not compatible with newer libftdi included in meta-oe: https://github.com/kobuki-base/kobuki_ftdi/issues/3
RDEPENDS:${PN}:remove = "kobuki-ftdi"

# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-python-requests-oauthlib' (but generated-recipes/jsk-3rdparty/rostwitter_2.1.13-1.bb DEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "rostwitter"

# Depends on unavailable ROS_UNRESOLVED_DEP-atlas, ROS_UNRESOLVED_DEP-jython ROS_UNRESOLVED_DEP-f2c
RDEPENDS:${PN}:remove = "openhrp3"

# Depends on unavailable ROS_UNRESOLVED_DEP-libirrlicht-dev, ROS_UNRESOLVED_DEP-net-tools, ROS_UNRESOLVED_DEP-procps, ROS_UNRESOLVED_DEP-ipython, ROS_UNRESOLVED_DEP-hostname and blacklisted openhrp3
RDEPENDS:${PN}:remove = "hrpsys-ros-bridge"

# Depends on unavailable ROS_UNRESOLVED_DEP-libirrlicht-dev, ROS_UNRESOLVED_DEP-net-tools, ROS_UNRESOLVED_DEP-procps, ROS_UNRESOLVED_DEP-ipython, ROS_UNRESOLVED_DEP-hostname and blacklisted openhrp3 and hrpsys-ros-bridge
RDEPENDS:${PN}:remove = "rtmros-common"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opencv-native', 'aruco-pose', '', d)}"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python-mechanize', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_MECHANIZE}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_MECHANIZE = " \
    pr2-bringup \
    pr2-bringup-tests \
    pr2-self-test \
    wifi-ddwrt \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python-speechrecognition-pip', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_SPEECHRECOGNITION_PIP}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_SPEECHRECOGNITION_PIP = " \
    respeaker-ros \
    ros-speech-recognition \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python-gi', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_GI}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_GI = " \
    audio-common \
    sound-play \
    tts \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python-imageio', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_IMAGEIO}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_IMAGEIO = " \
    movie-publisher \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'nkf', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_NKF}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_NKF = " \
    aques-talk \
    voice-text \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'kakasi', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_KAKASI}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_KAKASI = " \
    aques-talk \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python-google-cloud-texttospeech-pip', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_GOOGLE_CLOUD_TEXTTOSPEECH_PIP}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_GOOGLE_CLOUD_TEXTTOSPEECH_PIP = " \
    google-cloud-texttospeech \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'rospilot', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROSPILOT}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROSPILOT = " \
    rospilot \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'parrot-arsdk', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PARROT_ARSDK}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PARROT_ARSDK = " \
    parrot-arsdk \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python-whichcraft', 'leo-fw leo-robot', '', d)}"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'xclip', 'log-view', '', d)}"

# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-python-docker' (but generated-recipes/dockeros/dockeros_1.1.0-1.bb DEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "dockeros"

# ERROR: Nothing PROVIDES 'python-twisted-core' (but generated-recipes/linux-networking/multi-interface-roam_1.0.16-1.bb DEPENDS on or otherwise requires it). Close matches:
RDEPENDS:${PN}:remove = "multi-interface-roam"
RDEPENDS:${PN}:remove = "linux-networking"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python-omniorb', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_OMNIORB}', '', d)}"
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

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python-dialogflow-pip', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_DIALOGFLOW_PIP}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_DIALOGFLOW_PIP = " \
    dialogflow-task-executive \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'pydrive-pip', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYDRIVE_PIP}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYDRIVE_PIP = " \
    gdrive-ros \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'pugixml', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PUGIXML}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PUGIXML = " \
    lanelet2 \
    lanelet2-examples \
    lanelet2-io \
    lanelet2-projection \
    lanelet2-python \
    lanelet2-validation \
"

# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-libxmlrpc-c++"
RDEPENDS:${PN}:remove = "ifm3d"
RDEPENDS:${PN}:remove = "ifm3d-core"

# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-python-libpgm-pip' (but generated-recipes/jsk-3rdparty/pgm-learner_2.1.13-1.bb DEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "pgm-learner"

ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_LIBREFLEXXESTYPE2:x86-64 = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_LIBREFLEXXESTYPE2 = "\
    libreflexxestype2 \
    ros-reflexxes \
    ipr-extern \
"

ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_LIBNTCAN:x86 = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_LIBNTCAN:x86-64 = ""
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
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_PROSILICA_GIGE_SDK:x86 = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_PROSILICA_GIGE_SDK:x86-64 = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_PROSILICA_GIGE_SDK:armv7a = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', 'prosilica-gige-sdk prosilica-camera', '', d)}"
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_PROSILICA_GIGE_SDK:armv7ve = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', 'prosilica-gige-sdk prosilica-camera', '', d)}"
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_PROSILICA_GIGE_SDK_ppc = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_PROSILICA_GIGE_SDK = "\
    prosilica-camera \
    prosilica-gige-sdk \
"

ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API:x86 = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API:x86-64 = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API:armv7a = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', 'rc-genicam-api rc-genicam-driver rc-genicam-camera rc-visard-driver rc-visard', '', d)}"
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API:armv7ve = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', 'rc-genicam-api rc-genicam-driver rc-genicam-camera rc-visard-driver rc-visard', '', d)}"
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API:aarch64 = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API = "\
    rc-genicam-api rc-genicam-driver rc-genicam-camera rc-visard-driver rc-visard \
"

ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_MICROSTRAIN-INERTIAL-DRIVER:x86-64 = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_MICROSTRAIN-INERTIAL-DRIVER:armv7a = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', '', 'microstrain-inertial-driver', d)}"
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_MICROSTRAIN-INERTIAL-DRIVER:armv7ve = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', '', 'microstrain-inertial-driver', d)}"
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_MICROSTRAIN-INERTIAL-DRIVER:aarch64 = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_MICROSTRAIN-INERTIAL-DRIVER = "\
    microstrain-inertial-driver \
"

ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC = " \
    ${ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_MICROSTRAIN-INERTIAL-DRIVER} \
    ${ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_PROSILICA_GIGE_SDK} \
    ${ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API} \
    ${ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_LIBREFLEXXESTYPE2} \
    ${ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_LIBNTCAN} \
"

RDEPENDS:${PN}:remove = "${ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC}"

# There is recipe for glfw in meta-oe in dunfell:
# http://cgit.openembedded.org/meta-openembedded/commit/meta-oe/recipes-core/glfw/glfw_3.3.bb?id=a7464eaa69a7ee4734001aab2e232102e7135772
# but we don't have a backports layer from dunfell yet, lets skip it for now
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'glfw', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GLFW}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GLFW = " \
    librealsense2 \
    mrpt2 \
    realsense2-camera \
"

# recipes depending on various unavailable python modules
# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-python-cairosvg' (but generated-recipes/fiducials/aruco-detect_0.11.0-1.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-python-joblib' (but generated-recipes/fiducials/aruco-detect_0.11.0-1.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-python-urlgrabber' (but generated-recipes/jsk-visualization/jsk-rqt-plugins_2.1.5.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-python-sklearn' (but generated-recipes/jsk-visualization/jsk-rqt-plugins_2.1.5.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-python-cairo' (but generated-recipes/rqt-bag/rqt-bag-plugins_0.4.12.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-python-opengl' (but generated-recipes/rqt-pose-view/rqt-pose-view_0.5.8.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing RPROVIDES 'ROS_UNRESOLVED_DEP-python-termcolor' (but generated-recipes/criutils/criutils_0.1.3-2.bb RDEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python-deps', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_DEPS}', '', d)}"
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

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'pyqt5', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYQT5}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYQT5 = " \
    adi-driver \
    cob-command-tools \
    cob-dashboard \
    dataspeed-pds-rqt \
    dingo-desktop \
    dingo-viz \
    flir-ptu-viz \
    fmi-adapter-examples \
    fuse-ros \
    fuse-viz \
    gl-dependency \
    gundam-rx78-control \
    heron-desktop \
    heron-viz \
    hrpsys-ros-bridge \
    jderobot-drones \
    leo-desktop \
    leo-viz \
    mesh-tools \
    moose-desktop \
    moose-viz \
    moveit-resources-prbt-moveit-config \
    mrp2-desktop \
    mrp2-viz \
    pf-driver \
    pilz-status-indicator-rqt \
    pr2-motor-diagnostic-tool \
    python-qt-binding \
    psen-scan-v2 \
    qt-gui \
    qt-gui-app \
    qt-gui-core \
    qt-gui-cpp \
    radial-menu \
    radial-menu-example \
    radial-menu-rviz \
    robot-nav-rviz-plugins \
    robot-nav-viz-demos \
    robot-nav-tools \
    robot-statemachine \
    robotont-description \
    robotont-nuc-description \
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
    rqt-play-motion-builder \
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
    rsm-rqt-plugins \
    rsm-rviz-plugins \
    rtmros-common \
    rviz-map-plugin \
    rviz-mesh-plugin \
    rviz-satellite \
    sick-safetyscanners \
    visualstates \
    webkit-dependency \
    webots-ros \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'vtk-qt', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_VTK_QT}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_VTK_QT = " \
    cvp-mesh-planner \
    dijkstra-mesh-planner \
    ira-laser-tools \
    lvr2 \
    mbf-mesh-core \
    mbf-mesh-nav \
    mesh-client \
    mesh-controller \
    mesh-map \
    mesh-msgs-conversions \
    mesh-navigation \
    mesh-layers \
    rc-cloud-accumulator \
    rtabmap \
    rtabmap-ros \
    simple-grasping \
    wave-front-planner \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'x11', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_X11}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_X11 = " \
    audio-to-spectrogram \
    cob-collision-monitor \
    cob-obstacle-distance-moveit \
    denso-robot-ros \
    denso-robot-moveit-config \
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
    heifu \
    image-pipeline \
    image-view \
    image-view2 \
    industrial-core \
    industrial-trajectory-filters \
    khi-duaro-moveit-config \
    khi-robot \
    khi-robot-bringup \
    khi-rs007l-moveit-config \
    khi-rs007n-moveit-config \
    khi-rs080n-moveit-config \
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
    pilz-industrial-motion-planner-testutils \
    pilz-industrial-motion-planner \
    pilz-industrial-motion-testutils \
    pilz-industrial-motion \
    pilz-robot-programming \
    pilz-trajectory-generation \
    pincher-arm \
    pincher-arm-moveit-config \
    pincher-arm-moveit-demos \
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
    webots-ros \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'mongodb', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MONGODB}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MONGODB = " \
    mongodb-log \
    mongodb-store \
    warehouse-ros-mongo \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'mongodb-legacy-cxx-driver', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MONGODB_LEGACY_CXX_DRIVER}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MONGODB_LEGACY_CXX_DRIVER = " \
    mongodb-log \
    mongodb-store \
    warehouse-ros-mongo \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'vlc', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_VLC}', '', d)}"
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

# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-python-pyusb-pip' (but generated-recipes/jsk-3rdparty/respeaker-ros_2.1.13-1.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-python-speechrecognition-pip' (but generated-recipes/jsk-3rdparty/respeaker-ros_2.1.13-1.bb DEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "respeaker-ros"

# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-python-catkin-tools' (but generated-recipes/jsk-3rdparty/collada-urdf-jsk-patch_2.1.13-1.bb DEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "collada-urdf-jsk-patch"

# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-python-avahi' (but generated-recipes/multimaster-fkie/master-discovery-fkie_0.8.12.bb DEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "master-discovery-fkie"
# ERROR: Nothing PROVIDES 'master-discovery-fkie' (but generated-recipes/multimaster-fkie/master-sync-fkie_0.8.12.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing RPROVIDES 'master-discovery-fkie' (but generated-recipes/multimaster-fkie/master-sync-fkie_0.8.12.bb, generated-recipes/cpr-multimaster-tools/multimaster-launch_0.0.2-1.bb RDEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "master-sync-fkie"
RDEPENDS:${PN}:remove = "node-manager-fkie"
RDEPENDS:${PN}:remove = "multimaster-fkie"
# ERROR: Nothing RPROVIDES 'master-discovery-fkie' (but generated-recipes/multimaster-fkie/master-sync-fkie_0.8.12.bb, generated-recipes/cpr-multimaster-tools/multimaster-launch_0.0.2-1.bb RDEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "multimaster-launch"
# ERROR: Nothing PROVIDES 'multimaster-launch' (but generated-recipes/husky/husky-control_0.4.2-1.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing RPROVIDES 'multimaster-launch' (but generated-recipes/husky/husky-control_0.4.2-1.bb, generated-recipes/cpr-multimaster-tools/cpr-multimaster-tools_0.0.2-1.bb RDEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "husky-control"
# ERROR: Nothing RPROVIDES 'multimaster-launch' (but generated-recipes/husky/husky-control_0.4.2-1.bb, generated-recipes/cpr-multimaster-tools/cpr-multimaster-tools_0.0.2-1.bb RDEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "cpr-multimaster-tools"
# ERROR: Nothing PROVIDES 'husky-control' (but generated-recipes/husky/husky-base_0.4.2-1.bb DEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "husky-base"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python-cwiid', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_CWIID}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_CWIID = " \
    joystick-drivers \
    wiimote \
"

# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-libopenvdb' (but generated-recipes/spatio-temporal-voxel-layer/spatio-temporal-voxel-layer_1.3.5-2.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-libopenexr-dev' (but generated-recipes/spatio-temporal-voxel-layer/spatio-temporal-voxel-layer_1.3.5-2.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-libopenvdb-dev' (but generated-recipes/spatio-temporal-voxel-layer/spatio-temporal-voxel-layer_1.3.5-2.bb DEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "spatio-temporal-voxel-layer"

# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-gfortran' (but generated-recipes/optpp-catkin/optpp-catkin_2.4.0-1.bb DEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "optpp-catkin"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'fortran', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FORTRAN}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FORTRAN = " \
    abb-irb2400-moveit-plugins \
    cartographer-ros \
    cartographer \
    ceres-solver \
    fetch-calibration \
    fetch-ikfast-plugin \
    fetch-navigation \
    husky-cartographer-navigation \
    jackal-cartographer-navigation \
    lapack \
    mrp2-common \
    mrp2-navigation \
    nav2d-karto \
    nav2d-tutorials \
    nav2d \
    nextage-ik-plugin \
    ridgeback-cartographer-navigation \
    robot-calibration \
    slam-karto \
    sparse-bundle-adjustment \
    suitesparse-cholmod \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'openni', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENNI}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENNI = " \
    openni-camera \
    openni-launch \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'openni2', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENNI2}', '', d)}"
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

# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-gforth' (but generated-recipes/wge100-driver/wge100-camera-firmware_1.8.2-1.bb DEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "wge100-camera-firmware"

# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-arduino-core' (but generated-recipes/rosserial/rosserial-arduino_0.8.0.bb DEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "rosserial-arduino"

# Depends on unavailable ROS_UNRESOLVED_DEP-arduino-core, ROS_UNRESOLVED_DEP-avr-libc, ROS_UNRESOLVED_DEP-avrdude, ROS_UNRESOLVED_DEP-gcc-avr, ROS_UNRESOLVED_DEP-tar
RDEPENDS:${PN}:remove = "rosserial-leonardo-cmake"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'coinor-libipopt', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_COINOR_LIBIPOPT}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_COINOR_LIBIPOPT = " \
    control-box-rst \
    ifopt \
    mpc-local-planner-examples \
    mpc-local-planner \
    towr-ros \
    towr \
"

# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-npm-native' (but generated-recipes/vapor-master/vapor-master_0.3.0.bb DEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "vapor-master"

# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-libopenscenegraph' (but generated-recipes/visualization-osg/osg-utils_1.0.2-2.bb, generated-recipes/visualization-osg/osg-interactive-markers_1.0.2-2.bb, generated-recipes/visualization-osg/osg-markers_1.0.2-2.bb DEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'osg', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OSG}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OSG = " \
    osg-interactive-markers \
    osg-markers \
    osg-utils \
    uwsim \
    uwsim-osgbullet \
    uwsim-osgocean \
    uwsim-osgworks \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'muparser', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MUPARSER}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MUPARSER = " \
    canopen-motor-node \
    end-effector \
    moveit-resources-prbt-pg70-support \
    moveit-resources-prbt-support \
    pilz-robots \
    prbt-grippers \
    prbt-moveit-config \
    prbt-pg70-support \
    prbt-support \
    ros-canopen \
"

# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-java' (but generated-recipes/nao-meshes/nao-meshes_0.1.12-2.bb, generated-recipes/pepper-meshes/pepper-meshes_0.2.4-3.bb DEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "nao-meshes"
RDEPENDS:${PN}:remove = "pepper-meshes"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'clang-tidy', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CLANG_TIDY}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CLANG_TIDY = " \
    pilz-control \
    pilz-robots \
    pilz-status-indicator-rqt \
    pilz-utils \
    prbt-hardware-support \
    prbt-moveit-config \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'libspnav', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBSPNAV}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBSPNAV = " \
    moveit-servo \
    spacenav-node \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lcm', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LCM}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LCM = " \
    dataspeed-pds \
    dataspeed-pds-lcm \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'libpqxx', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBPQXX}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBPQXX = " \
    knowledge-representation \
"

# ERROR: Nothing PROVIDES 'ifopt' (but generated-recipes/towr/towr_1.4.1.bb DEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "towr"

# ERROR: Nothing PROVIDES 'pilz-utils' (but generated-recipes/pilz-robots/prbt-hardware-support_0.5.13-1.bb DEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "prbt-hardware-support"

# ERROR: Nothing PROVIDES 'osg-markers' (but generated-recipes/visualization-osg/visualization-osg_1.0.2-2.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'osg-utils' (but generated-recipes/visualization-osg/visualization-osg_1.0.2-2.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'osg-interactive-markers' (but generated-recipes/visualization-osg/visualization-osg_1.0.2-2.bb DEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "visualization-osg"

# ERROR: Nothing PROVIDES 'wge100-camera-firmware' (but generated-recipes/wge100-driver/wge100-driver_1.8.2-1.bb DEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "wge100-driver"

# ERROR: Nothing RPROVIDES 'canopen-motor-node' (but generated-recipes/pilz-robots/prbt-support_0.5.13-1.bb, generated-recipes/ros-canopen/ros-canopen_0.8.2-1.bb RDEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "prbt-support"
RDEPENDS:${PN}:remove = "ros-canopen"

# ERROR: Nothing RPROVIDES 'ROS_UNRESOLVED_DEP-python-pandas' (but generated-recipes/rosbag-pandas/rosbag-pandas_0.5.3.bb RDEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "rosbag-pandas"

# ERROR: Nothing RPROVIDES 'ROS_UNRESOLVED_DEP-python-termcolor' (but generated-recipes/py-trees-ros/py-trees-ros_0.5.18.bb RDEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "py-trees-ros"

# ERROR: Nothing RPROVIDES 'ROS_UNRESOLVED_DEP-python-msgpack' (but generated-recipes/json-transport/json-transport_0.0.3.bb RDEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "json-transport"

# ERROR: Nothing RPROVIDES 'ROS_UNRESOLVED_DEP-python-catkin-lint' (but generated-recipes/fetch-tools/fetch-tools_0.2.1.bb RDEPENDS on or otherwise requires it)
# ERROR: Nothing RPROVIDES 'ROS_UNRESOLVED_DEP-python-argcomplete' (but generated-recipes/fetch-tools/fetch-tools_0.2.1.bb RDEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "fetch-tools"

# Conflicts with platform fcl, causing
# ERROR: moveit-core-1.0.2-1-r0 do_package: moveit-core: Multiple shlib providers for libfcl.so.0.6: fcl, fcl-catkin (used by files: /jenkins/home/workspace/jansa/webos-melodic-dunfell/webos-melodic-dunfell/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/moveit-core/1.0.2-1-r0/packages-split/moveit-core/usr/opt/ros/melodic/lib/libmoveit_collision_detection_fcl.so.1.0.2)
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'fcl-catkin', 'fcl-catkin', '', d)}"

# ERROR: Nothing RPROVIDES 'ROS_UNRESOLVED_DEP-network-manager' (but generated-recipes/network-autoconfig/network-autoconfig_0.1.1-2.bb RDEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "network-autoconfig"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python-scipy', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_SCIPY}', '', d)}"
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
    jsk-footstep-controller \
    jsk-footstep-planner \
    jsk-interactive-marker \
    jsk-interactive-test \
    jsk-interactive \
    jsk-pcl-ros-utils \
    jsk-pcl-ros \
    jsk-perception \
    jsk-recognition-utils \
    jsk-recognition \
    jsk-rviz-plugins \
    jsk-teleop-joy \
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

# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-libnlopt-dev' (but generated-recipes/trac-ik/trac-ik-lib_1.5.1-1.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-libnlopt0' (but generated-recipes/trac-ik/trac-ik-lib_1.5.1-1.bb DEPENDS on or otherwise requires it)
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'trac-ik', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_TRAC_IK}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_TRAC_IK = " \
    nextage-moveit-config \
    trac-ik \
    trac-ik-examples \
    trac-ik-kinematics-plugin \
    trac-ik-lib \
    trac-ik-python \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ogre', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OGRE}', '', d)}"
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
    denso-robot-ros \
    denso-robot-moveit-config \
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
    flir-ptu-viz \
    franka-example-controllers \
    franka-gazebo \
    franka-ros \
    fuse-ros \
    fuse-viz \
    grid-map \
    grid-map-demos \
    grid-map-rviz-plugin \
    gundam-rx78-description \
    heron-desktop \
    heron-viz \
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
    moveit-resources-prbt-moveit-config \
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
    pf-driver \
    pincher-arm \
    pincher-arm-moveit-config \
    pincher-arm-moveit-demos \
    psen-scan-v2 \
    psen-scan \
    radial-menu \
    radial-menu-example \
    radial-menu-rviz \
    ridgeback-desktop \
    ridgeback-viz \
    robot-nav-rviz-plugins \
    robot-nav-viz-demos \
    robot-nav-tools \
    robot-statemachine \
    robotont-description \
    robotont-nuc-description \
    rqt-rviz \
    rsm-rviz-plugins \
    rviz \
    rviz-animated-view-controller \
    rviz-imu-plugin \
    rviz-map-plugin \
    rviz-mesh-plugin \
    rviz-python-tutorial \
    rviz-plugin-tutorials \
    rviz-satellite \
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

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT5}', '', d)}"

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
    cvp-mesh-planner \
    dataspeed-pds-rqt \
    denso-robot-ros \
    denso-robot-moveit-config \
    desktop \
    desktop-full \
    dijkstra-mesh-planner \
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
    flir-ptu-viz \
    fmi-adapter-examples \
    franka-example-controllers \
    franka-gazebo \
    franka-ros \
    fsrobo-r \
    fsrobo-r-bringup \
    fsrobo-r-moveit-config \
    fuse-ros \
    fuse-viz \
    geometry-tutorials \
    gl-dependency \
    grid-map \
    grid-map-demos \
    grid-map-rviz-plugin \
    gundam-robot \
    gundam-rx78-control \
    heron-desktop \
    heron-viz \
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
    jsk-footstep-controller \
    jsk-footstep-planner \
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
    jsk-teleop-joy \
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
    mbf-mesh-core \
    mbf-mesh-nav \
    mesh-client \
    mesh-controller \
    mesh-layers \
    mesh-map \
    mesh-msgs-conversions \
    mesh-navigation \
    mesh-tools \
    mir-gazebo \
    mir-robot \
    moose-desktop \
    moose-viz \
    moveit \
    moveit-resources-prbt-moveit-config \
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
    open-manipulator-p-control-gui \
    open-manipulator-p \
    open-manipulator-with-tb3 \
    panda-moveit-config \
    pf-driver \
    pilz-robots \
    pilz-status-indicator-rqt \
    pincher-arm \
    pincher-arm-moveit-config \
    pincher-arm-moveit-demos \
    plotjuggler-ros \
    plotjuggler \
    points-preprocessor \
    pr2-motor-diagnostic-tool \
    pr2eus-tutorials \
    prbt-gazebo \
    prbt-grippers \
    prbt-moveit-config \
    prbt-pg70-support \
    psen-scan-v2 \
    python-qt-binding \
    qt-dotgraph \
    qt-gui \
    qt-gui-app \
    qt-gui-core \
    qt-gui-cpp \
    qt-gui-py-common \
    qt-paramedit \
    qt-qmake \
    radial-menu \
    radial-menu-example \
    radial-menu-rviz \
    rc-cloud-accumulator \
    ridgeback-desktop \
    ridgeback-viz \
    robot-nav-rviz-plugins \
    robot-nav-viz-demos \
    robot-nav-tools \
    robot-statemachine \
    robotont-description \
    robotont-nuc-description \
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
    rqt-paramedit \
    rqt-play-motion-builder \
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
    rsm-rqt-plugins \
    rsm-rviz-plugins \
    rtabmap-ros \
    rtmros-common \
    rviz \
    rviz-animated-view-controller \
    rviz-imu-plugin \
    rviz-map-plugin \
    rviz-mesh-plugin \
    rviz-plugin-tutorials \
    rviz-python-tutorial \
    rviz-satellite \
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
    wave-front-planner \
    webkit-dependency \
    webots-ros \
"

# OE won't let us build ffmpeg unless LICENSE_FLAGS_WHITELIST contains "commercial" or "commercial_ffmpeg" or "ffmpeg".
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ffmpeg', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FFMPEG}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FFMPEG = " \
    clover \
    codec-image-transport \
    h264-encoder-core \
    h264-video-encoder \
    leo-bringup \
    leo-robot \
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
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'x264', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_X264}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_X264 = " \
    clover \
    codec-image-transport \
    h264-encoder-core \
    h264-video-encoder \
    leo-bringup \
    leo-robot \
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
# meta-webos/recipes-qt/qt5/qtbase_git.bbappend:PACKAGECONFIG:remove = "widgets"
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5-widgets', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_QT5_WIDGETS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_QT5_WIDGETS = " \
    asmach-tutorials \
    common-tutorials \
    dynamixel-workbench \
    dynamixel-workbench-single-manager-gui \
    find-object-2d \
    geometry-tutorials \
    open-manipulator-control-gui \
    open-manipulator-p-control-gui \
    open-manipulator-p \
    plotjuggler-ros \
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
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gst-ugly', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GSTREAMER1.0_PLUGINS_UGLY}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GSTREAMER1.0_PLUGINS_UGLY = " \
    aques-talk \
    audio-capture \
    audio-common \
    audio-play \
    audio-to-spectrogram \
    cis-camera \
    python-google-cloud-texttospeech-pip \
    imagesift \
    jsk-3rdparty \
    jsk-common \
    jsk-data \
    jsk-footstep-controller \
    jsk-footstep-planner \
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
    jsk-teleop-joy \
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
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GAZEBO}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GAZEBO = " \
    ainstein-radar \
    ainstein-radar-gazebo-plugins \
    ati-force-torque \
    audibot \
    audibot-gazebo \
    blender-gazebo \
    clover-description \
    clover-simulation \
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
    copernicus-control \
    denso-robot-gazebo \
    denso-robot-ros \
    denso-robot-moveit-config \
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
    franka-gazebo \
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
    gazebo-video-monitors \
    gundam-robot \
    gundam-rx78-gazebo \
    hector-gazebo \
    hector-gazebo-plugins \
    hector-gazebo-thermal-camera \
    hector-gazebo-worlds \
    hector-sensors-gazebo \
    heifu-description \
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
    khi-duaro-gazebo \
    khi-rs-gazebo \
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
    open-manipulator-p-gazebo \
    open-manipulator-p-simulations \
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
    robotont-gazebo \
    rosflight-pkgs \
    rosflight-sim \
    rosflight-utils \
    rotors-gazebo \
    rotors-gazebo-plugins \
    rotors-simulator \
    rqt-drone-teleop \
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
    volta-description \
    volta-simulation \
    vrx-gazebo \
    wamv-gazebo \
    warthog-gazebo \
    warthog-simulator \
    wave-gazebo \
    wave-gazebo-plugins \
    yosemite-valley \
"

# Depends on libqt4-dev from https://git.yoctoproject.org/cgit/cgit.cgi/meta-qt4
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt4', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT4}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT4 = " \
    hector-geotiff \
    hector-geotiff-plugins \
    hector-slam \
    hector-slam-launch \
    qt-ros \
    qt-tutorials \
"

# Depends on something from meta-networking
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'networking', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_NETWORKING}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_NETWORKING = " \
    azure-iot-sdk-c \
"

# Depends on vlc from meta-multimedia
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'multimedia', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_MULTIMEDIA}', '', d)}"

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

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'wxpython', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_WXPYTHON}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_WXPYTHON = " \
    executive-smach-visualization \
    jsk-planning \
    rx-service-tools \
    seed-r7-ros-pkg \
    seed-r7-samples \
    smach-viewer \
    task-compiler \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lisp', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_LISP}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_LISP = " \
    actionlib-lisp \
    cl-tf \
    cl-tf2 \
    cl-transforms \
    cl-transforms-stamped \
    cl-urdf \
    cl-utils \
    contact-states-observer \
    eus-assimp \
    eus-nlopt \
    eus-qp \
    eus-qpoases \
    euslime \
    euslisp \
    geneus \
    genlisp \
    jskeus \
    jsk-calibration \
    jsk-control \
    jsk-footstep-planner \
    jsk-ik-server \
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
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opengl', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENGL}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENGL = " \
    abb \
    abb-irb2400-moveit-config \
    abb-irb6640-moveit-config \
    cob-collision-monitor \
    cob-obstacle-distance-moveit \
    cob-moveit-bringup \
    cob-moveit-interface \
    denso-robot-ros \
    denso-robot-moveit-config \
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
    khi-duaro-moveit-config \
    khi-robot \
    khi-robot-bringup \
    khi-rs007l-moveit-config \
    khi-rs007n-moveit-config \
    khi-rs080n-moveit-config \
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
    pilz-industrial-motion-planner-testutils \
    pilz-industrial-motion-planner \
    pilz-industrial-motion-testutils \
    pilz-industrial-motion \
    pilz-robot-programming \
    pilz-trajectory-generation \
    pincher-arm \
    pincher-arm-moveit-config \
    pincher-arm-moveit-demos \
    play-motion \
    pr2-moveit-config \
    realsense2-camera \
    rc-visard \
    robot-body-filter \
    roomba-stage \
    rtabmap \
    rtabmap-ros \
    rviz-animated-view-controller \
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
    webots-ros \
    wxwidgets \
    rc-roi-manager-gui \
    rqt-pose-view \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'heifu-ros-utils', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROS_UTILS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROS_UTILS = " \
    heifu-bringup \
    heifu-diagnostic \
    heifu-mavros \
    heifu-safety \
    heifu-simple-waypoint \
    heifu \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ueye', 'ueye-cam', '', d)}"

# do_configure failures
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'dccomms-ros', 'dccomms-ros' , '', d)}"
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'pyros-utils', 'pyros-utils' , '', d)}"
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'dynamic-graph-python', 'dynamic-graph-python dynamic-graph-tutorial sot-core sot-tools sot-dynamic-pinocchio' , '', d)}"
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'hdf5-map-io', 'hdf5-map-io mesh-msgs-hdf5' , '', d)}"
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'jderobot-carviz', 'jderobot-carviz' , '', d)}"
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lanelet2-traffic-rules', 'lanelet2-traffic-rules lanelet2-routing' , '', d)}"
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'novatel-oem7-driver', 'novatel-oem7-driver' , '', d)}"

# do_compile failures
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt-gui-cpp', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_QT_GUI_CPP}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_QT_GUI_CPP = " \
    mapviz-plugins \
    mapviz \
    multires-image \
    qt-gui-core \
    qt-gui-cpp \
    robot-statemachine \
    rosmon \
    rqt-gui-cpp \
    rqt-image-view \
    rqt-multiplot \
    rqt-play-motion-builder \
    rqt-rosmon \
    rqt-rviz \
    rqt \
    rsm-rqt-plugins \
    tile-map \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'assimp-devel', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ASSIMP_DEVEL}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ASSIMP_DEVEL = " \
    assimp-devel \
    euscollada \
    hrpsys-ros-bridge \
    pr2eus-moveit \
    pr2eus \
    rtmros-common \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'bayesian-belief-networks', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_BAYESIAN_BELIEF_NETWORKS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_BAYESIAN_BELIEF_NETWORKS = " \
    bayesian-belief-networks \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'canopen-master', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CANOPEN_MASTER}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CANOPEN_MASTER = " \
    canopen-402 \
    canopen-chain-node \
    canopen-master \
    cob-elmo-homing \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'cob-generic-can', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_COB_GENERIC_CAN}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_COB_GENERIC_CAN = " \
    cob-base-drive-chain \
    cob-canopen-motor \
    cob-generic-can \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'cob-obstacle-distance-moveit', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_COB_OBSTACLE_DISTANCE_MOVEIT}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_COB_OBSTACLE_DISTANCE_MOVEIT = " \
    cob-obstacle-distance-moveit \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'downward', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_DOWNWARD}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_DOWNWARD = " \
    downward \
    jsk-planning \
    pddl-planner \
    pddl-planner-viewer \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'exotica-collision-scene-fcl', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_EXOTICA_COLLISION_SCENE_FCL}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_EXOTICA_COLLISION_SCENE_FCL = " \
    exotica \
    exotica-examples \
    exotica-collision-scene-fcl \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'fetch-drivers', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FETCH_DRIVERS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FETCH_DRIVERS = " \
    fetch-drivers \
    freight-bringup \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ff', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FF}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FF = " \
    ff \
    jsk-planning \
    pddl-planner \
    pddl-planner-viewer \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ffha', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FFHA}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FFHA = " \
    ffha \
    jsk-planning \
    pddl-planner \
    pddl-planner-viewer \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'fmi-adapter', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FMI_ADAPTER}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FMI_ADAPTER = " \
    fmi-adapter \
    fmi-adapter-examples \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'hpp-fcl', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_HPP_FCL}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_HPP_FCL = " \
    hpp-fcl \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'julius', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_JULIUS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_JULIUS = " \
    jsk-3rdparty \
    julius-ros \
    julius \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'libg2o', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBG2O}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBG2O = " \
    libg2o \
    seed-r7-navigation \
    teb-local-planner \
    teb-local-planner-tutorials \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'libphidget21', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBPHIDGET21}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBPHIDGET21 = " \
    libphidget21 \
    phidgets-api \
    phidgets-drivers \
    phidgets-high-speed-encoder \
    phidgets-ik \
    phidgets-imu \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'libphidgets', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBPHIDGETS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBPHIDGETS = " \
    cob-extern \
    cob-phidget-em-state \
    cob-phidget-power-state \
    cob-phidgets \
    cob-voltage-control \
    libphidgets \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'libsiftfast', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBSIFTFAST}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBSIFTFAST = " \
    libsiftfast \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'libuvc-camera', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBUVC_CAMERA}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBUVC_CAMERA = " \
    libuvc-camera \
    libuvc-ros \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'map-merge-3d', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MAP_MERGE_3D}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MAP_MERGE_3D = " \
    map-merge-3d \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'multisense-ros', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MULTISENSE_ROS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MULTISENSE_ROS = " \
    multisense \
    multisense-bringup \
    multisense-cal-check \
    multisense-ros \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'naoqi-libqi', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_NAOQI_LIBQI}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_NAOQI_LIBQI = " \
    naoqi-driver \
    naoqi-libqi \
    naoqi-libqicore \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'nerian-stereo', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_NERIAN_STEREO}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_NERIAN_STEREO = " \
    nerian-stereo \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'nlopt', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_NLOPT}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_NLOPT = " \
    nlopt \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'obj-to-pointcloud', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OBJ_TO_POINTCLOUD}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OBJ_TO_POINTCLOUD = " \
    obj-to-pointcloud \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'odva-ethernetip', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ODVA_ETHERNETIP}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ODVA_ETHERNETIP = " \
    odva-ethernetip \
    omron-os32c-driver \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'p2os-urdf', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_P2OS_URDF}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_P2OS_URDF = " \
    p2os-launch \
    p2os-urdf \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'pr2-description', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PR2_DESCRIPTION}', '', d)}"
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

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'rail-mesh-icp', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_RAIL_MESH_ICP}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_RAIL_MESH_ICP = " \
    rail-mesh-icp \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'robot-body-filter', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROBOT_BODY_FILTER}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROBOT_BODY_FILTER = " \
    robot-body-filter \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ros-reflexxes', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROS_REFLEXXES}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROS_REFLEXXES = " \
    ipr-extern \
    ros-reflexxes \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'rosbag-editor', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROSBAG_EDITOR}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROSBAG_EDITOR = " \
    rosbag-editor \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'rosmon-core', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROSMON_CORE}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROSMON_CORE = " \
    rosmon-core \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'sainsmart-relay-usb', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_SAINSMART_RELAY_USB}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_SAINSMART_RELAY_USB = " \
    sainsmart-relay-usb \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'sbpl-lattice-planner', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_SBPL_LATTICE_PLANNER}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_SBPL_LATTICE_PLANNER = " \
    navigation-experimental \
    sbpl-lattice-planner \
    sbpl-recovery \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'schunk-libm5api', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_SCHUNK_LIBM5API}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_SCHUNK_LIBM5API = " \
    schunk-libm5api \
    schunk-modular-robotics \
    schunk-powercube-chain \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'schunk-sdh', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_SCHUNK_SDH}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_SCHUNK_SDH = " \
    schunk-modular-robotics \
    schunk-sdh \
    schunk-simulated-tactile-sensors \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'soem', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_SOEM}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_SOEM = " \
    soem \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'stage-ros', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_STAGE_ROS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_STAGE_ROS = " \
    navigation-stage \
    navigation-tutorials \
    roomba-stage \
    stage-ros \
    teb-local-planner-tutorials \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'usb-cam-controllers', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_USB_CAM_CONTROLLERS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_USB_CAM_CONTROLLERS = " \
    usb-cam-controllers \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'wamv-description', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_WAMV_DESCRIPTION}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_WAMV_DESCRIPTION = " \
    wamv-description \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'hector-pose-estimation-core', 'hector-pose-estimation-core hector-localization hector-pose-estimation' , '', d)}"
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'mobile-robot-simulator', 'mobile-robot-simulator' , '', d)}"
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'pointgrey-camera-driver', 'pointgrey-camera-driver' , '', d)}"
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'rosflight', 'rosflight' , '', d)}"

# do_compile failures
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lanelet2-core', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LANELET2_CORE}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LANELET2_CORE = " \
    lanelet2-core \
    lanelet2-maps \
"

# do_install failures
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'omnibase-description', 'omnibase-description' , '', d)}"
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'omnibase-gazebo', 'omnibase-gazebo' , '', d)}"
