(ns clj-cv.core
  (:import [org.opencv.core Mat Size CvType])
  (:import [org.opencv.highgui Highgui])
  (:import [org.opencv.imgproc Imgproc])
  (:import [com.atul.JavaOpenCV Imshow])
  (:import [java.io FileReader])
  (:gen-class))


(defn -main
  [& args]
  (def lena (Highgui/imread "resources/images/lena.png"))
  (.showImage (Imshow. "lena") lena)
  (println "Hello CV!"))
