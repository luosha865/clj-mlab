(defproject clj-mlab "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [nz.ac.waikato.cms.weka/weka-stable "3.6.12"]
                 [org.nd4j/nd4j-jblas "0.0.3.5.5.5"]
                 [org.deeplearning4j/deeplearning4j-scaleout-api "0.0.3.3.4.alpha2"]
                 [org.deeplearning4j/deeplearning4j-nlp "0.0.3.3.4.alpha2"]
                 [incanter "1.5.6"]
                 [compojure "1.3.4"]]
  :plugins [[lein-localrepo "0.5.3"] [lein-expand-resource-paths "0.0.1"]]
  :resource-paths ["libs/*"]
  :injections [(clojure.lang.RT/loadLibrary org.opencv.core.Core/NATIVE_LIBRARY_NAME)]
  :main ^:skip-aot clj-mlab.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
