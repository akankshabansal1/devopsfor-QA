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
        
        stage('build'){
            steps{
                echo "build"
                bat "mvn clean install"
            }
        }
        
        stage('sonar'){
            steps{
                echo "sonar"
                withSonarQubeEnv("local sonar") 
				{
					bat "mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar"
				}
            }
        }
		
		        
    }
}
