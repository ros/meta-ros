# Copyright (c) 2019 LG Electronics, Inc.

# ASSERT(<prefix> == /usr)
# ros-workspace installs its setup scripts under <prefix>, which is an unnatural location when <prefix> is /usr. Move them to be
# under <sysconfdir>/profile.d/ros and create "ros_" prefixed symlinks to them under <bindir>.
#
# Create a ros.sh that sources ros/setup.sh, thereby setting up the ROS workspace for every login. Place it in a separate package
# which will be added to images when IMAGE_FEATURES contains "ros-implicit-workspace"
do_install_append() {
    profile_dir=${sysconfdir}/profile.d/ros
    mkdir -p ${D}$profile_dir
    cd ${D}$profile_dir

    mv ${D}${prefix}/*setup.bash .
    mv ${D}${prefix}/*setup.zsh .
    mv ${D}${prefix}/*setup.sh .
    mv ${D}${prefix}/_local_setup_util.py .

    for f in *setup.bash *setup.zsh; do
        # Hardcode AMENT_CURRENT_PREFIX and the directory where these files reside.
        sed -i -e '/AMENT_CURRENT_PREFIX=/ s@=.*@=${prefix}@' \
               -e '/\$AMENT_CURRENT_PREFIX/ s@\$AMENT_CURRENT_PREFIX@'$profile_dir'@' $f
    done

    # Add special case handling for AMENT_CURRENT_PREFIX == /usr
    sed -i -e '/for _path.*_UNIQUE_PREFIX_PATH.*do/ s@do.*@do [ $_path = ${prefix} ] \&\& _path='$profile_dir'@' \
           -e '/AMENT_CURRENT_PREFIX=.*_path/ s@_path.*@_path; [ $_path = '$profile_dir' ] \&\& AMENT_CURRENT_PREFIX=${prefix}@' \
           setup.sh

    # Don't attempt to use the build-time Python executable on the target and hardcode the directory where _order_packages.py
    # resides.
    sed -i -e '/^_ament_python_executable=/ s@=.*@=${bindir}/${PYTHON_PN}@' \
           -e '/_local_setup_util\.py/ s@\$_ament_prefix_sh_AMENT_CURRENT_PREFIX/@'$profile_dir'/@' \
           local_setup.sh

    # This script assumes, that it's installed in root of ROS distro instalation (e.g. /opt/ros/eloquent/_local_setup_util.py
    # in our setup it's installed in /etc/profile.d/ros/_local_setup_util.py) and uses it's path to search for ament packages:
    # https://github.com/ament/ament_package/commit/0a41c282b36902cee6b64f7c80138b93c729fb7b#diff-f837dfb214b29ba2075cb54047ffa159R54
    # and then also passes it's path in get_commands() call as a prefix:
    # https://github.com/ament/ament_package/commit/0a41c282b36902cee6b64f7c80138b93c729fb7b#diff-f837dfb214b29ba2075cb54047ffa159R62
    # so it wasn't finding anything in our setup, change it to ${prefix} and drop all this when we switch ROS2 to use ros_opt_prefix.bbclass
    sed -i -e "s#__file__#'${libdir}'#g" _local_setup_util.py

    mkdir -p ${D}${bindir}
    for f in *setup.bash *setup.zsh *setup.sh; do
        ln -s $profile_dir/$f ${D}${bindir}/ros_$f
    done

    echo ". $profile_dir/setup.sh" > ../ros.sh

    cd - > /dev/null
}

PACKAGES =+ "${PN}-implicitworkspace"

FILES_${PN}-implicitworkspace = " \
    ${sysconfdir}/profile.d/ros.sh \
"
