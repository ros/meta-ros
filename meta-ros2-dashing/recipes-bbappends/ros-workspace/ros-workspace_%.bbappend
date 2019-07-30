# Copyright (c) 2019 LG Electronics, Inc.

# ASSERT(<prefix> == /usr)
# ros-workspace installs its setup scripts under <prefix>, which is an unnatural location when <prefix> is /usr. Move them to be
# under <sysconfdir>/profile.d/ros and create "ros_" prefixed symlinks to them under <bindir>. If "ros-implicit-workspace"
# appears in DISTRO_FEATURES, create a ros.sh that sources ros/setup.sh, thereby setting up the ROS workspace for every login
# shell.
do_install_append() {
    profile_dir=${sysconfdir}/profile.d/ros
    mkdir -p ${D}$profile_dir
    cd ${D}$profile_dir

    mv ${D}${prefix}/*setup.bash .
    mv ${D}${prefix}/*setup.zsh .
    mv ${D}${prefix}/*setup.sh .
    mv ${D}${prefix}/_order_packages.py .

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
           -e '/_order_packages\.py/ s@\$AMENT_CURRENT_PREFIX/@'$profile_dir'/@' \
           local_setup.sh

    mkdir -p ${D}${bindir}
    for f in *setup.bash *setup.zsh *setup.sh; do
        ln -s $profile_dir/$f ${D}${bindir}/ros_$f
    done

    if ${@bb.utils.contains('DISTRO_FEATURES', 'ros-implicit-workspace', 'true', 'false', d)}; then
        echo ". $profile_dir/setup.sh" > ../ros.sh
    fi

    cd - > /dev/null
}
