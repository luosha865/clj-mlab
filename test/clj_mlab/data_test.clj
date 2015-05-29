(ns clj-mlab.data-test
  (:require [clj-mlab.data :as data]
            [clojure.test :refer :all]))

(deftest a-test
  (let [dataset (data/new-instances "data/iris.arff")
        count (data/num-instances dataset)]
    (testing "FIXME, I fail."
      (is (= count 150)))))