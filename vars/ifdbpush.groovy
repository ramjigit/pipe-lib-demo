#!/usr/bin/env groovy
def call(){
node('master') {
	environment{
		BUILD_ID=${BUILD_ID}
		BUILD_URL=${BUILD_URL}
		Stage_name="UNIT TEST"
			}
	stage('Display'){
		echo  "Build id is ${BUILD_ID}"
		echo "Build Url is ${BUILD_URL}"
		echo "Stage_name is ${Stage_name}"
	}
   
   stage('UNIT TEST') {
   	// Get InfluxDB plugin descriptor (version < 2.0)
def influxdb = Jenkins.instance.getDescriptorByType(jenkinsci.plugins.influxdb.DescriptorImpl)

// version >= 2.0
def influxdb = Jenkins.instance.getDescriptorByType(jenkinsci.plugins.influxdb.InfluxDbStep.DescriptorImpl)

// Create target
def target = new jenkinsci.plugins.influxdb.models.Target()

// Set target details

// Mandatory fields
target.description = 'my-new-target'
target.url = 'http://3.134.86.192:8086'
target.username = 'admin'

// version < 2.0
target.password = 'Rahul@18'

// version >= 2.0
target.password = hudson.util.Secret.fromString('Rahul@18')

target.database = 'mydb'

// Optional fields
target.retentionPolicy = '1d'                    // default = 'autogen'
target.jobScheduledTimeAsPointsTimestamp = true  // default = false
target.exposeExceptions = true                   // default = true
target.usingJenkinsProxy = true                  // default = false

// Add a target by using the created target object
influxdb.addTarget(target)
influxdb.save()
   	echo "Unit testing the code"
   	def sFields = [:]
     sFields['field_k'] = 'UNITTEST'
     influxDbPublisher  jenkinsEnvParameterField: 'KEY=${BUILD_ID}', jenkinsEnvParameterTag: 'KEY=${BUILD_URL}',customData: sFields,selectedTarget: 'my-new-target'
          }
}
}