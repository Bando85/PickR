
    node {
            withCredentials([usernamePassword(credentialsId: 'piSSH', passwordVariable: 'PASS', usernameVariable: 'USER')]) {

              def remote = [:]

              remote.name = 'test'
              remote.host = '192.168.1.4'
              remote.user = USER
              remote.password = PASS
              remote.allowAnyHosts = true
              stage('Test') {
                  echo 'Testing...'

                  stage('Remote SSH') {
                      echo 'Transfering files to test server'
                    writeFile file: 'abc.sh', text: 'ls -lrt'
                     sshPut remote: remote, from: 'abc.sh', into: '/home/pi/share'
                  }

              }

              input(message: "Deploy to production?")

              stage('Deploy') {
                  echo 'Deploying...'

              }
            }
    }