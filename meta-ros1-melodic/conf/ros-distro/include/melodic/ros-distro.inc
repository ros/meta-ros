# melodic/ros-distro.inc
# General configuration settings that are dependent on ROS_DISTRO.
#
# Copyright (c) 2019-2020 LG Electronics, Inc.

ROS_DISTRO_CODENAME = "Melodic Morenia"

ROS1_DISTRO = "melodic"

# The platform release that the metadata for this ROS distro targets. This determines the versions of the platform packages that
# OE must provide. It must be one of the values of ROS_DISTRO_RELEASE_PLATFORMS (which is set in
# generated/superflore-ros-distro.inc).
ROS_DISTRO_BASELINE_PLATFORM = "ubuntu-bionic"

require conf/ros-distro/include/melodic/generated/superflore-datetime.inc
require conf/ros-distro/include/melodic/generated/superflore-ros-distro.inc
require conf/ros-distro/include/melodic/ros-distro-recipe-blacklist.inc
require conf/ros-distro/include/melodic/ros-distro-preferred-versions.inc
require conf/ros-distro/include/melodic/ros-distro-preferred-providers.inc

# Override settings from generated/superflore-ros-distro.inc here.

# Since superflore doesn't know when it's generating a recipe that it will be for a build tool, it can't know that what's in
# ROS_EXEC_DEPEND are also build tools. Manually add them here.
ROS_SUPERFLORE_GENERATED_BUILDTOOLS += " \
    cmake-modules-native \
    rospack-native \
"

# roslisp depends on sbcl, for which there is no OE recipe
ROS_WORLD_SKIP_GROUPS += "lisp"
# There is recipe for glfw in meta-oe in dunfell:
# http://cgit.openembedded.org/meta-openembedded/commit/meta-oe/recipes-core/glfw/glfw_3.3.bb?id=a7464eaa69a7ee4734001aab2e232102e7135772
# but we don't have a backports layer from dunfell yet, lets skip it for now
ROS_WORLD_SKIP_GROUPS += "glfw"
# recipes depending on gazebo, for which there is no OE recipe
ROS_WORLD_SKIP_GROUPS += "gazebo"
# recipes depending on wxpython
ROS_WORLD_SKIP_GROUPS += "wxpython"
# recipes depending on libnlopt0 (http://neuro.debian.net/pkgs/libnlopt0.html)
ROS_WORLD_SKIP_GROUPS += "trac-ik"
# recipes depending on libogre
# there was ogre recipe in OE-classic 10 years ago:
# https://github.com/openembedded/openembedded/blob/master/recipes/ogre/ogre-egl_svn.bb
# but wasn'te ever ported to new layers
ROS_WORLD_SKIP_GROUPS += "ogre"
# recipes depending on python-scipy
ROS_WORLD_SKIP_GROUPS += "python-scipy"
# recipes depending on python-speechrecognition-pip
ROS_WORLD_SKIP_GROUPS += "python-speechrecognition-pip"
# recipes depending on python-gi
ROS_WORLD_SKIP_GROUPS += "python-gi"
# recipes depending on python-imageio
ROS_WORLD_SKIP_GROUPS += "python-imageio"
# recipes depending on nkf - Network Kanji code conversion Filter - https://packages.debian.org/sid/text/nkf
ROS_WORLD_SKIP_GROUPS += "nkf"
# recipes depending on rospilot which depends on UNRESOLVED-python-tilestache, UNRESOLVED-python-mapnik, UNRESOLVED-libnl-3, UNRESOLVED-postgresql-postgis, UNRESOLVED-python-cherrypy, UNRESOLVED-osm2pgsql, UNRESOLVED-dnsmasq, UNRESOLVED-mapnik-utils, UNRESOLVED-hostapd, UNRESOLVED-python-colorama, UNRESOLVED-gdal-bin, UNRESOLVED-libmicrohttpd, UNRESOLVED-libnl-3-dev
ROS_WORLD_SKIP_GROUPS += "rospilot"
# recipes depending on parrot-arsdk which depends on UNRESOLVED-automake, UNRESOLVED-yasm, UNRESOLVED-libavahi-core-dev, UNRESOLVED-nasm, UNRESOLVED-libavahi-client-dev
ROS_WORLD_SKIP_GROUPS += "parrot-arsdk"
# recipes depending on clang-tidy
ROS_WORLD_SKIP_GROUPS += "clang-tidy"
# recipes depending on muparser
ROS_WORLD_SKIP_GROUPS += "muparser"
# recipes depending on openni (libopenni-dev)
ROS_WORLD_SKIP_GROUPS += "openni"
# recipes depending on openni2 (libopenni2-dev)
ROS_WORLD_SKIP_GROUPS += "openni2"
# recipes depending on coinor-libipopt
ROS_WORLD_SKIP_GROUPS += "coinor-libipopt"
# recipes depending on libvtk-qt
ROS_WORLD_SKIP_GROUPS += "vtk-qt"
# recipes depending on libopenscenegraph
ROS_WORLD_SKIP_GROUPS += "osg"
# recipes depending on legacy mongo-cxx-driver (https://packages.debian.org/source/stretch/mongo-cxx-driver-legacy)
# the mongodb recipe in meta-oe installs just the binaries mongoc, mongos, install_compass
# the header files searched by mongo-store, warehouse-ros-mongo cmake files cmake/FindMongoClient.cmake and cmake/FindMongoDB.cmake
# aren't even part of current version of mongo-cxx-driver
# src/mongo/client/dbclient.h and src/mongo/client/dbclientinterface.h are only in the legacy branches
ROS_WORLD_SKIP_GROUPS += "mongodb-legacy-cxx-driver"
# provides the same libfcl.so.0.6 as platform fcl recipe, causing conflicts
# you need to make sure only one of these is included in dependency tree and in our world builds
# it was always including both, lets blacklist fcl-catkin, because nothing directly depends on it
ROS_WORLD_SKIP_GROUPS += "fcl-catkin"
# recipes depending on python-dialogflow-pip
ROS_WORLD_SKIP_GROUPS += "python-dialogflow-pip"
# recipes depending on pydrive-pip
ROS_WORLD_SKIP_GROUPS += "pydrive-pip"
# recipes depending on pugixml
ROS_WORLD_SKIP_GROUPS += "pugixml"
# recipes depending on python-omniorb
ROS_WORLD_SKIP_GROUPS += "python-omniorb"
# recipes depending on python-mechanize
ROS_WORLD_SKIP_GROUPS += "python-mechanize"
# recipes depending on lcm from meta-uav https://layers.openembedded.org/layerindex/recipe/25701/
ROS_WORLD_SKIP_GROUPS += "lcm"
# recipes depending on libpqxx (https://packages.debian.org/source/sid/libpqxx)
ROS_WORLD_SKIP_GROUPS += "libpqxx"
# recipes depending on UNRESOLVED-python-cwiid
ROS_WORLD_SKIP_GROUPS += "python-cwiid"
# recipes depending on UNRESOLVED-libspnav-dev
ROS_WORLD_SKIP_GROUPS += "libspnav"
# heifu-* recipes depending on ros-utils which seems to be this component:
# https://gitlab.pdmfc.com/drones/ros1/drone-generic/tree/master/src/ros_utils
# which isn't public as reported here:
# https://github.com/ros/rosdistro/pull/26336#issuecomment-696373544
ROS_WORLD_SKIP_GROUPS += "heifu-ros-utils"
# expects users to install official IDS uEye drivers (http://en.ids-imaging.com/download-ueye.html)
ROS_WORLD_SKIP_GROUPS += "ueye"

# do_configure failures
ROS_WORLD_SKIP_GROUPS += " \
    dccomms-ros \
    dynamic-graph-python \
    hdf5-map-io \
    jderobot-carviz \
    lanelet2-traffic-rules \
    novatel-oem7-driver \
    pyros-utils \
"

# do_compile failures
ROS_WORLD_SKIP_GROUPS += " \
    assimp-devel \
    bayesian-belief-networks \
    canopen-master \
    cob-generic-can \
    cob-obstacle-distance-moveit \
    downward \
    exotica-collision-scene-fcl \
    fetch-drivers \
    ff \
    ffha \
    fmi-adapter \
    hector-pose-estimation-core \
    hpp-fcl \
    julius \
    libg2o \
    libphidget21 \
    libphidgets \
    libsiftfast \
    libuvc-camera \
    map-merge-3d \
    mobile-robot-simulator \
    multisense-ros \
    naoqi-libqi \
    nerian-stereo \
    nlopt \
    obj-to-pointcloud \
    odva-ethernetip \
    p2os-urdf \
    pointgrey-camera-driver \
    pr2-description \
    qt-gui-cpp \
    rail-mesh-icp \
    rc-dynamics-api \
    robot-body-filter \
    ros-reflexxes \
    rosbag-editor \
    rosflight \
    rosmon-core \
    sainsmart-relay-usb \
    sbpl-lattice-planner \
    schunk-libm5api \
    schunk-sdh \
    soem \
    stage-ros \
    usb-cam-controllers \
    wamv-description \
"

# do_compile failures
ROS_WORLD_SKIP_GROUPS += " \
    omnibase-description \
    omnibase-gazebo \
"

# recipes depending on various unavailable python modules
# ERROR: Nothing PROVIDES 'UNRESOLVED-python-cairosvg' (but generated-recipes/fiducials/aruco-detect_0.11.0-1.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'UNRESOLVED-python-joblib' (but generated-recipes/fiducials/aruco-detect_0.11.0-1.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'UNRESOLVED-python-urlgrabber' (but generated-recipes/jsk-visualization/jsk-rqt-plugins_2.1.5.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'UNRESOLVED-python-sklearn' (but generated-recipes/jsk-visualization/jsk-rqt-plugins_2.1.5.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'UNRESOLVED-python-cairo' (but generated-recipes/rqt-bag/rqt-bag-plugins_0.4.12.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'UNRESOLVED-python-opengl' (but generated-recipes/rqt-pose-view/rqt-pose-view_0.5.8.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing RPROVIDES 'UNRESOLVED-python-termcolor' (but generated-recipes/criutils/criutils_0.1.3-2.bb RDEPENDS on or otherwise requires it)
ROS_WORLD_SKIP_GROUPS += "python-deps"

# recipes depending on something from meta-qt5 layer
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', '', 'qt5', d)}"
# recipes depending on something from meta-qt4 layer
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt4-layer', '', 'qt4', d)}"
# recipes depending on something from meta-multimedia layer
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'multimedia-layer', '', 'multimedia', d)}"

# recipes depending on 'x11' in DISTRO_FEATURES
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', '', 'x11', d)}"
# recipes depending on 'opengl' in DISTRO_FEATURES
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', '', 'opengl', d)}"
# recipes depending on 'ffmpeg' which is restricted by 'commercial' LICENSE_FLAG
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains_any('LICENSE_FLAGS_WHITELIST', ['commercial', 'ffmpeg', 'commercial_ffmpeg'], '', 'ffmpeg', d)}"
# recipes depending on 'x264' (ffmpeg does depend on it by default as well) which is restricted by 'commercial' LICENSE_FLAG
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains_any('LICENSE_FLAGS_WHITELIST', ['commercial', 'x264', 'commercial_x264'], '', 'x264', d)}"
# recipes depending on 'gstreamer1.0-plugins-ugly' which is restricted by 'commercial' LICENSE_FLAG
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains_any('LICENSE_FLAGS_WHITELIST', ['commercial', 'gstreamer1.0-plugins-ugly', 'commercial_gstreamer1.0-plugins-ugly'], '', 'gst-ugly', d)}"
# recipes depending on vlc from meta-multimedia layer which depends on ffmpeg which has commercial LICENSE_FLAGS restriction
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains_any('LICENSE_FLAGS_WHITELIST', ['commercial', 'vlc', 'commercial_vlc'], '', 'vlc', d)}"

# recipes depending on python*-pyqt5 from meta-qt5 layer
# Use separate group, because e.g. webOS OSE has meta-qt5 layer included, but python*-pyqt5
# is blacklisted, because webOS OSE is missing newer meta-qt5 from warrior with older meta-oe thud which has
# incompatible old sip
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', '', 'pyqt5', d)}"

# Must use a _pn- override in this file to override the ROS_BUILD_TYPE of a generated recipe,
# because we need to set this variable before the "inherit" line in the recipe is parsed,
# and having it in a .bbappend sets it too late.
ROS_BUILD_TYPE_pn-python-orocos-kdl = "catkin"

# Otherwise it will use cmake as specified in
# https://github.com/mavlink/mavlink-gbp-release/blob/release/melodic/mavlink/2019.11.11-1/package.xml#L29
# but that doesn't respect the prefix set in meta-ros-common/classes/ros_opt_prefix.bbclass
ROS_BUILD_TYPE_pn-mavlink = "catkin"

# python-backports-ssl@meta-python
ROS_UNRESOLVED_PLATFORM_PKG_python-backports.ssl-match-hostname = "${PYTHON_PN}-backports-ssl"

# python-pillow@meta-ros v5.1.0
ROS_UNRESOLVED_PLATFORM_PKG_python-imaging = "${PYTHON_PN}-pillow"

# python-tornado45@meta-ros v4.5.3
ROS_UNRESOLVED_PLATFORM_PKG_python-tornado = "${PYTHON_PN}-tornado45"

# python-twisted-core@meta-python (v18.4.0 instead of  bionic's v17.9.0)
ROS_UNRESOLVED_PLATFORM_PKG_python-twisted-core = "${PYTHON_PN}-twisted-core"

# Used by:
# generated-recipes/audio-common/audio-play_0.3.3.bb
# generated-recipes/audio-common/audio-capture_0.3.3.bb
# generated-recipes/audio-common/sound-play_0.3.3.bb
# generated-recipes/gscam/gscam_1.0.1.bb
ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0 = "gstreamer1.0"
ROS_UNRESOLVED_PLATFORM_PKG_libgstreamer1.0-dev = "gstreamer1.0"

# Used by:
# generated-recipes/audio-common/audio-play_0.3.3.bb
# generated-recipes/audio-common/audio-capture_0.3.3.bb
# generated-recipes/audio-common/sound-play_0.3.3.bb
# generated-recipes/gscam/gscam_1.0.1.bb
ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0-plugins-base = "gstreamer1.0-plugins-base"
ROS_UNRESOLVED_PLATFORM_PKG_libgstreamer-plugins-base1.0-dev = "gstreamer1.0-plugins-base"

# Used by:
# generated-recipes/audio-common/audio-play_0.3.3.bb
# generated-recipes/audio-common/audio-capture_0.3.3.bb
# generated-recipes/audio-common/sound-play_0.3.3.bb
ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0-plugins-good = "gstreamer1.0-plugins-good"

# Used by:
# generated-recipes/audio-common/audio-play_0.3.3.bb
# generated-recipes/audio-common/audio-capture_0.3.3.bb
# generated-recipes/audio-common/sound-play_0.3.3.bb
ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0-plugins-ugly = "gstreamer1.0-plugins-ugly"

# Used by:
# generated-recipes/jsk-3rdparty/assimp-devel_2.1.13-1.bb
# generated-recipes/jsk-3rdparty/downward_2.1.13-1.bb
# generated-recipes/jsk-3rdparty/ff_2.1.13-1.bb
# generated-recipes/jsk-3rdparty/libcmt_2.1.13-1.bb
# generated-recipes/jsk-3rdparty/slic_2.1.13-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_ca-certificates = "ca-certificates"

# Used by:
# generated-recipes/rc-genicam-api/rc-genicam-api_2.2.2-1.bb
# generated-recipes/phidgets-drivers/phidgets-api_0.7.9-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libusb-1.0 = "libusb1"

# Used by:
# generated-recipes/kobuki-core/kobuki-ftdi_0.7.8.bb
# generated-recipes/phidgets-drivers/libphidget21_0.7.9-1.bb
# generated-recipes/cob-extern/libphidgets_0.6.14-1.bb
# generated-recipes/joystick-drivers/ps3joy_1.13.0-1.bb
# generated-recipes/schunk-modular-robotics/schunk-sdh_0.6.14-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libusb-dev = "libusb1"

# Used by:
# generated-recipes/pr2-controllers/robot-mechanism-controllers_1.10.17-1.bb
# generated-recipes/jsk-3rdparty/nlopt_2.1.13-1.bb
# generated-recipes/pr2-controllers/ethercat-trigger-controllers_1.10.17-1.bb
# generated-recipes/stage/stage_4.3.0.bb
ROS_UNRESOLVED_PLATFORM_PKG_libtool = "libtool"

# Used by:
# generated-recipes/ros-canopen/socketcan-interface_0.8.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_linux-kernel-headers = "linux-libc-headers"

# Used by:
# generated-recipes/image-pipeline/image-view_1.13.0-1.bb
# generated-recipes/webrtc-ros/webrtc_59.0.3.bb
# generated-recipes/stage/stage_4.3.0.bb
ROS_UNRESOLVED_PLATFORM_PKG_gtk2 = "gtk+"

# Used by:
# generated-recipes/optpp-catkin/optpp-catkin_2.4.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_autoconf = "autoconf"

# Used by:
# generated-recipes/openrtm-aist/openrtm-aist_1.1.2-3.bb
ROS_UNRESOLVED_PLATFORM_PKG_automake-native = "automake-native"

# Used by:
# generated-recipes/jsk-3rdparty/ff_2.1.13-1.bb
# generated-recipes/jsk-3rdparty/ffha_2.1.13-1.bb
# generated-recipes/jsk-3rdparty/downward_2.1.13-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_bison = "bison"

# Used by:
# generated-recipes/jsk-roseus/roseus_1.7.4-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_coreutils = "coreutils"

# Used by:
# generated-recipes/schunk-modular-robotics/schunk-sdh_0.6.14-1.bb
# generated-recipes/cob-extern/libntcan_0.6.14-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_dpkg = "dpkg"

# Used by:
# generated-recipes/jsk-3rdparty/ff_2.1.13-1.bb,
# generated-recipes/jsk-3rdparty/ffha_2.1.13-1.bb
# generated-recipes/jsk-3rdparty/downward_2.1.13-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_flex = "flex"

# Used by:
# generated-recipes/jsk-3rdparty/ffha_2.1.13-1.bb
# generated-recipes/jsk-3rdparty/downward_2.1.13-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_gawk = "gawk"

# Used by:
# generated-recipes/openrtm-aist/openrtm-aist_1.1.2-3.bb
ROS_UNRESOLVED_PLATFORM_PKG_libtool-native = "libtool-native"

# Used by:
# generated-recipes/visp/visp_3.2.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libxml2 = "libxml2"

# Used by:
# generated-recipes/kinesis-manager/kinesis-manager_2.0.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_log4cplus = "log4cplus"

# Used by:
# generated-recipes/vapor-master/vapor-master_0.3.0.bb
ROS_UNRESOLVED_PLATFORM_PKG_nodejs-native = "nodejs-native"

# Used by:
# generated-recipes/marti-common/swri-transform-util_2.11.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_proj = "proj"

# Used by:
# generated-recipes/cpr-multimaster-tools/message-relay_0.0.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-cheetah = "${PYTHON_PN}-cheetah"

# Used by:
# generated-recipes/calibration/calibration-estimation_0.10.14.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-matplotlib = "${PYTHON_PN}-matplotlib"

# Used by:
# generated-recipes/catkin-pip/catkin-pip_0.2.3-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-pip = "${PYTHON_PN}-pip"

# Used by:
# generated-recipes/mongodb-store/mongodb-store_0.5.2-1.bb
# generated-recipes/mongodb-store/mongodb-log_0.5.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-pymongo = "${PYTHON_PN}-pymongo"

# Used by:
# generated-recipes/geographic-info/geodesy_0.5.3.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-pyproj = "${PYTHON_PN}-pyproj"

# Used by:
# generated-recipes/ros-pytest/ros-pytest_0.1.2-2.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-pytest = "${PYTHON_PN}-pytest"

# Used by:
# generated-recipes/jsk-3rdparty/rostwitter_2.1.13-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-requests = "${PYTHON_PN}-requests"

# Used by:
# generated-recipes/jsk-3rdparty/rostwitter_2.1.13-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-simplejson = "${PYTHON_PN}-simplejson"

# Used by:
# generated-recipes/abseil-cpp/abseil-cpp_0.4.2-1.bb
# generated-recipes/jsk-3rdparty/julius_2.1.13-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_rsync = "rsync"

# Used by:
# generated-recipes/jsk-3rdparty/libsiftfast_2.1.13-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_subversion = "subversion"

# Used by:
# generated-recipes/trac-ik/trac-ik-python_1.5.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_swig = "swig"

# Used by:
# generated-recipes/spatio-temporal-voxel-layer/spatio-temporal-voxel-layer_1.3.5-2.bb
# generated-recipes/navigation-2d/nav2d-karto_0.4.2.bb
ROS_UNRESOLVED_PLATFORM_PKG_tbb = "tbb"

# Used by:
# generated-recipes/jsk-3rdparty/downward_2.1.13-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_time = "time"

# Used by:
# generated-recipes/convex-decomposition/convex-decomposition_0.1.12.bb
# generated-recipes/jsk-3rdparty/julius_2.1.13-1.bb
# generated-recipes/jsk-3rdparty/assimp-devel_2.1.13-1.bb
# generated-recipes/jsk-3rdparty/ff_2.1.13-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_unzip = "unzip"

# Used by:
# generated-recipes/openni2-camera/openni2-launch_0.4.2.bb
ROS_UNRESOLVED_PLATFORM_PKG_usbutils = "usbutils"

# Used by:
# generated-recipes/jsk-3rdparty/julius_2.1.13-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_wget = "wget"

# Used by:
# generated-recipes/webrtc-ros/webrtc_59.0.3.bb
ROS_UNRESOLVED_PLATFORM_PKG_wget-native = "wget-native"

# Used by:
# generated-recipes/vision-visp/visp-auto-tracker_0.11.1-1.bb
# generated-recipes/visp/visp_3.2.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_zbar = "zbar"

# Used by:
# generated-recipes/openrtm-aist-python/openrtm-aist-python_1.1.0.bb
# generated-recipes/eigenpy/eigenpy_1.6.9-1.bb
# generated-recipes/openrtm-aist/openrtm-aist_1.1.2-3.bb
# generated-recipes/pinocchio/pinocchio_2.2.1-1.bb
# generated-recipes/visp/visp_3.2.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_doxygen = "doxygen"

# Used by:
# generated-recipes/qt-metapackages/libqt-concurrent_1.0.1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libqt5-concurrent = "qtbase"

# Used by:
# generated-recipes/qt-metapackages/libqt-network_1.0.1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libqt5-network = "qtbase"

# Used by:
# generated-recipes/qt-metapackages/libqt-opengl-rosdev_1.0.1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libqt5-opengl-dev = "qtbase"

# Used by:
# generated-recipes/qt-metapackages/libqt-svg-rosdev_1.0.1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libqt5-svg-dev = "qtsvg"

# Used by:
# generated-recipes/cob-driver/cob-mimic_0.7.1-1.bb
# generated-recipes/cob-driver/cob-sound_0.7.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libvlc-dev = "vlc"
ROS_UNRESOLVED_PLATFORM_PKG_vlc = "vlc"

# Used by:
# generated-recipes/mavros/mavros_0.33.3-1.bb
# generated-recipes/underwater-simulation/uwsim_1.4.2-1.bb
# Just a package built by geographiclib
ROS_UNRESOLVED_PLATFORM_PKG_geographiclib-tools = "geographiclib-tools"

# Used by:
# generated-recipes/webrtc-ros/webrtc_59.0.3.bb
ROS_UNRESOLVED_PLATFORM_PKG_libglib-dev = "glib-2.0"

# Used by:
# generated-recipes/kobuki-core/kobuki-ftdi_0.7.8.bb
ROS_UNRESOLVED_PLATFORM_PKG_ftdi-eeprom = "libftdi"

# Used by:
# generated-recipes/rc-dynamics-api/rc-dynamics-api_0.10.0-1.bb
# generated-recipes/rc-visard/rc-visard-driver_2.7.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_protobuf = "protobuf"

# Used by:
# generated-recipes/yp-spur/ypspur_1.17.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libreadline-dev = "readline"
ROS_UNRESOLVED_PLATFORM_PKG_libreadline = "readline"

# Used by:
# generated-recipes/robot-upstart/robot-upstart_0.3.0.bb
ROS_UNRESOLVED_PLATFORM_PKG_daemontools = "daemontools"

# Used by:
# generated-recipes/moveit/moveit-kinematics_1.0.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_liburdfdom-tools = "urdfdom"

# Used by:
# generated-recipes/python-qt-binding/python-qt-binding_0.3.6-2.bb
# generated-recipes/qt-gui-core/qt-gui_0.3.16-1.bb
# generated-recipes/visualstates/visualstates_0.2.3-2.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-qt5-bindings = "${PYTHON_PN}-pyqt5"
ROS_UNRESOLVED_PLATFORM_PKG_python3-qt5-bindings = "${PYTHON_PN}-pyqt5"

# Used by:
# generated-recipes/webkit-dependency/webkit-dependency_1.1.0.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-qt5-bindings-webkit = "${PYTHON_PN}-pyqt5"
ROS_UNRESOLVED_PLATFORM_PKG_python3-qt5-bindings-webkit = "${PYTHON_PN}-pyqt5"

# Used by:
# generated-recipes/visualstates/visualstates_0.2.3-2.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-qt5-bindings-qsci = "${PYTHON_PN}-pyqt5"
ROS_UNRESOLVED_PLATFORM_PKG_python3-qt5-bindings-qsci = "${PYTHON_PN}-pyqt5"

# Used by:
# generated-recipes/gl-dependency/gl-dependency_1.1.0.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-qt5-bindings-gl = "${PYTHON_PN}-pyqt5"
ROS_UNRESOLVED_PLATFORM_PKG_python3-qt5-bindings-gl = "${PYTHON_PN}-pyqt5"

# tango-icon-theme isn't available, but adwaita-icon-theme should be compatible
# Used by:
# generated-recipes/qt-gui-core/qt-gui_0.3.16-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_tango-icon-theme = "adwaita-icon-theme"

# Used by:
# generated-recipes/rviz-visual-tools/rviz-visual-tools_3.8.0-4.bb
ROS_UNRESOLVED_PLATFORM_PKG_libqt5x11extras5-dev = "qtx11extras"

# Used by:
# generated-recipes/mapviz/mapviz_1.2.0-1.bb
# generated-recipes/mapviz/tile-map_1.2.0-1.bb
# generated-recipes/moveit/moveit-ros-perception_1.0.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libglew-dev = "glew"

# Used by:
# generated-recipes/uwsim-bullet/uwsim-bullet_2.82.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libxext = "libxext"

# Used by:
# generated-recipes/lvr2/lvr2_19.12.1-1.bb
# generated-recipes/mapviz/mapviz_1.2.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libxmu-dev = "libxmu"

# Used by:
# generated-recipes/lvr2/lvr2_19.12.1-1.bb
# generated-recipes/mapviz/mapviz_1.2.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libxi-dev = "libxi"

# Used by:
# generated-recipes/marti-common/swri-transform-util_2.11.0-1.bb
# generated-recipes/marti-common/swri-geometry-util_2.11.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libgeos++-dev = "geos"

# Used by:
# generated-recipes/stage/stage_4.3.0.bb
ROS_UNRESOLVED_PLATFORM_PKG_libfltk-dev = "fltk"

# Used by:
# generated-recipes/fkie-potree-rviz-plugin/fkie-potree-rviz-plugin_1.0.0.bb
# generated-recipes/mapviz/tile-map_1.2.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libjsoncpp-dev = "jsoncpp"
ROS_UNRESOLVED_PLATFORM_PKG_libjsoncpp = "jsoncpp"

# Used by:
# generated-recipes/plotjuggler/plotjuggler_2.5.0-1.bb
# generated-recipes/kvh-geo-fog-3d/kvh-geo-fog-3d-rviz_1.3.3-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libqt5multimedia5-plugins = "qtmultimedia"

# Used by:
# generated-recipes/plotjuggler/plotjuggler_2.5.0-1.bb
# generated-recipes/kvh-geo-fog-3d/kvh-geo-fog-3d-rviz_1.3.3-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_qtmultimedia5-dev = "qtmultimedia"

# Used by:
# generated-recipes/plotjuggler/plotjuggler_2.5.0-1.bb
# generated-recipes/kvh-geo-fog-3d/kvh-geo-fog-3d-rviz_1.3.3-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_qtdeclarative5-dev = "qtdeclarative"

# Used by:
# generated-recipes/plotjuggler/plotjuggler_2.5.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_binutils = "binutils"

# Used by:
# generated-recipes/uwsim-osgocean/uwsim-osgocean_1.0.4-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libfftw3 = "fftw"

# Used by:
# generated-recipes/rqt-multiplot-plugin/rqt-multiplot_0.0.10.bb
ROS_UNRESOLVED_PLATFORM_PKG_libqwt-qt5-dev = "qwt-qt5"

# Used by:
# generated-recipes/qt-gui-core/qt-dotgraph_0.3.16-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-pydot = "${PYTHON_PN}-pydot"

# Used by:
# generated-recipes/ros/roslib_1.14.8-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libboost-thread-dev = "boost"

# Used by:
# generated-recipes/ros-tutorials/roscpp-tutorials_0.9.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libboost-date-time-dev = "boost"

# Used by:
# generated-recipes/lanelet2/lanelet2-python_1.0.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libboost-python-dev = "boost"

# Used by:
# generated-recipes/ros-comm/rosbag_1.14.5-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-pycryptodome = "${PYTHON_PN}-pycryptodomex"

# Used by:
# generated-recipes/cob-control/cob-twist-controller_0.8.11-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-six = "${PYTHON_PN}-six"

# Used by:
# generated-recipes/rosbridge-suite/rosbridge-server_0.11.4-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-autobahn = "${PYTHON_PN}-autobahn"

# Used by:
# generated-recipes/exotica/exotica-core_5.1.3-3.bb
ROS_UNRESOLVED_PLATFORM_PKG_msgpack = "msgpack-c"

# Used by:
# generated-recipes/exotica/exotica-python_5.1.3-3.bb
# generated-recipes/moveit-python/moveit-python_0.3.3-1.bb
# generated-recipes/moveit/moveit-commander_1.0.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-pyassimp = "${PYTHON_PN}-pyassimp"

# Used by:
# generated-recipes/exotica/exotica-python_5.1.3-3.bb
# generated-recipes/cob-driver/cob-voltage-control_0.7.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-tk = "${PYTHON_PN}-tkinter"

# Used by:
# generated-recipes/pointgrey-camera-driver/pointgrey-camera-driver_0.14.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libraw1394-dev = "libraw1394"

# Used by:
# generated-recipes/jsk-3rdparty/sesame-ros_2.1.17-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libffi-dev = "libffi"

# Used by:
# generated-recipes/mrt-cmake-modules/mrt-cmake-modules_1.0.3-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_lcov = "lcov"
# Needs https://lists.openembedded.org/g/openembedded-devel/message/86162
ROS_UNRESOLVED_PLATFORM_PKG_lcov-native = "lcov-native"

# Used by:
# generated-recipes/rtmros-hironx/hironx-ros-bridge_2.2.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_gnuplot = "gnuplot"

# Used by:
# generated-recipes/mesh-tools/hdf5-map-io_1.0.0-2.bb
ROS_UNRESOLVED_PLATFORM_PKG_libhdf5-dev = "hdf5"

# Used by:
# generated-recipes/mrpt2/mrpt2_2.0.4-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libxxf86vm = "libxxf86vm"

# Used by:
# generated-recipes/mesh-tools/rviz-map-plugin_1.0.0-2.bb
ROS_UNRESOLVED_PLATFORM_PKG_ocl-icd-opencl-dev = "ocl-icd-opencl"

# Used by:
# generated-recipes/mesh-tools/rviz-map-plugin_1.0.0-2.bb
ROS_UNRESOLVED_PLATFORM_PKG_opencl-headers = "opencl-headers"

# Used by:
# generated-recipes/rtmros-nextage/rtmros-nextage_0.8.6-2.bb
ROS_UNRESOLVED_PLATFORM_PKG_nextage_calibration = ""

# Used by:
# generated-recipes/csm/csm_1.0.2-2.bb
ROS_UNRESOLVED_PLATFORM_PKG_libgsl = "gsl"

# Used by:
# generated-recipes/fadecandy-ros/fadecandy-driver_0.1.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-usb = "${PYTHON_PN}-pyusb"

# Used by:
# generated-recipes/dataspeed-pds/dataspeed-pds-lcm_1.0.5-1.bb
# in meta-uav https://layers.openembedded.org/layerindex/recipe/25701/
ROS_UNRESOLVED_PLATFORM_PKG_liblcm-dev = "lcm"

# Used by:
# generated-recipes/rosconsole/rosconsole_1.13.16-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libboost-regex-dev = "boost"

# Used by:
# generated-recipes/rosconsole/rosconsole_1.13.16-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libboost-system-dev = "boost"

# Used by:
# generated-recipes/knowledge-representation/knowledge-representation_0.9.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-dev = "python"

# Used by:
# generated-recipes/knowledge-representation/knowledge-representation_0.9.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libpqxx = "postgresql"

# Used by:
# generated-recipes/knowledge-representation/knowledge-representation_0.9.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libpqxx-dev = "postgresql"

# Used by:
# generated-recipes/knowledge-representation/knowledge-representation_0.9.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_postgresql = "postgresql"

# Used by:
# generated-recipes/usb-cam/usb-cam_0.3.6.bb
ROS_UNRESOLVED_PLATFORM_PKG_v4l-utils = "v4l-utils"

# Used by:
# generated-recipes/tts/tts_1.0.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-boto3 = "${PYTHON_PN}-boto3"

# Used by:
# generated-recipes/audio-common/audio-play_0.3.7-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0-alsa = "gstreamer1.0-plugins-base"

# Used by:
# generated-recipes/ixblue-stdbin-decoder/ixblue-stdbin-decoder_0.1.2-1.bb
# generated-recipes/ixblue-ins-stdbin-driver/ixblue-ins-driver_0.1.3-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libboost-dev = "boost"

# Used by:
# generated-recipes/heifu/heifu-diagnostic_0.7.1-2.bb
# generated-recipes/heifu/heifu-safety_0.7.1-2.bb
# generated-recipes/heifu/heifu-simple-waypoint_0.7.1-2.bb
# generated-recipes/heifu/heifu-mavros_0.7.1-2.bb
# but it seems to be this component:
# https://gitlab.pdmfc.com/drones/ros1/drone-generic/tree/master/src/ros_utils
# which isn't public as reported here:
# https://github.com/ros/rosdistro/pull/26336#issuecomment-696373544
ROS_UNRESOLVED_PLATFORM_PKG_ros_utils = "ros-utils"

#ROS_UNRESOLVED_PLATFORM_PKG_arduino-core = "arduino-core"
ROS_UNRESOLVED_PLATFORM_PKG_bluez = "bluez5"
ROS_UNRESOLVED_PLATFORM_PKG_clang-tidy = "clang-tidy"
#ROS_UNRESOLVED_PLATFORM_PKG_coinor-libipopt-dev = "coinor-libipopt-dev"
#ROS_UNRESOLVED_PLATFORM_PKG_cwiid-dev = "cwiid-dev"
#ROS_UNRESOLVED_PLATFORM_PKG_gforth = "gforth"
#ROS_UNRESOLVED_PLATFORM_PKG_gfortran = "gfortran"
ROS_UNRESOLVED_PLATFORM_PKG_libasound2-dev = "alsa-lib"
ROS_UNRESOLVED_PLATFORM_PKG_libcap-dev = "libcap"
#ROS_UNRESOLVED_PLATFORM_PKG_libcoin80-dev = "libcoin80-dev"
ROS_UNRESOLVED_PLATFORM_PKG_libdc1394-dev = "libdc1394"
#ROS_UNRESOLVED_PLATFORM_PKG_libdmtx-dev = "libdmtx-dev"
ROS_UNRESOLVED_PLATFORM_PKG_libftdi-dev = "libftdi"
# with cpp-wrapper PACKAGECONFIG enabled
ROS_UNRESOLVED_PLATFORM_PKG_libftdipp-dev = "libftdi"
#ROS_UNRESOLVED_PLATFORM_PKG_libgeos++-dev = "libgeos++-dev"
ROS_UNRESOLVED_PLATFORM_PKG_libgphoto-dev = "libgphoto2"
ROS_UNRESOLVED_PLATFORM_PKG_libgps = "gpsd"
#ROS_UNRESOLVED_PLATFORM_PKG_libgts = "libgts"
ROS_UNRESOLVED_PLATFORM_PKG_libmodbus-dev = "libmodbus"
ROS_UNRESOLVED_PLATFORM_PKG_libmongoclient-dev = "mongodb"
ROS_UNRESOLVED_PLATFORM_PKG_libncurses-dev = "ncurses"
#ROS_UNRESOLVED_PLATFORM_PKG_libnlopt-dev = "libnlopt-dev"
#ROS_UNRESOLVED_PLATFORM_PKG_libnlopt0 = "libnlopt0"
#ROS_UNRESOLVED_PLATFORM_PKG_libogre-dev = "libogre-dev"
#ROS_UNRESOLVED_PLATFORM_PKG_libois-dev = "libois-dev"
#ROS_UNRESOLVED_PLATFORM_PKG_libopenexr-dev = "libopenexr-dev"
#ROS_UNRESOLVED_PLATFORM_PKG_libopenni-dev = "libopenni-dev"
#ROS_UNRESOLVED_PLATFORM_PKG_libopenni2-dev = "libopenni2-dev"
#ROS_UNRESOLVED_PLATFORM_PKG_libopenscenegraph = "libopenscenegraph"
#ROS_UNRESOLVED_PLATFORM_PKG_libopenvdb = "libopenvdb"
#ROS_UNRESOLVED_PLATFORM_PKG_libopenvdb-dev = "libopenvdb-dev"
ROS_UNRESOLVED_PLATFORM_PKG_libpng-dev = "libpng"
#ROS_UNRESOLVED_PLATFORM_PKG_libpng12-dev = "libpng12-dev"
ROS_UNRESOLVED_PLATFORM_PKG_libpulse-dev = "pulseaudio"
ROS_UNRESOLVED_PLATFORM_PKG_libsensors4-dev = "lmsensors"
#ROS_UNRESOLVED_PLATFORM_PKG_libspnav-dev = "libspnav-dev"
ROS_UNRESOLVED_PLATFORM_PKG_libv4l-dev = "v4l-utils"
ROS_UNRESOLVED_PLATFORM_PKG_mongodb = "mongodb"
#ROS_UNRESOLVED_PLATFORM_PKG_muparser = "muparser"
#ROS_UNRESOLVED_PLATFORM_PKG_npm-native = "npm-native"
#ROS_UNRESOLVED_PLATFORM_PKG_omniorb = "omniorb"
#ROS_UNRESOLVED_PLATFORM_PKG_python-avahi = "${PYTHON_PN}-avahi"
ROS_UNRESOLVED_PLATFORM_PKG_python-bluez = "${PYTHON_PN}-pybluez"
#ROS_UNRESOLVED_PLATFORM_PKG_python-cairosvg = "${PYTHON_PN}-cairosvg"
#ROS_UNRESOLVED_PLATFORM_PKG_python-catkin-tools = "${PYTHON_PN}-catkin-tools"
#ROS_UNRESOLVED_PLATFORM_PKG_python-cwiid = "${PYTHON_PN}-cwiid"
#ROS_UNRESOLVED_PLATFORM_PKG_python-docker = "${PYTHON_PN}-docker"
#ROS_UNRESOLVED_PLATFORM_PKG_python-joblib = "${PYTHON_PN}-joblib"
#ROS_UNRESOLVED_PLATFORM_PKG_python-libpgm-pip = "${PYTHON_PN}-libpgm-pip"
#ROS_UNRESOLVED_PLATFORM_PKG_python-mechanize = "${PYTHON_PN}-mechanize"
#ROS_UNRESOLVED_PLATFORM_PKG_python-omniorb = "${PYTHON_PN}-omniorb"
ROS_UNRESOLVED_PLATFORM_PKG_python-pyaudio = "${PYTHON_PN}-pyalsaaudio"
#ROS_UNRESOLVED_PLATFORM_PKG_python-pyusb-pip = "${PYTHON_PN}-pyusb-pip"
#ROS_UNRESOLVED_PLATFORM_PKG_python-requests-oauthlib = "${PYTHON_PN}-requests-oauthlib"
#ROS_UNRESOLVED_PLATFORM_PKG_python-scipy = "${PYTHON_PN}-scipy"
#ROS_UNRESOLVED_PLATFORM_PKG_python-speechrecognition-pip = "${PYTHON_PN}-speechrecognition-pip"
# This is an exception, there is no python-websockets recipe available and to keep
# meta-ros1-melodic/generated-recipes/async-web-server-cpp/async-web-server-cpp_0.0.3.bb
# buildable lets set python3 version here even when PYTHON_PN is python (version 2)
ROS_UNRESOLVED_PLATFORM_PKG_python-websocket = "python3-websockets"
