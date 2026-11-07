# Copyright (c) 2026 Wind River Systems, Inc.
# package.xml says "BSD", but the release bundles all of g2o and builds it with CHOLMOD,
# CXSparse and OpenGL enabled. README.md and the source headers give:
#   g2o core:                                  BSD-2-Clause (doc/license-bsd.txt)
#   g2o/autodiff (Ceres):                      BSD-3-Clause
#   g2o/EXTERNAL/freeglut:                     MIT
#   csparse_extension:                         LGPL-2.1-or-later
#   stuff/opengl_primitives, g2o_incremental:  GPL-3.0-or-later
# g2o_viewer is also GPL-3.0-or-later but needs Qt5 and QGLViewer, so it is not built here.
LICENSE = "BSD-2-Clause & BSD-3-Clause & MIT & LGPL-2.1-or-later & GPL-3.0-or-later"
