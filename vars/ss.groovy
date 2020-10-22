#!/usr/bin/env groovy
def call(){
node('master') {
   environment {
        buildurl = "${BUILD_URL}"
        jobname="${JOB_NAME}"
        BUILD_STRING = "checkout"
        
        
        
    }

   stage('Push 0 to stages not performed') {

  def log = build.log
  if (log.contains('checkout()')) {
    println "checkout stage present"
  }
}

}

}
}