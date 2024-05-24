SUMMARY = "Collection of perceptually uniform colormaps"
DESCRIPTION = "Colorcet is a collection of perceptually uniform colormaps for \
    use with Python plotting programs like bokeh, matplotlib, holoviews, and \
    datashader based on the set of perceptually uniform colormaps created by \
    Peter Kovesi at the Center for Exploration Targeting."
HOMEPAGE = "https://colorcet.holoviz.org/"

LICENSE = "CC-BY-4.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=b443afaf131aa64a6644f9bd3383f208"

PYPI_PACKAGE = "colorcet"

inherit pypi setuptools3

DEPENDS += "python3-pyct-native python3-param-native"

SRC_URI[sha256sum] = "51455a20353d12fac91f953772d8409f2474e6a0db1af3fa4f7005f405a2480b"
