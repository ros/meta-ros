SRC_URI = "http://sourceforge.net/projects/cmusphinx/files/${PN}/${PV}/${P}.tar.gz;downloadfilename=${P}.tar.gz"

inherit autotools pythonnative python-dir

# required for python binding
export HOST_SYS
export BUILD_SYS
export STAGING_LIBDIR
export STAGING_INCDIR
