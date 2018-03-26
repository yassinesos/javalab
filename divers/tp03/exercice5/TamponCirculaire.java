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

public class TamponCirculaire {
    Object[] elements;
    int maxElements;
    int nbElements;
    int indexDepot;
    int indexRetrait;

    public TamponCirculaire(int max) {
        maxElements = max;
        elements = new Object[maxElements];
        nbElements = 0;
        indexDepot = 0;
        indexRetrait = 0;
    }

    public synchronized void deposer(Object element) {
        while (nbElements == maxElements) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        elements[indexDepot] = element;
        indexDepot = (indexDepot + 1) % maxElements;
        nbElements++;
        notify();
    }

    public synchronized Object prelever() {
        while (nbElements == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Object element = elements[indexRetrait];
        indexRetrait = (indexRetrait + 1) % maxElements;
        nbElements--;
        notify();
        return element;
    }
}
