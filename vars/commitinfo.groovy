#!/usr/bin/env groovy

def call (String dummy) {
    message= sh (
    script:"git log --pretty=%s -1",
    returnStdout:true).trim()

    gitCommit = sh (
    script:"git rev-parse HEAD",
    returnStdout:true).trim()


    author = sh (
    script:"git --no-pager show -s --format='%an' ${gitCommit}",
    returnStdout:true).trim()

    Map<String,String> map = new HashMap<>()
    map.put("message",message)
    map.put("commit",gitCommit)
    map.put("author",author)

    return map


}