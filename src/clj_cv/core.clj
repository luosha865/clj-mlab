(ns clj-cv.core
  (:import [org.bytedeco.javacpp.opencv_core *])
  (:import [java.io FileReader])
  (:gen-class))

(defn -main
  [& args]
  (opencv_core/cvLoadImage "/Users/tianhaowei/Pictures/a.jpg")
  (println "Hello CV!"))
