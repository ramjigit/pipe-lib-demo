#!/usr/bin/env groovy
def call(int param1){
node('master') {
   environment {
        buildurl = "${BUILD_URL}"
        jobname="${JOB_NAME}"
        Checkout=param1
        
        
    }

   stage('Checkout') {
   	echo "Checkout source code"
   	
   	sh '''build_url=${BUILD_URL}
        jobname=${JOB_NAME}
        echo "BUILD_URL is $build_url"
        echo "Checkout value is $Checkout"
        var1="buildurl="
        echo "var1 is $var1"
        buildurl="$var1$build_url"
        echo " build url is $buildurl"
        curl -i -XPOST \'http://18.221.233.168:8086/write?db=mydb\' --data-binary "j_s,buildurl=$build_url,jobname=$jobname Checkout=$Checkout"'''

}

}
}