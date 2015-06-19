(ns clj-mlab.core
  (:require [clj-mlab.classifiers.lda  :as lda])
  (:gen-class))



(defn -main
  [& args]
  (lda/start)
  (println "Hello ML!"))
