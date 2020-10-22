#!/usr/bin/env groovy
def call(){
node('master') {
   environment {
        buildurl = "${BUILD_URL}"
        jobname="${JOB_NAME}"
        
      BUILD_STRING = "checkout"
        
        
        
    }

   stage('Push 0 to stages not performed') {

   println "build id is ${BUILD_ID}"
  def job = Jenkins.instance.items.find { it.name == "${JOB_NAME}" }
   for (build in job.builds) {
      def log = build.log
      if (log.contains('bbbbbbb' )  &&  ("${build.id}" == "${BUILD_ID}" )) {
       println "${job.name}: ${build.id}"
      
                       }
                    }

                  }

}
}