#!/usr/bin/env groovy
def call(){
node('master') {
   environment {
        BUILD_URL = "${BUILD_URL}"

    }

   stage('ArtifactoryPush') {
   	echo "ArtifactoryPush"
   	sh '''build_url=${BUILD_URL}
jobname=${JOB_NAME}
echo "BUILD_URL is $build_url"
var1="buildurl="
echo "var1 is $var1"
buildurl="$var1$build_url"
echo " build url is $buildurl"
curl -i -XPOST \'http://3.134.86.192:8086/write?db=mydb\' --data-binary "jenkins_final_data,buildurl=$build_url,jobname=$jobname,Stage=ArtifactoryPush value=1"'''

}

}
}