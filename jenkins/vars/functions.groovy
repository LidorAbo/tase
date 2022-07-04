#!/usr/bin/env groovy
import groovy.json.JsonSlurper
def prepareEnv(json) {
    def jsonSlurper = new JsonSlurper()
    def object = jsonSlurper.parseText(json)
    echo "$object"
}