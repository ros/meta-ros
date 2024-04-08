DESCRIPTION = "A translator library for raster and vector geospatial data formats"
LICENSE = "Apache-2.0 & BSD-3-Clause & MIT & ISC & Info-ZIP & Qhull"
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=c50ab31669698143abc7d61e9404b940 \
                    file://alg/internal_libqhull/COPYING.txt;md5=484ee0cacf0472e8b40225b116f6296c \
                    file://autotest/gdrivers/data/netcdf_cf_xml/udunits2-LICENCE;md5=b19151c1ce22098c7740b5bc0871b24a \
                    file://autotest/gdrivers/data/tga/ref_test_suite/LICENSE;md5=04a545d2353fb1bafb554b2aaf4b53ff \
                    file://cmake/modules/Copyright.txt;md5=a9411e1f3f66c6538b3e7547221847e8 \
                    file://doc/source/development/rfc/rfc34_license_policy.rst;md5=44a9deac6eaa25b3026c5c76884d733b \
                    file://doc/source/gdal_rtd/LICENSE;md5=fae97b5ad072682750697bd9979577ac \
                    file://doc/source/license.rst;md5=9d9876af6ef4285e287c80b8665b1576 \
                    file://frmts/gif/giflib/COPYING;md5=ae11c61b04b2917be39b11f78d71519a \
                    file://frmts/grib/degrib/LICENSE.TXT;md5=f1598fd5b29e50328fbf6ba41529c93e \
                    file://frmts/mrf/LERCV1/LICENSE.TXT;md5=06209abe95b90904e809b2e6f3ba4ea7 \
                    file://frmts/pcraster/libcsf/COPYING;md5=bb1803659a82ae9748406a56173637b4 \
                    file://frmts/png/libpng/LICENSE;md5=b0085051bf265bac2bfc38bc89f50000 \
                    file://ogr/ogrsf_frmts/flatgeobuf/LICENSE;md5=985fc422c8f687ea7704d82216cc4e04 \
                    file://ogr/ogrsf_frmts/flatgeobuf/flatbuffers/LICENSE;md5=4ef8c3ba7ee94719dd880951221b03b6 \
                    file://ogr/ogrsf_frmts/geojson/libjson/COPYING;md5=de54b60fbbc35123ba193fea8ee216f2 \
                    file://ogr/ogrsf_frmts/pmtiles/pmtiles/LICENSE;md5=b516c4e2f7bebc832527305609b4e3f0 \
                    file://ogr/ogrsf_frmts/shape/COPYING;md5=ce0aeb69ae1c6381a50010d96706baff \
                    file://port/LICENCE_minizip;md5=28dcc51d0d279f531e4be676efb0071f \
                    file://third_party/LercLib/LICENSE;md5=06209abe95b90904e809b2e6f3ba4ea7 \
                    file://third_party/fast_float/LICENSE-MIT;md5=32b11d50c7d9788d4270f6a83f3e68eb"

SRC_URI = " \
    git://github.com/OSGeo/GDAL;protocol=https;branch=release/3.8 \
    file://install-headers-to-gdal-subdir.patch \
"

PV = "3.8.3+git${SRCPV}"
SRCREV = "654f4907abbbf6bf4226d58a8c067d134eaf3ce9"

S = "${WORKDIR}/git"

DEPENDS = " \
    curl \
    expat \
    gtest \
    libarchive \
    libdeflate \
    libjpeg-turbo \
    libpng \
    libwebp \
    libxml2 \
    lz4 \
    openjpeg \
    libpcre2 \
    postgresql \
    python3-numpy \
    python3-setuptools-native \
    proj \
    swig-native \
    tiff \
    zlib \
    zstd \
"

inherit cmake python3-dir python3native python3targetconfig

PACKAGES += "python3-${PN}"

FILES:${PN} += " \
    ${datadir}/bash-completion/completions/ \
    ${libdir}/gdalplugins/drivers.ini \
"

FILES:python3-${PN} = " \
    ${PYTHON_SITEPACKAGES_DIR}/GDAL-3.8.3-py${PYTHON_BASEVERSION}.egg-info \
    ${PYTHON_SITEPACKAGES_DIR}/osgeo \
    ${PYTHON_SITEPACKAGES_DIR}/osgeo_utils \
"

# ERROR: gdal-3.8.3-r0 do_package_qa: QA Issue: gdal: ... maximum shebang size exceeded, the maximum size is 128.
do_install:append() {
    # Modify the Python scripts to use the runtime path to Python 
    sed -i -e '1s|^#!.*|#!${bindir}/env python3|' ${D}${bindir}/gdal2tiles.py
    sed -i -e '1s|^#!.*|#!${bindir}/env python3|' ${D}${bindir}/ogr_layer_algebra.py
    sed -i -e '1s|^#!.*|#!${bindir}/env python3|' ${D}${bindir}/gdalattachpct.py
    sed -i -e '1s|^#!.*|#!${bindir}/env python3|' ${D}${bindir}/gdal_sieve.py
    sed -i -e '1s|^#!.*|#!${bindir}/env python3|' ${D}${bindir}/gdal2xyz.py
    sed -i -e '1s|^#!.*|#!${bindir}/env python3|' ${D}${bindir}/pct2rgb.py
    sed -i -e '1s|^#!.*|#!${bindir}/env python3|' ${D}${bindir}/rgb2pct.py
    sed -i -e '1s|^#!.*|#!${bindir}/env python3|' ${D}${bindir}/gdalmove.py
    sed -i -e '1s|^#!.*|#!${bindir}/env python3|' ${D}${bindir}/gdal_calc.py
    sed -i -e '1s|^#!.*|#!${bindir}/env python3|' ${D}${bindir}/gdal_pansharpen.py
    sed -i -e '1s|^#!.*|#!${bindir}/env python3|' ${D}${bindir}/gdalcompare.py
    sed -i -e '1s|^#!.*|#!${bindir}/env python3|' ${D}${bindir}/ogrmerge.py
    sed -i -e '1s|^#!.*|#!${bindir}/env python3|' ${D}${bindir}/gdal_merge.py
    sed -i -e '1s|^#!.*|#!${bindir}/env python3|' ${D}${bindir}/gdal_polygonize.py
    sed -i -e '1s|^#!.*|#!${bindir}/env python3|' ${D}${bindir}/gdal_proximity.py
    sed -i -e '1s|^#!.*|#!${bindir}/env python3|' ${D}${bindir}/gdal_fillnodata.py
    sed -i -e '1s|^#!.*|#!${bindir}/env python3|' ${D}${bindir}/gdal_edit.py
    sed -i -e '1s|^#!.*|#!${bindir}/env python3|' ${D}${bindir}/gdal_retile.py
}
