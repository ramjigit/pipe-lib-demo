#!/usr/bin/env groovy
def call(){
node('master') {
   environment {
        BUILD_URL = "${BUILD_URL}"

    }

   stage('Compile') {
   	echo "Compile"
   	echo "${BUILD_URL}"
    sh '''curl -i -XPOST http://3.134.86.192:8086/query --data-urlencode "q=CREATE DATABASE mydb"
curl -i -XPOST \'http://3.134.86.192:8086/write?db=mydb\' --data-binary \'stagecheck,STAGE=COMPILE,buildurl=${BUILD_URL},buildid=$BUILD_ID,jobname=${JOB_NAME},Presence=Yes value=1\''''



}

}
}
