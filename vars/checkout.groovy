#!/usr/bin/env groovy
def call(){
node('master') {
   environment {
        buildurl = "${BUILD_URL}"
        
    }

   stage('Checkout') {
   	echo "Checkout source code"
   	echo "${BUILD_URL}"
   	echo  "job url is $buildurl"
   	//sh '''curl -i -XPOST http://3.134.86.192:8086/query --data-urlencode "q=CREATE DATABASE mydb"
//curl -i -XPOST \'http://3.134.86.192:8086/write?db=mydb\' --data-binary \'stagecheck,STAGE=CHECKOUT,buildurl=${BUILD_URL},buildid=$BUILD_ID,jobname=${JOB_NAME},Presence=Yes value=1\''''
   
   sh 'curl -i -XPOST \'http://3.134.86.192:8086/write?db=mydb\' --data-binary "jenkins_stage_data,buildurl=$buildurl,Stage=CHECKOUT value=1"'

}

}
}