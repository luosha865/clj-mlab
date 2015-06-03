(ns clj-mlab.core.data-test
  (:require [clj-mlab.core.data :as data]
            [clojure.test :refer :all]))

(deftest a-test
  (let [dataset (data/new-dataset "data/iris.arff")
        count (data/num-dataset dataset)
        numattrs (data/num-attribute dataset)]
    (do
      (println (data/class-index dataset))
      (data/set-class-index dataset (- numattrs 1))
      (println (data/class-index dataset))
      (testing "FIXME, I fail."
        (is (= count 150))
        (is (= numattrs 5))))))