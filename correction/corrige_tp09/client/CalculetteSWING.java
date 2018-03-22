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
package corrige_tp09.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Amélioration de la calculette du TP no 6 avec incorporation d'un menu afin de gérer
 * la connexion avec le serveur.
 *
 * @author Alain Lebret
 * @version 1.0
 * @see JFrame
 * @see WindowListener
 * @see ActionListener
 */
public class CalculetteSWING extends JFrame implements WindowListener, ActionListener {
    /**
     * objet pour transmettre les calculs à effectuer
     */
    private ClientTCP clientTCP;

    /**
     * MenuItem "Connecter" du menu "Serveur"
     */
    private JMenuItem miConnecter = null;

    /**
     * MenuItem "Déconnecter" du menu "Serveur"
     */
    private JMenuItem miDeconnecter = null;

    /**
     * MenuItem "Quitter" du menu "Serveur"
     */
    private JMenuItem miQuitter = null;

    /**
     * MenuItem "A Propos" du menu "Aide"
     */
    private JMenuItem miAPropos = null;

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
        clientTCP = new ClientTCP(9090);
        this.construireMenus();

        this.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        tfOperation = new JTextField();
        tfOperation.setColumns(6);
        this.getContentPane().add(tfOperation);
        tfOperation.addActionListener(this);

        taResultat = new JTextArea("", 3, 20);
        this.getContentPane().add(taResultat);
        this.addWindowListener(this);
        this.setSize(300, 150);
        this.setVisible(true);
    }

    /**
     * Construction de la barre de menus de la calculette.
     */
    private void construireMenus() {
        /* Barre de menus de la CalculetteSWING */
        JMenuBar barreMenus = new JMenuBar();

        /* Menu "Serveur" dans la barre de menus de la CalculetteSWING */
        JMenu menuServeur = new JMenu("Serveur");
        miConnecter = new JMenuItem("Connecter");
        miDeconnecter = new JMenuItem("Déconnecter");
        miQuitter = new JMenuItem("Quitter");

        /* Menu "Aide" dans la barre de menus de la CalculetteSWING */
        JMenu menuAide = new JMenu("Aide");
        miAPropos = new JMenuItem("À Propos");

        menuServeur.setMnemonic('S');
        menuServeur.add(miConnecter);
        menuServeur.add(miDeconnecter);
        menuServeur.addSeparator();
        menuServeur.add(miQuitter);

        menuAide.setMnemonic('A');
        menuAide.add(miAPropos);

        miConnecter.addActionListener(this);
        miDeconnecter.addActionListener(this);
        miQuitter.addActionListener(this);
        miAPropos.addActionListener(this);

        barreMenus.add(menuServeur);
        barreMenus.add(menuAide);
        this.setJMenuBar(barreMenus);
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
            String tmp1 = tfOperation.getText();
            System.out.println("Calcul a envoye : " + tmp1);
            String tmp = clientTCP.requeter(tmp1);

            // Mise à jour de la zone de texte avec le résultat
            System.out.println("Resultat recu : " + tmp);
            taResultat.setText(tmp);
        }

        /*
         * Si l'objet dans lequel à eu lieu l'événement est le MenuItem "Connecter"
         */
        if (evt.getSource() == this.miConnecter) {
            System.out.println("Connexion en cours...");
            clientTCP.connecter("127.0.0.1");
            System.out.println("Connexion effectuee");
        }

        /*
         * Si l'objet dans lequel à eu lieu l'événement est le MenuItem "Déconnecter"
         */
        if (evt.getSource() == this.miDeconnecter) {
            System.out.println("Deconnexion en cours...");
            clientTCP.deconnecter();
            System.out.println("Client deconnecte");
        }

        /*
         * Si l'objet dans lequel à eu lieu l'événement est le MenuItem "Quitter"
         */
        if (evt.getSource() == this.miQuitter) {
            System.exit(0);
        }

        /*
         * Si l'objet dans lequel à eu lieu l'événement est le MenuItem "A Propos"
         */
        if (evt.getSource() == this.miAPropos) {
            JOptionPane.showMessageDialog(this, "Calculette v. 1.8\nTSII - 2000",
                    "A Propos", JOptionPane.PLAIN_MESSAGE);
        }
    }

} // Fin CalculetteSwing
