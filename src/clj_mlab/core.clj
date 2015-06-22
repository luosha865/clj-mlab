(ns clj-mlab.core
  (:require [clj-mlab.example.DBNFullMnistExample  :as dbn])
  (:gen-class))



(defn -main
  [& args]
  (println dbn/conf)
  (println "Hello ML!"))
