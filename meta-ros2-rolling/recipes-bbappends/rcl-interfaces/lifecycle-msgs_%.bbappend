# These DEPENDS are necessary to avoid QA [file-rdeps] to service_msgs and
# builtin-interfaces
DEPENDS:append = " \
    service-msgs \
    builtin-interfaces \
"
