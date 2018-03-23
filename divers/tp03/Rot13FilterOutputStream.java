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
package tp03;

import java.io.*;


public class Rot13FilterOutputStream extends FilterOutputStream {

    /**
     * Construit un nouveau filtre de flux de sortie
     */
    public Rot13FilterOutputStream(OutputStream out) {
        super(out);
    }

    public static void main(String[] arg) {
        int caract;

        Rot13FilterOutputStream out = null;
        BufferedInputStream in = new BufferedInputStream(System.in);

        try {
            out = new Rot13FilterOutputStream(new FileOutputStream("output.cry"));
        } catch (FileNotFoundException e) {
            System.err.println("Rot13FilterOutputStream: " + e);
            System.exit(-1);
        }

        try {
            while ((caract = in.read()) != -1) {
                out.write(caract);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            System.err.println("Rot13FilterOutputStream: " + e);
            System.exit(-1);
        }
    }

    public void write(int b) throws IOException {
        out.write(encode(b));
    }

    private int encode(int caract) {
        int alpha = 65;

        if (caract >= 65 && caract <= 90) alpha = 65;
        else if (caract >= 97 && caract <= 122) alpha = 97;
        return (caract - alpha + 13) % 26 + alpha;
    }
}