#!/usr/bin/env groovy
def call(nodename){
node(nodename) {
   environment {
        buildurl = "${BUILD_URL}"
        
    }

   stage('Checkout') {
   	echo "Checkout source code"
sh '''build_url=${BUILD_URL}
jobname=${JOB_NAME}
buildid=${BUILD_ID}

echo "BUILD_URL is $build_url"

var1="buildurl="

echo "var1 is $var1"

buildurl="$var1$build_url"
echo " build url is $buildurl"
curl -i -XPOST \'http://18.221.233.168:8086/write?db=mydb\' --data-binary "st,buildurl=$build_url,jobname=$jobname,Stage=Checkout  Checkout=1"'''

}

}
}