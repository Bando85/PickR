
pipeline {

    node {
        def remote = [:]
          remote.name = 'test'
          remote.host = 'test.domain.com'
          remote.user = 'root'
          remote.password = 'password'
          remote.allowAnyHosts = true
          stage('Remote SSH') {
            writeFile file: 'abc.sh', text: 'ls -lrt'
            sshPut remote: remote, from: 'abc.sh', into: '.'
          }
    }

}