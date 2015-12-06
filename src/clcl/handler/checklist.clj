(ns clcl.handler.checklist
  (:require [clcl.event :as event]
            [clcl-checklist.core :as c]))

(def event-name event/pull-request)

(defn run [payload option]
  (c/add-checlist payload option))
