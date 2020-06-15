pipeline
{
agent any
tools
{
maven 'maven'
}
stages
{
stage('checkout')
{
checkout scm
}
stage ('build')
{
bat "mvn clean install"

}
}
}
