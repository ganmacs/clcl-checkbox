(ns clcl-checklist.core
  (:require [clcl.action.add-comment :as c]
            [clcl.util :as u]
            [clojure.java.io :as io]
            [clojure.tools.logging :as log]))

(defn- safe-slurp [file-path]
  (try (slurp file-path)
       (catch java.io.FileNotFoundException e
         (log/error (format "%s is not found." file-path)))))

(defn- body []
  (let [file-path (or (u/env "checklist-file-path")
                      "CONTRIBUTING.md")]
    (safe-slurp file-path)))

(defn add-checklist [file-path payload option]
  (if-let [b (body)]
    (c/add-comment b payload option)))
