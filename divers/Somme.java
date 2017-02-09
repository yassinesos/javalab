/*
 * Copyright 2017 fouroche74.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Cette "classe" (en est-ce vraiment une au sens objet du terme ?) propose 
 * de faire la somme des entiers passés en arguments.
 * @author A. Lebret 
 * @version 1.0 (01/2017)
 */ 


public class Somme {
	public static void main(String[] args) {
		int i;
		int somme = 0;

		for (i = 0; i< args.length; i++) {
			try {
				somme += Integer.valueOf(args[i]);
			} catch(NumberFormatException e) {
				System.err.println("Attention, \"" + args[i] + "\" n'est pas un nombre entier !");
			}
		}
		System.out.println("Somme = " + somme);
	}
}

