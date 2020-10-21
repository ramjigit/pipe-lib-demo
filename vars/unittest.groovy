#!/usr/bin/env groovy
def call(int param1){
node('master') {
   environment {
        buildurl = "${BUILD_URL}"
        jobname="${JOB_NAME}"
        Unittest=param1
        
        
    }

   stage('Unittest') {
   	echo "Unittest source code"
   	
   	sh '''build_url=${BUILD_URL}
        jobname=${JOB_NAME}
        echo "BUILD_URL is $build_url"
        echo "Unittest value is $Unittest"
        var1="buildurl="
        echo "var1 is $var1"
        buildurl="$var1$build_url"
        echo " build url is $buildurl"
        curl -i -XPOST \'http://3.134.86.192:8086/write?db=mydb\' --data-binary "j_s,buildurl=$build_url,jobname=$jobname Unittest=$Unittest"'''

}

}
}