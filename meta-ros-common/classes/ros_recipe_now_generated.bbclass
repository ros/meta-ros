# Inherit this bbclass in a manually created recipe to handle the case where a package that originally wasn't listed in
# ROS_DISTRO-cache.yaml now appears in that file for a subsequent distro. It appends a '-notgenerated' suffix to PN if the current
# ROS_DISTRO now has a generated recipe for PN, thus ensuring it won't be used regardless of the algorithm used by OE to select
# between multiple recipes.

def ros_recipe_now_generated__get_suffix(d):
    pn = bb.parse.vars_from_file(d.getVar('FILE', False),d)[0] or 'defaultpkgname'
    return bb.utils.contains('ROS_SUPERFLORE_GENERATED_RECIPES', pn, '-notgenerated', '', d)

PN:append = "${@ros_recipe_now_generated__get_suffix(d)}"
