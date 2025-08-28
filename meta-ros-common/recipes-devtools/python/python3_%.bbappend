inherit update-alternatives

ALTERNATIVE_PRIORITY = "80"
ALTERNATIVE:${PN}-core = "python python_config"
ALTERNATIVE_LINK_NAME[python] = "${bindir}/python"
ALTERNATIVE_LINK_NAME[python_config] = "${bindir}/python-config"
ALTERNATIVE_TARGET[python] = "${bindir}/python3"
ALTERNATIVE_TARGET[python_config] = "${bindir}/python3-config"

# tk causes a loop in python3-native
PACKAGECONFIG:append:class-target = " tk"

# From d2e82fc12509950ea30fa20fcbe9fc148b6cff1c                                                                                                                                                                  FILES:${PN}-tkinter += "${libdir}/python${PYTHON_MAJMIN}/lib-dynload/_tkinter.*.so"
