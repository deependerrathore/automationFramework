pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        build 'Test_job_automation_framework'
      }
    }

    stage('run') {
      steps {
        echo 'compiled and runned'
      }
    }

  }
  environment {
    test = 'test'
  }
}