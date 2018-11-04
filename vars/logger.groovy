#!/usr/bin/env groovy

def call (String message) {
  sh "echo ${message}"
}