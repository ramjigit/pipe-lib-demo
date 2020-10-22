#!/usr/bin/env groovy
def call(){
node('master') {
   environment {
        buildurl = "${BUILD_URL}"
        jobname="${JOB_NAME}"
        BUILD_STRING = "checkout"
        
        
        
    }

   stage('Push 0 to stages not perfoemed') {
   	
def job = Jenkins.instance.items.find { it.name == jobname }
for (build in job.builds) {
  def log = build.log
  if (log.contains(BUILD_STRING)) {
    println "${job.name}: ${build.id}"
  }
}

}

}
}