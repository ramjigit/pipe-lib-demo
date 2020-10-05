#!/usr/bin/env groovy
def call(){
node('master') {
   environment {
        BUILD_URL = "${BUILD_URL}"

    }

   stage('SAST') {
   	echo "SAST"
   	echo "${BUILD_URL}"
   	echo "${BUILD_ID}"
   	echo "${JOB_NAME}"
   	   sh '''curl -i -XPOST http://3.134.86.192:8086/query --data-urlencode "q=CREATE DATABASE mydb"
curl -i -XPOST \'http://3.134.86.192:8086/write?db=mydb\' --data-binary \'jd1,SAST=STAGE,buildurl=${BUILD_URL},buildid=$BUILD_ID,jobname=${JOB_NAME},Presence=Yes value=1\''''

}

}
}