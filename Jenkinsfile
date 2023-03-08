pipeline {
    
    agent any
    
       tools {
          maven 'M2_HOME'
      }
    stages {
	
        stage('GIT Checkout') 
		{
            steps 
			{
                echo 'Pulling project from GIT...';
                git branch: 'sabrinezekri',
                url : 'https://github.com/adamderbali/achatRepo.git',
                
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
  
    }
}