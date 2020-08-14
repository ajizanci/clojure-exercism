(ns rna-transcription)

(defn to-rna [dna]
  (let [dna->rna {\G \C
                  \C \G
                  \T \A
                  \A \U}
        rna-map (map #(get dna->rna %) dna)]
    (assert (every? #(not= nil %) rna-map))
    (apply str rna-map)))

