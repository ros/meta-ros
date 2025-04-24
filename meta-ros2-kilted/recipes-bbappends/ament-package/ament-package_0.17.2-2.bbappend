FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI:append = " file://skip_shell_path.patch \
                   file://0001-Simplify-removing-leading-and-trailing-separators.patch"
