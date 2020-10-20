#!/usr/bin/env groovy
def call(compile){
node('master') {
   environment {
        BUILD_URL = "${BUILD_URL}"

    }

   stage('Compile') {
   	echo "Compile"
   	sh '''build_url=${BUILD_URL}
 if [ $checkout == 1 ]
then
jobname=${JOB_NAME}
echo "BUILD_URL is $build_url"
var1="buildurl="
echo "var1 is $var1"
buildurl="$var1$build_url"
echo " build url is $buildurl"
curl -i -XPOST \'http://3.134.86.192:8086/write?db=mydb\' --data-binary "jenkins_stages_data,buildurl=$build_url,jobname=$jobname,Stage=Compile Compile=$compile 
else
jobname=${JOB_NAME}
echo "BUILD_URL is $build_url"
var1="buildurl="
echo "var1 is $var1"
buildurl="$var1$build_url"
echo " build url is $buildurl"
curl -i -XPOST \'http://3.134.86.192:8086/write?db=mydb\' --data-binary "jenkins_stages_data,buildurl=$build_url,jobname=$jobname,Stage=Compile Compile=$compile 
fi

"'''



}

}
}
