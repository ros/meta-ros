# Copyright (c) 2026 Wind River Systems, Inc.

do_configure:append() {
    sed -i -e 's/^requires = \["setuptools>=77"/requires = ["setuptools"/' ${S}/pyproject.toml
    sed -i -e 's/^license = "BSD-2-Clause"$/license = {text = "BSD-2-Clause"}/' ${S}/pyproject.toml
    sed -i -e '/^license-files/d' ${S}/pyproject.toml
}
