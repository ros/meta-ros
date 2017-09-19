Extension to recipetool to enable automatic creation of
BitBake recipe files for ROS packages.

## REQUIREMENTS ##

Two changes to the recipetool are required to use this plugin:

Requires either:
    From OE-Core rev: 1df60b09f7a60427795ec828c9c7180e4e52f98c
    From OE-Core rev: 3bb979c13463705c4db6c59034661c4cd8100756
or
    From poky rev: b1f237ebd0d4180c5d23a0ecd9aaf7193c63a48a
    From poky rev: a7baa47c876c7895499909731aaa451c6009610a

These changes are currently in the master branch as of 2017-Aug-24.


## USAGE ##

  Initialize the build environment:

    source oe-init-build-env

  Currently the plugin only allow for processing a single
  ROS package in a repository. If a repository contains more than
  one package, or the package is not in the root of the repository,
  then use the `--src-subdir=<dir>` option.

  ROS repositories generally do not use `master` as their default
  branch, so be sure to include the correct branch for the desired
  distribution as part of the URI: `<URI>;branch=indigo-devel`

## EXAMPLES ##
Build the Vector Nav package
```
devtool add https://github.com/dawonn/vectornav
```

Use the XBox Kinect Camera
```
devtool add --src-subdir=freenect_stack  "https://github.com/ros-drivers/freenect_stack.git"
devtool add --src-subdir=freenect_launch "https://github.com/ros-drivers/freenect_stack.git"
devtool add --src-subdir=freenect_camera "https://github.com/ros-drivers/freenect_stack.git"
```

## TO DO ##

  * Wrapper to generate recipes for each package in a repository.
  * Add support for ament for ROS2 packages.
  * Wrapper for using rosdistro data to generate recipes for various ROS distributions.

