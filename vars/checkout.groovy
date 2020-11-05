#!/usr/bin/env groovy

def call(int param1){
node('master') {
  environment{
    BUILD_ID=${BUILD_ID}
    BUILD_URL=${BUILD_URL}
    JOB_NAME=${JOB_NAME}
    Checkout=param1
          }


  
   
   stage('Checkout') {
    echo "Checking out the code"
        
     def influxdb = Jenkins.instance.getDescriptorByType(jenkinsci.plugins.influxdb.InfluxDbStep.DescriptorImpl)

               // Create target
    def target = new jenkinsci.plugins.influxdb.models.Target()

               // Set target details

               // Mandatory fields
    target.description = 'my-new-target'
    target.url = 'http://3.131.85.206:8086'
    target.database = 'mydb'
    influxdb.addTarget(target)
    influxdb.save()
    def myFields1 = [:]
    def myCustomMeasurementFields = [:]
     myFields1['unittest'] =  Checkout
     myFields1['Total']  = 1
     myCustomMeasurementFields['score'] = myFields1
     //myTags = ['scorecard':['buildurl':"test",'JOB_NAME':"test1"]]
     myTags = ['scorecard':['buildurl':BUILD_URL,'JOBNAME':JOB_NAME]]
     influxDbPublisher(selectedTarget: 'my-new-target', customDataMap: myCustomMeasurementFields, customDataMapTags: myTags)
          }
}
}