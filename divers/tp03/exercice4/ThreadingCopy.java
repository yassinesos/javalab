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
package tp03.exercice4;

public class ThreadingCopy extends Thread {
    FileCopy fc;

    public ThreadingCopy(String name, String in, String out) {
        super(name);
        fc = new FileCopy(in, out);
    }

    public void displayNumberBytesCopied() {
        System.out.println("" + fc.getNumberBytesCopied() + " bytes copied.");
    }

    @Override
    public void run() {
        System.out.println("ThreadingCopy - START "+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
            displayNumberBytesCopied();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadingCopy - END "+Thread.currentThread().getName());
    }
}
