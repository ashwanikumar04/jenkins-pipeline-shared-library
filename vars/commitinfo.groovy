#!/usr/bin/env groovy

def call () {
 Map<String,String> info = new HashMap<>();
 info.put("message",sh (
script:"git log --pretty=%s -1",
returnStdout:true).trim()
 )   

 return info
}