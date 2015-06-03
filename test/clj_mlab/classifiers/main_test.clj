(ns clj-mlab.classifiers.main-test
  (:require [clj-mlab.core.data :as data]
            [clj-mlab.classifiers.tree.id3 :as id3]
            [clj-mlab.classifiers.classifier :as cls]
            [clojure.test :refer :all]))

(deftest a-test
  (let [dataset (data/new-dataset "data/car.arff")
        numattrs (data/num-attribute dataset)
        cls (id3/create-Id3)]
    (do
      (data/set-class-index dataset (- numattrs 1))
      (println (data/class-index dataset))
      (cls/buildClassifier cls dataset)
      (testing "FIXME, I fail."
        (= 1 1)
        ))))