(ns clj-mlab.core.data
  (:import [weka.core Attribute FastVector Instance Instances])
  (:import [java.io FileReader]))

(defn is-dataset? [dataset]
  "Checks if the provided object is dataset"
  (if (= weka.core.Instances
        (class dataset))
    true
    false))

(defn dataset-values-at [dataset pos]
  "get possible values for Nominal attrs"
  (let [attr (.attribute dataset pos)
        values (.enumerateValues attr)]
    (if (not (nil? values))
      (loop [continue (.hasMoreElements values)
             acum {}]
        (if continue
          (let [val (.nextElement values)
                index (.indexOfValue attr val)]
            (recur (.hasMoreElements values)
              (conj acum {(keyword val) index})))
          acum)))))

(defn is-instance? [instance]
  "Checks if the provided object is an instance"
  (if (= weka.core.Instance
        (class instance))
    true
    false))

(defn attribute-name-at [instance pos]
  (let [attr (.attribute instance pos)]
    (.name attr)))

(defn attribute-value-at [instance pos]
  (let [attr (.attribute instance pos)]
    (if (.isNominal attr)
      (let [val (.value instance pos)
            key-vals (dataset-values-at instance pos)
            key-val (loop [ks (keys key-vals)]
                      (if (= (get key-vals (first ks))
                            val)
                        (first ks)
                        (recur (rest ks))))]
        key-val)
      (.value instance pos))))


(defn num-dataset [dataset]
  (.numInstances dataset))

(defn num-attribute [dataset]
  (.numAttributes dataset))

(defn new-dataset [file]
  (let [input (FileReader. file)
        dataset (Instances. input)]
    dataset))

(defn class-index [dataset]
  (.classIndex dataset))

(defn class-value [instance]
  (.classValue instance))

(defn set-class-index [dataset pos]
  (.setClassIndex dataset pos))

(defn instance-at [dataset pos]
  (.index dataset pos))
