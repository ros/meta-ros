require recipes-imported-labgrid/python/python-snappy.inc

inherit ${@bb.utils.contains("BBFILE_COLLECTIONS", "meta-python2", "setuptools", "", d)}

python() {
    if 'meta-python2' not in d.getVar('BBFILE_COLLECTIONS').split():
        raise bb.parse.SkipRecipe('Requires meta-python2 to be present.')
}

SRC_URI[md5sum] = "0c06bbed70a8390b55a60f5ee79a27d2"
SRC_URI[sha256sum] = "385fb216e7d1241f70c14c2bea3f042ec235caa65d708294f1ece50d3efa5de3"
