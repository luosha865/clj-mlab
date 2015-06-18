(ns clj-cv.core
  (:import [org.opencv.core Rect Mat Size CvType])
  (:import [org.opencv.highgui Highgui])
  (:import [org.opencv.imgproc Imgproc])
  (:import [com.atul.JavaOpenCV Imshow])
  (:import [java.io FileReader])
  (:gen-class))


(defn -main
  [& args]
  (def lena (Highgui/imread "resources/images/lena.png"))
  (def blurred (Mat. 512 512 CvType/CV_8UC3))
  (Imgproc/GaussianBlur lena blurred (Size. 5 5) 3 3)
  (.showImage (Imshow. "lena") blurred)
  (println "Hello CV!"))
