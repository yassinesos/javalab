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
package tp01;

import java.util.StringTokenizer;

public class EcritDouble {

    static String tronque(String chaine, int nbDecimales) {
        String avant;
        String apres;

        StringTokenizer st = new StringTokenizer(chaine, ".");
        avant = st.nextToken();

        if (st.hasMoreTokens())
            apres = st.nextToken();
        else
            return avant;

        if (apres.length() <= nbDecimales)
            return chaine;

        return chaine.substring(0, chaine.length() - apres.length() + nbDecimales);
    }

    public static void main(String[] arg) {
        if (arg.length != 2) {
            System.out.println("Il faut deux paramètres");
            System.exit(0);
        }

        try {
            int nbDecimales = Integer.parseInt(arg[1]);
            if (nbDecimales < 0) throw new NumberFormatException();
            System.out.println(tronque(arg[0], nbDecimales));
        } catch (NumberFormatException exc) {
            System.err.println("erreur d'écriture ; le premier paramètre " +
                    "doit être un double et le second paramètre " +
                    "un entier positif ou nul");
        }
    }
}
