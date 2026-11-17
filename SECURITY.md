# Security Policy

## Scope

This repository contains OpenEmbedded/Yocto metadata (recipes, bbappends,
patches, classes and configuration) for building ROS 1, ROS 2 and Space ROS.
It covers every layer in this repository: meta-ros-common, meta-ros1,
meta-ros1-noetic, meta-ros2, meta-ros2-<distro>, meta-spaceros and
meta-spaceros-<distro>.

In scope:
- Problems in this metadata itself, for example a recipe that fetches over an
  insecure protocol, pins a known-vulnerable revision, disables a security
  hardening flag, installs files with unsafe permissions, or a patch here that
  introduces a vulnerability.

Out of scope (please report upstream instead):
- Vulnerabilities in ROS 2 packages themselves: follow the ROS 2
  Vulnerability Disclosure Policy
  ([REP 2006](https://www.ros.org/reps/rep-2006.html), which currently
  directs reports to security@openrobotics.org). REP 2006 covers ROS 2 only;
  for ROS 1 (Noetic, end of life) packages, report to the package's own
  maintainers.
- Vulnerabilities in OpenEmbedded-Core, BitBake or other layers: follow the
  Yocto Project security process.
- Vulnerabilities in third-party software we package: report them to that
  project. If a fix needs to be carried here as a patch or version bump, you
  are welcome to tell us as well.

## Supported branches

Security fixes are made on the branches that track supported Yocto Project
releases, plus `master`. See the README for the current list of supported
branches and ROS distros.

## Reporting a vulnerability

Please do not open a public issue for a suspected vulnerability.

Use GitHub's private vulnerability reporting ("Report a vulnerability" under
this repository's Security tab), or email the maintainers listed in the README
at rob.woolley@windriver.com.

Please include the affected branch, layer and recipe, a description of the
issue and its impact, and any suggested fix.

We aim to acknowledge reports within 5 business days and to agree on a
disclosure timeline with the reporter. Fixed issues are announced in the
commit message and, where appropriate, in a GitHub security advisory.
