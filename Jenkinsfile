
pipeline {
    

    agent any
    
       tools {
          maven 'M2_HOME'
      }
    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling project from GIT...';
                git branch: 'ademDerbali',
                url : 'https://github.com/adamderbali/achatRepo.git',
                credentialsId : 'e344e277-5a08-40df-8aaa-152740d92aaa'
                
            }
        }
        
      
              stage('CLean') {
            steps {
              sh 'mvn clean'
                
            }
        }
        

    
        
        
         
   
        
    
        
    }
}