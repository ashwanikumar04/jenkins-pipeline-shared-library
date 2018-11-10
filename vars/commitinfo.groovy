#!/usr/bin/env groovy

def call () {
    env["GIT-MESSAGE"]= sh (
    script:"git log --pretty=%s -1",
    returnStdout:true).trim()

    env["GIT-COMMIT"]= sh (
    script:"git rev-parse HEAD",
    returnStdout:true).trim()

    env["GIT-AUTHOR"]= sh (
    script:"git --no-pager show -s --format='%an' ${GIT-COMMIT}",
    returnStdout:true).trim()
}