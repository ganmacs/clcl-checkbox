(ns clcl-checklist.core
  (:require [clcl.action.add-comment :as c]
            [clcl.util :as u]))

(defn- body []
  (let [file-path (or (u/env "CHECKLIST_FILE_PATH")
                      "CONTRIBUTING.md")]
    (u/safe-slurp file-path)))

(defn add-checklist [file-path payload option]
  (if-let [b (body)]
    (c/add-comment b payload option)))
