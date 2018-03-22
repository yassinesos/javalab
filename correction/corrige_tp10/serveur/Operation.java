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
package corrige_tp10.serveur;

/**
 * Définie une opération sous forme de chaine de caractères. Permet d'introduire la
 * notion d'héritage ainsi que de l'encapsulation. Elle utilise :
 * <p>
 * String : Représente une chaîne de caractères dont le contenu ne
 * peut être modifié.
 *
 * @author Alain Lebret
 * @version 1.0
 */
public class Operation {
    /**
     * chaîne de caractères représentant l'opération à effectuer sous la forme :
     * operande1 operateur operande2
     */
    private String operation;

    /**
     * Constructeur par défaut.
     */
    public Operation() {
        operation = "";
    }

    /**
     * Récupération de l'opération souhaitée.
     *
     * @return chaîne de caractères représentant le calcul effectué
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Mise à jour de l'opération souhaitée
     *
     * @param operation chaîne de caractères décrivant l'opération à effectuer
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }
} // Fin Operation