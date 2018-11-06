#!/usr/bin/env groovy

def call (String message) {
  sh '''set +xe 
        echo ${message}
      '''
}