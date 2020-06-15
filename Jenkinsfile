pipeline
{
    agent any
    tools
    {
        maven 'maven'
    }
    
    stages
    {
        stage('checkout'){
            steps{
                echo "checkout"
                git branch:"master", url:"https://github.com/akankshabansal1/devopsfor-QA"
				//checkout scm
            }
        }
	    stage('Build')
  {
    steps
    {
      bat "mvn clean install"
    }
  }
	
  stage('Sonar Analysis')
  {
    steps
    {
      echo "Sonar"
      withSonarQubeEnv("local sonar") 
				{
					bat "mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar"
				}
    }
  }
	
    stage ('Uploading to Artifactory')
	{
		steps
		{
		echo "Stage for artifact"
		rtMavenDeployer (
                    id: 'deployer',
                    serverId: '123456789@artifactory',
		    snapshotRepo: 'devopsforqa',
                    releaseRepo: 'devopsforqa_release'
                    
                )
                rtMavenRun (
                    pom: 'pom.xml',
                    goals: 'clean install',
                    deployerId: 'deployer',
                )
                rtPublishBuildInfo (
                    serverId: '123456789@artifactory',
                )
			
		}
	}
	
	stage('Docker Build Image')
	{
		steps
		{
			
		}
	}
	
	stage('Docker Deployment-container run')
	{
		steps
		{
			
		}
	}	
	
}
    }     
        
