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
package corrige_tp06;

import java.io.*;

/**
 * Classe d'essai pour les fichiers binaire. Elle utilise :
 * <p>
 * DataInputStream        : Permet la lecture de type primitifs Java depuis un flux d'octets.
 * DataOutputStream       : Permet l'écriture de types Java primitifs sur un flux d'octets.
 * FileInputStream        : Flux d'entrée permettant la lecture d'octets depuis
 * un fichier (spécifié par une instance de <code>File</code> ou
 * par son nom).
 * FileOutputStream       : Flux d'octets permettant l'écriture de données dans
 * un fichier (spécifié par une instance de <code>File</code> ou
 * par son nom).
 * IOException            : Indique une erreur d'entrée/sortie quelconque.
 * System                 : Contient plusieurs attributs et méthodes utiles au
 * dialogue avec le system d'exploitation.
 *
 * @author Alain Lebret
 * @version 1.0
 */
public class EssaiFichierBinaire {
    /**
     * Fonction principale
     */
    public static void main(String[] argument) {
        /* flot de sortie permettant l'envoi d'octets */
        DataOutputStream fWo;

        /* flot d'entrée permettant la réception d'octets */
        DataInputStream fRo;

        /*
         * Ouverture d'un flot vers un fichier binaire et écriture d'informations
         */
        try {
            fWo = new DataOutputStream(new FileOutputStream("test.bin"));
            fWo.writeBoolean(true);
            fWo.writeByte(10);
            fWo.writeChar(65);
            fWo.writeDouble(1.0);
            fWo.writeInt(1024);
            fWo.writeLong(131072);
            fWo.writeShort(8);
            fWo.close();
        } catch (IOException e) {
            System.err.println("Erreur durant l'écriture dans le fichier");
        }

        /*
         * Ouverture d'un flot depuis un fichier binaire et lecture d'informations
         */
        try {
            fRo = new DataInputStream(new FileInputStream("test.bin"));
            System.out.println("" + fRo.readBoolean());
            System.out.println("" + fRo.readByte());
            System.out.println("" + fRo.readChar());
            System.out.println("" + fRo.readDouble());
            System.out.println("" + fRo.readInt());
            System.out.println("" + fRo.readLong());
            System.out.println("" + fRo.readShort());
            fRo.close();
        } catch (IOException e) {
            System.err.println("Erreur durant la lecture dans le fichier");
        }
    }
} // Fin EssaiFichierBinaire