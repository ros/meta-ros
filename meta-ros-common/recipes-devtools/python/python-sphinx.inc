# Copyright (c) 2019 LG Electronics, Inc.

DESCRIPTION = "Sphinx is a tool that makes it easy to create intelligent and beautiful documentation for Python projects"
HOMEPAGE = "http://www.sphinx-doc.org"
SECTION = "devel/python"
LICENSE = "BSD-2-Clause & Python-2.0 & BSD-3-Clause & MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d5575c977f2e4659ece47f731f2b8319"

SRC_URI[md5sum] = "753731d5751991d9cc0c02b8994f21f6"
SRC_URI[sha256sum] = "832bed0dc6099c2abca957d90ff55bc1a6ec4425c13fc144adbae68a970e3775"

PYPI_PACKAGE = "Sphinx"
inherit pypi

BBCLASSEXTEND = "native"
