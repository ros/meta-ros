# Copyright (c) 2026 Wind River Systems, Inc.

# populate_sdk_qt6_base.bbclass does
#   SDK_POSTPROCESS_COMMAND:prepend = "create_qt6_sdk_files;"
# which glues "create_qt6_sdk_files;create_sdk_files" into a single word and
# triggers this warning from populate_sdk_base.bbclass:
#   SDK_POSTPROCESS_COMMAND contains ';' but is a space separated list of
#   functions, remove the ';' delimiters or the functions will not be part of
#   the task signature
# Replace the glued word with the two functions as separate words, in the same
# order as before.
SDK_POSTPROCESS_COMMAND:remove = "create_qt6_sdk_files;create_sdk_files"
SDK_POSTPROCESS_COMMAND:prepend = "create_qt6_sdk_files create_sdk_files "
