# Copyright (c) 2020 LG Electronics, Inc.

# python-tkinter is just a package created by python, python-tk is mapped to python-tkinter
# to get the correct runtime dependencies, but exotica-python is using the same variable
# also for build time dependency
DEPENDS_remove = "python-tkinter"
