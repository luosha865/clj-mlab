(ns clj-mlab.core
  (:require [clj-mlab.example.DBNFullMnistExample  :as dbn])
  (:gen-class))



(defn -main
  [& args]
  (dbn/start)
  (println "Hello ML!"))
