#!/usr/bin/env groovy
def call(int param1){
node('master') {
   environment {
        buildurl = "${BUILD_URL}"
        jobname="${JOB_NAME}"
        ck=param1
        
        
    }

   stage('Checkout') {
   	echo "Checkout source code"
   	println param1
   	ck = param1
sh """

    echo "ck is $ck"
    if [ $ck == 1 ]
              echo "BUILD_URL is buildurl"
              echo  " jobname  is jobname"

curl -i -XPOST \'http://3.134.86.192:8086/write?db=mydb\' --data-binary "j_s,buildurl=buildurl,jobname=jobname Checkout=$ck"  

  """

}

}
}