#!/usr/bin/env groovy
def call(nodename,ck){
node(nodename) {
   environment {
        buildurl = "${BUILD_URL}"
        ck=$ck
        
    }

   stage('Checkout') {
   	echo "Checkout source code"
sh '''build_url=${BUILD_URL}
if [ $checkout == 1 ]
then
jobname=${JOB_NAME}
buildid=${BUILD_ID}

echo "BUILD_URL is $build_url"

echo  "value of ck is $ck"

var1="buildurl="

echo "var1 is $var1"

buildurl="$var1$build_url"
echo " build url is $buildurl"
curl -i -XPOST \'http://3.134.86.192:8086/write?db=mydb\' --data-binary "j_s_d,buildurl=$build_url,jobname=$jobname Checkout=$ck"  
else
jobname=${JOB_NAME}
buildid=${BUILD_ID}

echo "BUILD_URL is $build_url"

var1="buildurl="

echo "var1 is $var1"

buildurl="$var1$build_url"
echo " build url is $buildurl"
curl -i -XPOST \'http://3.134.86.192:8086/write?db=mydb\' --data-binary "j_s_d,buildurl=$build_url,jobname=$jobname Checkout=$ck"
fi'''

}

}
}