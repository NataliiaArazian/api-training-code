node {
   stage("checkout repo") {
        git branch: 'master',
        credentialsId: '7928ee09-3992-4031-8087-7c0b6309c0a6',
        url: 'https://github.com/NataliiaArazian/api-training-code.git'
   }

   stage("build") {
        sh "./gradlew clean api-test:assemble"
   }

   stage("run api tests") {
        sh "./gradlew api-test:test"
   }

    allure([
          includeProperties: false,
          jdk: '',
          properties: [],
          reportBuildPolicy: 'ALWAYS',
          results: [[path: 'api-test/allure-results']]
    ])
}