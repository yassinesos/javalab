/*
 * Java programming laboratory work.
 *
 * Copyright (C) 2002-2018 Alain Lebret (alain.lebret@ensicaen.fr)
 * ENSICAEN
 * 6 Bd Maréchal Juin
 * 14000 Caen, France
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
package tp4;

/**
 * Classe d'essai pour la calculette. Elle utilise :
 * <pre>
 *   String : représente une chaîne de caractères dont le contenu ne
 *            peut être modifié.
 *   System : contient plusieurs attributs et méthodes utiles au dialogue
 *            avec le system d'exploitation.
 *   </pre>
 *
 * @author Alain Lebret
 * @version 1.4
 */
public class Essai {
    /**
     * Fonction principale
     */
    public static void main(String[] argument) {
        CalculetteAWT calculette = new CalculetteAWT();
    }
} // Fin Essai