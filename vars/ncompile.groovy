#!/usr/bin/env groovy
def call(int param1){
node('master') {
   environment {
        buildurl = "${BUILD_URL}"
        jobname="${JOB_NAME}"
        Compile=param1
        
        
    }

   stage('Compile') {
   	echo "Compile source code NOT PERFORMED"
   	
   	sh '''build_url=${BUILD_URL}
        jobname=${JOB_NAME}
        echo "BUILD_URL is $build_url"
        echo "Compile value is $Compile"
        var1="buildurl="
        echo "var1 is $var1"
        buildurl="$var1$build_url"
        echo " build url is $buildurl"
        curl -i -XPOST \'http://18.221.233.168:8086/write?db=mydb\' --data-binary "stdata,buildurl=$build_url,jobname=$jobname Compile=$Compile"'''

}

}
}