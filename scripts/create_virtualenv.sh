#!/bin/bash

if [ $# -ne 3 ]; then
    echo "Usage: scripts/create_virtualenv.sh <BASEDIR> <LAYERNAME> <VIRTUALENV PKGS>"
    exit 1
fi

BASEDIR="$1"
LAYERNAME="$2"
VIRTUALENV_PKGS="$3"

mkdir -p "${BASEDIR}/${LAYERNAME}/conf"

cat <<EOF > "${BASEDIR}/${LAYERNAME}/conf/layer.conf"
# We have a conf and classes directory, add to BBPATH
BBPATH .= ":\${LAYERDIR}"

# We have recipes-* directories, add to BBFILES
BBFILES += "\${LAYERDIR}/recipes-*/*/*.bb \
            \${LAYERDIR}/recipes-*/*/*.bbappend"

BBFILE_COLLECTIONS += "${LAYERNAME}"
BBFILE_PATTERN_${LAYERNAME} = "^\${LAYERDIR}/"
BBFILE_PRIORITY_${LAYERNAME} = "6"

LAYERDEPENDS_${LAYERNAME} = "core"
LAYERSERIES_COMPAT_${LAYERNAME} = "kirkstone scarthgap styhead walnascar"
EOF

virtualenv "${BASEDIR}/${LAYERNAME}/pylib"

bash  -c "source \"${BASEDIR}/${LAYERNAME}/pylib/bin/activate\"; pip install \"${VIRTUAL_ENV_PKGS}\""

EXTRA_LAYERCONF_LINES=$( \
  ls -d "${BASEDIR}/${LAYERNAME}"/pylib/lib/python*/site-packages/*/ | \
  grep -v -e dist-info -e __pycache__ -e _distutils_hack -e pip -e pkg_resources -e setuptools | \
  sed "s|${BASEDIR}/${LAYERNAME}|\${LAYERDIR}|" | \
  sed 's|\(.*site-packages\)/\([^/]*\)/$|addpylib \1 \2|')

echo "${EXTRA_LAYERCONF_LINES}" >> "${BASEDIR}/${LAYERNAME}/conf/layer.conf"
