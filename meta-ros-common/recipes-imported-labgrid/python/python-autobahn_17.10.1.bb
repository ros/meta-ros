require python-autobahn.inc

inherit ${@bb.utils.contains("BBFILE_COLLECTIONS", "meta-python2", "setuptools", "", d)}

python() {
    if 'meta-python2' not in d.getVar('BBFILE_COLLECTIONS').split():
        raise bb.parse.SkipRecipe('Requires meta-python2 to be present.')
}

SRC_URI[md5sum] = "f8c8d74bf73644719b751e6fb11dc4a3"
SRC_URI[sha256sum] = "8cf74132a18da149c5ea3dcbb5e055f6f4fe5a0238b33258d29e89bd276a8078"
