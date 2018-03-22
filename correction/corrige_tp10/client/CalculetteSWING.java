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
package corrige_tp10.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Amélioration de la calculette du TP n°9 avec incorporation d'un Executeur.
 * Elle utilise :
 * <PRE>
 * ActionEvent    : Evénement sémantique indiquant une action sur un composant.
 * ActionListener : Permet de recevoir les événements d'action (ActionEvent).
 * FlowLayout     : Dispose les composants d'un conteneur de gauche à droite, comme
 * les lignes de texte dans un paragraphe.
 * JFrame         : Version étendue de <code>Frame</code> ajoutant le support d'une couche
 * permettant le dessin et la gestion des entrées et des sorties
 * au-dessus de la fenêtre et le support de composants gérés par
 * strates dans un <code>LayeredPane</code>.
 * JMenu          : Menu, c'est-à-dire une fenêtre contenant des entrées de menu.
 * Celles-ci apparaissent lorsque l'utilisateur sélectionne son
 * titre.
 * JMenuBar       : Barre de menus.
 * JMenuItem      : Entrée de menu.
 * JTextArea      : Zone de texte simple pouvant contenir plusieurs lignes éditables ou non.
 * JTextField     : Composant léger permettant la saisie d'une ligne de texte.
 * WindowEvent    : Indique que le statut d'une fenêtre a changé.
 * WindowListener : Permet de revevoir les événements concernant les fenêtres.
 * </PRE>
 *
 * @author Alain Lebret
 * @version 1.4
 * @see javax.swing.JFrame
 * @see java.awt.event.WindowListener
 * @see java.awt.event.ActionListener
 */
public class CalculetteSWING extends JFrame implements WindowListener, ActionListener {
    /**
     * Barre de menus de la CalculetteSWING
     */
    JMenuBar barreMenus = null;
    /**
     * Menu "Serveur" dans la barre de menus de la CalculetteSWING
     */
    JMenu menuServeur = null;
    /**
     * MenuItem "Connecter" du menu "Serveur"
     */
    JMenuItem miConnecter = null;
    /**
     * MenuItem "Déconnecter" du menu "Serveur"
     */
    JMenuItem miDeconnecter = null;
    /**
     * MenuItem "Quitter" du menu "Serveur"
     */
    JMenuItem miQuitter = null;
    /**
     * Menu "Aide" dans la barre de menus de la CalculetteSWING
     */
    JMenu menuAide = null;
    /**
     * MenuItem "A Propos" du menu "Aide"
     */
    JMenuItem miAPropos = null;
    /**
     * MenuItem "Editeur" du menu "Aide"
     */
    JMenuItem miEditeur = null;
    /**
     * objet ClientTCP
     */
    private ClientTCP clientTCP;
    /**
     * Champ de texte chargé de récupérer l'opération
     */
    private JTextField tfOperation;

    /**
     * Zone de texte chargée d'afficher les résultats
     */
    private JTextArea taResultat;

    /**
     * Indicateur d'OS
     */
    static String OS = System.getProperty("os.name").toLowerCase();


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
        barreMenus = new JMenuBar();

        menuServeur = new JMenu("Serveur");
        miConnecter = new JMenuItem("Connecter");
        miDeconnecter = new JMenuItem("Déconnecter");
        miQuitter = new JMenuItem("Quitter");

        menuAide = new JMenu("Aide");
        miAPropos = new JMenuItem("À Propos");
        miEditeur = new JMenuItem("Aide");

        menuServeur.setMnemonic('S');
        menuServeur.add(miConnecter);
        menuServeur.add(miDeconnecter);
        menuServeur.addSeparator();
        menuServeur.add(miQuitter);

        menuAide.setMnemonic('A');
        menuAide.add(miAPropos);
        menuAide.addSeparator();
        menuAide.add(miEditeur);

        miConnecter.addActionListener(this);
        miDeconnecter.addActionListener(this);
        miQuitter.addActionListener(this);
        miAPropos.addActionListener(this);
        miEditeur.addActionListener(this);

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
            // Récupération du texte dans le champ de texte et transmission au client
            String tmp1 = tfOperation.getText();
            System.out.println("Calcul a envoyé : " + tmp1);
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
            System.out.println("Connexion effectuée");
        }

        /*
         * Si l'objet dans lequel à eu lieu l'événement est le MenuItem "Déconnecter"
         */
        if (evt.getSource() == this.miDeconnecter) {
            System.out.println("Déconnexion en cours...");
            clientTCP.deconnecter();
            System.out.println("Client déconnecté");
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
            JOptionPane.showMessageDialog(this, "Calculette v. 1.10\nTSII - 2000",
                    "A Propos", JOptionPane.PLAIN_MESSAGE);
        }

        /*
         * Si l'objet dans lequel à eu lieu l'événement est le MenuItem "Aide"
         */
        if (evt.getSource() == this.miEditeur) {
            Executeur executeur = new Executeur();
            String editeur = null;

            if (isMac()) {
                editeur = "mate aide.txt";
            } else if (isWindows()) {
                editeur = "notepad.exe aide.txt";
            } else if (isUnix()) {
                editeur = "gedit aide.txt";
            }

            executeur.lancer(editeur);
        }
    }

    public static boolean isWindows() {
        return (OS.contains("win"));
    }

    public static boolean isMac() {
        return (OS.contains("mac"));
    }

    public static boolean isUnix() {
        return (OS.contains("nix") || OS.contains("nux") || OS.indexOf("aix") > 0 );
    }

    public static boolean isSolaris() {
        return (OS.contains("sunos"));
    }

} // Fin CalculetteSWING