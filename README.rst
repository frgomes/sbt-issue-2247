SBT issue 2247
==============

https://github.com/sbt/sbt/issues/2247 describes an issue related to configurations.

In a nutshell, the behaviour is actually expected, but it is very non intuitive to SBT users.
At this point, it's not known whether SBT will offer a more intuitive API, or will provide helper functions or will improve the documentation or some other alternative.

In ``build.sbt.HACKED`` we provide an example of how the difficulty can be circumvented.

Documented in StackOverflow:

http://stackoverflow.com/questions/33243981/how-can-i-override-tasks-run-and-runmain-in-sbt-to-use-my-own-forkopti/33244341#33244341


-- Richard Gomes