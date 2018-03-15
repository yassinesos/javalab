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

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


/**
 * Amélioration de la calculette du TP n°4 avec des fonctionnalités graphiques AWT.
 * Elle utilise :
 * <pre>
 * ActionEvent    : Evénement sémantique indiquant une action sur un composant.
 * ActionListener : Permet de recevoir les événements d'action (ActionEvent).
 * FlowLayout     : Dispose les composants d'un conteneur de gauche à droite, comme
 * les lignes de texte dans un paragraphe.
 * Frame          : Classe dérivée de <code>Window</code>, représente une fenêtre pourvue
 * d'un titre, d'une bordure et éventuellement d'une barre de menus.
 * TextArea       : Zone de texte comportant plusieurs lignes éditables ou non.
 * TextField      : Composant de texte permettant l'édition d'une ligne de texte.
 * WindowEvent    : Indique que le statut d'une fenêtre a changé.
 * WindowListener : Permet de revevoir les événements concernant les fenêtres.
 * </pre>
 *
 * @author Alain Lebret
 * @version 1.4
 * @see java.awt.Frame
 * @see java.awt.event.WindowListener
 * @see java.awt.event.ActionListener
 */
public class CalculetteAWT extends Frame implements WindowListener, ActionListener {
    /**
     * objet Calculette
     */
    private Calculette calculette;

    /**
     * Champ de texte chargé de récupérer l'opération
     */
    private TextField tfOperation;

    /**
     * Zone de texte chargée d'afficher les résultats
     */
    private TextArea taResultat;

    /**
     * Constructeur par défaut. Celui-ci initialise les attributs de la classe.
     */
    public CalculetteAWT() {
        super("Calculette avec AWT");

        calculette = new Calculette(5);

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        tfOperation = new TextField();
        tfOperation.setColumns(6);
        this.add(tfOperation);
        tfOperation.addActionListener(this);

        taResultat = new TextArea("Calculette - v. 1.4\n", 3, 20, TextArea.SCROLLBARS_NONE);
        this.add(taResultat);
        this.addWindowListener(this);
        this.setSize(300, 150);
        this.setVisible(true);
    }

    public void windowActivated(WindowEvent evt) {
    }

    public void windowDeactivated(WindowEvent evt) {
    }

    public void windowClosed(WindowEvent evt) {
    }

    public void windowClosing(WindowEvent evt) {
        System.exit(0);
    }

    public void windowIconified(WindowEvent evt) {
    }

    public void windowDeiconified(WindowEvent evt) {
    }

    public void windowOpened(WindowEvent evt) {
    }


    /**
     * Fonction d'<code>ActionListener</code> devant être redéfinie pour gérer les événements
     * dans la fenêtre.
     *
     * @param evt événement source ayant provoquée l'événement
     */
    public void actionPerformed(ActionEvent evt) {
        /*
         * Si l'objet dans lequel à eu lieu l'événement est le champ de texte...
         */
        if (evt.getSource() == this.tfOperation) {
            // Récupération du texte dans le champ de texte et transmission à la calculette
            calculette.calculer(tfOperation.getText());

            // Mise à jour de la zone de texte avec le résultat
            taResultat.setText(calculette.toString());
        }
    }
} // Fin CalculetteAWT