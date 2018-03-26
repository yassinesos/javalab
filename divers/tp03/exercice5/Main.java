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
package tp03.exercice5;

public class Main {
    public static void main(String[] args) {
        TamponCirculaire tampon = new TamponCirculaire(10);
        Producteur p1 = new Producteur("p1", tampon);
        Producteur p2 = new Producteur("p2", tampon);
        Producteur p3 = new Producteur("p3", tampon);
        Consommateur c1 = new Consommateur("c1", tampon);
        Consommateur c2 = new Consommateur("c2", tampon);
        Consommateur c3 = new Consommateur("c3", tampon);
    }
}
