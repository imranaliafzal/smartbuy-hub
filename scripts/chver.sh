 #!/bin/bash
 read -p "Enter new version: " version
 mvn -f ../pom.xml versions:set -DnewVersion=${version}-SNAPSHOT -DgenerateBackupPoms=false