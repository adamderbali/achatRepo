pipeline {
    

    agent any
    
       tools {
          maven 'M2_HOME'
      }
     
      environment {
          MAVEN_OPTS = "-Xmx2g"
     }

    stages {
	
        stage('GIT Checkout') 
		{
            steps 
			{
                echo 'Getting project from GIT...';
                git branch : 'ghadaFridhi',
                url : 'https://github.com/adamderbali/achatRepo.git'
                
            }
        }
        
        stage ('Maven Clean')
		{
            steps 
			{
                sh 'mvn clean'
            }
        }
        
		stage ('Maven Compile')
		{
            steps 
			{
                sh 'mvn compile'
            }
        }
		
		stage ('Maven Sonar') 
		{
            steps 
			{
                sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.56.100:9000 -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }
		
        stage ('Maven Test')
		{
            steps 
			{
                sh 'mvn test'    
            }
        }
        
		stage('Maven Build')
	    {
            steps 
			{
                sh 'mvn package'
            }
        }
		
		stage ('Maven Install')
		{
            steps 
			{
                sh 'mvn install'    
            }
        }
    
        stage('NEXUS'){

         steps{

		   sh 'mvn deploy -DrepositoryId=deploymentRepo -Durl=http://192.168.60.20:8081/repository/maven-releases/ '
			 }

		}

      
    }
}