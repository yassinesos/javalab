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

import java.io.*;

public class FileCopy {

    private String in;
    private String out;
    private int delay;
    private int numberBytesCopied;

    public FileCopy(String in, String out) {
        this.in = in;
        this.out = out;
        delay = 0;
        numberBytesCopied = 0;
    }

    public void duplicateFile() throws IOException {
        InputStream is = new FileInputStream(in);
        OutputStream os = new FileOutputStream(out);
        int aByte;

        while ((aByte = is.read()) != -1) {
            os.write(aByte);
            numberBytesCopied++;
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        is.close();
        os.close();
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getNumberBytesCopied() {
        return numberBytesCopied;
    }
}
