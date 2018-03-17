/*
 * SVEN is an open source Java library for machine learning, image analysis
 * and computer vision educational projects.
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
package corrige_tp06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Amélioration de la calculette du TP n4 avec des fonctionnalités graphiques SWING.
 * Elle utilise :
 *
 *   ActionEvent    : Evénement sémantique indiquant une action sur un composant.
 *   ActionListener : Permet de recevoir les événements d'action (ActionEvent).
 *   FlowLayout     : Dispose les composants d'un conteneur de gauche à droite, comme
 *                    les lignes de texte dans un paragraphe.
 *   JFrame         : Version étendue de <code>Frame</code> ajoutant le support d'une couche
 *                    permettant le dessin et la gestion des entrées et des sorties
 *                    au-dessus de la fenêtre et le support de composants gérés par
 *                    strates dans un <code>LayeredPane</code>.
 *   JTextArea      : Zone de texte simple pouvant contenir plusieurs lignes éditables ou non.
 *   JTextField     : Composant léger permettant la saisie d'une ligne de texte.
 *   WindowEvent    : Indique que le statut d'une fenêtre a changé.
 *   WindowListener : Permet de revevoir les événements concernant les fenêtres.
 *
 * @author Alain Lebret
 * @version 1.0
 * @see JFrame
 * @see WindowListener
 * @see ActionListener
 */
public class CalculetteSWING extends JFrame implements WindowListener, ActionListener {
    /**
     * objet Calculette
     */
    private CalculetteSauvegarde calculette;

    /**
     * Champ de texte chargé de récupérer l'opération
     */
    private JTextField tfOperation;

    /**
     * Zone de texte chargée d'afficher les résultats
     */
    private JTextArea taResultat;

    /**
     * Constructeur par défaut. Celui-ci initialise les attributs de la classe.
     */
    public CalculetteSWING() {
        super("Calculette avec SWING");

        calculette = new CalculetteSauvegarde(5);

        this.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        tfOperation = new JTextField();
        tfOperation.setColumns(6);
        this.getContentPane().add(tfOperation);
        tfOperation.addActionListener(this);

        taResultat = new JTextArea("Calculette - v. 1.5\n", 6, 20);
        this.getContentPane().add(taResultat);
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
     * @param evt événement source
     */
    public void actionPerformed(ActionEvent evt) {
        /*
         * Si l'objet dans lequel à eu lieu l'événement est le champ de texte...
         */
        if (evt.getSource() == this.tfOperation) {
            // Récupération du texte dans le champ de texte et transmission à la calculette
            calculette.calculer(tfOperation.getText());
            calculette.sauvegarder();

            // Mise à jour de la zone de texte avec le résultat
            taResultat.setText("");
            taResultat.setText(calculette.toString());
            tfOperation.setText("");
        }
    }
} // Fin CalculetteSwing
