---
name: Bug report
about: Create a report to help us improve
title: ''
labels: ''
assignees: ''

---

**Describe the bug**
A clear and concise description of what the bug is.

**To Reproduce**
List all the Yocto layers you have included in the build and the revisions you were using.
What MACHINE you're building for and what host OS you're using.

The "Build Configuration:" section shown by bitbake at the beginning of the build is very good start.

Then show the exact error you're seeing, often it's useful to attach whole log.do_<task> from ${WORKDIR} and if it doesn't show much details, then additional files as well (like config.log from ${B} directory for do_configure errors with autotools or CMakeOutput.log/CMakeError.log files with cmake).

**Expected behavior**
A clear and concise description of what you expected to happen.
