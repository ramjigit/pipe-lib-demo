#!/usr/bin/env groovy
def call(int param1){
node('master') {
   environment {
        buildurl = "${BUILD_URL}"
        ck=param1
        
        
    }

   stage('Checkout') {
   	echo "Checkout source code"
   	println param1
   	ck = param1
sh """build_url=${BUILD_URL}
      jobname=${JOB_NAME}

    echo "ck is $ck"
    if [ $ck == 1 ]
     then
         echo "BUILD_URL is $build_url"

          echo " build url is $buildurl"
curl -i -XPOST \'http://3.134.86.192:8086/write?db=mydb\' --data-binary "j_s_d,buildurl=$build_url,jobname=$jobname Checkout=$ck"  
else

curl -i -XPOST \'http://3.134.86.192:8086/write?db=mydb\' --data-binary "j_s_d,buildurl=$build_url,jobname=$jobname Checkout=0"
fi"""

}

}
}