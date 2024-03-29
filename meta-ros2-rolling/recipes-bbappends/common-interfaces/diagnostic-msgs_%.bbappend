# This fixes a QA with [file-rdeps] because transitive rdeps are not
# propagated properly

DEPENDS:append = " \
    service-msgs \
"
