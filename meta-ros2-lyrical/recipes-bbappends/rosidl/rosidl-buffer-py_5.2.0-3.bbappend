# ERROR: QA Issue: File '/opt/ros/rolling/lib/python3.14/site-packages/rosidl_buffer/_rosidl_buffer_py.cpython-314-x86_64-linux-gnu.so' from rosidl-buffer-py was already stripped, this will prevent future debugging! [already-stripped]
INSANE_SKIP:${PN} += "already-stripped"

BBCLASSEXTEND = "native nativesdk"
