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
     then
              echo "BUILD_URL is buildurl"
                  fi
  """

}

}
}