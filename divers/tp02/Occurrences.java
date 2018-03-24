/*
 * Java programming laboratory work.
 *
 * Copyright (C) 2002-2018 Alain Lebret (alain.lebret@ensicaen.fr)
 * ENSICAEN
 * 6 Bd Maréchal Juin
 * 4000 Caen, France
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package tp02;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Occurrences {
    HashMap<String, Integer> motsEtOccurrences;

    public Occurrences() {
        motsEtOccurrences = new HashMap<>();
    }

    public void lire(String fichier) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fichier));
        String ligne;
        String[] mots;
        int compteur;

        while ((ligne = br.readLine()) != null) {
            mots = ligne.split("[ ,.;:_\\-+*/\\n\"'{}()=><\\t!?]");
            for (String mot : mots) {
                compteur = 1;
                if (motsEtOccurrences.containsKey(mot)) {
                    compteur = motsEtOccurrences.get(mot) + 1;
                }
                motsEtOccurrences.put(mot, compteur);
            }
        }
        br.close();
    }

    public void afficher() {
        for (Map.Entry<String, Integer> mot : motsEtOccurrences.entrySet()) {
            System.out.println(mot.getKey() + " - " + mot.getValue());
        }
    }

    public static void main(String[] args) {
        Occurrences occ = new Occurrences();
        try {
            occ.lire("divers/tp02/test.txt");
            occ.afficher();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
