#!/usr/bin/env groovy
import groovy.json.JsonSlurper
def prepareEnv(json) {
    def jsonSlurper = new JsonSlurper()
    def object = jsonSlurper.parseText(json)
    env.committer = object.head_commit.committer.name
    env.email = object.head_commit.committer.email
    env.latest_commit = object.head_commit.id
    env.modified_files = object.head_commit.modified
    env.removed_files = object.head_commit.removed
    env.added_files = object.head_commit.added
    env.repo_name = object.repository.name
    env.branch_name = object.repository.default_branch

}
