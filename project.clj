(defproject clj-mlab "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [nz.ac.waikato.cms.weka/weka-stable "3.6.12"]]
  :main ^:skip-aot clj-mlab.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
