#!/usr/bin/env groovy

def call (String dummy) {
    env["GIT-MESSAGE"]= sh (
    script:"git log --pretty=%s -1",
    returnStdout:true).trim()

    gitCommit = sh (
    script:"git rev-parse HEAD",
    returnStdout:true).trim()

    env["GIT-COMMIT"]= gitCommit

    env["GIT-AUTHOR"]= sh (
    script:"git --no-pager show -s --format='%an' ${gitCommit}",
    returnStdout:true).trim()
}