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

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *   La classe Fichier propose une gestion simplifiée des fichiers de sérialisation
 *   des objets. Elle utilise :
 *   <PRE>
 *   ClassNotFoundException : Indique qu'une application essaie de charger une
 *                            classe introuvable.
 *   FileInputStream        : Flux d'entrée permettant la lecture d'octets depuis
 *                            un fichier (spécifié par une instance de <code>File</code> ou
 *                            par son nom).
 *   FileOutputStream       : Flux d'octets permettant l'écriture de données dans
 *                            un fichier (spécifié par une instance de <code>File</code> ou
 *                            par son nom).
 *   IOException            : Indique une erreur d'entrée/sortie quelconque.
 *   ObjectInputStream      : Permet la désérialisation de types primitifs Java et
 *                            d'objets sérialisés à l'aide de la classe ObjectOutputStream.
 *   ObjectOutputStream     : Permet la sérialisation de types Java primitifs ou
 *                            d'objets sérialisables (implémentants <code>Serializable</code>).
 *   System                 : Contient plusieurs attributs et méthodes utiles au
 *                            dialogue avec le system d'exploitation.
 *   </PRE>
 *   @version 1.0
 *   @author Alain Lebret
 */
public class Fichier
{
    /** nom du fichier à manipuler */
    private String nom;

    /**
     * Constructeur.
     * @param nomDuFichier nom du fichier à ouvrir
     * @see java.io.IOException
     */
    public Fichier(String nomDuFichier)
    {
        nom = nomDuFichier;
    }

    /**
     * Lecture d'un Objet dans le fichier.
     * @return une référence sur l'objet lu
     * @see java.io.IOException
     * @see java.lang.ClassNotFoundException
     */
    public Object lire()
    {
        Object tmp = null;

        try
        {
            ObjectInputStream fRo = new ObjectInputStream(new FileInputStream(nom));
            tmp = (Object) fRo.readObject();
            fRo.close();
        }
        catch (IOException e)
        {
            System.err.println("Fichier:lire() - Erreur durant la lecture du fichier");
        }
        catch (ClassNotFoundException e)
        {
            System.err.println("Fichier:lire() - Erreur durant la lecture des objets");
        }

        return tmp;
    }

    /**
     * Ecriture d'un Objet dans le fichier.
     * @param tmp référence de l'objet à écrire
     * @see java.io.IOException
     */
    public void ecrire(Object tmp)
    {
        if (tmp != null)
        {
            try
            {
                ObjectOutputStream fWo = new ObjectOutputStream(new FileOutputStream(nom));
                fWo.writeObject(tmp);
                fWo.close();
            }
            catch (IOException e)
            {
                System.err.println("Fichier:ecrire() - Erreur durant l'écriture du fichier");
            }
        }
    }
} // Fin Fichier