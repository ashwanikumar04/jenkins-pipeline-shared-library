#!/usr/bin/env groovy

def call (String dummy) {
    message= sh (
    script:"git log --pretty=%s -1",
    returnStdout:true).trim()

    gitCommit = sh (
    script:"git rev-parse HEAD",
    returnStdout:true).trim()

    shortGitCommit = gitCommit.take(6)

    author = sh (
    script:"git --no-pager show -s --format='%an' ${gitCommit}",
    returnStdout:true).trim()

    email = sh (
    script:"git --no-pager show -s --format='%ae' ${gitCommit}",
    returnStdout:true).trim()

    Map<String,String> map = new HashMap<>()
    map.put("message", message)
    map.put("commit", gitCommit)
    map.put("shortCommit", shortGitCommit)
    map.put("author", author)
    map.put("email", email)
    return map
}