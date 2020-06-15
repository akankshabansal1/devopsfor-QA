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
    }	
    
